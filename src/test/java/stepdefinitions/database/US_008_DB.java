package stepdefinitions.database;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.JdbcUtils;

import java.util.List;

public class US_008_DB {

    List<Object> idsList;
    List<Object> createdByList;

    @Given("user connects to the Medunna application database to read appointment")
    public void user_connects_to_the_application_database_to_read_appointment() {
        JdbcUtils.connectToDatabase("157.230.48.97","medunna_db_v2","select_user", "Medunna_pass_@6");
        JdbcUtils.createStatement();
    }

    @Given("user gets the column {string} from {string} table")
    public void user_gets_the_column_from_table(String columnName, String table) {
        idsList = JdbcUtils.getColumnList(columnName, table);
        //System.out.println(idsList);
    }

    @Then("verify table {string} and column {string} contains expected data {string}")
    public void verify_table_and_column_contains_data(String table, String columnData, String id) {
        Assert.assertTrue(idsList.toString().contains(id));
    }

    @Then("close the Medunna database connection")
    public void closeTheMedunnaDatabaseConnection() {
        JdbcUtils.closeConnectionAndStatement();
    }

    @When("user sends the query to get the values of {string} column from {string} table")
    public void user_sends_the_query_to_get_the_names_of_column_from_table(String columnName, String table) {
        createdByList = JdbcUtils.getColumnList(columnName, table);

    }
    @Then("assert there are some appointments created by {string}")
    public void assert_that_there_are_some_appointments_created_by(String name) {
        Assert.assertTrue(createdByList.toString().contains(name));
    }

}

/*
DataBase Credentials:
   DataBaseIP: 157.230.48.97
   Database Name: medunna_db_v2
   Username: select_user
   Password: Medunna_pass_@6
 */

