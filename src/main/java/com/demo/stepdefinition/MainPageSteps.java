package com.demo.stepdefinition;

import com.demo.pags.MainPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class MainPageSteps {
    protected WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver){
        driver = this.driver;
        this.mainPage = new MainPage(driver);
    }

    @Then("^verify the right count of values appear on the screen$")
    public void verify_the_count(){
        this.mainPage.verifyCountofValues();
        System.out.println(this.mainPage.verifyCountofValues()+ "Count of values");
    }

    @Then("^verify the values on the screen are greater than 0$")
    public void values_greater_than_zero(){
        this.mainPage.verifyValuesAreGreaterThanZero();
    }
    @Then("^verify the total balance is correct based on the values listed on the screen and the total balance matches the sum of the values$")
    public void verify_total_balance(){
        this.mainPage.verifyTotalBalance();
    }

    @Then("^verify the values are formatted as currencies$")
    public void verify_currencies(){
        this.mainPage.allvaluesAreCurrency();
    }
}
