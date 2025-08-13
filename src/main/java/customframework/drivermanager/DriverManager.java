package customframework.drivermanager;



/*
 * Driver manager is used to create thread safe driver in parallel
 */

import customframework.driverFactory.BrowserDriver;
import org.openqa.selenium.WebDriver;

;

public final class DriverManager {
				
	public static final ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();
	
	//Method to get the thread local driver. Should be used to get the driver 
	//throughout the project for parallel threads to work as expected
	public static WebDriver getDriver() {
		return threadlocal.get();	
	}
	
	// Method to set the Thread local driver. Type driver of type Driver is accepted  
	public static void setDriver(WebDriver driver) {
		threadlocal.set(driver);
	}
	
	// Methos to remove the driver after excecution
	public static void removeDriver() {
		threadlocal.get().quit();
		threadlocal.remove();
	}
	
}
