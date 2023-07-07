package stepdefinition_DSAlgo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.testng.Assert;
import org.junit.Assert;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_DataStructure;
import utilities_DSAlgo.ExcelReader;
import utilities_DSAlgo.Loggerload;

public class DataStructure_step  {
	
	private PF_DataStructure PF_DataStructure_obj = new PF_DataStructure(DriverFactory.getDriver());
	
	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/login");
	}

	@When("The user enters a valid username {string} and  password {string}")
	public void the_user_enters_a_valid_username_and_password(String uname, String passwd) {
		PF_DataStructure_obj.do_ValidLogin(uname,passwd);
	}

	@Then("The user is on the home page of DS Algo portal")
	public void the_user_is_on_the_home_page_of_DS_Algo_portal() {
		String title=PF_DataStructure_obj.getPageTitle();
		System.out.println("Then usr in home page--->"+title);
		Assert.assertEquals(title, "NumpyNinja");
	}

	@Given("The user is on the home page after logged in")
	public void the_user_is_on_the_home_page_after_logged_in() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/home");
			String title=	PF_DataStructure_obj.getPageTitle();
			Assert.assertEquals(title, "NumpyNinja");
	}

	@When("The user clicks the Getting Started button in Data Structure Page introduction Panel")
	public void the_user_clicks_the_getting_started_button_in_data_structure_page_introduction_panel() throws InterruptedException {
		PF_DataStructure_obj.GetStart_DSFunction();
	}

	@Then("The user is on the Data Structure introduction page")
	public void the_user_is_on_the_home_page() {
		String title= PF_DataStructure_obj.getPageTitle();
		System.out.println("Then DS title---->"+title);
		Loggerload.info("****** Launching DS Intro Page******************");
		
	}

	@Given("The user is on the Data Structures Introduction after logged in")
	public void the_user_is_on_the_data_structures_introduction_after_logged_in() {
		String title= PF_DataStructure_obj.getPageTitle();
		Assert.assertEquals(title, "Data Structures-Introduction");
	}

	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
	    PF_DataStructure_obj.TimeComplexity();
	}

	@Then("The user should be redirected to Time Complexity page")
	public void the_user_should_be_redirected_to_time_complexity_page() {
	  String timecom=DriverFactory.getDriver().getTitle();
	  System.out.println("Time complexity page -->"+timecom);
	}

	@Given("The user is on the Time Complexity after logged in")
	public void the_user_is_on_the_time_complexity_after_logged_in() {
		
		String title= PF_DataStructure_obj.getPageTitle();
		Assert.assertEquals(title, "Time Complexity");
	}

	@When("The user clicks Try Here button on Time Complexity page")
	public void the_user_clicks_try_here_button_on_time_complexity_page() {
		PF_DataStructure_obj.trybutton_clickfn();
	}

	@Then("The user is in tryEditor page")
	public void jjjjjjjj() {
		String tryedit=PF_DataStructure_obj.getPageTitle();
		  System.out.println("Try dit box page page -->"+tryedit);
	}

	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
		String title= PF_DataStructure_obj.getPageTitle();
		Assert.assertEquals(title, "Assessment");
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
		List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
		String code= tryhereData.get(RowNum).get("Code");
		//System.out.println("code-->"+code);
		String result= tryhereData.get(RowNum).get("ExpectedResult");
		PF_DataStructure_obj.DS_TryhereCodeFunction(code,result);
	}

	@And("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
		PF_DataStructure_obj.setRunButton();
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		String outputMsg=PF_DataStructure_obj.python_Resultmsg();
		System.out.println("Msg printed below Run-->"+outputMsg);
	}

	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String sheetName, Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
		List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
		String code= tryhereData.get(RowNum).get("Code");
		String result= tryhereData.get(RowNum).get("ExpectedResult");
		PF_DataStructure_obj.DS_TryhereCodeFunction(code,result);
	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() throws InterruptedException {
		String alertmsg= PF_DataStructure_obj.python_alertmsg();
		System.out.println("alert msg-->"+alertmsg);
	}


}
