package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstraintMovement {
	
	@FindBy(css = "#draggabl > p")
	private WebElement dragVertically;
	
	public WebElement dragVerticallyOnly() {
		return dragVertically;
	}
	
	@FindBy(css = "#draggabl2 > p")
	private WebElement dragHorizontally;
	
	public WebElement dragHorizontallyOnly() {
		return dragHorizontally;
	}
	
	@FindBy(css = "#draggabl3 > p")
	private WebElement dragWithinBox;
	
	public WebElement dragWithinBoxOnly() {
		return dragWithinBox;
	}
	
	@FindBy(css = "#draggabl5")
	private WebElement withinParentBox;
	
	public WebElement withinParentBoxOnly() {
		return withinParentBox;
	}

}
