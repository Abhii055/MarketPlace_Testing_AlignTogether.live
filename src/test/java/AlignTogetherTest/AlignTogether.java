package AlignTogetherTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AlignTogether {

	String url ="https://aligntogether.live/";
	WebDriver driver;

	@Test(priority  = '1')
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(url);
	}
	@Test(dependsOnMethods = "invokeBrowser")
	public void sessionBookingPage() {
		driver.findElement(By.xpath("//div/a[text()='Book Your Service']")).click();
	}
	
	@Test(dependsOnMethods = "sessionBookingPage")
	public void booking() {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[1]/div/div/div/div/div/div[3]/a/div/div/div[3]/div/a")));
		card.click();}
	
	
	@Test(dependsOnMethods = "booking")
	public void loginPageRedirect() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"ant-btn ant-btn-primary\"]/span[text()='Contact Seller']")));
		login.click();}
	
	
	@Test(dependsOnMethods = "loginPageRedirect")
	public void login() {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement flagsetting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='iti-flag us']")));
		flagsetting.click();

		WebElement indianFlag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='India (भारत)']")));
		indianFlag.click();
	}
	
	@Test(dependsOnMethods = "login")
	public void loginCredInput() {
		driver.findElement(By.xpath("//div[@class='allow-dropdown intl-tel-input']/input[@placeholder='081234 56789']")).sendKeys("hichka@mailinator.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hichka");
	}

	public void closeBrowser() {
		driver.navigate().refresh();
		driver.close();
	}
}


// Trying to login but was unable to git in(unknown error kinds unable to fetch the xpath due  to dynamic nature i guess)
//public void loginUser(){
//	driver.navigate().refresh();
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[text()=\"Book Your Service\"]")));
//    loginButton.click();
//}
