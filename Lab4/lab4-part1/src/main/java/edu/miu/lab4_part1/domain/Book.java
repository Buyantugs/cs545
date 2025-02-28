package edu.miu.lab4_part1.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Book {

    @NotBlank(message="ISBN is required")
    private String isbn;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Price is required")
    @Min(value=1, message = "Price must be greater than 0")
    private double price;

    public Book(String isbn, String author, String title, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
