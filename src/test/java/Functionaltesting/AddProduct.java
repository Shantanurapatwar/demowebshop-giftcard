package Functionaltesting;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.javautility.PropertiesClass;
import com.crm.javautility.TestData;
import com.crm.pom.Addtocart;



public class AddProduct extends BaseClass {
	@Test
public void main() throws IOException, InterruptedException {
		PropertiesClass pc=new PropertiesClass();
		Actions act=new Actions(driver);
		act.keyDown(Keys.PAGE_DOWN).perform();
		Addtocart ad=new Addtocart(driver);
		Thread.sleep(2000);
		ad.cart();
		TestData data=new TestData();
		String name=data.data("Sheet1", 0, 0);
		String email=data.data("Sheet1", 0, 1);
		String qnty=data.data("Sheet1", 0, 2);
		ad.recepiantname(name);
		ad.rEmail(email);
		ad.qntity("5");
		ad.cartbut();
		Thread.sleep(2000);
		ad.shopping();
		WebElement giftCard = driver.findElement(By.xpath("//tr[@class='cart-item-row']/td/img[@title='Show details for $25 Virtual Gift Card']"));
		assertTrue(giftCard.isDisplayed(),"is not displyed");
		System.out.println("card Verified");

}
}
