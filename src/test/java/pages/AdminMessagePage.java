package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminMessagePage {

    public AdminMessagePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='dropdown-item'])[9]")
    public WebElement itemsAndTitlesMessage;

    @FindBy(id = "jh-create-entity")
    public WebElement createNewMessage;

    @FindBy(id = "c-message-name")
    public WebElement createMessageName;

    @FindBy(id = "c-message-email")
    public WebElement createMessageEmail;

    @FindBy(id = "c-message-subject")
    public WebElement createMessageSubject;

    @FindBy(id = "c-message-message")
    public WebElement createMessageMessage;

    @FindBy(id = "save-entity")
    public WebElement saveCreatingMessage;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewMessage;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement viewMessageAndEdit;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteMessage;


}

