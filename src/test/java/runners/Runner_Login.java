package runners;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.Listener;

@CucumberOptions(
        features = {"src/test/java/features"},
        tags = "@Login",
        glue = {"stepDefs"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary"}


)

@Listeners(Listener.class)
public class Runner_Login extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suit");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeClass
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }
}
