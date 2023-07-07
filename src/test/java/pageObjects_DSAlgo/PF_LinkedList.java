package pageObjects_DSAlgo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_LinkedList {
	
	private WebDriver ldriver;
	public PF_LinkedList (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(linkText="Data Structures") WebElement Ds_dropdownBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[2]")@CacheLookup WebElement Drop_Linklist;
	@FindBy(linkText="Introduction")@CacheLookup WebElement linklist_intro;
	@FindBy(linkText ="Creating Linked LIst")@CacheLookup WebElement linklist_create;
	@FindBy(linkText ="Types of Linked List")@CacheLookup WebElement linklist_types;
	
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement DS_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	@FindBy(xpath="//*[@id='output']") @CacheLookup WebElement output_msgarea;
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement CodetryArea;
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void startLinkList() {
		Ds_dropdownBtn.click();
		Drop_Linklist.click();
	}
	public void IntroLinkList() {
		linklist_intro.click();
	}
	public void createLinklist() {
		linklist_create.click();
	}
	public void typesLinklist() {
		linklist_types.click();
	}
	public void tryhere() {
		DS_TryhereBtn.click();
	}
	public void runfunction() {
		Run_button.click();
	}
	public String runMessage() {
		String outputMsg=output_msgarea.getText();
		return outputMsg;
	}
	public void Linklist_PythonCode(String pythoncode) throws InterruptedException {
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
