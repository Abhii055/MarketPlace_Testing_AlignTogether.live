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

	@Test(priority=1)
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
		WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-col ServiceCard_gap__mDp8q ant-col-xs-0 ant-col-sm-0 ant-col-md-24']")));
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
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='allow-dropdown intl-tel-input']/input[@placeholder='081234 56789']")));
		username.click();		username.sendKeys("hichkaa@mailinator.com");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("hichkaa");
		
		driver.findElement(By.xpath("//div[@class='mt-1']/button/span[text()='Login']")).click();
	}

	// ---ONly REQUIRED ONCE WHILE CREATING NEW USER, ONCE IT IS SET NO NEED TO RUN THE OTHERWISE ALL THE UPCOMING TESTCASES WILL BE IGNORED-----------
//	@Test(dependsOnMethods ="loginCredInput")
//	public void confirmUserName() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement confirmBtn  =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-btn-primary style_ConfirmBtn__0OFqM']")));
//		confirmBtn.click();
//	}
//	@Test(dependsOnMethods ="confirmUserName")
//	public void confirmationDone() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement confirmationBtn  =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[text()='Yes']")));
//		confirmationBtn.click();
//}
	
//	@Test(dependsOnMethods="loginCredInput")
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





//package AlignTogetherTest;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.*;
//
//public class AlignTogether {
//
//    String url ="https://aligntogether.live/";
//    WebDriver driver;
//    
//    @Test(priority =1)
//    public void invokeBrowser() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.get(url);
//    }
//
//    @Test(dependsOnMethods = "invokeBrowser")
//    public void sessionBookingPage() {
//        try {
//            driver.findElement(By.xpath("//div/a[text()='Book Your Service']")).click();
//        } catch (Exception e) {
//            System.out.println("Exception in sessionBookingPage: " + e.getMessage());
//        }
//    }
//
//    @Test(dependsOnMethods = "sessionBookingPage")
//    public void booking() {    
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'card-class')]/a/div[contains(@class, 'book-now')]")));
//            card.click();
//        } catch (Exception e) {
//            System.out.println("Exception in booking: " + e.getMessage());
//        }
//    }
//
//    @Test(dependsOnMethods = "booking")
//    public void loginPageRedirect() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-btn-primary']/span[text()='Contact Seller']")));
//            login.click();
//        } catch (Exception e) {
//            System.out.println("Exception in loginPageRedirect: " + e.getMessage());
//        }
//    }
//
//    @Test(dependsOnMethods = "loginPageRedirect")
//    public void login() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            WebElement flagsetting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='iti-flag us']")));
//            flagsetting.click();
//
//            WebElement indianFlag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='India (भारत)']")));
//            indianFlag.click();
//        } catch (Exception e) {
//            System.out.println("Exception in login: " + e.getMessage());
//        }
//    }
//
//    @Test(dependsOnMethods = "login")
//    public void loginCredInput() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='081234 56789']")));
//            username.sendKeys("hichka@mailinator.com");
//
//            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hichka");
//            driver.findElement(By.xpath("//div[@class='mt-1']/button/span[text()='Login']")).click();
//        } catch (Exception e) {
//            System.out.println("Exception in loginCredInput: " + e.getMessage());
//        }
//    }
//
//    // Uncomment these if you need to create a new user
//     @Test(dependsOnMethods ="loginCredInput")
//     public void confirmUserName() {
//         try {
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//             WebElement confirmBtn  =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-btn-primary style_ConfirmBtn__0OFqM']")));
//             confirmBtn.click();
//         } catch (Exception e) {
//             System.out.println("Exception in confirmUserName: " + e.getMessage());
//         }
//     }
//     @Test(dependsOnMethods ="confirmUserName")
//     public void confirmationDone() {
//         try {
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//             WebElement confirmationBtn  =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[text()='Yes']")));
//             confirmationBtn.click();
//         } catch (Exception e) {
//             System.out.println("Exception in confirmationDone: " + e.getMessage());
//         }
//     }
//
////    @Test(dependsOnMethods = "confirmationDone")
//    public void closeBrowser() {
//        driver.navigate().refresh();
//        driver.close();
//    }
//}
