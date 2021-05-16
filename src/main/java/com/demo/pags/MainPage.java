package com.demo.pags;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://www.exercise1.com/values";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    @FindBy(id = "lbl_val_1")
    private WebElement label_value1;
    @FindBy(id = "txt_val_1")
    private WebElement amount_value1;
    @FindBy(id = "lbl_val_2")
    private WebElement label_value2;
    @FindBy(id = "txt_val_2")
    private WebElement amount_value2;
    @FindBy(id = "lbl_val_3")
    private WebElement label_value3;
    @FindBy(id = "txt_val_4")
    private WebElement amount_value3;
    @FindBy(id = "lbl_val_4")
    private WebElement label_value4;
    @FindBy(id = "txt_val_5")
    private WebElement amount_value4;
    @FindBy(id = "lbl_val_5")
    private WebElement label_value5;
    @FindBy(id = "txt_val_6")
    private WebElement amount_value5;
    @FindBy(id = "lbl_ttl_val")
    private WebElement label_totalBalance;
    @FindBy(id = "txt_ttl_val")
    private WebElement amount_totalBalance;
    @FindAll(
            @FindBy (xpath="//*[contains(@id,'lbl_val')]")
            )
    private List<WebElement> allValues;
    double value1 = Double.valueOf(amount_value1.getText().substring(1));
    double value2 = Double.valueOf(amount_value2.getText().substring(1));
    double value3 = Double.valueOf(amount_value3.getText().substring(1));
    double value4 = Double.valueOf(amount_value4.getText().substring(1));
    double value5 = Double.valueOf(amount_value5.getText().substring(1,6));

    public MainPage(WebDriver driver){
        driver = this.driver;
        wait = new WebDriverWait(driver,20);
        softAssert= new SoftAssert();
        PageFactory.initElements(driver, this);
    }

    public void openMainPage(){
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize() ;
        wait.until(ExpectedConditions.visibilityOf(label_value1));
    }

    public int verifyCountofValues(){
        return allValues.size();
    }

    public void verifyValuesAreGreaterThanZero(){


        if(value1>0&&value2>0
                &&value3>0&&value4>0
                &&value5>0){
            softAssert.assertTrue(true, "All Values are greater than 0.");
        }
        else {
            softAssert.assertTrue(false, "All Values are not greater than 0.");
        }

    }

    public void verifyTotalBalance(){
        double totalBalance = value1+value2+value3+value4+value5;
        BigDecimal totalBalanceDecimal = BigDecimal.valueOf(totalBalance);
        BigDecimal totalBalanceUI = BigDecimal.valueOf(Double.valueOf(amount_totalBalance.getText().substring(1)));
        softAssert.assertEquals(totalBalance,totalBalanceUI, "Total Balance is matched");
    }

     public void allvaluesAreCurrency(){
        if(amount_value1.getText().contains("$")
        && amount_value2.getText().contains("$")
        && amount_value3.getText().contains("$")
        && amount_value4.getText().contains("$")
        && amount_value5.getText().contains("$")
        && amount_totalBalance.getText().contains("$")){
            softAssert.assertTrue(true, "All currencies are in dollar.");
        }
        else{
            softAssert.assertTrue(false, "All currencies are not in dollar.");
        }
    }


}
