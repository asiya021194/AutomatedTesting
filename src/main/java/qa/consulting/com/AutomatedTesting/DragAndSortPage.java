package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndSortPage {
	
	@FindBy(css = "#sortablebox > li:nth-child(1)")
	private WebElement sortItem1;
	
	public WebElement dragSortItem1() {
		return sortItem1;
	}
	
	@FindBy(css = "#sortablebox > li:nth-child(2)")
	private WebElement sortItem2;
	
	public WebElement dragSortItem2() {
		return sortItem2;
	}
	
	@FindBy(css = "#sortablebox > li:nth-child(3)")
	private WebElement sortItem3;
	
	public WebElement dragSortItem3() {
		return sortItem3;
	}
	
	@FindBy(css = "#sortablebox > li:nth-child(4)")
	private WebElement sortItem4;
	
	public WebElement dragSortItem4() {
		return sortItem4;
	}
	
	@FindBy(css = "#sortablebox > li:nth-child(5)")
	private WebElement sortItem5;
	
	public WebElement dragSortItem5() {
		return sortItem5;
	}

}
