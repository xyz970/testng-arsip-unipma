package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class LogoutTest {
	
  @Test(priority = 3, dependsOnGroups = { "login_group" })
  public void logoutTestPage() {
	 Reporter.log("logout");
	 WebDriver driver = Setup.getDriver();
	 
	 //Klik icon profil di pojok kanan atas
	 driver.findElement(By.id("navbarDropdownUserImage")).click();
	 
	 //Klik pilihan logout
	 driver.findElement(By.xpath("//button[@class='dropdown-item']")).click();
	 Reporter.log("Logout Berhasil");
	 
  }
}
