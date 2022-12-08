package by.step.java.core.end.project.controller;

import by.step.java.core.end.project.service.CarParkChangeSettings;
import by.step.java.core.end.project.service.cars.CarForm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private CarParkChangeSettings carParkChangeSettings = new CarParkChangeSettings();

    private Scanner sc = new Scanner(System.in);
    private Menu menu;
    private Login login;


    public Controller(Menu menu, Login login) {
        this.menu = menu;
        this.login = login;
    }

    private void showMenu(Menu menu) {
        for (String s : menu.getMenu()) {
            System.out.println(s);
        }
    }

    private CarForm newCarDeveloping() {
        int idNo;
        String carBrand;
        int manufactureDate;
        double price;

        System.out.print("Input car's ID No: ");
        idNo = sc.nextInt();
        System.out.print("Input car's car brand : ");
        carBrand = sc.next();
        System.out.print("Input car's date of manufacture: ");
        manufactureDate = sc.nextInt();
        System.out.print("Input car's prise: ");
        price = sc.nextDouble();
        return new CarForm(idNo, carBrand, manufactureDate, price);
    }

    private void adminMenuAct() {
        showMenu(menu);
        switch (sc.nextInt()) {
            case 1: {
                login.doAuthorization();
                break;
            }
            case 2: {
                CarForm carForm = newCarDeveloping();
                carParkChangeSettings.addNewCar(carForm);
                adminMenuAct();
                break;
            }
            case 3: {
                CarForm carForm = deleteCar();
                carParkChangeSettings.deleteCar(carForm);
                adminMenuAct();
                break;
            }
            case 4: {
                adminMenuAct();
                break;
            }
            case 5: {
                showAllCarList();
                adminMenuAct();
                break;
            }
            case 0: {
                return;
            }
            default: {
                showError();
                adminMenuAct();
            }
        }
    }
    private void showError() {
        System.out.println("Menu point is NOT FOUND");
    }

    public void menuAct() {
        if (menu instanceof AdminMenu) {
            adminMenuAct();
        } else {
            userMenuAct();
        }
    }

    private void userMenuAct() {
        showMenu(menu);
        switch (sc.nextInt()) {
            case 1: {
                login.doAuthorization();
            }
            case 2: {
                showAllCarList();
                userMenuAct();
                break;
            }
            case 5: {
                return;
            }
            default: {
                showError();
                userMenuAct();
            }
        }
    }

    private CarForm deleteCar() {
        int idNo;
        String carBrand;
        int manufactureDate;

        System.out.print("Input car's ID No: ");
        idNo = sc.nextInt();
        System.out.print("Input car's brand: ");
        carBrand = sc.next();
        System.out.print("Input car's date of manufacture: ");
        manufactureDate = sc.nextInt();

        return new CarForm(idNo, carBrand, manufactureDate);
    }

    private List<String> showAllCarList() {
        List<String> carpark = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\carpark.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                carpark.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String str : carpark) {
            System.out.println(str);
        }
        return carpark;
    }
}
