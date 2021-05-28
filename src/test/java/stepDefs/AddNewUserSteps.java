package stepDefs;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Locators;
import utils.MyMethods;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddNewUserSteps extends MyMethods {
    String username;

    @When("User create a new user as follows")
    public void userCreateANewUserAsFollows(DataTable dataTable) {

        List<String > user = dataTable.asList();

        $(buttonUserAdd).shouldBe(Condition.visible).click();
        $(userTypeSelect).shouldBe(Condition.visible).selectOptionContainingText(user.get(0));
        $(employeeNameInput).setValue(user.get(1));
        $(userNameInput).setValue(user.get(2));
        $(statusSelect).selectOption(user.get(3));
        $(passwordInput).setValue(user.get(4));
        $(passwordConfirmInput).setValue(user.get(5));
        $$(validationErrors).filterBy(Condition.visible).shouldHaveSize(0);
        $(saveButton).click();
        $("html").shouldHave(Condition.text("Successfully Saved"));

     //   username = user.get(2);

    }

//    @Then("User should be created")
//    public void userShouldBeCreated() {
//
//        $(searchUserNameInput).shouldBe(Condition.visible).setValue(username);
//        $(searchButton).click();
//        $(resultTable).shouldHave(Condition.text(username));
//    }


    @And("User search username as {string}")
    public void userSearchUsernameAs(String user) {
        $(searchUserNameInput).shouldBe(Condition.visible).setValue(user);
        $(searchButton).click();
    }


    @Then("User {string} should be listed")
    public void userShouldBeListed(String user) {

        $(resultTable).shouldHave(Condition.text(user));

    }



}
