package test.data;

import com.github.javafaker.Faker;

public class User {
    private static Faker faker = new Faker();

    private String username;
    private String password;

    public static User valid() {
        User user = new User();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        return user;
    }

    public User blankPassword() {
        User user = new User();
        user.setPassword("");
        return user;
    }

    public  void setUsername(String name) {
        username = name;
    }

    public User() {
        username = faker.name().username();
        password = faker.internet().password();
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
