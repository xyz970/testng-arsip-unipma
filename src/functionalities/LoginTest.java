package functionalities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import helpers.Setup;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {

	
	@Test(priority = 1,groups = {"login_group"})
	public void accessWeb() throws InterruptedException {
		Reporter.log("Access web");
		System.out.println("Access Web");
		Setup.getDriver().get(Setup.getWebUrl());
		Thread.sleep(2000);
	}
	

	
	@Test(priority = 2, dependsOnGroups = {"login_group"})
	public void loginFunction() throws InterruptedException, FileNotFoundException {
		Reporter.log("Login");
		System.out.println("Login");
		Setup.getDriver().findElement(By.id("email")).sendKeys(getEmailsCreds().nextLine());
		Thread.sleep(1000);
		Setup.getDriver().findElement(By.id("password")).sendKeys(getPasswordsCreds().nextLine());
		Thread.sleep(1000);
		Setup.getDriver().findElement(By.tagName("button")).click();
		Thread.sleep(1800);
	}
	
	
	private Scanner getEmailsCreds() throws FileNotFoundException {
		String path = "C:\\mydata\\testing\\testng-arsip-unipma\\credentials\\email.txt";
		File file = new File(path);
		Scanner scan = new Scanner(file);
		return scan;
	}
	private Scanner getPasswordsCreds() throws FileNotFoundException {
		String path = "C:\\mydata\\testing\\testng-arsip-unipma\\credentials\\password.txt";
		File file = new File(path);
		Scanner scan = new Scanner(file);
		return scan;
	}
	
	
}

