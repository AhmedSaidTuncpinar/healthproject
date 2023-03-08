package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffMyPage {

    public StaffMyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@aria-haspopup='true'])[1]")
    public WebElement staffMyPages;

    @FindBy(xpath = "(//a[@role='menuitem'])[1]")
    public WebElement staffSearchPatient;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement staffSearchSsn;

    @FindBy(xpath = "//a[@class='btn btn-warning btn-sm']")
    public WebElement staffShowAppointments;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement staffShowTest;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement staffViewResults;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement staffEditTest;

    @FindBy(id = "c-test-result-result")
    public WebElement staffTestResult;

    @FindBy(id = "save-entity")
    public WebElement staffTestResultSave;

    @FindBy(id = "c-test-result-description")
    public WebElement staffTestDescription;

    @FindBy(id = "c-test-result-id")
    public WebElement staffTestId;

    @FindBy(id = "c-test-result-date")
    public WebElement staffTestDate;

    @FindBy(id = "c-test-result-createdDate")
    public WebElement staffTestCreatedDate;

    @FindBy(id = "c-test-result-cTestItem")
    public WebElement staffTestItem;

    @FindBy(id = "c-test-result-cTest")
    public WebElement staffTestInput;

    @FindBy(xpath = "(//span[.='Edit'])[1]")
    public WebElement editAppointmentStaff;

    @FindBy(id = "appointment-status")
    public WebElement statusPendingStaff;

    @FindBy(id = "appointment-physician")
    public WebElement physicianChoose;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveAppointmentEditStaff;




}
