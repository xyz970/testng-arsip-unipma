package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class LogoutTest {
	
  @Test(priority = 3, dependsOnGroups = { "login_group" })
  public void logoutTestPage() throws InterruptedException {
	 Reporter.log("logout");
	 WebDriver driver = Setup.getDriver();
	 
	 Thread.sleep(500);
	 //Klik icon profil di pojok kanan atas
	 WebElement profileImage = driver.findElement(By.id("navbarDropdownUserImage"));
	 profileImage.click();
	 
	 //Klik pilihan logout
	 WebElement submitButton =  driver.findElement(By.xpath("//button[@type='submit']"));
	 submitButton.click();
	 Reporter.log("Logout Berhasil");
	 
  }
}
