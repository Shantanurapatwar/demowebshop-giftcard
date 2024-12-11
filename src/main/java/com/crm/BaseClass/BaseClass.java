package com.crm.BaseClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.javautility.PropertiesClass;
import com.crm.pom.LogOutPage;
import com.crm.pom.LoginpagePom;



public class BaseClass {
	public	static WebDriver driver;
	 public static PropertiesClass pc=new PropertiesClass();
	@BeforeClass
	public static void preConditions() throws InterruptedException, IOException {
		String expectedurl=pc.propdata("url");
		String browser=pc.propdata("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("fireFox")) {
			driver=new FirefoxDriver();
		}
		else {
			ChromeDriver driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.get("https://demowebshop.tricentis.com/");
		String actualResult=driver.getCurrentUrl();
		if (expectedurl.equals(actualResult)) {
			System.out.println("My url is verified");
		}
//		assertEquals(expectedurl.equalsIgnoreCase(actualResult), "My url is verified");
	}
	@BeforeMethod
	public void logindws() throws InterruptedException, IOException {
		
		LoginpagePom loginPagePOM=new LoginpagePom(driver);
		String e=pc.propdata("email");
		String pwd=pc.propdata("pass");
		Thread.sleep(2000);
		
		loginPagePOM.loginLink();
		Thread.sleep(2000);
		loginPagePOM.login(e,pwd);

		
	}
	@AfterMethod
	public void logotdws() {
		LogOutPage lp=new LogOutPage(driver);
		lp.logout();
	}
	@AfterClass
	public void finals() {
		driver.close();
	}
}
