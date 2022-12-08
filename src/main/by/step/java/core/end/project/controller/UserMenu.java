package by.step.java.core.end.project.controller;

public class UserMenu extends Menu{

    @Override
    public String[] getMenu() {
        return userMenu;
    }

    private String[] userMenu = {
            "1. Authorization again",
            "2. Show car park list",
            "0. Exit",
    };
}
