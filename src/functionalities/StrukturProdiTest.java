package functionalities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class StrukturProdiTest {
	
	
  @Test(priority = 3,dependsOnGroups = {"login_group"},groups = "afterStrukturProdi")
  public void StrukturProdiTestPage() throws InterruptedException {
	  WebDriver driver = Setup.getDriver();
	  Reporter.log("Halaman Struktur Prodi dapat diakses dan menampilkan gambar bagan prodi");
	  driver.get(Setup.getWebUrl()+"admin/department");
	  WebElement bagan = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/main/div/div/div/div/center/img"));
	  assertTrue(bagan.isDisplayed());
  }
}
