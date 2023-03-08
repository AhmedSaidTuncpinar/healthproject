package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientAppointmentPage {

    public PatientAppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='MY PAGES(PATIENT)']")
    public WebElement myPagesPatientIcon;

    @FindBy(xpath = "//span[.='Make an Appointment']")
    public WebElement makeAnAppointmentIcon;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "ssn")
    public WebElement ssnInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "phone")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//span[.='Send an Appointment Request']")
    public WebElement sendAnAppointmentRequestButton;

    @FindBy(xpath = "//div[@role='alert']/span/strong")
    public WebElement toastContainerSuccessMessage;

    @FindBy (id = "appoDate")
    public WebElement appointmentDateInput;

    @FindBy(xpath = "//span[.='Appointment date can not be past date!']")
    public WebElement pastDateFailureMessage;

    @FindBy(xpath = "//div[.='Phone number is required.']")
    public WebElement phoneNumberFailureMessage;







}

