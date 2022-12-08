package by.step.java.core.end.project.dao;

import by.step.java.core.end.project.service.users.UserData;
import by.step.java.core.end.project.service.users.UserType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUsers extends FileDAO{

    @Override
    public ArrayList<UserData> readFile() {
        ArrayList<UserData> userData = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\users.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArray = line.split(",");

                userData.add(new UserData(
                        Integer.parseInt(tempArray[0]),
                        tempArray[1],
                        tempArray[2],
                        getUserTypeByString(tempArray[3])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userData;
    }

    private UserType getUserTypeByString(String userType) {
        UserType tempUserType;

        if (userType.equals(UserType.Admin.toString().toLowerCase())) {
            tempUserType = UserType.Admin;
        } else {
            tempUserType = UserType.User;
        }
        return tempUserType;
    }
}
