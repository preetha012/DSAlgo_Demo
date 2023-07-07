package pageObjects_DSAlgo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Date;
//import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PF_SignInPage {
	
	public WebDriver localdriver;
	private static String loginMsg;
	private static String LoginExcelMsg;
	
	public PF_SignInPage(WebDriver rdriver) {
		localdriver= rdriver;
		PageFactory.initElements(localdriver, this);
	}
	
	
	@FindBy(name="username") WebElement s_username;
	@FindBy(name="password") WebElement s_passwrd;
	@FindBy(xpath="//div[@class='col-sm']//input[4]") WebElement s_LoginBtn;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a") WebElement RegBtnDown;
	@FindBy(linkText = " Register ") WebElement RegBtnRightSide;
	@FindBy(linkText="Sign in") WebElement SignBtnRightSide;
	@FindBy(xpath="//*[@id='id_username']") @CacheLookup  WebElement UnameErrormsg;
	@FindBy(xpath="//*[@id='id_password']") @CacheLookup WebElement PswdErrormsg;
	@FindBy(xpath="//div[@class='alert alert-primary']") WebElement Login_ErrMessage;
	//@FindBy(xpath ="/html/body/div[3]") WebElement err_message;
	@FindBy(xpath ="//div[@class='alert alert-primary']") WebElement err_message;
	@FindBy(xpath = "/html/body") WebElement screenshots;
	public String login_pagetitle() {
		String title=localdriver.getTitle();
		System.out.println(title);
		return title;
	}
	public void click_regFromSignPage() throws InterruptedException {
		//Actions action = new Actions(localdriver);
		//action.moveToElement(RegBtnDown).click().build().perform();
		
		RegBtnDown.click();
		
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
	public void click_withEmpyUsername(String uname) throws InterruptedException {

		setUsername(uname);
		s_LoginBtn.click();		
		loginMsg = UnameErrormsg.getAttribute("validationMessage");		 
		System.out.println("Empty username-->"+loginMsg);
	}

	public void excelDataLogin(String uname,String pswd,String excelmsg) throws IOException {
		setUsername(uname);
		setpassword(pswd);
		setloginBtn();
		LoginExcelMsg=Login_ErrMessage.getText();	
		//assertEquals(excelmsg, LoginExcelMsg);
		System.out.println("login message-->"+LoginExcelMsg);
		//error_message();
	}
	public String excelMessage() {
		return LoginExcelMsg;
	}
	public void doInvalidLogin(String uname,String password) throws InterruptedException {
		
		setUsername(uname);
		setpassword(password);
		setloginBtn();
		String getName=s_username.getText();
		String getPasswd= s_passwrd.getText();
		if(getName.isEmpty()) {		
			
			loginMsg = UnameErrormsg.getAttribute("ValidationMessage");
			System.out.println("Loginuname  msg -- "+loginMsg);
		}else if(getPasswd.isEmpty()) {	
			loginMsg = PswdErrormsg.getAttribute("ValidationMessage");
			System.out.println("Login pswd msg -- "+loginMsg);
		}else {
			loginMsg="You are logged in Successfully";
		}		
	}
	public String getLoginMsg() {
		
		return loginMsg;
	}
	public void error_message() throws IOException
	{
	String message = err_message.getText();
	System.out.println("Error mssgg printing-->"+message);
	//TakesScreenshot ts = (TakesScreenshot) screenshots;
	//File src = ts.getScreenshotAs(OutputType.FILE);
	File src1 = ((TakesScreenshot) screenshots).getScreenshotAs(OutputType.FILE);
	Date dt = new Date();
	DateFormat dft = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
	//File trg = new File(".\\Screenshots\\image.png");
	FileUtils.copyFile(src1, new File("./Screenshots/imag1" + dft.format(dt) + ".png"));

	}
	
}
