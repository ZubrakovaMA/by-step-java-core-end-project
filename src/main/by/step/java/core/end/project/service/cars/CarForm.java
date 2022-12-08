package by.step.java.core.end.project.service.cars;

public class CarForm {

    private int idNo;
    private String carBrand;
    private int manufactureDate;
    private double price;

    public CarForm(int idNo, String carBrand, int manufactureDate, double price) {
        this.idNo = idNo;
        this.carBrand = carBrand;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public CarForm(int idNo, String carBrand, int manufactureDate) {
        this.idNo = idNo;
        this.carBrand = carBrand;
        this.manufactureDate = manufactureDate;
    }

    public int getIdNo() {
        return idNo;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getManufactureDate() {
        return manufactureDate;
    }

    public double getPrice() {
        return price;
    }
}
