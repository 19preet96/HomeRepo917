package crm.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.Base.TestBase;
import crm.Pages.HomePage;
import crm.Pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	
	public LoginTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void startUp() throws IOException {
		initialization();
		lp = new LoginPage();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTest() throws IOException {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}

}
