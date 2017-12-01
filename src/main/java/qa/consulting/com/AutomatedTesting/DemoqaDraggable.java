package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoqaDraggable {
	
	@FindBy(css = "#ui-id-1")
	private WebElement defaultFunctionality;
	
	public void defaultFunctionalityTab() {
		defaultFunctionality.click();
	}
	
	@FindBy(css = "#ui-id-2")
	private WebElement constraintMovement;
	
	public void constraintMovementTab() {
		constraintMovement.click();
	}
	
	@FindBy(css = "#ui-id-3")
	private WebElement cursorStyle;
	
	public void cursorStyleTab() {
		cursorStyle.click();
	}
	
	@FindBy(css = "#ui-id-4")
	private WebElement events;
	
	public void eventsTab() {
		events.click();
	}
	
	@FindBy(css = "#ui-id-5")
	private WebElement dragSort;
	
	public void dragSortTab() {
		dragSort.click();
	}

}
