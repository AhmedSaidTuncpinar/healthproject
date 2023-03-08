package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RoomPage {

    public RoomPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "jh-create-entity")
    public WebElement createANewRoomButton;

    @FindBy(id = "room-roomNumber")
    public WebElement roomNumberInput;

    @FindBy(id = "room-roomType")
    public WebElement roomTypeDropdown;

    @FindBy(id = "room-status")
    public WebElement statusCheckbox;

    @FindBy(xpath = "//input[@value='true']")
    public WebElement statusCheckboxIsClicked;

    @FindBy(id = "room-price")
    public WebElement priceInput;

    @FindBy(id = "room-description")
    public WebElement decriptionInput;

    @FindBy(id = "room-createdDate")
    public WebElement roomCreatedDate;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//span[.='Created Date']")
    public WebElement createdDate;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement firstRoomNumber;

    @FindBy(xpath = "//tbody//tr[1]//td[3]")
    public WebElement newRoomType;

    @FindBy(xpath = "//tbody//tr[1]//td[5]")
    public WebElement newPrice;

    @FindBy(xpath = "//tbody//tr[1]//td[6]")
    public WebElement newDescription;

    @FindBy(xpath = "//span[.='Create or edit a Room']")
    public WebElement createEditRoomText;

    @FindBy(xpath = "//div[@class='invalid-feedback']")         //"(//div[.='This field is required.'])[1]//div"
    public WebElement thisFieldIsRequiredText;


    @FindBy(xpath = "//span[.='Edit']")
    public WebElement editButton;

    @FindBy(id = "room-heading")
    public WebElement roomText;




}