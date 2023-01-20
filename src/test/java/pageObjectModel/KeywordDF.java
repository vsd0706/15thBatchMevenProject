package pageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeywordDF {

	public static void main(String[] args) throws IOException, InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			OperationLoginOHM loginOHM=new OperationLoginOHM(driver);
			LogoutUsingPageFactory logoutPF=new LogoutUsingPageFactory(driver);

			FileInputStream inputStream=new FileInputStream("C:\\Users\\sures\\OneDrive\\Documents\\Book1.xlsx");

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
				XSSFSheet sheet=workbook.getSheet("Keyword");

				int rows=sheet.getLastRowNum();
				System.out.println(rows);

				for(int r=1;r<=rows;r++)
				{
					XSSFRow row=sheet.getRow(r);
					XSSFCell key=row.getCell(1);
					System.out.println(key);

					switch(key.toString())
					{
						case "url":
							loginOHM.url();
							break;
						case "username":
							loginOHM.userName("Admin");
							break;
						case "password":
							loginOHM.passWord("admin123");
							break;
						case "login":
							loginOHM.loginBtn();
						case "userProfile":
							logoutPF.userProfile();
						case "logout" :
							logoutPF.logout();
						default:
							System.out.println("Invalid Keyword");
							break;
					}
				}
			}

		 }
	}


