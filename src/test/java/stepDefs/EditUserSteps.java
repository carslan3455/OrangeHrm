package stepDefs;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.Locators;
import utils.MyMethods;

import static com.codeborne.selenide.Selenide.$;

public class EditUserSteps extends MyMethods {

    @When("User edits {string}")
    public void userEdits(String username) {

        $(resultTable).find(By.linkText(username)).shouldBe(Condition.visible).click();
        $(editButton).shouldBe(Condition.visible).click();
        $(userTypeSelect).shouldBe(Condition.enabled);
    }

    @And("User update user name as {string}")
    public void userUpdateUserNameAs(String newUsername) {

        $(userNameInput).setValue(newUsername);
        $(By.cssSelector("span[for='systemUser_userName']")).shouldNotBe(Condition.visible);
        // todo bir kere exist olunca sayfadan silinmiyor. Onun icin visible olma secenegini kontrol edemedik
        $(saveButton).click();
    }

    @Then("Update should be successfully")
    public void updateShouldBeSuccessfully() {
        $("html").shouldHave(Condition.text("Successfully Updated"));
    }
}
