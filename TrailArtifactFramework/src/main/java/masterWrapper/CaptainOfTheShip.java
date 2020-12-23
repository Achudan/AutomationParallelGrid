package masterWrapper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import pages.PageMaster;
import reporter.ExtentReporter;

public class CaptainOfTheShip{
	public WebDriver driver;
	public static MasterClass master;
	public ExtentReporter extentLog;
//	public CaptainOfTheShip(WebDriver driver, ExtentReporter extentLog) {
//		this.driver = driver;
//		this.extentLog = extentLog;
//	}
	public void setDriverAndExtentLog(WebDriver driver, ExtentReporter extentLog) {
		this.driver = driver;
		this.extentLog = extentLog;
	}
	public WebDriver getDriver() {
		return this.driver;
	}
	public PageMaster startApplication(String browserName, String URL) {
		DesiredCapabilities dr=null;		

		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				dr=new DesiredCapabilities();
				dr.setBrowserName("chrome");
				//			    dr.setVersion("87.0.4280.88");
				dr.setPlatform(Platform.WINDOWS);

				ChromeOptions options = new ChromeOptions();
				options.merge(dr);

				driver=new RemoteWebDriver(new URL("http://localhost:5551/wd/hub"), options);
				//				driver = new ChromeDriver();

			}
			else if(browserName.equalsIgnoreCase("edge")) {
				System.out.println("The thread ID for edge is "+ Thread.currentThread().getId());
				System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
				dr=new DesiredCapabilities();
				dr.setBrowserName("MicrosoftEdge");
				dr.setPlatform(Platform.WINDOWS);

				EdgeOptions options = new EdgeOptions();
				options.merge(dr);

				driver=new RemoteWebDriver(new URL("http://localhost:5551/wd/hub"), options);
				//				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(URL);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentLog.setDriver(driver);
		setDriverAndExtentLog(driver, extentLog);
		master = new MasterClass(driver);
		return new PageMaster(driver, extentLog);
		
	}

	@BeforeSuite
	public void instantiate() {
//		master = new MasterClass(driver);
//		extentLog = new ExtentReporter(driver);
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM edgedriver.exe");


			//			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "gridHubStart.bat");
			//			File dir = new File(System.getProperty("user.dir")+"/Drivers");
			//			pb.directory(dir);
			//			Process p = pb.start();
			//			
			//			ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "gridNodeChromeStart.bat");
			//			pb1.directory(dir);
			//			Process p1 = pb1.start();
			//			
			//			ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c", "gridNodeEdgeStart.bat");
			//			pb2.directory(dir);
			//			Process p2 = pb2.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		//		extent.endTest(test);
		System.out.println("In after method");
		try {
			ExtentReporter extent = new ExtentReporter();
			extent.flushNow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebDriver driver = getDriver();
//		driver.close();
//		driver.quit();
	}
	@AfterClass
	public void killAll() {
		try {
			//			report.endTest(test);
			//			extent.flush();
			System.out.println("in after class");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CaptainOfTheShip startReporting(String testCaseName, String testCaseDescription) {
		// TODO Auto-generated method stub
		extentLog = new ExtentReporter();
		extentLog.startTest(testCaseName,testCaseDescription);
		return this;
	}

}
