package functionalities;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Setup;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {

	
	@Test(priority = 1,groups = {"login_group"})
	public void accessWeb() throws InterruptedException {
		Reporter.log("Access web");
		System.out.println("Access Web");
		Setup.getDriver().get(Setup.getWebUrl());
		Thread.sleep(1000);
	}
	

	
	@Test(priority = 2, dependsOnGroups = {"login_group"})
	public void loginFunction() throws InterruptedException, IOException {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Login");
		System.out.println("Login");
		for (int i = 0; i < getEmailsCreds().size(); i++) {
			driver.findElement(By.id("email")).sendKeys(getEmailsCreds().get(i));
			Thread.sleep(1000);
			driver.findElement(By.id("password")).sendKeys(getPasswordsCreds().get(i));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
		}
	}
	
	
	private List<String> getEmailsCreds() throws IOException {
		String path = "C:\\mydata\\testing\\testng-arsip-unipma\\credentials\\email.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		   return allLines;
//		File file = new File(path);
//		Scanner scan = new Scanner(file);
//		return scan;
	}
//	private Scanner getPasswordsCreds() throws FileNotFoundException {
//		String path = "C:\\mydata\\testing\\testng-arsip-unipma\\credentials\\password.txt";
//		File file = new File(path);
//		Scanner scan = new Scanner(file);
//		return scan;
//	}
	
	private List<String> getPasswordsCreds() throws IOException {
		String path = "C:\\mydata\\testing\\testng-arsip-unipma\\credentials\\password.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		   return allLines;
	}
	
	
}

