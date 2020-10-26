package test.data;

import com.github.javafaker.Faker;

public class Person {
    public String firstName;
    public String lastName;
    public String zipCode;
    private static Faker faker = new Faker();

    public static Person beverlyHills() {
        return new Person();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}
