package stepdefinitions.ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientAppointmentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US_008_TC_001_UI {

    HomePage homePage = new HomePage();

    LoginPage loginPage = new LoginPage();

    PatientAppointmentPage patientAppointmentPage = new PatientAppointmentPage();

    @Given("user is on {string} page")
    public void user_is_on_page(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("click on user icon")
    public void click_on_user_icon() {
        ReusableMethods.waitFor(1);
        homePage.userIcon.click();
    }

    @When("click on Sign In option")
    public void click_on_sign_in_option() {
        ReusableMethods.waitFor(1);
        homePage.signInOption.click();
    }

    @When("enter {string} in username input")
    public void enter_in_username_input(String username) {
        ReusableMethods.waitFor(1);
        loginPage.usernameInput.sendKeys(username);
    }

    @When("enter {string} in password input")
    public void enter_in_password_input(String password) {
        ReusableMethods.waitFor(1);
        loginPage.passwordInput.sendKeys(password);
    }

    @When("click on Remember Me check box")
    public void click_on_remember_me_check_box() {
        ReusableMethods.waitFor(1);
        loginPage.rememberMeCheckbox.click();
    }

    @When("click on Sign In submit button")
    public void click_on_sign_in_submit_button() {
        ReusableMethods.waitFor(1);
        loginPage.signInSubmitButton.click();
    }

    @When("click on MyPages")
    public void click_on_my_pages() {
        ReusableMethods.waitFor(2);
        patientAppointmentPage.myPagesPatientIcon.click();
    }

    @When("click on Make an Appointment")
    public void click_on_make_an_appointment() {
        ReusableMethods.waitFor(2);
        patientAppointmentPage.makeAnAppointmentIcon.click();
    }

    @Then("verify that {string}, {string}, {string} , {string} boxes are filled automatically")
    public void verify_that_boxes_are_filled_automatically(String firstName, String lastName, String SSN, String email) {
        ReusableMethods.waitFor(1);
        Assert.assertEquals(JSUtils.getValueInStringByJS("firstName"), firstName);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(JSUtils.getValueInStringByJS("lastName"), lastName);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(JSUtils.getValueInStringByJS("ssn"), SSN);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(JSUtils.getValueInStringByJS("email"), email);
    }

    @And("enter a valid {string} number in Phone box")
    public void enterAValidNumberInPhoneBox(String validPhoneNumber) {
        ReusableMethods.waitFor(1);
        patientAppointmentPage.phoneNumberInput.sendKeys(validPhoneNumber);
    }

    @Then("verify given default date in Appointment DateTime box is next day from the current date")
    public void verifyGivenDefaultDateInAppointmentDateTimeBoxIsNextDayFromTheCurrentDate() {
        String dateBoxValue = patientAppointmentPage.appointmentDateInput.getAttribute("value");
        LocalDate currentDate = LocalDate.now();
        LocalDate nextDayFromTheCurrentDate = currentDate.plusDays(1);
        String givenDateInString = "" + nextDayFromTheCurrentDate ;
        Assert.assertTrue(dateBoxValue.equals(givenDateInString));
    }

    @And("click on Send an Appointment Request button")
    public void clickOnSendAnAppointmentRequestButton() {
        ReusableMethods.waitFor(1);
        patientAppointmentPage.sendAnAppointmentRequestButton.click();
    }

    @Then("verify appointment registration saved successfully")
    public void verifyAppointmentRegistrationSavedSuccessfully() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(patientAppointmentPage.toastContainerSuccessMessage.isDisplayed());
    }

    @And("enter a random future date in Appointment DateTime box")
    public void enterARandomFutureDateInAppointmentDateTimeBox() {
        String futureDate = ReusableMethods.setPastOrFutureDate("yyyy-MM-dd",1,"feature");
        patientAppointmentPage.appointmentDateInput.clear();
        patientAppointmentPage.appointmentDateInput.sendKeys(futureDate);
    }

    @And("enter current date in Appointment DateTime box")
    public void enterCurrentDateInAppointmentDateTimeBox() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String currentDate = LocalDate.now().format(formatter);
        //String currentDayInString = "" + currentDate;
        patientAppointmentPage.appointmentDateInput.clear();
        patientAppointmentPage.appointmentDateInput.sendKeys(currentDate);
    }

    @Then("verify appointment registration is not saved successfully")
    public void verifyAppointmentRegistrationIsNotSavedSuccessfully() {
        Assert.assertTrue(patientAppointmentPage.pastDateFailureMessage.isDisplayed());
    }

    @And("enter a random past date in Appointment DateTime box")
    public void enterARandomPastDateInAppointmentDateTimeBox() {
        String pastDate = ReusableMethods.setPastOrFutureDate("yyyy-MM-dd",1,"past");
        patientAppointmentPage.appointmentDateInput.clear();
        patientAppointmentPage.appointmentDateInput.sendKeys(pastDate);
    }

    @And("enter an {string} in Appointment DateTime box")
    public void enterAnInAppointmentDateTimeBox(String invalidDate) {
        ReusableMethods.waitFor(1);
        patientAppointmentPage.appointmentDateInput.clear();
        patientAppointmentPage.appointmentDateInput.sendKeys(invalidDate);
    }

    @Then("verify providing {string} cannot be entered in Appointment DateTime box")
    public void verifyProvidingCannotBeEnteredInAppointmentDateTimeBox(String invalidDate) {
        String inputOfDateTextBox = JSUtils.getValueInStringByJS("appoDate");
        Assert.assertTrue(!inputOfDateTextBox.equals(invalidDate));
    }

    @Then("verify appointment cannot be saved successfully without providing a valid phone number.")
    public void verifyAppointmentCannotBeSavedSuccessfullyWithoutProvidingAValidPhoneNumber() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(patientAppointmentPage.phoneNumberFailureMessage.isDisplayed());
    }

    @And("enter a {string} in Appointment DateTime box")
    public void enterAInAppointmentDateTimeBox(String validDate) {
        ReusableMethods.waitFor(1);
        patientAppointmentPage.appointmentDateInput.sendKeys(validDate);
    }

    @Then("verify providing {string} format is in yearMMdd")
    public void verifyProvidingFormatIsInYearMMdd(String validDate) {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(ReusableMethods.isValid("yyyy/MM/dd", validDate));
    }

    @Then("close the application")
    public void closeTheApplication() {
        Driver.closeDriver();
    }
}

