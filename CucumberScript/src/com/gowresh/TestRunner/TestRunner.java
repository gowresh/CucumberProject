package com.gowresh.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "./features",
		glue = {"com.gowresh.StepDef"},
		tags = {"@AssignmentScenario"},
		plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber-json"},
		monochrome = true
		)
public class TestRunner {

	private TestNGCucumberRunner testRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception{
		testRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features(){
		return testRunner.provideFeatures();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception{
		testRunner.finish();
	}
}
