package pageObjects_DSAlgo;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PF_RegisterPage {
	
	private WebDriver ldriver;
	private static String emptyAllMsg;
	private static String emptypswdMsg;
	private static String emptyCnfrmpswdMsg;
	private static String Reg_alertmsg;
	private static String Reg_alertmsgNum;
	
	public PF_RegisterPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="username") WebElement r_username;
	@FindBy(name="password1") WebElement r_passwrd;
	@FindBy(name="password2") WebElement r_cnfrmpasswrd;
	@FindBy(xpath="//input[@autocomplete='username']") WebElement uNameErrormsg;
	@FindBy(xpath="//input[@autocomplete='new-password']") WebElement pswdErrormsg;
	@FindBy(xpath="//input[@name='password2']") WebElement pswdCnfrmErrormsg;
	@FindBy(xpath="//div[@class='col-sm']//input[5]") WebElement RegisterBtn;
	@FindBy(xpath="//div[@class='alert alert-primary']") WebElement RegisterAlertmsg;
	@FindBy(xpath = "/html") WebElement screenshots;
	
	
	public void Reg_pagetitle() {
		String title=ldriver.getTitle();
		System.out.println(title);
	}
	public void setRegisterBtn()
	{		
		RegisterBtn.click();
	}
	public void setusername(String uname) {
		r_username.clear();
		r_username.sendKeys(uname);
	}
	public void setpassword(String pswd) {
		r_passwrd.clear();
		r_passwrd.sendKeys(pswd);
	}
	public void setCnfrmpassword(String  cnfrmpswd) {
		r_cnfrmpasswrd.clear();
		r_cnfrmpasswrd.sendKeys(cnfrmpswd);
	}
	
	//@reg1--------
	public void withEmpyUsername_Password() throws InterruptedException {
		
		String uname="";
		String pswd="";
		String cnfpsswd="";
		setusername(uname);
		setpassword(pswd);
		setCnfrmpassword(cnfpsswd);
		setRegisterBtn();		
		String getName=r_username.getText();
		String getPasswd= r_passwrd.getText();
		String getcnfpswd=r_cnfrmpasswrd.getText();
		if(getName.isBlank()|getPasswd.isBlank()|getcnfpswd.isBlank()) {
		emptyAllMsg = uNameErrormsg.getAttribute("validationMessage");		 
		}
	}
	public String emptyAllMsg() {
		
		return emptyAllMsg;
	}
	//@reg2--------
	public void click_withEmpyPassword(String uname) throws InterruptedException {
		setusername(uname);
		String pass="";
		setpassword(pass);
		setRegisterBtn();
				 emptypswdMsg = pswdErrormsg.getAttribute("validationMessage");	
		
	}
	public String emptyPswdMsg() {
		//System.out.println(emptypswdMsg);
		return emptypswdMsg;
	}
	//@reg3
	public void emptyConfirmPassword(String uname, String pswd) throws InterruptedException {
		setusername(uname);
		setpassword(pswd);
		String cnfpswd="";
		setCnfrmpassword(cnfpswd);
		setRegisterBtn();
		 emptyCnfrmpswdMsg = pswdCnfrmErrormsg.getAttribute("validationMessage");	
		 
	}
	public String emptyCnfirmPswdMsg() {
		
		return emptyCnfrmpswdMsg;
	}
	//@reg4
	public void uname_withsymbol(String uname,String pass1,String pass2) {
		setusername(uname);
		setpassword(pass1);
		setCnfrmpassword(pass2);
		setRegisterBtn();
		//String getName=r_username.getText();

		 Reg_alertmsg= RegisterAlertmsg.getText();
	}
	public String uname_withsymbolmsg() {
		return Reg_alertmsg;
	}
	//@reg5
	public void existing_user(String uname,String pass1,String pass2) {
		setusername(uname);
		setpassword(pass1);
		setCnfrmpassword(pass2);
		setRegisterBtn();
		 Reg_alertmsg= RegisterAlertmsg.getText();	
	}
	public String existing_userMsg() {
		return Reg_alertmsg;
	}
	//@reg6
	public void withDiffPasswrd(String uname,String passwd,String cnfpasswd) {
		setusername(uname);
		setpassword(passwd);
		setCnfrmpassword(cnfpasswd);
		setRegisterBtn();
		 Reg_alertmsg= RegisterAlertmsg.getText();	
	}
	public String withDiffPasswrdMsg() {
		return Reg_alertmsg;
		
	}
	//@reg7
	public void passWith_LessChar(String uname,String passwd,String cnfpasswd) {
		setusername(uname);
		setpassword(passwd);
		setCnfrmpassword(cnfpasswd);
		if(r_passwrd.getText().length()<=8) {
			setRegisterBtn();
			 Reg_alertmsg= RegisterAlertmsg.getText();	
		}
	}
	public String passWith_LessCharMsg() {
		return Reg_alertmsg;
	}
	//@reg8
	public void passWithOnlyNumbers(String uname,String pass1,String pass2) {
		setusername(uname);
		setpassword(pass1);
		setCnfrmpassword(pass2);
		setRegisterBtn();
		String value= r_passwrd.getText();
		if(!value.matches("[a-zA-Z_]+")) {
			 Reg_alertmsgNum= RegisterAlertmsg.getText();	
		}
	}
	public String passwdOnlyNumberMsg() {
		return Reg_alertmsgNum;
	}
	//@reg9
	public void sameUnameAndPass(String uname,String pass1,String pass2) {
		setusername(uname);
		setpassword(pass1);
		setCnfrmpassword(pass2);
		setRegisterBtn();
		String getName=r_username.getText();
		String getPasswd= r_passwrd.getText();
		if(getPasswd.contains(getName)) {
			System.out.println("password contains username data....");
			 Reg_alertmsg= RegisterAlertmsg.getText();	
		}
	}
	public String sameUnameAndPassMsg() {
		return Reg_alertmsg;
	}
	//@reg10
	public void commonlyUsedPaswd(String uname,String pass1,String pass2) {
		setusername(uname);
		setpassword(pass1);
		setCnfrmpassword(pass2);
		setRegisterBtn();
		String getPasswd= r_passwrd.getText();
		if(getPasswd.contains("Welcome")) {
			System.out.println("Commonly used Passwords....");
			 Reg_alertmsg= RegisterAlertmsg.getText();	
		}
	}
	public String commonlyUsedPaswdMsg() {
		return Reg_alertmsg;
	}
	//@reg11
	public void vaidReg_credentials(String uname,String pass1,String pass2) {
		setusername(uname);
		setpassword(pass1);
		setCnfrmpassword(pass2);
		setRegisterBtn();
		
	}
	public void error_message() throws IOException
	{
	String message = RegisterAlertmsg.getText();
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
