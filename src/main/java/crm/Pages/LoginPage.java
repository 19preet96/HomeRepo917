package crm.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.Base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passBox;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBox;
	
	

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String us, String pw) throws IOException {
		
		emailBox.sendKeys(us);
		passBox.sendKeys(pw);
		loginBox.click();
		
		return new HomePage();
		
	}
	

}
