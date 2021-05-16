package com.demo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/resources",
        glue = {"com.demo.stepdefinition.BackGround_Steps",
                "com.demo.stepdefinition.MainPagesSteps"},
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")
public class MainPageTest {

}
