package stepdefinition_DSAlgo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.testng.Assert;
import org.junit.Assert;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_Stack;
import utilities_DSAlgo.ExcelReader;


public class Stack_step {
	
	private PF_Stack PF_Stack_obj = new PF_Stack(DriverFactory.getDriver());
	
	
	@When("The user select stack item from the drop down menu")
	public void the_user_select_stack_item_from_the_drop_down_menu() {	    
		PF_Stack_obj.startStack();
	}

	@Then("The user should then be directed to {string} Page")
	public void the_user_should_then_be_directed_to_page(String string) {
		String title=PF_Stack_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@Given("The user is on the Stack page after logged in")
	public void the_user_is_on_the_stack_page_after_logged_in() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/stack/");
	    
	}

	@When("The user clicks on the Operations in Stack link")
	public void the_user_clicks_on_the_operations_in_stack_link() {
		PF_Stack_obj.OperatnStack();
	    
	}

	@Given("The user is on the {string} after logged in for stack")
	public void the_user_is_on_the_after_logged_in_for_stack(String string) {
		String title=PF_Stack_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@When("The user clicks Try Here button in stack page")
	public void the_user_clicks_try_here_button_in_stack_page() {
		PF_Stack_obj.tryhere();
	    
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test for stack")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test_for_stack() {
		String title=PF_Stack_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@Given("The user is in the Stack page having an tryEditor with a Run button to test")
	public void the_user_is_in_the_stack_page_having_an_try_editor_with_a_run_button_to_test() {
		String title=PF_Stack_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@When("The user gets input from sheet {string} and {int}")
	public void the_user_gets_input_from_sheet_and(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
		List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
		String code= tryhereData.get(RowNum).get("Code");
		PF_Stack_obj.Stack_PythonCode(code);	
	    
	    
	}

	@When("The user clicks on Run button after Entering valid python code in stack tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_stack_try_editor() {
		PF_Stack_obj.runfunction();
	    
	}

	@Then("The user should be presented with Run output for stack")
	public void the_user_should_be_presented_with_run_output_for_stack() {
	    
		String validmsg=PF_Stack_obj.runMessage();
		System.out.println("Stack run result valid->"+validmsg);
	}

	@When("The user gets invalid input from sheet {string} and {int}")
	public void the_user_gets_invalid_input_from_sheet_and(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
		List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
		String code= tryhereData.get(RowNum).get("Code");
		PF_Stack_obj.Stack_PythonCode(code);
	}

	@When("The user clicks on Run button after Entering invalid python code in stack tryEditor")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_stack_try_editor() {
		PF_Stack_obj.runfunction();
	    
	}

	@Then("The user should get the error message for stack")
	public void the_user_should_get_the_error_message_for_stack() throws InterruptedException {
		String invalidmsg=PF_Stack_obj.alertmsgforInvalid();
		System.out.println("Stack invalid msg->"+invalidmsg);
	    
	}

	@When("The user clicks on the Implementation button")
	public void the_user_clicks_on_the_implementation_button() {
		PF_Stack_obj.ImplemtnStack();
	    
	}

	@When("The user clicks on the Applications button")
	public void the_user_clicks_on_the_applications_button() {
		PF_Stack_obj.ApplictnStack();
	    
	}

	

}
