package pageObjects_DSAlgo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_Queue {

	private WebDriver ldriver;
	public PF_Queue (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(linkText="Data Structures") WebElement Ds_dropdownBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[4]")@CacheLookup WebElement Drop_queue;
	@FindBy(linkText = "Implementation of Queue in Python") @CacheLookup WebElement Queuepython_btn;
	@FindBy(linkText = "Implementation using array") @CacheLookup WebElement QueueUsngArray_btn;
	@FindBy(linkText = "Queue Operations") @CacheLookup WebElement Queueoperatn_btn;
	
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement Q_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	@FindBy(xpath="//*[@id='output']") @CacheLookup WebElement output_msgarea;
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement CodetryArea;
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void startQueue() {
		Ds_dropdownBtn.click();
		Drop_queue.click();
	}
	public void Queue_in_python() {
		Queuepython_btn.click();
	}
	public void Queue_using_array() {
		QueueUsngArray_btn.click();
	}
	public void Queue_Operatns() {
		Queueoperatn_btn.click();
	}
	public void tryhere() {
		Q_TryhereBtn.click();
	}
	public void runfunction() {
		Run_button.click();
	}
	public String runMessage() {
		String outputMsg=output_msgarea.getText();
		return outputMsg;
	}
	/*public void Queue_PythonCode(String pythoncode) throws InterruptedException {
		Actions action = new Actions(ldriver);
		action.click(CodetryArea).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(CodetryArea,pythoncode).build().perform();	
	}*/
	public String alertmsgforInvalid() throws InterruptedException {	
		Alert alert = ldriver.switchTo().alert();
		String alertmessage= alert.getText();
		alert.accept();
		return alertmessage;
	}
}
