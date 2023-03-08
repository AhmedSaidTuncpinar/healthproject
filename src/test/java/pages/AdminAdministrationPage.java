package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminAdministrationPage {

    public AdminAdministrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table//th[8]")
    public WebElement createdDateOption;

    @FindBy(xpath = "//table//tr[4]//td[2]")
    public WebElement lastRegisteredUserName;

    @FindBy(xpath = "//table//tr[4]//td[5]")
    public WebElement deActivateButton;

    @FindBy(xpath = "//table//tr[4]//td[11]//span[.='Edit']")
    public WebElement editOption;

    @FindBy(xpath = "//table//tr[4]//td[7]//span")
    public WebElement roleOfUser;

    @FindBy(xpath = "//span[.='Administration']")
    public WebElement administrationIcon;

    @FindBy(xpath = "//*[.='Create a new user']")
    public WebElement createNewUser;

    //Create or edit a user

    @FindBy(id = "login")
    public WebElement loginUserName;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(xpath = "//*[.='ROLE_PATIENT']")
    public WebElement rolePatient;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

//****************************** US_21 ***************************************

    @FindBy(xpath = "//span[.='User management']")
    public WebElement userManagementIcon;

    @FindBy(xpath = "//th")
    public List<WebElement> userHeadingList;

//    @FindBy(xpath = "//span[.='Created date']")
//    public WebElement createdDateButton;

    @FindBy(xpath = "//thead//th[8]")
    public WebElement createdDateButton;

    @FindBy(xpath = "(//span[.='View'])[5]")
    public WebElement viewNewlyCreatedUserButton;

    @FindBy(xpath = "//dd[2]")
    public WebElement viewUserFirstName;

    @FindBy(xpath = "//dd[3]")
    public WebElement viewUserLastName;

    @FindBy(xpath = "//dd[4]")
    public WebElement viewUserEmail;

    @FindBy(xpath = "(//span[.='Edit'])[5]")
    public WebElement editNewlyCreatedUserButton;

    @FindBy(xpath = "//input[@id='activated']")
    public WebElement activatedCheckBox;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement activatedSuccessMessage;

    @FindBy(xpath = "//tr[1]/td[5]/button/span")
    public WebElement activatedStatusOfNewlyUpdatedUser;

    @FindBy(xpath = "//thead/tr/th[1]/span")
    public WebElement IDButton;

    @FindBy(xpath = "//tr[1]/td[4]")
    public WebElement emailOfNewlyUpdatedUser;

    @FindBy(id = "authorities")
    public WebElement profilesRolesDropdown;

    @FindBy(xpath = "//tr[1]/td[7]/div/span")
    public WebElement profileRoleOfNewlyUpdatedUser;

    @FindBy(xpath = "(//span[.='Delete'])[5]")
    public WebElement deleteNewlyCreatedUserButton;

    @FindBy(xpath = "//button[2]/span")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement deleteSuccessMessage;



}
