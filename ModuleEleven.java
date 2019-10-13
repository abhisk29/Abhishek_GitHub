package TestingMaven;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ModuleEleven {
	WebDriver driver;
	

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.edureka.co/");
		// driver.get("https://learning.edureka.co/onboarding/personaldetails");
		System.out.println("edureka Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Login() {

		driver.findElement(By.xpath("//*[@class='signin top-signin giTrackElementHeader hidden-xs']")).click();
		driver.findElement(By.id("si_popup_email")).sendKeys("abhisk29@gmail.com");
		driver.findElement(By.id("si_popup_email")).sendKeys(Keys.TAB);
		driver.findElement(By.id("si_popup_passwd")).sendKeys("Test@456");
		driver.findElement(By.xpath("//*[@class='clik_btn_log btn-block']")).click();
		System.out.println("Successfully Logged In");

	}

	@Test
	public void UploadPhoto() throws InterruptedException, IOException {
		// Entering My Profile
		driver.findElement(By.xpath("//*[@class='user_name']")).click();
		driver.findElement(By.xpath("//a[text()='My Profile']")).click();
		System.out.println("Entered My Profile");
		// Editing Personal Details
		driver.findElement(By.id("personal_details")).click();
		System.out.println("Editing Personal details");
		

		WebElement element = driver.findElement(By.xpath("//*[@class='icon-camera']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().build().perform();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//i[@class='icon-camera']")).click();
		Thread.sleep(5000);

		String parentwindowhandler = driver.getWindowHandle(); // store your parent window..
		String subwindowhandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subwindowhandler = iterator.next();
		}
		driver.switchTo().window(subwindowhandler); // switch to child window..
		Thread.sleep(5000);
		try {
			

			driver.findElement(By.xpath("//*[@class='file-upload']")).click();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		Runtime.getRuntime().exec("D:\\Projects\\Selenium\\Tutorials\\FileUpload.exe");

	
		Thread.sleep(5000);
		
	//	System.out.println("about to be scrolled");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	//	System.out.println("scrolled");
		driver.findElement(By.xpath("//div[@class='submitbtnsec']//following::button[1]")).click();
		System.out.println("end of code");

	}
}
