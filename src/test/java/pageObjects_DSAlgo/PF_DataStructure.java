package pageObjects_DSAlgo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class PF_DataStructure {

	private WebDriver ldriver;
	public PF_DataStructure (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(name="username") WebElement s_username;
	@FindBy(name="password") WebElement s_passwrd;
	@FindBy(xpath="//div[@class='col-sm']//input[4]") WebElement s_LoginBtn;
	@FindBy(xpath="//a[@href='data-structures-introduction']")@CacheLookup WebElement GetStart_intro;
	
	@FindBy(linkText = "Time Complexity") @CacheLookup WebElement TimeComplexityBtn;
	@FindBy(linkText = "Try here>>>") @CacheLookup WebElement DS_TryhereBtn;
	@FindBy(xpath="//button[text()='Run']") @CacheLookup WebElement Run_button;
	@FindBy(xpath="//*[@id='output']") @CacheLookup WebElement output_msgarea;
	@FindBy(xpath="//*[@class='CodeMirror-scroll']") @CacheLookup WebElement CodetryArea;
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void setUsername(String uname) {
		s_username.clear();
		s_username.sendKeys(uname);
	}
	public void setpassword(String pswd) {
		s_passwrd.clear();
		s_passwrd.sendKeys(pswd);
	}
	public void setloginBtn()
	{
		s_LoginBtn.click();
	}
	public void do_ValidLogin(String uname,String password) {	
		setUsername(uname);
		setpassword(password);
		setloginBtn();		
	}
	public void GetStart_DSFunction() {
		GetStart_intro.click();
	}
	public void TimeComplexity() {
		TimeComplexityBtn.click();
	}

	public void trybutton_clickfn() {
		DS_TryhereBtn.click();
	}

	public void DS_TryhereCodeFunction(String code,String result) throws InterruptedException {
		Actions action = new Actions(ldriver);
		//action.click(CodetryArea).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();		
		action.click(CodetryArea)
							.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
							.sendKeys(Keys.BACK_SPACE).build().perform();
		action.sendKeys(CodetryArea,code).build().perform();
	}
	public void setRunButton() {
		Run_button.click();
		
	}
	public String python_Resultmsg() {
		String outMsg= output_msgarea.getText();
		return outMsg;
	}
	public String python_alertmsg() throws InterruptedException {
		
		Alert alert = ldriver.switchTo().alert();
		String alertmessage= alert.getText();
		alert.accept();
		return alertmessage;
	}
	
	
	

}
