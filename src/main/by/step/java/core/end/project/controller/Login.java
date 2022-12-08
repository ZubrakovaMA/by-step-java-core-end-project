package by.step.java.core.end.project.controller;

import by.step.java.core.end.project.service.Authorization;
import by.step.java.core.end.project.service.users.UserType;

import java.util.Scanner;

public class Login {

    private Authorization authorization = new Authorization();

    public void doAuthorization () {
        Scanner sc = new Scanner(System.in);
        System.out.print("input your LOGIN: ");
        String login = sc.nextLine();
        System.out.print("input your PASSWORD: ");
        String password = sc.nextLine();

        Menu menu = tryLogin(login,password);
        Controller controller = new Controller(menu, this);
        controller.menuAct();
    }

    private Menu tryLogin(String login, String password) {
        UserType userType = null;
        try {
            userType = authorization.getUserType(login, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (userType.equals(UserType.Admin)){
            return new AdminMenu();
        } else {
            return new UserMenu();
        }
    }
}

