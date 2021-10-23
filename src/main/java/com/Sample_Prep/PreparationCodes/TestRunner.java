package com.Sample_Prep.PreparationCodes;
import org.junit.runner.RunWith;
import io.cucumber.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="Resources\\SampleCucum2.feature", glue={"com.Sample_Prep.PreparationCodes"}, tags = "@SmokeTest or @RegressionTest")

public class TestRunner {

}
