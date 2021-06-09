package crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Learning\\Program\\Selenium_Workspace\\RevisionProject1\\src\\main\\java\\crm\\Config\\config.properties");
		prop.load(ip);
		
	
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Learning/Program/SeleniumJars/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
	}

}
