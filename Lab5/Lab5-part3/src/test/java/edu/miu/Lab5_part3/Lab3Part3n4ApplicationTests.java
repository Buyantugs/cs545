package edu.miu.Lab5_part3;

import edu.miu.Lab5_part3.domain.BankAccount;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

class Lab5Part3ApplicationTests {

	@BeforeAll
	public static void setup() {
		RestAssured.port = Integer.valueOf(8080);
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "/bank";
	}

	@Test
	void createAccount() {
		BankAccount bankAccount=new BankAccount(1001,"Bob");

		given()
				.contentType("application/json")
				.body(bankAccount)
				.when().post("/createAccount").then()
				.statusCode(200);

		given()
				.when()
				.get("/getAccount/1001")
				.then()
				.contentType(ContentType.JSON)
				.and()
				.body("accountNumber",equalTo(1001))
				.body("accountHolder",equalTo("Bob"))
				.body("balance",equalTo(0F))
				.body("transactions",equalTo(Collections.emptyList()));

		given()
				.when()
				.delete("remove/1001");
	}

	@Test
	void removeAccount() {
		BankAccount bankAccount=new BankAccount(1001,"Bob");

		given()
				.contentType("application/json")
				.body(bankAccount)
				.when().post("/createAccount").then()
				.statusCode(200);

		given()
				.when()
				.get("/getAccount/1001")
				.then()
				.contentType(ContentType.JSON)
				.and()
				.body("accountNumber",equalTo(1001))
				.body("accountHolder",equalTo("Bob"))
				.body("balance",equalTo(0F))
				.body("transactions",equalTo(Collections.emptyList()));

		given()
				.when()
				.delete("remove/1001")
				.then()
				.statusCode(200);

		given()
				.when()
				.get("getAccount/1001")
				.then()
				.statusCode(404)
				.body("errorMessage",equalTo("The bank account with number=1001 is not available!"));
	}

	@Test
	void makeDepositOnExistingAccount() {
		int accNumber = 1001;
		double depositAmount = 15.0;

		BankAccount bankAccount = new BankAccount(accNumber, "Bob");

		given()
				.contentType("application/json")
				.body(bankAccount)
				.when().post("/createAccount")
				.then()
				.statusCode(200);

		given()
				.when()
				.post("/deposit/" + accNumber + "?amount=" + depositAmount)
				.then()
				.statusCode(200)
				.body("accountNumber", equalTo(accNumber))
				.body("accountHolder", equalTo("Bob"))
				.body("balance", equalTo((float) depositAmount))  // Ensure balance is updated
				.body("transactions[0].txnType", equalTo("Deposit"))
				.body("transactions[0].amount", equalTo((float) depositAmount));

		given()
				.when()
				.get("/getAccount/" + accNumber)
				.then()
				.statusCode(200)
				.body("balance", equalTo((float) depositAmount))  // Verify balance
				.body("transactions.size()", equalTo(1)) // Ensure transaction exists
				.body("transactions[0].txnType", equalTo("Deposit"))
				.body("transactions[0].amount", equalTo((float) depositAmount));

		given()
				.when()
				.delete("/remove/" + accNumber)
				.then()
				.statusCode(200);
	}

	@Test
	void withdrawAmount() {
		int accNumber = 1001;
		double depositAmount = 50.0;
		double withdrawAmount = 20.0;
		double expectedBalance = depositAmount - withdrawAmount;

		BankAccount bankAccount = new BankAccount(accNumber, "Test User");

		given()
				.contentType("application/json")
				.body(bankAccount)
				.when().post("/createAccount")
				.then()
				.statusCode(200);

		given()
				.when()
				.post("/deposit/" + accNumber + "?amount=" + depositAmount)
				.then()
				.statusCode(200)
				.body("balance", equalTo((float) depositAmount));

		given()
				.when()
				.post("/withdraw/" + accNumber + "?amount=" + withdrawAmount)
				.then()
				.statusCode(200)
				.body("balance", equalTo((float) expectedBalance))
				.body("transactions[1].txnType", equalTo("withdrawal"))
				.body("transactions[1].amount", equalTo((float) withdrawAmount));


		given()
				.when()
				.get("/getAccount/" + accNumber)
				.then()
				.statusCode(200)
				.body("balance", equalTo((float) expectedBalance))
				.body("transactions.size()", equalTo(2))
				.body("transactions[1].txnType", equalTo("withdrawal"))
				.body("transactions[1].amount", equalTo((float) withdrawAmount));


		given()
				.when()
				.delete("/remove/" + accNumber)
				.then()
				.statusCode(200);
	}



}
