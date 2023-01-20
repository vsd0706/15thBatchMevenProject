package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	public LoginPageFactory(WebDriver wd) {


		driver=wd;
		PageFactory.initElements(driver, this); //this method will create WebElements
	}

	@FindBy(name= "username") WebElement un;
	@FindBy(name = "password") WebElement pw;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;


	public void url() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void un() throws InterruptedException {
		un.sendKeys("Admin");
		Thread.sleep(1000);
	}
	public void pw() throws InterruptedException {
		pw.sendKeys("admin123");
		Thread.sleep(1000);
	}
	public void submit() {
		submit.click();
		}
	public void LoginProcess() throws InterruptedException {
		url();
		un();
		pw();
		submit();

	}





}
