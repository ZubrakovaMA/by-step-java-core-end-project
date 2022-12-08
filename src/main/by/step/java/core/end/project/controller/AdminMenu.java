package by.step.java.core.end.project.controller;

public class AdminMenu extends Menu {

    @Override
    public String[] getMenu() {
        return adminMenu;
    }

    private String[] adminMenu = {
            "1. Authorization again",
            "2. Add new car",
            "3. Delete car",
            "4. Add car's description",
            "5. Show car park list",
            "0. Exit"
    };
}

