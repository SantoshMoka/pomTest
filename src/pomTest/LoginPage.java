package pomTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
WebDriver driver;

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void VerifyTitle(String title) {
		String getApptitle = driver.getTitle();
		System.out.println(getApptitle);
		if(getApptitle.equals(title)) {
			System.out.println("Swag Labs Application is opened");
		}
		else {
			System.out.println("Application is uanble to open");
		}
		
	}

 
}
