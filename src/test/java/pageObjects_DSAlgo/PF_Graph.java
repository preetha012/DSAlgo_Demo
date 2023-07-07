package pageObjects_DSAlgo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_Graph {
	

	private WebDriver ldriver;
	public PF_Graph (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(linkText="Data Structures") WebElement Ds_dropdownBtn;
	@FindBy(xpath="//div[@class='dropdown-menu show']/a[6]")@CacheLookup WebElement Drop_graph;
	@FindBy(linkText = "Graph") @CacheLookup WebElement graph_btn;
	@FindBy(linkText = "Graph Representations") @CacheLookup WebElement graphRep_btn;
	
	
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement Q_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	@FindBy(xpath="//*[@id='output']") @CacheLookup WebElement output_msgarea;
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement CodetryArea;
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void startGraph() {
		Ds_dropdownBtn.click();
		Drop_graph.click();
	}
	public void Graph_Link() {
		graph_btn.click();
	}
	public void Graph_Representn() {
		graphRep_btn.click();
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
