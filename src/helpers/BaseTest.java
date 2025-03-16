package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BaseTest {
	protected Setup setup;
	protected WebDriver driver;
	public BaseTest() {
		setup = new Setup();
		setup.initiateProperty();
		DriverHelper driverHelper = new DriverHelper();
		driver = driverHelper.setSelectedDriver(DriverChoice.CHROME);
	}
}
