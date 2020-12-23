package masterWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class MasterClass extends CaptainOfTheShip{
	public WebDriver driver;
	
	public MasterClass(){
		System.out.println("MAster created");
	}
	public MasterClass(WebDriver driver){
		System.out.println("Master created");
		this.driver = driver;
	}
	public String getTextByXpath(String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();
		return text;
	}
	public void waitUntilElementVisible(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement web1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception e) {
			
		}
	}
	public void scrollTillElement(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Actions action = new Actions(driver);
			action.moveToElement(element,5,5).perform();
//			System.out.println("scrollling");
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
