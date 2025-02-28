package mvc;

public class Car {
    private String license;
    private String make;
    private String model;

    public Car() {
    }

    public Car(String license, String make, String model) {
        this.license = license;
        this.make = make;
        this.model = model;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
