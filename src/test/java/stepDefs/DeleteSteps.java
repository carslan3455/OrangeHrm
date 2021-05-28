package stepDefs;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import utils.MyMethods;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeleteSteps extends MyMethods {
    @When("User delete the {string}")
    public void userDeleteThe(String username) {

        $(getCheckboxOf(username)).should(Condition.visible).click();
        $(buttonUserDelete).shouldBe(Condition.enabled).click();
        $(buttonUserDeleteDialog).shouldBe(Condition.visible).click();
    }

    @Then("User should be deleted")
    public void userShouldBeDeleted() {
        $("html").shouldHave(Condition.text("Successfully Deleted"));
    }

    @When("User search as follows")
    public void userSearchAsFollows(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();

        for (Map<String, String> map : maps) {
            String userType;
            if (map.get("UserType") == null) {
                userType = "All";
            } else
                userType = (!map.get("UserType").equals("Admin") && !map.get("UserType").equals("ESS")) ? "All" : map.get("UserType");
            String status;
            if (map.get("Status") == null) {
                status = "All";
            } else
                status = (!map.get("Status").equals("Admin") && !map.get("Status").equals("ESS")) ? "All" : map.get("Status");

            $(searchUserTypeSelect).selectOption(userType);
            $(searchUserStatusSelect).selectOption(status);
            $(searchButton).click();

            if ($$(By.xpath("//table[@id='resultTable']//td[3]")).size() > 0) {

                if (!userType.equals("All")) {
                    System.out.println("UserType befor: " + $$(By.xpath("//table[@id='resultTable']//td[3]")).size());
                    $$(By.xpath("//table[@id='resultTable']//td[3]")).filter(Condition.not(Condition.text(userType))).shouldHaveSize(0);
                    System.out.println("UserType after: " + $$(By.xpath("//table[@id='resultTable']//td[3]")).size());

                }
                if (!status.equals("All")) {
                    $$(By.xpath("//table[@id='resultTable']//td[5]")).filter(Condition.not(Condition.text(status))).shouldHaveSize(0);
                }
            }
        }
    }


    // value siradan kontrol etmek icin method.
    public boolean justifyArrayWith(List<String> list, String value) {

        for (String s : list) {
            if (!s.equals(value))
                return false;
        }
        return true;
    }
}
