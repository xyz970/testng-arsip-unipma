package helpers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Setup {
	
	private static WebDriver driver;
	Setup setup;

    public static WebDriver getDriver() {
        return driver;
    }
   

    @BeforeSuite
    public void beforeSuite() {
    	System.out.print("Testing Dimulai");
    	initiateProperty();
		DriverHelper driverHelper = new DriverHelper();
		driver = driverHelper.setSelectedDriver(DriverChoice.CHROME);
    }

    @AfterSuite
    public void afterSuite() {
    	System.out.print("Testing Selesai");
        driver.quit();
    }
	
	public void initiateProperty() {
		String parentDir = "C:\\mydata\\testing\\";
		System.setProperty("webdriver.chrome.driver", parentDir+"testng-arsip-unipma\\driver\\chromedriver.exe");
	}
	
	public static String getWebUrl() {
//		return "https://www.google.com/";
		return "http://arsip-unipma.my.id/";
	}
}
