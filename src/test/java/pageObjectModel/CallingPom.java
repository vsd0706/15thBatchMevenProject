package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CallingPom {

	public static void main(String[] args)
			throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  OperationLoginOHM loginOHM=new OperationLoginOHM(driver);
		  OperationLogoutOHM logoutOHM=new OperationLogoutOHM(driver);
		  LoginPageFactory loginPF=new LoginPageFactory(driver);
		  LogoutUsingPageFactory logoutPF=new LogoutUsingPageFactory(driver);
		  //loginOHM.url();
		  //loginOHM.userName("Admin");
		  //loginOHM.passWord("admin123");
		  //loginOHM.loginBtn();
		  loginOHM.loginProcess("Admin", "admin123");
          logoutOHM.userProfile();
          logoutOHM.logout();
          Thread.sleep(2000);
          loginPF.LoginProcess();
          logoutPF.logoutProcess();
		 }



	}


