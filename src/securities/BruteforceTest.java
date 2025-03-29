package securities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class BruteforceTest {


	@Test
	public void accessPage() throws IOException, InterruptedException {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Bruteforce Test");
		System.out.println("Bruteforce Test");
		driver.get(Setup.getWebUrl());
		
		for (int i = 0; i < getEmailDict().size(); i++) {
			JavascriptExecutor jsEx = (JavascriptExecutor)driver;
			jsEx.executeScript("document.getElementById('email').setAttribute('type','text')");
			driver.findElement(By.id("email")).sendKeys(getEmailDict().get(i));
			Thread.sleep(500);
			driver.findElement(By.id("password")).sendKeys(getPasswordDict().get(i));
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(1000);
			
		}
	}
	
	
	private List<String> getEmailDict() throws IOException {
		String path = "D:\\testing\\testng-arsip-unipma\\credentials\\dict\\email.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		   return allLines;
	}
	private List<String> getPasswordDict() throws IOException {
		String path = "D:\\testing\\testng-arsip-unipma\\credentials\\dict\\password.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		return allLines;
	}
}
