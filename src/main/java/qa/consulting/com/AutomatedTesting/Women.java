package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Women {
	
	@FindBy(css = "#subcategories > ul > li:nth-child(1) > div.subcategory-image > a > img")
	private WebElement toTopPage;

	public void topPage() {
		toTopPage.click();
	}
	
	@FindBy(css = "#subcategories > ul > li:nth-child(2) > div.subcategory-image > a > img")
	private WebElement toDressPage;
	
	public void dressPage() {
		toDressPage.click();
	}
	
	@FindBy(css = "#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")
	private WebElement toBlousePage;
	
	public WebElement blouse() {
		return toBlousePage;
	}
}
