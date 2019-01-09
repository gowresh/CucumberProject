package com.gowresh.StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import comm.gowresh.Utility.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Scenario {

	public static WebDriver driver;
	public static String toolTipSessionValue;
	public static String tempWindowValue;
	public static String windowSessionValue;
	public static WebElement hoverToElement;
	
	
	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gnagesh\\git\\SeleniumConcepts\\Selenium\\EXE\\chromedriver.exe");
		 ChromeOptions chromeOptions = new ChromeOptions();
	      chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");	    
	      //driver = new ChromeDriver();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.highcharts.com/demo/line-ajax");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("^MouseOver to Jan 5 2018 and note only the session count$")
	public void mouseOver_to_Jan_5_2018_and_store_only_session_count_to_a_variable() throws Throwable{
		 Thread.sleep(5000);	
		    driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept")).click();
		    
		    hoverToElement = new WebDriverWait(driver, 10)
			        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g'][4]/*[name()='path'][19]")));
		    Thread.sleep(5000);
		    
			new Actions(driver).moveToElement(hoverToElement).build().perform();
			Thread.sleep(5000);
			
			toolTipSessionValue= driver.findElement(By.xpath("//*[name()='svg']/*[name()='g'][15]/*[name()='text']/*[name()='tspan'][7]")).getText();      
        
	}
	
	@And("^Click on it and that session will be highlighted$")
	public void Click_on_it_and_that_session_will_be_highlighted() throws Throwable{
		 Thread.sleep(5000);
		 hoverToElement.click();
	}
	
	@Then("^Now Compare session count between tool tip and highlighted window$")
	public void now_Compare_session_count_between_tool_tip_and_highlighted_window() throws Throwable{
		
		tempWindowValue = driver.findElement(By.xpath("//div[@class='highslide-container']/div[3]/div/div/div/div[2]/div/div")).getText();
		windowSessionValue = Helper.getOnlySessionCount(tempWindowValue);
		
		System.out.println(toolTipSessionValue);
		System.out.println(windowSessionValue);
		Assert.assertEquals(toolTipSessionValue.trim(), windowSessionValue.trim());
	
	    driver.close();
			 
	}
	
	
}
