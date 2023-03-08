package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AdminAdministrationPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_021_TC_001_UI {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    AdminAdministrationPage adminAdministrationPage = new AdminAdministrationPage();

    Faker faker = new Faker();
    String fakeSsn;
    String fakeFirstName;
    String fakeLastName;
    String fakeUserName;
    String fakeEmail;
    String pwd = "Kelly01+";


    @Given("user navigate {string} page")
    public void user_navigate_page(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @When("clicks on user icon")
    public void clicks_on_user_icon() {
        ReusableMethods.waitFor(1);
        homePage.userIcon.click();
    }
    @When("clicks on Register option")
    public void clicks_on_register_option() {
        ReusableMethods.waitFor(1);
        homePage.registerOption.click();
    }
    @When("enters valid ssn in ssn input")
    public void enters_valid_ssn_in_ssn_input() {
        ReusableMethods.waitFor(1);
        fakeSsn = faker.idNumber().ssnValid();
        registerPage.snnRegister.sendKeys(fakeSsn);
    }
    @When("enters valid first name in first name input")
    public void enters_valid_first_name_in_first_name_input() {
        ReusableMethods.waitFor(1);
        fakeFirstName = faker.name().firstName();
        registerPage.firstNameRegister.sendKeys(fakeFirstName);
    }
    @When("enters valid last name in last name input")
    public void enters_valid_last_name_in_last_name_input() {
        ReusableMethods.waitFor(1);
        fakeLastName = faker.name().lastName();
        registerPage.lastNameRegister.sendKeys(fakeLastName);
    }
    @When("enters valid username in username input")
    public void enters_valid_username_in_username_input() {
        ReusableMethods.waitFor(1);
        fakeUserName = faker.name().username();
        registerPage.usernameRegister.sendKeys(fakeUserName);
    }
    @When("enters valid email in email input")
    public void enters_valid_email_in_email_input() {
        ReusableMethods.waitFor(1);
        fakeEmail = faker.internet().emailAddress();
        registerPage.emailRegister.sendKeys(fakeEmail);
    }
    @When("enters new password in new password input")
    public void enters_new_password_in_new_password_input() {
        ReusableMethods.waitFor(1);
        registerPage.newPasswordRegister.sendKeys(pwd);
    }
    @When("enters password again in new password confirmation")
    public void enters_password_again_in_new_password_confirmation() {
        ReusableMethods.waitFor(1);
        registerPage.confirmPasswordRegister.sendKeys(pwd);
    }
    @When("clicks register button")
    public void clicks_register_button() {
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(registerPage.registerButtonRegister);
    }
    @Then("verify new user registered successfully")
    public void verify_new_user_registered_successfully() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(registerPage.registerSuccessMessage.isDisplayed());
    }
    @Then("clicks user icon and Sign in option to login as admin")
    public void clicks_user_icon_and_sign_in_option_to_login_as_admin() {
        ReusableMethods.waitFor(1);
        homePage.userIcon.click();
        ReusableMethods.waitFor(1);
        homePage.signInOption.click();
    }
    @Then("enters {string} in username input")
    public void enters_in_username_input(String userName) {
        ReusableMethods.waitFor(1);
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty(userName));
    }
    @Then("enters {string} in password input")
    public void enters_in_password_input(String password) {
        ReusableMethods.waitFor(1);
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty(password));
    }
    @Then("clicks on Remember Me check box")
    public void clicks_on_remember_me_check_box() {
        ReusableMethods.waitFor(1);
        loginPage.rememberMeCheckbox.click();
    }
    @Then("clicks on Sign In submit button")
    public void clicks_on_sign_in_submit_button() {
        ReusableMethods.waitFor(1);
        loginPage.signInSubmitButton.click();
    }
    @When("admin clicks on Administration option")
    public void admin_clicks_on_administration_option() {
        ReusableMethods.waitFor(1);
        adminAdministrationPage.administrationIcon.click();
    }
    @When("clicks on User management option")
    public void clicks_on_user_management_option() {
        ReusableMethods.waitFor(1);
        adminAdministrationPage.userManagementIcon.click();
    }
    @Then("verify users heading is visible on the page")
    public void verify_users_heading_is_visible_on_the_page() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        List<String> expectedHeadingList = new ArrayList<>(Arrays.asList("ID", "Login", "SSN", "Email", "", "Language", "Profiles", "Created date", "Modified by", "Modified date", ""));
        boolean isHeadingExist = false;
        int idx = 0;
        for(WebElement eachHeading : adminAdministrationPage.userHeadingList){
            if(eachHeading.getText().equals(expectedHeadingList.get(idx)));
            isHeadingExist = true;
            idx++;
        }
        Assert.assertTrue(isHeadingExist);
    }
    @Then("clicks on Created date column to sort users")
    public void clicks_on_created_date_column_to_sort_users() {
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(adminAdministrationPage.createdDateButton);
    }
    @Then("clicks on View button of created user")
    public void clicks_on_view_button_of_created_user() {
        ReusableMethods.waitFor(2);
        adminAdministrationPage.viewNewlyCreatedUserButton.click();
    }
    @Then("verify first name, last name, email credentials")
    public void verify_first_name_last_name_email_credentials() {
        ReusableMethods.waitFor(1);
        Assert.assertEquals(fakeFirstName, adminAdministrationPage.viewUserFirstName.getText());
        Assert.assertEquals(fakeLastName, adminAdministrationPage.viewUserLastName.getText());
        Assert.assertEquals(fakeEmail, adminAdministrationPage.viewUserEmail.getText());
    }


