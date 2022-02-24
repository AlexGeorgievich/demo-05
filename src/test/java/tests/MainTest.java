package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.Manager;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.screenshot;

public class MainTest extends BaseData {
    Manager app = new Manager();
  static  BaseData b = new BaseData();

    //    initial
    @BeforeAll
    public static void beforeAll() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x2080";
        reportsFolder = "test-result/reports";
    }

    // open and fill form
    @Test
    public void openTest() {
        app.openSite()
                .verifyTitle();

        app.setFirstName(b.firstName)
                .setLastName(b.lastName)
                .setUserEmail(b.userEmail)
                .setGender(genterWrapper)
                .setUserNumber(b.userNumber)
                .setSubjectInputField()
                .setHobby(hobbies)
                .setDate(calendarDay, calendarMonth, calendarYear)
                .setPicture()
                .setCurrentAddress(b.currentAddress)
                .setStateCity(state)
                .setCity(city)
                .activateForm();
        String pngFileName = screenshot(pngName);
        Selenide.screenshot(pngFileName);

// control date in form
        app.checkForm(b.firstName,
                b.lastName,
                b.userEmail,
                genterWrapper,
                b.userNumber,
                dateCreated,
                subjectsInput,
                hobbies,
                uploadPicture,
                b.currentAddress,
                 state,
                 city);

    }
}
