package test.data;

public class User {
    private String username;
    private String password;

    public static User valid() {
        User user = new User();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        return user;
    }

    public  void setUsername(String name) {
        username = name;
    }

    public String getUsername() {
        return username;
    }

    public  void setPassword(String pwd) {
        password = pwd;
    }

    public String getPassword() {
        return password;
    }
}
