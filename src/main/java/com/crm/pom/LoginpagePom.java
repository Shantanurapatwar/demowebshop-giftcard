package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePom {
	
	public LoginpagePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginlink;
	
	@FindBy(id = "Email")
	private WebElement emailinput;
	
	@FindBy(id = "Password")
	private WebElement passInput;
	
	@FindBy(xpath = "//input[@value='Log in']" )
	private WebElement loginBut;

	public void loginLink() {
		loginlink.click();
	}

	public void login(String name, String pass) {

		emailinput.sendKeys(name);
		passInput.sendKeys(pass);
		loginBut.click();
	}

}
