package learnTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationHRM {
	WebDriver driver;
	@BeforeSuite
	public void launchBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\sures\\\\OneDrive\\\\Documents\\\\Selenium\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
	 driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	@BeforeTest
	public void loginProcess() throws InterruptedException
	{

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority=1)
	public void testPIM() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/child::li[2]")).click();
		System.out.println("Clicked on PIM SuccessFully");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void pIMReport() throws InterruptedException
	{
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Reports SuccessFully");
	}
	@Test(priority=3)
	public void addEmployee() throws InterruptedException
	{
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Add Employees SuccessFully");
	}

	@AfterTest
	public void logoutProcess() throws InterruptedException
	{

		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}


}
