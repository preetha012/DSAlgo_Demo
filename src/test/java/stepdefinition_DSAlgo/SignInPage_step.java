package stepdefinition_DSAlgo;

//import static org.testng.Assert.assertEquals;
//import org.junit.Assert;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_HomePage;
import pageObjects_DSAlgo.PF_SignInPage;
import utilities_DSAlgo.ExcelReader;
import utilities_DSAlgo.Loggerload;

public class SignInPage_step {
	
	private PF_SignInPage PF_SignInPage_obj= new PF_SignInPage(DriverFactory.getDriver());
	private PF_HomePage PF_HomePage_obj = new PF_HomePage(DriverFactory.getDriver());
	
	
	@Given("The user is on signin page")
	public void the_user_is_on_signin_page() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/login");
		Loggerload.info("********** Launching Sigin In Page******************");
	}

	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() throws InterruptedException {
		PF_SignInPage_obj.click_regFromSignPage();
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		String title=PF_SignInPage_obj.login_pagetitle();
		System.out.println("register page from sign in -> "+title);
		assertEquals(title,"Registration");
		
	}
//---------------Data Table----------
	/*@DataTableType(replaceWithEmptyString = "0")
	public String stringType(String cell) {
	    return cell;
	}*/
	@DataTableType
	  public String nullToString(String cell) {
	    return Objects.isNull(cell) ? "" : cell;
		
	  }
	@When("The user enter invalid Username and Password")
	public void the_user_enter_invalid_Username_and_Password(DataTable datatable) throws InterruptedException {
		
		List<Map<String,String>> rows= datatable .asMaps(String.class,String.class);
		for(Map<String,String>columns: rows){
			String uname = columns.get("Username");
			String passwd= columns.get("Password");
			  System.out.println("Username is :"+ uname);
			  System.out.println("Password is  :"+ passwd);
			  PF_SignInPage_obj.doInvalidLogin(uname,passwd);
		
		}
		
	}
	/*@When("The user enter invalid Username and Password")
	public void the_user_enter_invalid_Username_and_Password(Map<String,String>map) throws InterruptedException {
		//map contains {
		@DataTableType(replaceWithEmptyString ="[blank]" )
		
	}*/
	@Then("click login button to verify credentials")
	public void click_login_button_to_verify_credentials() {
		String title=PF_SignInPage_obj.login_pagetitle();
	    assertEquals(title,"Login");
	}
//-----------------------Excel Data --------------------------------------------
	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetName, Integer RowNum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\ExcelLoginData1.xlsx";
		List<Map<String,String>> logindata= reader.getData(excelfile_path, sheetName);
		String uname= logindata.get(RowNum).get("username");
		String pswd= logindata.get(RowNum).get("password");
		String msg= logindata.get(RowNum).get("expected msg");
		System.out.println(uname);
		System.out.println(pswd);
		System.out.println(msg);
		PF_SignInPage_obj.excelDataLogin(uname,pswd,msg);
	}

	@Then("click login button to verify exceldata")
	public void click_login_button_to_verify_exceldata() throws IOException {
		PF_SignInPage_obj.excelMessage();
		//PF_SignInPage_obj.error_message();
	}
//--------------------------------------------
	@Given("The user is in the Home page with valid  log in")
	public void the_user_is_in_the_home_page_with_valid_log_in() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/login");
		String uname="NumpyNinja@112";
		String passwd="Project@123";
		PF_SignInPage_obj.do_ValidLogin(uname,passwd);

	}

	@When("The user clicks Sign out")
	public void the_user_clicks_sign_out() {
		PF_HomePage_obj.logout_fn();
	}

	@Then("The user is in signin page")
	public void the_user_is_in_signin_page() {
		String title=PF_SignInPage_obj.login_pagetitle();
		assertEquals(title,"NumpyNinja");
	}

}
