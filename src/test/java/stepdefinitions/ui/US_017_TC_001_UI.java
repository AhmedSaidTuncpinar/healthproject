package stepdefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.RoomPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;


public class US_017_TC_001_UI{

    HomePage homePage = new HomePage();
    RoomPage roomPage = new RoomPage();

    String newNum;

    @And("user clicks on Items&Titles")
    public void userClicksOnItemsTitles() {
        homePage.itemsAndTitles.click();
    }

    @And("user clicks on Room option")
    public void userClicksOnRoomOption() {
        homePage.roomOption.click();
    }


    @And("user clicks on Create a new room button")
    public void userClicksOnCreateANewRoomButton() {
        roomPage.createANewRoomButton.click();
    }


    @And("user enters a unique number {string} in Room Number input")
    public void userEntersAUniqueNumberInRoomNumberInput(String string) {

        Random r = new Random();
        int min = 10, max = 99;
        int rn = r.nextInt(max - min) + min;
        newNum = String.valueOf(rn) + string + String.valueOf(rn);

    }


    @And("user enters {string} in Room Number input")
    public void userEntersInRoomNumberInput(String roomNumber) {
        roomPage.roomNumberInput.sendKeys(roomNumber);
    }


    @And("user selects Suit option from Room Type dropdown")
    public void userSelectsSuitOptionFromRoomTypeDropdown() {

        new Select(roomPage.roomTypeDropdown).selectByIndex(3);          //suite is in index 3 in webside
    }

    @And("user selects {string} from Room Type dropdown")
    public void userSelectsFromRoomTypeDropdown(String string) {
        new Select(roomPage.roomTypeDropdown).selectByVisibleText(string);
    }

    @And("user clicks on status checkbox")
    public void userClicksOnStatusCheckbox() {

        roomPage.statusCheckbox.click();
    }


    @And("user verifies status is selected")
    public void userVerifiesStatusIsSelected() {
        assertTrue(roomPage.statusCheckboxIsClicked.isDisplayed());
    }

    @And("user enters {string} in Price input")
    public void userEntersInPriceInput(String price) {

        roomPage.priceInput.sendKeys(price);
    }

    @And("user enters {string} in Description input")
    public void userEntersInDescriptionInput(String description) {

        roomPage.decriptionInput.sendKeys(description);
    }

    @And("user does not enter description in Description input")
    public void userDoesNotEnterDescriptionInDescriptionInput() {
    }

    @And("user clicks on Save button")
    public void userClicksOnSaveButton() {
        roomPage.saveButton.submit();
    }

    @And("user clicks on Created Date")
    public void userClicksOnCreatedDate() {
        ReusableMethods.waitFor(5);
        JSUtils.clickElementByJS(roomPage.createdDate);
        ReusableMethods.waitFor(5);
    }



    @Then("user verifies {string} text is visible for {string}")
    public void userVerifiesTextIsVisibleFor(String string1, String string2) {

        if(string2.equals("room number")) {
            ReusableMethods.waitFor(3);
            assertTrue(Driver.getDriver().getPageSource().contains("This field is required."));
        }

        if(string2.equals("price")) {
            ReusableMethods.waitFor(3);
            assertTrue(Driver.getDriver().getPageSource().contains("This field is required."));
        }
    }


    @Then("user verifies {string} text is visible")
    public void userVerifiesTextIsVisible(String string) {

        if(string.equals("Rooms")) {
            assertTrue(roomPage.roomText.isDisplayed());
        }

        if(string.equals("Create or edit a Room")) {
            assertTrue(roomPage.createEditRoomText.isDisplayed());
        }
    }


    @Then("user verifies all rooms are created with same room numbers {string}")
    public void userVerifiesAllRoomsAreCreatedWithSameRoomNumbers(String roomNumbers) {
        ReusableMethods.waitFor(3);
        ReusableMethods.waitForVisibility(roomPage.firstRoomNumber,10);
        assertEquals(roomNumbers, roomPage.firstRoomNumber.getText());

    }

    @And("user does not enter room number")
    public void userDoesNotEnterRoomNumber() {
    }


    @And("user verifies {string} is selectable from Room Type options")
    public void userVerifiesIsSelectableFromRoomTypeOptions(String string) {
        Select select = new Select(roomPage.roomTypeDropdown);

        ReusableMethods.waitFor(3);


        List<WebElement> allRooms = select.getOptions();
        for(WebElement each: allRooms){
            System.out.println(each.getText());
            assertTrue(each.isDisplayed());
        }
    }


    @And("user enters a passed date")
    public void userEntersAPassedDate() {

        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println(currentDate.minusDays(3));           //2023-02-25T12:39:24.768119200

        String s = String.valueOf(currentDate);
        String day = s.substring(7,9);
        String month = s.substring(5,7);
        String year = s.substring(0,4);
        String time1 = "10";
        String time2 = "30";


        Actions actions = new Actions(Driver.getDriver());
        actions.click(roomPage.roomCreatedDate).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(day).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(month).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(year).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(time1).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(time2).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
    }



    @And("user enters current date or later date")
    public void userEntersCurrentDateOrLaterDate() {

        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println(currentDate.plusDays(5));           //2023-02-25T12:39:24.768119200

        String s = String.valueOf(currentDate);
        String day = s.substring(7,9);
        String month = s.substring(5,7);
        String year = s.substring(0,4);
        String time1 = "10";
        String time2 = "30";



        Actions actions = new Actions(Driver.getDriver());
        actions.click(roomPage.roomCreatedDate).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(day).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(month).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(year).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(time1).sendKeys(Keys.TAB)
                .sendKeys(Keys.DELETE)
                .sendKeys(time2).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
    }



    @And("user edits {string} from Room Type dropdown")
    public void userEditsFromRoomTypeDropdown(String roomType) {
        new Select(roomPage.roomTypeDropdown).selectByVisibleText(roomType);

    }

    @And("user edits {string} in Price input")
    public void userEditsInPriceInput(String price) {
        roomPage.priceInput.click();
        roomPage.priceInput.clear();
        roomPage.priceInput.sendKeys(price);
    }

    @And("user edits {string} in Description input")
    public void userEditsInDescriptionInput(String newdecription) {
        roomPage.decriptionInput.click();
        roomPage.decriptionInput.clear();
        roomPage.decriptionInput.sendKeys(newdecription);
    }

    @Then("user verifies the room is edited with new {string}, {string} and {string}")
    public void userVerifiesTheRoomIsEditedWithNewAnd(String roomType, String roomPrice, String description) {
        assertTrue(roomPage.newRoomType.getText().equals(roomType));
        assertTrue(roomPage.newPrice.getText().equals(roomPrice));
        assertTrue(roomPage.newDescription.getText().equals(description));

    }
}






