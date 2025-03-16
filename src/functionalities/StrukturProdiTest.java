package functionalities;

import org.testng.annotations.Test;

import helpers.Setup;

public class StrukturProdiTest {
	
	
  @Test(priority = 3, dependsOnGroups = {"login_group"})
  public void accessPage() throws InterruptedException {
	  Setup.getDriver().get(Setup.getWebUrl()+"admin/department");
	  Thread.sleep(3000);
  }
}
