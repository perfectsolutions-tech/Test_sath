package StepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Property;
import cucumber.api.java.en.Given;

public class StepDefinition {

	WebDriver driver;
	Properties p = Property.getProperty();

	@Given("^Browser is launched and user is loggedin and navigated to application page$")
	public void browser_is_launched_and_user_is_loggedin_and_navigated_to_application_page() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivern\\chromedriver.exe");
		;
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		driver.findElement(By.xpath("//*[@id=\"initial-login-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"org-name-input\"]")).sendKeys("Testing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"login-block\"]/form//button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(p.getProperty("UserName"));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(p.getProperty("Password"));
		driver.findElement(By.xpath("//*[@id=\"kc-login\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 6000);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Request Access']")));
		element.click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Applications']")));
		element.click();
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("7Geese");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"search-entity-box\"]/button/span")).click();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@class ='d-flex search-result-card ng-star-inserted'])[1]")));
		driver.findElement(By.xpath("(//*[@alt ='add-icon0'])[1]")).click();
		element = driver
				.findElement(By.xpath("/html/body/app-root/app-core-layout/div/section[2]/app-cart-detail/div/img"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//app-cart-detail//div[2][text()=' 7Geese ']")));
		element = driver.findElement(By.xpath("//app-cart-detail//*[text()='Proceed ']"));
		executor.executeScript("arguments[0].click();", element);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class ='entity-title idh-col-8 ng-star-inserted']")));
		element.click();
		// verification of fields pending here!
		element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-drawer-container//div[3]//button[3]")));
		element.click();
		Thread.sleep(5000);
		// opening right panel second time to verify details
		element = driver.findElement(By.xpath("//*[@class ='entity-card d-flex']"));
		executor.executeScript("arguments[0].click();", element);
		// before and after verification of fields pending here!
		// Click on 'continue' button in the footer of the page
		element = driver.findElement(
				By.xpath("//*[@class='continue-button primary-button mat-button mat-button-base ng-star-inserted']"));
		executor.executeScript("arguments[0].click();", element);
		element = driver.findElement(By.xpath("//div[@class='mat-form-field-infix']"));
		executor.executeScript("arguments[0].value='Please provide me access to this application';", element);
		
		

		/*
		 * toast_text =
		 * driver.find_element_by_xpath("Copy the xpath of toast and paste here...")
		 * assert toast_text =="Text which is shown in toast paste here"
		 * print("Test case passed")
		 */

	}
}