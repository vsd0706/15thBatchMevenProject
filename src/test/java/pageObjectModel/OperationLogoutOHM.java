package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OperationLogoutOHM {

	 WebDriver driver;

	 public OperationLogoutOHM(WebDriver driver)
	 {
	  this.driver=driver;
	 }

	 //repository of WebElement
	 By userProfile=By.xpath("//p[@class='oxd-userdropdown-name']");
	 By logOut=By.linkText("Logout");



	 public void userProfile() throws InterruptedException {
		 driver.findElement(userProfile).click();
		 Thread.sleep(1000);
	 }
	 public void logout() throws InterruptedException {
		 driver.findElement(logOut).click();
		 Thread.sleep(1000);
	 }
	 public void logoutProcess() throws InterruptedException{
		 userProfile();
		 logout();

	 }
}
