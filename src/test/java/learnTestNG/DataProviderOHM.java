package learnTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderOHM {
	@DataProvider(name="LoginDataSet")
	public Object[][] searchData()
	{
		Object[][] Login=new Object[3][2];
		Login[0][0]="Admin";
		Login[0][1]="Admin123";
		Login[1][0]="admin";
		Login[1][1]="admin123";
		Login[2][0]="aDmin";
		Login[2][1]="Adjhg";
		return Login;
	}

	@Test(dataProvider="LoginDataSet")
	public void Log_in(String username, String password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);


		Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.className("//button[@type='submit']")).click();

	}}
