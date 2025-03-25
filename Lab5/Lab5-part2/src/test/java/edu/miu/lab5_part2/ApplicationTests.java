package edu.miu.lab5_part2;

import edu.miu.lab5_part2.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class ApplicationTests {
	@BeforeAll
	public static void setup() {
		RestAssured.port = Integer.valueOf(8080);
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "/lab5";
	}

	@Test
	void testGetOneBook() {

		Book book = new Book("isbn010", "Jones", "Book1 book1 book1", 8.5);
		given()
				.contentType("application/json")
				.body(book)
				.when().post("/books").then()
				.statusCode(200);

		given()
				.when()
				.get("books/isbn010")
				.then()
				.contentType(ContentType.JSON)
				.and()
				.body("isbn",equalTo("isbn010"))
				.body("author",equalTo("Jones"))
				.body("title",equalTo("Book1 book1 book1"))
				.body("price",equalTo(8.5F));

		given()
				.when()
				.delete("books/isbn010");
	}

	@Test
	void testDeleteBook() {
		// add the book to be deleted book
		Book book = new Book("isbn010", "Jones", "Book1 book1 book1", 8.5);
		given()
				.contentType("application/json")
				.body(book)
				.when().post("/books").then()
				.statusCode(200);

		given()
				.when()
				.delete("books/isbn010");

		given()
				.when()
				.get("books/isbn010")
				.then()
				.statusCode(404)
				.and()
				.body("errorMessage",equalTo("Book with isbn=isbn010 is not available!"));
	}

	@Test
	void testAddBook() {

		Book book = new Book("isbn010", "Jones", "Book1 book1 book1", 8.5);
		given()
				.contentType("application/json")
				.body(book)
				.when().post("/books").then()
				.statusCode(200);
		// get the book and verify
		given()
				.when()
				.get("books/isbn010")
				.then()
				.statusCode(200)
				.and()
				.body("isbn",equalTo("isbn010"))
				.body("author",equalTo("Jones"))
				.body("title",equalTo("Book1 book1 book1"))
				.body("price",equalTo(8.5F));
		//cleanup
		given()
				.when()
				.delete("books/isbn010");
	}

	@Test
	void testUpdateBook() {

		Book book = new Book("isbn010", "Jones", "Book1 book1 book1", 8.5);
		Book bookUpdate = new Book("isbn010", "Jones", "Data Engineering", 8.5);
		given()
				.contentType("application/json")
				.body(book)
				.when().post("/books").then()
				.statusCode(200);

		given()
				.contentType("application/json")
				.body(bookUpdate)
				.when().put("/books/isbn010").then()
				.statusCode(200);

		given()
				.when()
				.get("books/isbn010")
				.then()
				.statusCode(200)
				.and()
				.body("isbn",equalTo("isbn010"))
				.body("author",equalTo("Jones"))
				.body("title",equalTo("Data Engineering"))
				.body("price",equalTo(8.5F));
		//cleanup
		given()
				.when()
				.delete("books/isbn010");
	}

	@Test
	void testGetAllBooks()
	{
		Book book1 = new Book("isbn010", "Jones", "Book1 book1 book1", 8.5);
		Book book2 = new Book("isbn011", "Bob", "Data Engineering", 5.5);
		given()
				.contentType("application/json")
				.body(book1)
				.when().post("/books").then()
				.statusCode(200);

		given()
				.contentType("application/json")
				.body(book2)
				.when().post("/books").then()
				.statusCode(200);

		given()
				.when()
				.get("/getAllBooks")
				.then()
				.statusCode(200)
				.and()
				.body("books.isbn",hasItems("isbn010","isbn011"))
				.body("books.author",hasItems("Jones","Bob"))
				.body("books.title",hasItems("Data Engineering","Book1 book1 book1"))
				.body("books.price",hasItems(8.5F,5.5F));
		//cleanup
		given()
				.when()
				.delete("books/isbn010");
		given()
				.when()
				.delete("books/isbn011");
	}

	@Test
	void SearchAuthor(){
		Book book = new Book("isbn010", "Jones", "Data Engineering", 8.5);

		given()
				.contentType("application/json")
				.body(book)
				.when().post("/books").then()
				.statusCode(200);
		given()
				.get("/search/Jones")
				.then()
				.statusCode(200)
				.and()
				.body("books[0].isbn",equalTo("isbn010"))
				.body("books[0].author",equalTo("Jones"))
				.body("books[0].title",equalTo("Data Engineering"))
				.body("books[0].price",equalTo(8.5F));

		//cleanup
		given()
				.when()
				.delete("books/isbn010");
	}

}
