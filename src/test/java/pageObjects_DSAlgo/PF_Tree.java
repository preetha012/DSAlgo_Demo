package pageObjects_DSAlgo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_Tree {
	
	private WebDriver ldriver;
	public PF_Tree (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(linkText="Data Structures") WebElement Ds_dropdownBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[5]")@CacheLookup WebElement Drop_tree;
	@FindBy(linkText = "Overview of Trees") @CacheLookup WebElement treeoverv_btn;
	@FindBy(linkText = "Terminologies") @CacheLookup WebElement treetermi_btn;
	@FindBy(linkText = "Types of Trees") @CacheLookup WebElement treeTypes_btn;
	
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement Q_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	@FindBy(xpath="//*[@id='output']") @CacheLookup WebElement output_msgarea;
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement CodetryArea;
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void startTree() {
		Ds_dropdownBtn.click();
		Drop_tree.click();
	}
	public void Tree_Overview() {
		treeoverv_btn.click();
	}
	public void Tree_Terminology() {
		treetermi_btn.click();
	}
	public void Tree_Types() {
		treeTypes_btn.click();
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
