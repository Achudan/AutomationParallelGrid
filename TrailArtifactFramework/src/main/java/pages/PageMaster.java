package pages;

import org.openqa.selenium.WebDriver;

import masterWrapper.CaptainOfTheShip;
import reporter.ExtentReporter;

public class PageMaster extends CaptainOfTheShip{

	public WebDriver driver;
	public ExtentReporter extentLog;
	
	public PageMaster(WebDriver driver, ExtentReporter extentLog) {
		this.driver = driver;
		this.extentLog = extentLog;
	}
	
	public StartPage startPage() {
		return new StartPage(this.driver, this.extentLog);
	}
	
	public CaptainOfTheShip endPage(WebDriver driver, ExtentReporter extentLog) {
		setDriverAndExtentLog(driver, extentLog);
		driver.close();
//		driver.quit();
		return this;
	}
	
}
