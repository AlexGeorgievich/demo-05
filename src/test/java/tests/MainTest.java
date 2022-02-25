package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Manager;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.Selenide.sleep;

public class MainTest extends BaseData {
    Manager app = new Manager();
    static BaseData test = new BaseData();
    String screenshotBefore =  "before";
    String screenshotFillForm =  "fillform";
    String screenshotAfter =  "after";

    //    initial
    @BeforeAll
    public static void beforeAll() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x2080";
        reportsFolder = "test-result/reports";
    }

    // open and fill form
    @Test
    @DisplayName(" - Fill Form -")
    public void openTest() {
        app.openSite()
                .verifyTitle();
        Selenide.screenshot(screenshotBefore);

        app.setFirstName(test.firstName)
                .setLastName(test.lastName)
                .setUserEmail(test.userEmail)
                .setGender(test.genterWrapper)
                .setUserNumber(test.userNumber)
                .setDate(calendarDay, calendarMonth, calendarYear)
                .setSubjectField(test.subjects)
                .setHobby(test.hobbies)
                .uploadPicture(test.uploadPicture)
                .setCurrentAddress(test.currentAddress)
                .setState(test.state)
                .setCity(test.city);
        Selenide.screenshot(screenshotFillForm);
                app.activateForm();

        sleep(2000);
// control date in form
        app.checkForm(test.firstName,
                test.lastName,
                test.userEmail,
                test.genterWrapper,
                test.userNumber,
                test.dateCreated,
                test.subjects,
                test.hobbies,
                test.uploadPicture,
                test.currentAddress,
                test.state,
                test.city);
        Selenide.screenshot(screenshotAfter);

    }
}
