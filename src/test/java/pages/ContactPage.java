package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ContactPage {

    public ContactPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "name")
    public WebElement nameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "subject")
    public WebElement subjectInput;

    @FindBy(name = "message")
    public WebElement messagetextBox;

    @FindBy(id = "register-submit")
    public WebElement sendButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public List<WebElement> requiredFieldErrorMessages;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement emailRequiredFieldErrorMessage;

    @FindBy(xpath = "(//div[@role='alert'])[2]")
    public WebElement secondSuccessMessage;

}

