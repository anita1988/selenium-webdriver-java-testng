package webdriver;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic03_Selenium_Locator {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	}

	@Test
	public void TC_01_FindElement() {
		driver.findElement(By.className(""));

	}

	
	public void TC_02_ID() {
		driver.findElement(By.id("send2")).click();
		// verify error messega xuất hiện
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());

	}

	
	public void TC_03_Class() {
		
		driver.findElement(By.className("validate-password")).sendKeys("123456");
		// verify error messega xuất hiện
		
	}

	
	public void TC_04_Name() {
		driver.navigate().refresh();
		driver.findElement(By.name("send")).click();
//verify error messega xuất hiện
		Assert.assertTrue(driver.findElement(By.id("advice-required-entry-email")).isDisplayed());
	}

	
	public void TC_05_TagName() {
		
		driver.navigate().refresh();
// lấy hết tất cả đường link tại màn hình sau đó get text ra
		List<WebElement> loginPageLinks = driver.findElement(By.tagName("a"));
		for (WebElement webElement : loginPageLinks) {
			System.out.println(webElement.getText());
		}
	}

	
	public void TC_06_LinkText() {
		driver.navigate().refresh();
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		Assert.assertTrue(driver.findElement(By.id("email_address")).isDisplayed());

	}

	
	public void TC_07_PatialLinkText() {
driver.findElement(By.partialLinkText("Back to")).click();
Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
	}

	@Test
	public void TC_08_Css() {
		driver.findElement(By.cssSelector("#email")).sendKeys("thao@gmail.com");
		driver.findElement(By.cssSelector("input[name='login[password]']")).sendKeys("1234");

	}

	@Test
	public void TC_09_Xpath() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
