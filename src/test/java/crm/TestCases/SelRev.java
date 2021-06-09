package crm.TestCases;


import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelRev {
	
	WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void startUp() throws IOException {
		
		prop = new Properties();
		FileInputStream inT = new FileInputStream("C:\\Learning\\Program\\Selenium_Workspace\\RevisionProject1\\src\\main\\java\\crm\\Config\\selConfig.properties");
		prop.load(inT);
		
		System.setProperty("webdriver.gecko.driver", "C:/Learning/Program/SeleniumJars/geckodriver.exe");
		driver = new FirefoxDriver();
		
		//driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	//@Test
	public void test1() throws IOException {
		
		driver.get(prop.getProperty("url"));
		
		//switching frame
		
		WebElement linkFrame = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(linkFrame);
		
		driver.findElement(By.linkText("Visit W3Schools.com!")).click();
		
		//handling tab or windows
		
		Set<String> wHandles = driver.getWindowHandles();
		
		System.out.println(driver.getWindowHandle());
		
		for(String s: wHandles) {
			System.out.println(s);
		}
		
		Iterator<String> itr = wHandles.iterator();
		
		String mainWindow = itr.next();
		String childWindow = itr.next();
		
		driver.switchTo().window(childWindow);

		
		driver.close();
		
		driver.switchTo().window(mainWindow);
		
		driver.get("https://www.virustotal.com/gui/");
		driver.getTitle();
		
		//File scrnShot = driver.getScreen
		TakesScreenshot srcnsht = (TakesScreenshot)driver;
		File srcFile = srcnsht.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("C:/Learning/Program/tryScrnSht.jpg");
		
		FileUtils.copyFile(srcFile, destFile);
		
		 driver.quit();
		
		
	}
	
	//@Test
	public void test2() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		String target = "Yahoo";
		
		Actions builder = new Actions(driver);
		
		WebElement telcomProject = driver.findElement(By.linkText("Telecom Project"));
		WebElement selClick = driver.findElement(By.linkText("Selenium"));
		
		builder.contextClick(selClick).build().perform();
		
		builder.moveToElement(telcomProject).build().perform();
		
		Thread.sleep(3000);
		
		
		selClick.click();
		
		List<WebElement> alList = driver.findElements(By.xpath("(//ul[@class='dropdown-menu'])[1]/li"));
		
		System.out.println(alList.size());
		
		for(int x=0;x<alList.size();x++) {
			if(alList.get(x).getText().equals(target)) {
				alList.get(x).click();
				break;
			}
		}
		
		
		
		
		
	}
	
	@Test
	public void test4() {
		driver.get("https://www.amazon.ca/");
		WebElement amazonPrime = driver.findElement(By.xpath("//a[text()='Amazon Prime']"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		
		System.out.println(amazonPrime.getLocation());
		
		//jse.executeScript("window.scrollBy"+amazonPrime.getLocation()); //1st method
		jse.executeScript("arguments[0].scrollIntoView(true);", amazonPrime);
	}
	
	//@Test
	public void test3() {
		String aTest = "Canada";
		
		char btest = 'a';
		int charCount = 0;
		
		for(int i=0;i<aTest.length();i++) {
			if(aTest.charAt(i)== btest) {
				charCount++;
				
			}aa
		}
		System.out.println(charCount);
		
	}
	

}
