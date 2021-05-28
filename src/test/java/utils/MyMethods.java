package utils;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyMethods implements Locators{

    public static void navigateOnMenuTo1(String...links){  // todo varargs

        for (int i = 0; i < links.length-1 ; i++) {
            $(mainMenuDiv).find(By.linkText(links[i])).shouldBe(Condition.visible).hover();
        }

        $(mainMenuDiv).find(By.linkText(links[links.length-1])).shouldBe(Condition.visible).click();

    }


    public static void navigateOnMenuTo(MenuLinks menuLinks){
        String[] links = menuLinks.getLinks();

        navigateOnMenuTo1(links);
    }


    public By getCheckboxOf(String name){
        return By.xpath("//a[text()='" + name + "']//ancestor::tr//input[@type='checkbox']");
    }



}
