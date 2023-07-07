package pageObjects_DSAlgo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_Stack {
	private WebDriver ldriver;
	public PF_Stack (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(linkText="Data Structures") WebElement Ds_dropdownBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[3]")@CacheLookup WebElement Drop_stack;
	@FindBy(linkText="Operations in Stack") @CacheLookup WebElement OperatnBtn;
	@FindBy(linkText="Implementation") @CacheLookup WebElement ImplemtnBtn;
	@FindBy(linkText="Applications") @CacheLookup WebElement ApplictnBtn;
	
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement S_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	@FindBy(xpath="//*[@id='output']") @CacheLookup WebElement output_msgarea;
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement CodetryArea;
	

	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void startStack() {
		Ds_dropdownBtn.click();
		Drop_stack.click();
	}
	public void OperatnStack() {
		OperatnBtn.click();
	}
	public void ImplemtnStack() {
		ImplemtnBtn.click();
	}
	public void ApplictnStack() {
		ApplictnBtn.click();
	}
	public void tryhere() {
		S_TryhereBtn.click();
	}
	public void runfunction() {
		Run_button.click();
	}
	public String runMessage() {
		String outputMsg=output_msgarea.getText();
		return outputMsg;
	}
	public void Stack_PythonCode(String pythoncode) throws InterruptedException {
		Actions action = new Actions(ldriver);
		action.click(CodetryArea).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(CodetryArea,pythoncode).build().perform();	
	}
	public String alertmsgforInvalid() throws InterruptedException {	
		Alert alert = ldriver.switchTo().alert();
		String alertmessage= alert.getText();
		alert.accept();
		return alertmessage;
	}
}
