package eMail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailDemo {

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
	public void TC3_validlogin() {

		driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[1]/a")).click();

		driver.findElement(By.cssSelector("#Email")).clear();
		driver.findElement(By.cssSelector("#Email")).sendKeys("govtechtesting");

		//driver.findElement(By.xpath("//input[@Value='Next']"));
		
		WebElement nextBtn = driver.findElement(By.xpath("//input[@id='next']"));
		nextBtn.click();

		driver.findElement(By.cssSelector("#Passwd")).clear();
		driver.findElement(By.cssSelector("#Passwd")).sendKeys("govtechtesting1");
		driver.findElement(By.cssSelector("#signIn")).click();

		System.out.println(driver.getTitle());
	}

	@Test(priority = 4)
	public void TC4_Compose() throws Exception {

		WebElement composeElement = driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]"));
		composeElement.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("Gov Tech <govtechtesting@gmail.com>");

		driver.findElement(By.name("subjectbox")).sendKeys("Test mail from Eclipse");
		System.out.println("Entered in Subject box");

		WebElement element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		element.click();
		element.sendKeys("Hello GovTech");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
	}

	@Test(priority = 5)
	public void TC5_SignOut() throws Exception {

		driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		Thread.sleep(3000);

		driver.findElement(By.className("gb_yb")).click();

		driver.findElement(By.id("gb_71")).click();

		System.out.println("Sign out successfully");

		driver.quit();

	}

	@BeforeTest
	public void driverLaunch() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\IDACTMO002\\Desktop\\GovTech\\Selenium\\geckodriver-v0.11.1-win64\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	}
}
