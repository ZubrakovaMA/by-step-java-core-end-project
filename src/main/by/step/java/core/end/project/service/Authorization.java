package by.step.java.core.end.project.service;

import by.step.java.core.end.project.dao.FileDAO;
import by.step.java.core.end.project.dao.FileUsers;
import by.step.java.core.end.project.service.users.UserData;
import by.step.java.core.end.project.service.users.UserType;

import java.util.ArrayList;

public class Authorization {

    private FileDAO fileUsers = new FileUsers();

    private boolean doVerification (String login, String password) {
        ArrayList<UserData> users = (ArrayList<UserData>) fileUsers.readFile();
        for (UserData user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public UserType getUserType (String login, String password) throws ClassNotFoundException {
        if (doVerification(login, password)) {
            ArrayList<UserData> users = (ArrayList<UserData>) fileUsers.readFile();
            for (UserData user: users) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    return user.getUserType();
                }
            }
        }
        throw new ClassNotFoundException("User is NOT FOUND");
    }
}
