package pomTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void setUserName(String firstName) {
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("user-name")).sendKeys(firstName);
	}
	
	public void setPassword(String lastName) {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(lastName);
	}
	
	public void verifyErrorMessage(String message) {

		String errorMessage = driver.findElement(By.cssSelector("div.error-message-container.error")).getText();
		if(errorMessage.equals(message)) {
			System.out.println("Application displayed with an error message");
		}
		else {
			System.out.println(errorMessage);
		}
		
	}
	
	public void verifyhomePage() {
		String url = driver.getCurrentUrl();
		if(url.contains("inventory")) {
			System.out.println("Home Page Displayed");
		}
		else {
			System.out.println("Home Page is not displayed");
		}
	}
	
	
	public void selectSubmit() {
	driver.findElement(By.id("login-button")).click();
	}
	
		
		
	}
	


