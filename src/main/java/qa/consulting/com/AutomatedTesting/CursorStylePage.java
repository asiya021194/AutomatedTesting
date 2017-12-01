package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursorStylePage {
	
	@FindBy(css = "#drag > p")
	private WebElement cursorStayCentre;
	
	public WebElement cursorStaysCentre() {
		return cursorStayCentre;
	}
	
	@FindBy(css = "#drag2 > p")
	private WebElement cursorStayTopLeft;
	
	public WebElement cursorStaysTopLeft() {
		return cursorStayTopLeft;
	}
	
	@FindBy(css = "#drag3 > p")
	private WebElement cursorStayBottom;
	
	public WebElement cursorStaysBottom() {
		return cursorStayTopLeft;
	}

}
