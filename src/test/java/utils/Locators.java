package utils;

import org.openqa.selenium.By;

public interface Locators {

    String url = "https://opensource-demo.orangehrmlive.com";

    //Login

    By usernameLogin = By.cssSelector("input#txtUsername");
    By passwordLogin = By.cssSelector("input#txtPassword");
    By submitLogin = By.cssSelector("input#btnLogin");
    By welcome = By.cssSelector("a#welcome");


    // mainMenu

    By mainMenuDiv = By.cssSelector("div#mainMenu");

    String[] menuLinks ={"Admin","User Management","Users"};

    // Users

    By buttonUserAdd = By.cssSelector("input#btnAdd");
    By buttonUserDelete = By.cssSelector("input#btnDelete");
    By userTypeSelect = By.cssSelector("select#systemUser_userType");
    By employeeNameInput = By.cssSelector("input#systemUser_employeeName_empName");
    By userNameInput = By.cssSelector("input#systemUser_userName");
    By statusSelect = By.cssSelector("select#systemUser_status");
    By passwordInput = By.cssSelector("input#systemUser_password");
    By passwordConfirmInput = By.cssSelector("input#systemUser_confirmPassword");
    By saveButton = By.cssSelector("input#btnSave");
    By editButton = By.cssSelector("input[id='btnSave'][value='Edit']");
    By validationErrors = By.cssSelector("span.validation-error");
    By buttonUserDeleteDialog = By.cssSelector("input#dialogDeleteBtn");


    By searchUserNameInput = By.cssSelector("input#searchSystemUser_userName");
    By searchUserTypeSelect = By.cssSelector("select#searchSystemUser_userType");
    By searchUserStatusSelect = By.cssSelector("select#searchSystemUser_status");
    By searchButton = By.cssSelector("input#searchBtn");
    By resultTable = By.cssSelector("table#resultTable");




     default void deneme(){
        // interface lerde gövdeli method yazamiyorduk.

        // Java 8 den sonra default olarak ekleme yapilmis durumda

    }
}
