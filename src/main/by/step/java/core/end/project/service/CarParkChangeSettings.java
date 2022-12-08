package by.step.java.core.end.project.service;

import by.step.java.core.end.project.dao.FileCarpark;
import by.step.java.core.end.project.dao.FileDAO;
import by.step.java.core.end.project.service.cars.CarForm;

import java.util.ArrayList;

public class CarParkChangeSettings {

    private ArrayList<CarForm> carpark;
    private FileDAO fileCarpark = new FileCarpark();

    public CarParkChangeSettings() {
        this.carpark = (ArrayList<CarForm>) fileCarpark.readFile();
    }

    public boolean addNewCar (CarForm carForm) {
        carpark.add(carForm);
        ArrayList <String> convertedCollection = convertCarparkToString();
        return fileCarpark.saveFile(convertedCollection, "carpark");
    }
    public boolean deleteCar (CarForm carForm) {
        carpark.remove(carForm.getIdNo()-1);
        ArrayList <String> convertedCollection = convertCarparkToString();
        return fileCarpark.saveFile(convertedCollection, "carpark");
    }

    private ArrayList<String> convertCarparkToString() {
        ArrayList<String> strings = new ArrayList<>();
        for (CarForm model : carpark) {
            strings.add(model.getIdNo() + "," + model.getCarBrand() + "," + model.getManufactureDate() + "," + model.getPrice());
        }
        return strings;
    }
}

