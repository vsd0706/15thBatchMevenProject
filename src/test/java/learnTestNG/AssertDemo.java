package learnTestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertDemo {
	public void amazonAssertTitle()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		String expectedTitle="Fails";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertNotEquals(actualTitle,expectedTitle,"This title is showing");
	}
}
