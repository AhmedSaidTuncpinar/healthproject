package stepdefinitions.ui;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;

public class US_027_TC_001_UI {

    HomePage homePage = new HomePage();

    LoginPage loginPage = new LoginPage();

    ContactPage contactPage = new ContactPage();

    @Given("user goes to the {string} page")
    public void user_goes_to_the_page(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @When("user click on Contact icon")
    public void user_click_on_contact_icon() {
        ReusableMethods.waitFor(1);
        homePage.contactIcon.click();
    }
    @Then("verifies that user is on Contact page")
    public void verifies_that_user_is_on_contact_page() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("contact"));
    }
    @Then("user enters {string} in name text box")
    public void user_enters_in_name_text_box(String name) {
        ReusableMethods.waitFor(1);
        contactPage.nameInput.sendKeys(name);
    }
    @Then("user enters {string} in email text box")
    public void user_enters_in_email_text_box(String email) {
        ReusableMethods.waitFor(1);
        contactPage.emailInput.sendKeys(email);
    }
    @Then("user enters {string} in subject text box")
    public void user_enters_in_subject_text_box(String subject) {
        ReusableMethods.waitFor(1);
        contactPage.subjectInput.sendKeys(subject);
    }
    @Then("user enters {string} in message text box")
    public void user_enters_in_message_text_box(String message) {
        ReusableMethods.waitFor(1);
        contactPage.messagetextBox.sendKeys(message);
    }
    @Then("user clicks on Send button")
    public void user_clicks_on_send_button() {
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(contactPage.sendButton);
    }
    @Then("verify that message has been received successfully")
    public void verify_that_message_has_been_received_successfully() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(contactPage.successMessage.isDisplayed());
        Assert.assertEquals("Success message text does not match!","Your message has been received", contactPage.successMessage.getText());
    }

//*********************************************************************

    @Then("verify Name, Email, and Subject fields are required to send a message successfully.")
    public void verifyNameEmailAndSubjectFieldsAreRequiredToSendAMessageSuccessfully() {
        ReusableMethods.waitFor(1);
        ArrayList<String> expectedRequiredFieldMessages = new ArrayList<>(Arrays.asList("Name is required.", "Your email is required.", "This field is required."));
        int index = 0;
        for(WebElement eachRequiredFieldMessage : contactPage.requiredFieldErrorMessages){
            ReusableMethods.waitFor(1);
            Assert.assertTrue(eachRequiredFieldMessage.isDisplayed());
            Assert.assertEquals("Required fields error message does not match!", expectedRequiredFieldMessages.get(index), eachRequiredFieldMessage.getText());
            index++;
        }
    }

//*********************************************************************

    @When("user click on user icon")
    public void user_click_on_user_icon() {
        ReusableMethods.waitFor(1);
        homePage.userIcon.click();
    }
    @When("user click on Sign In option")
    public void user_click_on_sign_in_option() {
        ReusableMethods.waitFor(1);
        homePage.signInOption.click();
    }
    @When("user enter {string} in username input")
    public void user_enter_in_username_input(String username) {
        ReusableMethods.waitFor(1);
        loginPage.usernameInput.sendKeys(username);
    }
    @When("user enter {string} in password input")
    public void user_enter_in_password_input(String password) {
        ReusableMethods.waitFor(1);
        loginPage.passwordInput.sendKeys(password);
    }
    @When("user click on Remember Me check box")
    public void user_click_on_remember_me_check_box() {
        ReusableMethods.waitFor(1);
        loginPage.rememberMeCheckbox.click();
    }
    @When("user click on Sign In submit button")
    public void user_click_on_sign_in_submit_button() {
        ReusableMethods.waitFor(1);
        loginPage.signInSubmitButton.click();
    }

    //*********************************************************************

    @Then("verify Message field is not required to send a message successfully.")
    public void verifyMessageFieldIsNotRequiredToSendAMessageSuccessfully() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(contactPage.successMessage.isDisplayed());
        Assert.assertEquals("Success message text does not match!","Your message has been received", contactPage.successMessage.getText());
    }

    //*********************************************************************

    @Then("user enters registered {string} username  in name text box")
    public void user_enters_registered_patient_username_in_name_text_box(String name) {
        ReusableMethods.waitFor(1);
        contactPage.nameInput.sendKeys(name);
    }
    @Then("user enters registered {string} in email text box")
    public void user_enters_registered_in_email_text_box(String email) {
        ReusableMethods.waitFor(1);
        contactPage.emailInput.sendKeys(email);
    }
    @Then("user enters a {string} in subject text box")
    public void user_enters_a_in_subject_text_box(String subject) {
        ReusableMethods.waitFor(1);
        contactPage.subjectInput.sendKeys(subject);
    }
    @Then("user enters a {string} in message text box")
    public void user_enters_a_in_message_text_box(String message) {
        ReusableMethods.waitFor(1);
        contactPage.messagetextBox.sendKeys(message);
    }

    //*********************************************************************

    @Then("verify that invalid email error message is displayed on the page")
    public void verifyThatInvalidEmailErrorMessageIsDisplayedOnThePage() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(contactPage.emailRequiredFieldErrorMessage.isDisplayed());
    }

    //*********************************************************************

    @Then("verifies that admin is on Contact page")
    public void verifies_that_admin_is_on_contact_page() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("contact"));
    }
    @Then("admin enters registered {string} username  in name text box")
    public void admin_enters_registered_name_username_in_name_text_box(String name) {
        ReusableMethods.waitFor(1);
        contactPage.nameInput.sendKeys(name);
    }
    @Then("admin enters registered {string} in email text box")
    public void admin_enters_registered_in_email_text_box(String email) {
        ReusableMethods.waitFor(1);
        contactPage.emailInput.sendKeys(email);
    }
    @Then("admin enters a {string} in subject text box")
    public void admin_enters_a_in_subject_text_box(String subject) {
        ReusableMethods.waitFor(1);
        contactPage.subjectInput.sendKeys(subject);
    }
    @Then("admin enters a {string} in message text box")
    public void admin_enters_a_in_message_text_box(String message) {
        ReusableMethods.waitFor(1);
        contactPage.messagetextBox.sendKeys(message);
    }
    @Then("admin clicks on Send button")
    public void admin_clicks_on_send_button() {
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(contactPage.sendButton);
    }

    //*********************************************************************

    @And("user clicks on Send button again")
    public void userClicksOnSendButtonAgain() {
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(contactPage.sendButton);
    }

    @Then("verify success message is displayed again")
    public void verifySuccessMessageIsDisplayedAgain() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(contactPage.secondSuccessMessage.isDisplayed());
        Assert.assertEquals("Second success message text does not match!","Your message has been received", contactPage.secondSuccessMessage.getText());
    }

    //*********************************************************************

    @And("verify the message in the message box")
    public void verifyTheMessageImTheMessageBox() {
        ReusableMethods.waitFor(1);
        Assert.assertEquals("Message text does not match!","2. 250$ Billing request!" ,JSUtils.getValueInStringByJS("message"));
    }

}


