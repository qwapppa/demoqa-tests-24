package utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class RandomUtils {

    final Faker faker = new Faker(new Locale("en-GB"));

    final public String firstName = faker.name().firstName();
    final public String lastName = faker.name().lastName();
    final public String userFullName = faker.name().fullName();
    final public String userEmail = faker.internet().emailAddress();
    final public String userGender = faker.options().option("Male", "Female", "Other");
    final public String userNumber = String.valueOf(faker.number().numberBetween(7_000_000_000L, 8_999_999_999L));
    final public String userBirthDay = String.valueOf(faker.number().numberBetween(1, 28));
    final public String userBirthMonth = setRandomValue("February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    final public String userBirthYear = String.valueOf(faker.number().numberBetween(1924, 2010));
    final public String userStreetAddress = faker.address().streetAddress();
    final public String userPicture = getRandomFile();
    final public String userHobbies = faker.options().option("Sports", "Reading", "Music");
    final public String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    final public String userSubject = faker.options().option("Accounting", "Maths", "Arts", "Social Studies", "Chemistry", "Computer Science", "Commerce", "Physics", "Economics");
    final public String userCity = setRandomCity(userState);


    public String setRandomValue(String... strings) {
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values, strings);
        return values.get(faker.number().numberBetween(0, values.size() - 1));
    }

    public String getRandomFile() {
        String[] files = {"pic1.jpg", "pic2.jpg", "pic3.png"};
        return faker.options().option(files);
    }

    public String setRandomCity(String state) {
        return switch (userState) {
            case "Uttar Pradesh" -> setRandomValue("Agra", "Lucknow", "Merrut");
            case "NCR" -> setRandomValue("Delhi", "Gurgaon", "Noida");
            case "Haryana" -> setRandomValue("Karnal", "Panipat");
            case "Rajasthan" -> setRandomValue("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
