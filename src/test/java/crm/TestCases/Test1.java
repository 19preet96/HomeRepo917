package crm.TestCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void browserOpen() {
		System.setProperty("webdriver.gecko.driver", "C:/Learning/Program/SeleniumJars/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@Test
	public void dropDownTest() {
		
		driver.get("https://moodle.cestarcollege.com/moodle/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//span[text()='Faq'])[1]")).click();
		
		Set<String> s =driver.getWindowHandles();
		Iterator<String> iter = s.iterator();
		
		String mainWindow = iter.next();
		String childWindow = iter.next();
		
		driver.switchTo().window(childWindow);
		
	}

}
