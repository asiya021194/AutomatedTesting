package qa.consulting.com.AutomatedTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageDemoqa {
	
	@FindBy(css = "#menu-item-140 > a")
	private WebElement toDraggablePage;
	
	
	public void toDraggable() {
		toDraggablePage.click();
	}
	
	@FindBy(css = "#menu-item-142")
	private WebElement toSelectablePage;
	
	public void toSelectable() {
		toSelectablePage.click();
	}
	
	@FindBy(css = "#menu-item-151 > a")
	private WebElement toSortablePage;
	
	public void toSortable() {
		toSortablePage.click();
	}
	
	@FindBy(css = "#menu-item-99 > a")
	private WebElement toTooltipPage;
	
	public void toTooltip() {
		toTooltipPage.click();
	}
	
	@FindBy(css = "#menu-item-97 > a")
	private WebElement toSliderPage;
	
	public void toSlider() {
		toSliderPage.click();
	}
	
	@FindBy(css = "#menu-item-146 > a")
	private WebElement toDatapickerPage;
	
	public void toDatapicker() {
		toDatapickerPage.click();
	}
	
}
