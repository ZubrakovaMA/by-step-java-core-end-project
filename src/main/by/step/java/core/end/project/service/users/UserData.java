package by.step.java.core.end.project.service.users;

public class UserData {

    private int idNo;
    private String login;
    private String password;
    private UserType userType;

    public UserData(int idNo, String login, String password, UserType userType) {
        this.idNo = idNo;
        this.login = login;
        this.password = password;
        this.userType = userType;
    }

    public int getIdNo() {
        return idNo;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
