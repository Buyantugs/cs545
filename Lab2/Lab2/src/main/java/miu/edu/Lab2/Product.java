package miu.edu.Lab2;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {

    @NotNull
    @Size(min=2, max=5)
    private String serial;

    @NotNull
    @Size(min=2, max=20)
    private String name;

    @Digits(integer = 6, fraction = 2, message = "Amount must have up to 6 int digits and 2 decimal")
    private Float price;

    public Product() {
    }

    public Product(String serial, String name, Float price) {
        this.serial = serial;
        this.name = name;
        this.price = price;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
