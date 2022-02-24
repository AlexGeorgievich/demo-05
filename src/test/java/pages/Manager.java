package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseData.*;


public class Manager {

    private final SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            userEmailField = $("#userEmail"),
            genterWrapperField = $("#genterWrapper"),
            userNumberField = $("#userNumber"),
            dateOfBirthField = $("#dateOfBirthInput"),
            subjectsInputField = $("#subjectsInput"),
            hobbiesField = $("#hobbiesWrapper"),
            uploadPictureField = $("#uploadPicture"),
            currentAddressField = $("#currentAddress"),
            stateButton = $("#state"),
            stateCity = $("#react-select-3-input"),
            cityButton = $("#city"),
            cityField = $("#react-select-4-input"),
            submitButton = $("#submit"),
            tableResponsive = $(".table-responsive");



    private CalendarComponent calendarComponent = new CalendarComponent();

    public Manager openSite() {
        open("/automation-practice-form");
        return this;
    }

    public Manager verifyTitle() {
        headerTitle.shouldHave(text(title));
        return this;
    }

    public Manager setFirstName(String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }

    public Manager setLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public Manager setUserEmail(String userEmail) {
        userEmailField.setValue(userEmail);
        return this;
    }

    public Manager setUserNumber(String userNumber) {
        userNumberField.setValue(userNumber);
        return this;
    }

    public Manager setSubjectField(String subject) {
        subjectsInputField.setValue(subject).pressEnter();
        return this;
    }

    public Manager setHobby(String hobbies) {
        hobbiesField.$(byText(hobbies)).click();
        return this;
    }
    public Manager setGender(String gender) {
        genterWrapperField.$(byText(gender)).click();
        return this;
    }

    public Manager setPicture(String picture) {
        uploadPictureField.uploadFromClasspath(picture);
        return this;
    }

    public Manager setCurrentAddress(String currentAddress) {
        currentAddressField.setValue(currentAddress).pressEnter();
        return this;
    }

    public Manager setDate(String day, String month, String year) {
        dateOfBirthField.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public Manager setState(String state) {
        stateButton.click();
        stateCity.setValue(state).pressEnter();
        return this;
    }

    public Manager setCity(String city) {
        cityButton.click();
        cityField.setValue(city).pressEnter();
        return this;
    }

    public void activateForm() {
        submitButton.click();
    }

    public Manager checkForm(
            String firstName,
            String lastName,
            String userEmail,
            String genterWrapper,
            String userNumber,
            String dateCreated,
            String subjectsInput,
            String hobbies,
            String uploadPicture,
            String currentAddress,
            String state,
            String city) {
        tableResponsive.shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(genterWrapper),
                text(userNumber),
                text(dateCreated),
                text(subjectsInput),
                text(hobbies),
                text(uploadPicture),
                text(currentAddress),
                text(state + " " + city));
        return this;
    }

}




