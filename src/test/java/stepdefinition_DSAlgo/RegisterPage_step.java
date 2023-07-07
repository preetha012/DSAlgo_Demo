package stepdefinition_DSAlgo;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_RegisterPage;
import pageObjects_DSAlgo.PF_SignInPage;
import utilities_DSAlgo.Loggerload;

public class RegisterPage_step {

	
	private PF_RegisterPage PF_RegPage_obj = new PF_RegisterPage(DriverFactory.getDriver());
	private PF_SignInPage PF_SignInPage_obj= new PF_SignInPage(DriverFactory.getDriver());
	
	//@reg1
	@Given("The user opens Register Page")
	public void the_user_opens_register_page() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/register");
		Loggerload.info("******************* Launching Register Page******************");
	}

	@When("The user clicks Register button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty() throws InterruptedException {
		PF_RegPage_obj.withEmpyUsername_Password();
	}

	@Then("It should display an error Please fill out this field. below Username textbox")
	public void it_should_display_an_error_below_username_textbox() {		
		String msg=PF_RegPage_obj.emptyAllMsg();
		System.out.println("Fiels Empty-->"+msg);
	}
	
	
	//@reg2
	@When("The user clicks Register button after entering {string} with other fields empty")
	public void the_user_clicks_button_after_entering_username_with_other_fields_empty(String uname) throws InterruptedException {
		PF_RegPage_obj.click_withEmpyPassword(uname);
	}

	@Then("It should display an error Please fill out this field. below Password textbox")
	public void it_should_display_an_error_below_password_textbox() {
		String pswdEmpty=PF_RegPage_obj.emptyPswdMsg();
		System.out.println("Password is empty--> "+pswdEmpty);
	}
	
	//@reg3
	@When("The user clicks Register button after entering {string} and {string} with Password Confirmation field empty")
	public void the_user_clicks_button_after_entering_and_with_password_confirmation_field_empty(String uname, String pswd) throws InterruptedException {
		PF_RegPage_obj.emptyConfirmPassword(uname, pswd);
	 
	}

	@Then("It should display an error Please fill out this field. below Password Confirmation textbox")
	public void it_should_display_an_error_below_password_confirmation_textbox() {
		//System.out.print(string);
		String X=PF_RegPage_obj.emptyCnfirmPswdMsg();
		System.out.println("CnfrmPasswd Empty....>>>>"+X);
	}
	

