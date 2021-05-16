package com.demo.stepdefinition;

import com.demo.pags.MainPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class BackGround_Steps {
    protected WebDriver driver;
    private MainPage mainPage;

    public BackGround_Steps(WebDriver driver){
        driver = this.driver;
        this.mainPage = new MainPage(driver);
    }
    @Given("^I navigate to the Main page and user is successfully navigated to MainPage$")
    public void i_navigaye_to_mainPage(){
        this.mainPage.openMainPage();
    }
}
