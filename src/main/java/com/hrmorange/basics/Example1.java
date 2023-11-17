package com.hrmorange.basics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example1 
{
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test(priority = 1)
	public void verifyTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority = 2)
	public void verifyUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	

}
