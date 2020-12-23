package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import masterWrapper.CaptainOfTheShip;
import pages.StartPage;
import reporter.ExtentReporter;

public class TC1 extends CaptainOfTheShip{
	@Test
	public void sampleMethod() {

		CaptainOfTheShip startApp = new CaptainOfTheShip()
				.startReporting("SampleReport","1st test")
				.startApplication("chrome", "https://phptravels.com/demo")
				.startPage()
				.getEmailandVerify("Homepage", "Front-End")
				.getPasswordandVerify("Homepage", "Front-End")
				.getEmailandVerify("Administrator", "Back-End")
				.getPasswordandVerify("Administrator", "Back-End")
				.endOfTest()
				;

	}

	@Test(alwaysRun = true) public void sampleMethod2() {
		CaptainOfTheShip startApp = new CaptainOfTheShip()
				.startReporting("SampleReport2","2nd test")
				.startApplication("edge", "https://phptravels.com/demo")
				.startPage()
				.getEmailandVerify("Homepage", "Front-End")
				.getPasswordandVerify("Homepage", "Front-End")
				.getEmailandVerify("Administrator", "Back-End")
				.getPasswordandVerify("Administrator", "Back-End")
				.endOfTest()
				;
		}

	@Test public void sampleMethod3() {
		CaptainOfTheShip startApp = new CaptainOfTheShip()
				.startReporting("SampleReport2","3rd test")
				.startApplication("edge", "https://phptravels.com/demo")
				.startPage()
				.getEmailandVerify("Homepage", "Front-End")
				.getPasswordandVerify("Homepage", "Front-End")
				.getEmailandVerify("Administrator", "Back-End")
				.getPasswordandVerify("Administrator", "Back-End")
				.endOfTest()
				;
	}

}
