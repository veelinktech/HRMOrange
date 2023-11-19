package com.hrmorange.basics;

import java.time.Duration;

import org.openqa.selenium.By;
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
	
	@Test(priority = 3)
	public void verifyLoginTitle()
	{
		String actualLoginTitle = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5")).getText();
		Assert.assertEquals(actualLoginTitle, "Login");
	}
	@Test(priority = 5)
	public void verifyusername()
	{
		try {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		Thread.sleep(3000);}
		catch(Exception a)
		{
			System.out.println(a.getMessage());
			
		}
	}
	@Test(priority =6 )
	public void verifypassword()
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	@Test(priority =7 )
	public void verifyloginbutton()
	{
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	@Test(priority=4)
	public void verifyforgotpasswordtitle()
	{
		String a=driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']//p")).getText();
		Assert.assertEquals(a, "Forgot your password?");
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	

}