//    ************************************************************************

    @Then("verify Edit button is visible for created user")
    public void verifyEditButtonIsVisibleForCreatedUser() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminAdministrationPage.editNewlyCreatedUserButton.isDisplayed());
    }

//    *************************************************************************

    @When("clicks on Edit button of created user")
    public void clicks_on_edit_button_of_created_user() {
        ReusableMethods.waitFor(1);
        adminAdministrationPage.editNewlyCreatedUserButton.click();
    }
    @Then("verify user is on Edit page")
    public void verify_user_is_on_edit_page() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("edit"));
    }
    @When("clicks on activate check box")
    public void clicks_on_activate_check_box() {
        ReusableMethods.waitFor(1);
        if(!adminAdministrationPage.activatedCheckBox.isSelected()){
            adminAdministrationPage.activatedCheckBox.click();
        }
    }
    @When("clicks on save button")
    public void clicks_on_save_button() {
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(adminAdministrationPage.saveButton);
    }
    @Then("verify user has been activated")
    public void verify_user_has_been_activated() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(adminAdministrationPage.activatedSuccessMessage.getText().contains("updated"));
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(adminAdministrationPage.IDButton);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(fakeEmail, adminAdministrationPage.emailOfNewlyUpdatedUser.getText());
        Assert.assertEquals("Activated", adminAdministrationPage.activatedStatusOfNewlyUpdatedUser.getText());
    }


//    *************************************************************************

    @Then("verify admin can assign {string} {string} to user")
    public void verifyAdminCanAssignToUser(String role, String index) {
        Select select = new Select(adminAdministrationPage.profilesRolesDropdown);
        List<WebElement> allRoles = select.getOptions();
        ReusableMethods.waitFor(1);
        System.out.println(allRoles.get(Integer.parseInt(index)).getText());
        Assert.assertTrue(allRoles.get(Integer.parseInt(index)).getText().contains(role));
        select.selectByValue(role);

        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(adminAdministrationPage.saveButton);
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(adminAdministrationPage.IDButton);

        ReusableMethods.waitFor(1);
        Assert.assertEquals(fakeEmail, adminAdministrationPage.emailOfNewlyUpdatedUser.getText());
        Assert.assertTrue(adminAdministrationPage.profileRoleOfNewlyUpdatedUser.getText().contains(role));
    }


//    *************************************************************************

    @And("admin clicks on Created date column to sort users")
    public void adminClicksOnCreatedDateColumnToSortUsers() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(1);

    }
    @Then("verify Delete button is visible")
    public void verify_delete_button_is_visible() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminAdministrationPage.deleteNewlyCreatedUserButton.isDisplayed());
        JSUtils.clickElementByJS(adminAdministrationPage.createdDateButton);
    }
    @Then("clicks on Delete button")
    public void clicks_on_delete_button() {
        ReusableMethods.waitFor(1);
        adminAdministrationPage.deleteNewlyCreatedUserButton.click();
    }
    @Then("confirm Delete operation in confirmation message")
    public void confirm_delete_operation_in_confirmation_message() {
        ReusableMethods.waitFor(1);
        adminAdministrationPage.confirmDeleteButton.click();
    }
    @Then("verify user is deleted")
    public void verify_user_is_deleted() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(adminAdministrationPage.deleteSuccessMessage.isDisplayed());
        Assert.assertTrue(adminAdministrationPage.deleteSuccessMessage.getText().contains("deleted"));

    }


}

