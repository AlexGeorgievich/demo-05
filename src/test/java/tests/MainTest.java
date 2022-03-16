package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Manager;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;

public class MainTest extends BaseData {
    Manager app = new Manager();
    public static BaseData test = new BaseData();
    public String screenshotBefore = "before";
    public String screenshotFillForm = "fillform";
    public String screenshotAfter = "after";

    //    initial
    @BeforeAll
    public static void beforeAll() {
        baseUrl = "https://demoqa.com";
        browserSize = "1920x1080";
        reportsFolder = "test-result/reports";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

//        Configuration.browserCapabilities = capabilities;
//        Configuration.startMaximized = true;
//        Configuration.remote = getSelenoidUrl();
    }

    @Test
    @Description(" Работа выполнена в рамках курса QA.GURU")
    @Link(name = "Testing", url = "https://demoqa.com")
    @DisplayName(" - Заполнение формы и контроль результатов -")
    public void openTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Allure.step(" Открытие сайта " + baseUrl, () -> {
            app.openSite()
                    .verifyTitle();
            Selenide.screenshot(screenshotBefore);
            app.takeScreenshot();
        });

        Allure.step(" Заполнение регистрационной  формы ", () -> {
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
            app.takeScreenshot();
        });
        sleep(2000);
// control date in form
        Allure.step(" Контроль достоверности заполнения регистрационной формы ", () -> {
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
            app.takeScreenshot();
        });
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
