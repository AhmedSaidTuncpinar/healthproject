package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = " //button[@type='submit']")
    public WebElement signInSubmitButton;


    @FindBy(xpath = "//span[.='Register a new account']")
    public WebElement registerANewAccountLink;

    @FindBy(xpath = "//span[.='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[.='Failed to sign in!']")
    public WebElement failedSigninMessage;

    @FindBy(xpath = "//*[text()='SIGN IN AGAIN']")
    public WebElement SigninAgain;






}
