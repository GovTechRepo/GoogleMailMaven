package eMail;

import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.Equals;
import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailDemo_InValidLogin {

	WebDriver driver;

	// Method 1: Open Browser say Firefox
	@Test(priority = 1)
	public void TC1_OpenBrowser() {
		driver = new FirefoxDriver();
	}

	// Method 2: Launch Google.com
	@Test(priority = 2)
	public void TC2_LaunchGoogle() {
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 3)
	public void TC3_InValidlogin() {

		driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[1]/a")).click();

		driver.findElement(By.cssSelector("#Email")).clear();
		driver.findElement(By.cssSelector("#Email")).sendKeys("govtechtesting");
			
		WebElement nextElement = driver.findElement(By.xpath("//input[contains(@value,'Nextt')]"));
		nextElement.click();
												
		driver.findElement(By.cssSelector("#Passwd")).clear();
		driver.findElement(By.cssSelector("#Passwd")).sendKeys("govtechtesting11");
									
		driver.findElement(By.cssSelector("#signIn")).click();
		
		WebElement element = driver.findElement(By.xpath("//span[@id='errormsg_0_Passwd']"));
		String strng = element.getText();
		System.out.println(strng);
		Assert.assertEquals("Wrong password. Try again.", strng);

		System.out.println(driver.getTitle());
		
		driver.quit();
	}

	@BeforeTest
	public void driverLaunch() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\IDACTMO002\\Desktop\\GovTech\\Selenium\\geckodriver-v0.11.1-win64\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	}
}
