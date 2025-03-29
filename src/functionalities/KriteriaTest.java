package functionalities;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class KriteriaTest {
	
  @Test(priority = 3,dependsOnGroups = {"login_group"})
  public void KriteriaTestPage() throws InterruptedException {
	    Reporter.log("kriteria");
	    WebDriver driver =  Setup.getDriver();
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-1");
		Reporter.log("Akses halaman kriteria 1");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-2");
		Reporter.log("Akses halaman kriteria 2");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-3");
		Reporter.log("Akses halaman kriteria 3");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-4");
		Reporter.log("Akses halaman kriteria 4");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-5");
		Reporter.log("Akses halaman kriteria 5");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-6");
		Reporter.log("Akses halaman kriteria 6");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-7");
		Reporter.log("Akses halaman kriteria 7");
	
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-8");
		Reporter.log("Akses halaman kriteria 8");
		
		driver.get(Setup.getWebUrl()+"admin/letter/kriteria-9");
		Reporter.log("Akses halaman kriteria 9");
  }
}
