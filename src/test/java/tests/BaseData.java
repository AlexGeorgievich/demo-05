package tests;

import com.github.javafaker.Faker;

public  class BaseData {
  static  Faker faker = new Faker();
    // вынести в отдельный класс инициализации
    public static String
            title    = "Student Registration Form",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            genterWrapper = "Male",
            userNumber = faker.number().digits(10),
            calendarMonth = "February",
            calendarYear = "2000",
            calendarDay = "10",
            dateCreated = calendarDay + " " + calendarMonth + "," + calendarYear,
            subjects = "Maths",
            hobbies = "Music",
            uploadPicture = "tools.png",
            currentAddress = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

}
