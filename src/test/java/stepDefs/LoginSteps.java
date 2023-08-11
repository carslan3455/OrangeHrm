package stepDefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.Locators;
import utils.MenuLinks;
import utils.MyMethods;


import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps extends MyMethods implements Locators {


    @Given("User on home page")
    public void userOnHomePage() {
        open(url);
    }

    @When("User login as follows")
    public void userLoginAsFollows(DataTable dataTable) {
        List<String> list = dataTable.asList();
        $(usernameLogin).shouldBe(Condition.appear).setValue(list.get(0));
        $(passwordLogin).setValue(list.get(1));
        $(submitLogin).click();

    }

    @Then("Login should be successfull")
    public void loginShouldBeSuccessfull() {

//        $(welcome).shouldBe(Condition.appear);
        String successUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(welcomeUrl,successUrl);


    }

    @And("User navigate to Users Menu")
    public void userNavigateToUsersMenu() {

        back();

        // todo 1. Yöntem bu sekilde tek tek yazilabilir
//        Configuration.holdBrowserOpen = true;   // test bitince browser kapatmasin görelim diye
//        $(mainMenuDiv).find(By.linkText("Admin")).hover();
//        $(mainMenuDiv).find(By.linkText("User Management")).hover();
//        $(mainMenuDiv).find(By.linkText("Users")).hover().click();
//
//
//        $(mainMenuDiv).find(By.linkText("Time")).hover();
//        $(mainMenuDiv).find(By.linkText("Reports")).hover();
//        $(mainMenuDiv).find(By.linkText("Project Reports")).hover().click();

        // todo 2. Yöntem bu sekilde tek tek yazilabilir
//        navigateOnMenuTo1("Admin","User Management","Users");

        // todo 3. Yöntem bu sekilde tek tek yazilabilir
//        navigateOnMenuTo1(menuLinks);

        // todo 4. Yöntem bu sekilde tek tek yazilabilir. ---ENUM---

//        navigateOnMenuTo(MenuLinks.Users);
//        navigateOnMenuTo1(MenuLinks.Users.getLinks());
//          navigateOnMenuTo(MenuLinks.Apply);

    }


}
