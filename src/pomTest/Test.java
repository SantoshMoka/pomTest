package pomTest;

import java.util.concurrent.TimeUnit; 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Test{
	
	WebDriver driver;
	
	/*
	 * Constants which are being used in the script
	 */
	HomePage objHome;
	LoginPage objLogin = new LoginPage(driver);
	String url = "https://www.saucedemo.com";
	String expTitle = "Swag Labs";
	String userName = "standard_user";
	String invalidUserName = "standard_ur";
	String password = "secret_sauce";
	String invalidPassword = "secret_sau";
	String errorMessage = "Epic sadface: Username and password do not match any user in this service";
	String emptyuserName = "";
	String emptyPassword = "";
	String emptyfieldErrorMessage= "Epic sadface: Username is required";
	String emptyPasswordFieldErrMsg = "Epic sadface: Password is required";
	

	
	
	@BeforeTest
public void setup() {
		
System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
	}
	
	
	@org.testng.annotations.Test(priority=0)
	
	public  void verifyLoginFunctionality() throws InterruptedException {
		try 
		    {
				WebDriverWait wait=new WebDriverWait(driver, 20);		
			    objLogin = new LoginPage(driver);
				objHome = new HomePage(driver);
				
				//TC01 Verify the expected Title is displayed in the application
			    objLogin.VerifyTitle(expTitle);	
			    
			    //TC02- empty username and password and hit the submit button and verify the error message
			    
			    objHome.setUserName(emptyuserName);
			    objHome.setPassword(emptyPassword);
			    objHome.selectSubmit();
			    objHome.verifyErrorMessage(emptyfieldErrorMessage);

			    //TC03- Valid username and empty passowrd and hit the submit button and verify the error message
			    
			    objHome.setUserName(userName);
			    objHome.setPassword(emptyPassword);
			    objHome.selectSubmit();
			    objHome.verifyErrorMessage(emptyPasswordFieldErrMsg);
			    
			    // TCO4 - Invalid username and Invalid password and verify the error message
			    objHome.setUserName(invalidUserName);
			    objHome.setPassword(invalidPassword);
			    objHome.selectSubmit();
			    objHome.verifyErrorMessage(errorMessage);
			    
			    //TC05 - Valid Username and Valid password and verify successfull login
			    objHome.setUserName(userName);
			    objHome.setPassword(password);
			    objHome.selectSubmit();
			    objHome.verifyhomePage();
		    }
		
		finally 
		{
			driver.close();
		}
		
	}
	

}
