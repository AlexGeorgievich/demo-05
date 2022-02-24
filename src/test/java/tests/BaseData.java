package tests;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.$;

public  class BaseData {
  static  Faker faker = new Faker();
    // вынести в отдельный класс инициализации
    public static String
            title    = "Student Registration Form",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            genterWrapper = "Male",
            userNumber = "+7 " + faker.number().digits(7),
            calendarMonth = "February",
            calendarYear = "2000",
            calendarDay = "10",
            dateCreated = calendarDay + " " + calendarMonth + "," + calendarYear,
            subjectsInput = "Maths",
            hobbies = "Music",
            uploadPicture = "tools.png",
            currentAddress = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

    String pngName = "testfillform";


}
