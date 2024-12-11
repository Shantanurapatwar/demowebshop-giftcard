package com.crm.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtocart {
	WebDriver driver1;

	public Addtocart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "$25 Virtual Gift Card")
//	@FindBy(xpath = "//tr[@class='cart-item-row']/td/img[@title='Show details for $25 Virtual Gift Card']")
	private WebElement card;
	@FindBy(className = "recipient-name")
	private WebElement rname;
	@FindBy(className = "recipient-email")
	private WebElement remail;
	@FindBy(className = "qty-input")
	private WebElement qnty;
    @FindBy(xpath = "//input[@id='add-to-cart-button-2']")
    private WebElement but;
    @FindBy(xpath = "//span[text()='Shopping cart']")
    private WebElement shoppingcart;
    
	public void cart() {
		card.click();
	}

	public void recepiantname(String name) {
		rname.sendKeys(name);
	}

	public void rEmail(String email) {
		remail.sendKeys(email);
	}

	public void qntity(String num) throws InterruptedException {
		qnty.clear();
		Thread.sleep(2000);
		;
		qnty.sendKeys(num);
	}
	public void cartbut() {
		but.click();
		
	}
	public void shopping() {
		shoppingcart.click();
	}
	

}
