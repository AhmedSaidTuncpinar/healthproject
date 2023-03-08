package stepdefinitions.ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.PhysicianAppointmentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class US_014_TC_001_UI {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    PhysicianAppointmentPage physicianAppointmentPage = new PhysicianAppointmentPage();

    Actions action;

    @Given("user-physician is on {string} page")
    public void user_physician_is_on_page(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @When("user-physician click on user icon")
    public void user_physician_click_on_user_icon() {
        ReusableMethods.waitFor(1);
        homePage.userIcon.click();
    }
    @When("user-physician click on Sign In option")
    public void user_physician_click_on_sign_in_option() {
        ReusableMethods.waitFor(1);
        homePage.signInOption.click();
    }
    @When("user-physician enter {string} in username input")
    public void user_physician_enter_in_username_input(String username) {
        ReusableMethods.waitFor(1);
        loginPage.usernameInput.sendKeys(username);
    }
    @When("user-physician enter {string} in password input")
    public void user_physician_enter_in_password_input(String password) {
        ReusableMethods.waitFor(1);
        loginPage.passwordInput.sendKeys(password);
    }
    @When("user-physician click on Remember Me check box")
    public void user_physician_click_on_remember_me_check_box() {
        ReusableMethods.waitFor(1);
        loginPage.rememberMeCheckbox.click();
    }
    @When("user-physician click on Sign In submit button")
    public void user_physician_click_on_sign_in_submit_button() {
        ReusableMethods.waitFor(1);
        loginPage.signInSubmitButton.click();
    }
    @When("user-physician click on MyPages")
    public void user_physician_click_on_my_pages() {
        ReusableMethods.waitFor(1);
        homePage.myPagesButton.click();
    }
    @When("user-physician click on My Appointments")
    public void user_physician_click_on_my_appointments() {
        ReusableMethods.waitFor(1);
        homePage.myAppointmentsButton.click();
    }

    //*************************************************************************************
    @When("user-physician click on Edit button")
    public void user_physician_click_on_edit_button() {
        action = new Actions(Driver.getDriver());

        ReusableMethods.waitFor(1);
        physicianAppointmentPage.appointmentFromInput.clear();
        ReusableMethods.waitFor(1);
        physicianAppointmentPage.appointmentToInput.clear();
        ReusableMethods.waitFor(1);
        action.
                click(physicianAppointmentPage.appointmentFromInput).
                sendKeys("2023").sendKeys(Keys.ARROW_RIGHT).
                sendKeys("02").sendKeys(Keys.ARROW_RIGHT).
                sendKeys("23").sendKeys(Keys.TAB).
                sendKeys("2023").sendKeys(Keys.ARROW_RIGHT).
                sendKeys("03").sendKeys(Keys.ARROW_RIGHT).
                sendKeys("07").
                build().perform();
        ReusableMethods.waitFor(5);
        physicianAppointmentPage.editAppoToSeeTestResultsButton.click();
    }

    @Then("verify Show Test Results button is displayed on the site")
    public void verify_show_test_results_button_is_displayed_on_the_site() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(physicianAppointmentPage.showTestResultsButton.isDisplayed());
    }

    //*************************************************************************************
    @When("user-physician click on Show Test Results button")
    public void user_physician_click_on_show_test_results_button() {
        ReusableMethods.waitFor(1);
        physicianAppointmentPage.showTestResultsButton.click();
    }
    @Then("verify View Results button is displayed on the site")
    public void verify_view_results_button_is_displayed_on_the_site() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(physicianAppointmentPage.viewResultsButton.isDisplayed());
    }
    @Then("user-physician click on View Results button")
    public void user_physician_click_on_view_results_button() {
        ReusableMethods.waitFor(1);
        physicianAppointmentPage.viewResultsButton.click();
    }
    @Then("verify Test Results page is displayed")
    public void verify_test_results_page_is_displayed() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("testresult"));
    }
    @Then("verify test id, name, result, default max value is visible, default min value is visible, test is visible, description is visible, date is visible")
    public void verify_test_id_name_result_default_max_value_is_visible_default_min_value_is_visible_test_is_visible_description_is_visible_date_is_visible() {
        ReusableMethods.waitFor(1);
        List<String> expectedHeadingList = new ArrayList<>(Arrays.asList("ID", "Name", "Result", "Default Min. Value", "Default Max. Value", "Test", "Description", "Date", ""));
        boolean isHeadingExist = false;
        int idx = 0;
        for(WebElement eachHeading : physicianAppointmentPage.testResultHeadingList){
            if(eachHeading.getText().equals(expectedHeadingList.get(idx)));
            isHeadingExist = true;
            idx++;
        }
        Assert.assertTrue(isHeadingExist);
    }

    //******************************************************************************************
    @Then("verify Request Inpatient button is displayed on the site")
    public void verifyRequestInpatientButtonIsDisplayedOnTheSite() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(physicianAppointmentPage.requestInpatientButton.isDisplayed());
    }
    @When("user-physician click on Request Inpatient button")
    public void user_physician_click_on_request_inpatient_button() {
        ReusableMethods.waitFor(1);
        physicianAppointmentPage.requestInpatientButton.click();
    }
    @Then("verify Inpatient request success or already done failure message is displayed on the site")
    public void verifyInpatientRequestSuccessOrAlreadyDoneFailureMessageIsDisplayedOnTheSite() {
        ReusableMethods.waitFor(1);
        try{
            Assert.assertTrue(physicianAppointmentPage.inpatientRequestSuccessMessage.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(physicianAppointmentPage.inpatientRequestFailureMessage.isDisplayed());
        }
    }


}

