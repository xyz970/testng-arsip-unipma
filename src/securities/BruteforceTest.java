package securities;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class BruteforceTest {


	@Test(priority = 5)
	public void bruteforceCondition() throws IOException, InterruptedException {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Bruteforce Test");
		System.out.println("Bruteforce Test");
		driver.get(Setup.getWebUrl());
		
		for (int i = 0; i < getEmailDict().size(); i++) {
			JavascriptExecutor jsEx = (JavascriptExecutor)driver;
			jsEx.executeScript("document.getElementById('email').setAttribute('type','text')");
			WebElement emailInput = driver.findElement(By.id("email"));
			WebElement passwordInput = driver.findElement(By.id("password"));
			emailInput.sendKeys(getEmailDict().get(i));
			passwordInput.sendKeys(getPasswordDict().get(i));
			WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
			button.click();
			Thread.sleep(1000);
		}
		assertTrue(driver.getCurrentUrl().replaceAll("(?)https", "http").equals(Setup.getWebUrl()));
	}
	
	
	private List<String> getEmailDict() throws IOException {
		String path = Setup.getParentDirectory()+"credentials\\dict\\email.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		   return allLines;
	}
	private List<String> getPasswordDict() throws IOException {
		String path = Setup.getParentDirectory()+"credentials\\dict\\password.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		return allLines;
	}
}
