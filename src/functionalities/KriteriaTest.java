package functionalities;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class KriteriaTest {
	
  @Test(priority = 3,dependsOnGroups = {"login_group"})
  public void accessPage() throws InterruptedException {
	    WebDriver driver =  Setup.getDriver();
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-1");
		Reporter.log("Akses halaman kriteria 1");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-2");
		Reporter.log("Akses halaman kriteria 2");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-3");
		Reporter.log("Akses halaman kriteria 3");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-4");
		Reporter.log("Akses halaman kriteria 4");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-5");
		Reporter.log("Akses halaman kriteria 5");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-6");
		Reporter.log("Akses halaman kriteria 6");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-7");
		Reporter.log("Akses halaman kriteria 7");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-8");
		Reporter.log("Akses halaman kriteria 8");
		Thread.sleep(3000);
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-9");
		Reporter.log("Akses halaman kriteria 9");
		Thread.sleep(3000);
  }
}
