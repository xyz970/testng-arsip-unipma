package functionalities;

import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class StrukturProdiTest {
	
	
  @Test(priority = 3,dependsOnGroups = {"login_group"})
  public void StrukturProdiTestPage() throws InterruptedException {
	  Reporter.log("struktur prodi");
	  Setup.getDriver().get(Setup.getWebUrl()+"admin/department");
  }
}