//------------------------------------------------------------------------------------------------------------------
	//@reg4

		@When("The user enters a username with characters other than Letters, digits and symbols")
		//    "@/./+/-/_\"
		public void the_user_enters_a_with_characters_other_than_letters_digits_and(DataTable datatable) {
			List<Map<String,String>> rows= datatable.asMaps();
				String uname = rows.get(0).get("username");
				String passwd= rows.get(0).get("password");
				String cnfpasswd= rows.get(0).get("password confirmation");
				  System.out.println("Username is :"+ uname);
				  System.out.println("Password is  :"+ passwd);
				  System.out.println("Confrm passwrd is :"+cnfpasswd);
				  PF_RegPage_obj.uname_withsymbol(uname,passwd,cnfpasswd); 
			
		}
		
		@Then("It should display an error message Please enter a valid username")
		public void it_should_display_an_error_message_please_enter_a_valid_username() {
			String symbol=PF_RegPage_obj.uname_withsymbolmsg();
		   System.out.println("Symbols not allowed-->"+symbol);
		}
		
		//@reg5
		
		@When("The user enters a valid existing {string} with {string} and {string}")
		public void the_user_enters_a_valid_existing_with_and(String uname,String pass1,String pass2) {
			//List<Map<String,String>> rows= datatable.asMaps();
			//String uname= rows.get(0).get("username");
			//String pass1= rows.get(0).get("password");
			//String pass2= rows.get(0).get("password confirmation");
		
			PF_RegPage_obj.existing_user(uname,pass1,pass2);
			
		}
		
		@Then("It should display an error message Username already exists")
		public void it_should_display_an_error_message_username_already_exists() {
			String uname_ex=PF_RegPage_obj.existing_userMsg();
			System.out.println("Already existing user-->"+uname_ex);
		}
		//@reg6
		@When("The user clicks Register button after entering valid {string} and different passwords in {string} and {string} fields")
		public void the_user_clicks_register_button__different_passwords(String uname,String pass1,String pass2) {

			PF_RegPage_obj.withDiffPasswrd(uname,pass1,pass2);
		}
		
		@Then("It should display an error message password_mismatch:The two password fields didn’t match.")
		public void it_should_display_an_error_message_password_mismatch_the_two_password_fields_didn_t_match() {
			String dfpass=PF_RegPage_obj.withDiffPasswrdMsg();
			System.out.println("Passwd mismatch-->"+dfpass);
		}
		//@reg7
		@When("The user enters a valid {string} and {string} and {string} with characters less than {int}")
		public void the_user_enters_a_valid_and_with_characters_less_than(String uname, String pass1,String pass2, Integer int1) {
			PF_RegPage_obj.passWith_LessChar(uname,pass1,pass2);
		}
		
		@Then("It should display an error message Password should contain at least {int} characters")
		public void it_should_display_an_error_message_password_should_contain_at_least_characters(Integer int1) {
			String passLength=PF_RegPage_obj.passWith_LessCharMsg();
			System.out.println("Paswd less characters->"+passLength);
		}
		//@reg8
		@When("The user enters a valid {string} and {string} and {string} with only numbers")
		public void the_user_enters_a_valid_and_with_only_numbers(String uname, String pass1,String pass2) {
			PF_RegPage_obj.passWithOnlyNumbers(uname,pass1,pass2);
		}
		
		@Then("It should display an error message Password can’t be entirely numeric.")
		public void it_should_display_an_error_message_password_can_t_be_entirely_numeric() {
			String onlynum=PF_RegPage_obj.passwdOnlyNumberMsg();
			System.out.println("pass only numbers error-->"+onlynum);
		}
		
		//@reg9
		@When("The user enters a valid {string} and {string} and {string} similar to username")
		public void the_user_enters_a_valid_and_similar_to_username(String uname, String pass1,String pass2) {
			PF_RegPage_obj.sameUnameAndPass(uname,pass1,pass2);
		}
		
		@Then("It should display an error message password can’t be too similar to your other personal information.")
		public void it_should_display_an_error_message_password_can_t_be_too_similar_to_your_other_personal_information() throws IOException {
			String sameUandP = PF_RegPage_obj.sameUnameAndPassMsg();
			System.out.println("password same as username-->"+sameUandP);
			String expected="password cannot be similar to your Username";
			PF_RegPage_obj.error_message();
			assertEquals(sameUandP,expected);
			
		}
		
		
		//@reg10
		@When("The user enters a valid {string} and commonly used password {string} and {string}")
		public void the_user_enters_a_valid_and_commonly_used_password(String uname, String pass1,String pass2) {
			PF_RegPage_obj.commonlyUsedPaswd(uname,pass1,pass2);
		}
		
		@Then("It should display an error message Password can’t be commonly used password")
		public void it_should_display_an_error_message_password_can_t_be_commonly_used_password() {
			String commonpass = PF_RegPage_obj.commonlyUsedPaswdMsg();
			System.out.println("Commonly used Password-->"+commonpass);
		}
		
		//@reg11
		@When("The user enters a valid {string} and {string} and {string}")
		public void the_user_enters_a_valid_and_and(String uname, String passwd, String cnfpasswd) {
			PF_RegPage_obj.vaidReg_credentials(uname,passwd,cnfpasswd);
		}
		
		@Then("The user should be redirected to Homepage with the message New Account Created. You are logged in as {string}")
		public void the_user_should_be_redirected_to_homepage_with_the_message_new_account_created_you_are_logged_in_as(String string) {
			
			//assertTrue(DriverFactory.getDriver().getPageSource().contains("New Account Created"));
			
		}
		//@reg12
		@Given("The user opens Signin Page")
		public void the_user_opens_Signin_Page() {
			DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/login");
		}
		@When("The user enters a valid {string} and {string}")
		public void the_user_enters_a_valid_and(String uname, String password) throws InterruptedException {
			if(uname!=null || password!=null) {
				PF_SignInPage_obj.do_ValidLogin(uname,password);	
			}
		}
		
		@Then("click login button to verify")
		public void click_login_button_to_verify() {
			
			assertTrue(DriverFactory.getDriver().getPageSource().contains("You are logged in"));
			
			
		}
}
