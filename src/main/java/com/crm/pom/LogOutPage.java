package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	 public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	 @FindBy(className = "ico-logout")
	 private WebElement l;
	 public void logout() {
		l.click();
	}
		
	
}
