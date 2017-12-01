package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAP {
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
	private WebElement towomenPage;
	
	public void womenPage() {
		towomenPage.click();
	}
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
	private WebElement toDressesPage;
	
	public void dressesPage() {
		toDressesPage.click();
	}
	
	@FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
	private WebElement toShirtsPage;
	
	public void shirtsPage() {
		toShirtsPage.click();
	}
	
	@FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
	private WebElement toSignIn;
	
	public void signInPage() {
		toSignIn.click();
	}
	
}
