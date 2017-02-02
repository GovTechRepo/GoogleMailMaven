package eMail;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\IDACTMO002\\Desktop\\GovTech\\Selenium\\geckodriver-v0.11.1-win64\\geckodriver-v0.11.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com.sg/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[1]/a")).click();

		driver.findElement(By.cssSelector("#Email")).clear();
		driver.findElement(By.cssSelector("#Email")).sendKeys("govtechtesting");

		// driver.findElement(By.cssSelector("#next")).click();
		driver.findElement(By.xpath("//*[@id='next']")).click();
		// driver.findElement(By.xpath("//div[contains(text(),'next')]")).click();

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("#Passwd")).clear();
		driver.findElement(By.cssSelector("#Passwd")).sendKeys("govtechtesting1");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#signIn")).click();

		// Compose email
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("Gov Tech <govtechtesting@gmail.com>");

		driver.findElement(By.name("subjectbox")).sendKeys("Test mail from Eclipse");
		System.out.println("Entered in Subject box");

		WebElement element = driver.findElement(By.xpath("//div[@class='Ar Au']//div"));
		element.click();
		element.sendKeys("Hello GovTech");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();

		// driver.findElement(By.cssSelector("gb_b gb_eb gb_R")).click();

		driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		Thread.sleep(3000);

		driver.findElement(By.className("gb_yb")).click();
		
		driver.findElement(By.id("gb_71")).click();

		System.out.println("Sign out successfully");
		
		driver.quit();

	}

}
