package stepdefinition_DSAlgo;

//import static org.testng.Assert.assertEquals;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_ArrayPage;
import utilities_DSAlgo.ExcelReader;
import utilities_DSAlgo.Loggerload;


public class ArrayPage_step {
	
	private PF_ArrayPage PF_ArrayPage_obj= new PF_ArrayPage(DriverFactory.getDriver());
	

		@When("The user clicks the Getting Started button in Array Page")
		public void the_user_clicks_the_getting_started_button_in_array_page() {
			PF_ArrayPage_obj.getStartArray();
		}		
		@Then("The user is on the Array Page")
		public void the_user_is_on_the_array_page() {
		    String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Then Page title is->"+title);	
		    Loggerload.info("****** Launching Array Page******************");
		}	
		@Given("The user is on the {string} after logged in")
		public void the_user_is_on_the_after_logged_in(String string) {
			String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Actual Pagetitle is->"+title);
		    System.out.println("*Expected Pagetitle from featurefile is->"+string);
		    assertEquals(title,string);		    
		}		
		@When("The user clicks Arrays in Python button")
		public void the_user_clicks_arrays_in_python_button() {
			PF_ArrayPage_obj.array_PythonFn();		    
		}		
		@Then("The user should be redirected to {string} page")
		public void the_user_should_be_redirected_to_page(String string) {
			String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Current title is->"+title+" and Title passed frm feature is->"+string);
		    assertEquals(title,string);
		}		
		@When("The user clicks Try Here button")
		public void the_user_clicks_button() {		
				PF_ArrayPage_obj.array_tryHere();			
		}		
		@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
		public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
			String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Actual Pagetitle is ->"+title);
		    assertEquals(title,"Assessment");		    
		}		
		@When("The user enter valid python code in tryEditor from sheet {string} and {int} for array")
		public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and_for_array(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
			List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
			String code= tryhereData.get(RowNum).get("Code");
			PF_ArrayPage_obj.Array_validPythonCode(code);		    
		}
		@And("The user clicks on run button for array")
		public void the_user_clicks_on_run_button() throws InterruptedException {
			PF_ArrayPage_obj.setRunButton();
		}
		@Then("The user should be presented with Run result for array")
		public void the_user_should_be_presented_with_run_result_for_array() {
			String run_result=PF_ArrayPage_obj.getRunResult();
			System.out.println("*Printed msg after Run->"+run_result);
			DriverFactory.getDriver().navigate().refresh();
		}
		@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int} for array")
		public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and_for_array(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
			List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
			String code= tryhereData.get(RowNum).get("Code");
			PF_ArrayPage_obj.Array_InvalidPythonCode(code);		    
		}
		@Then("The user should be presented with error message for array")
		public void the_user_should_be_presented_with_error_message_for_array() throws InterruptedException {
			String alertMsg=PF_ArrayPage_obj.alertmsgforInvalid();
			System.out.println("*Error msg from alert box->"+alertMsg);
			
		}
		@Given("The user is on the Array page after logged in")
		public void the_user_is_on_the_after_logged_in() {
			DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/array/");
	    
		}
		@When("The user clicks Arrays Using List link")
		public void the_user_clicks_arrays_using_list_link() {
			PF_ArrayPage_obj.array_usingList();
		}
		
		@When("The user enter valid python code in tryEditor with valid credential from sheet {string} and {int}")
		public void the_user_enter_valid_python_code_in_try_editor_with_valid_credential_from_sheet_and(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
			List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
			String code= tryhereData.get(RowNum).get("Code");
			PF_ArrayPage_obj.Array_validPythonCode(code);		    
		}		
		@When("The user clicks Basic Operations in Lists link")
		public void the_user_clicks_basic_operations_in_lists_link() {
			PF_ArrayPage_obj.array_BasicOperation();		    
		}		
		@When("The user clicks Applications of Array link")
		public void the_user_clicks_applications_of_array_link() {
			PF_ArrayPage_obj.Applictn_array();		    
		}
		@Given("The user is on the Arrays in Python after logged in")
		public void the_user_is_on_the_Arrays_in_Python_after_logged_in() {
		   DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/array/arrays-in-python/");		   
		}	
		@When("The user clicks Practice Questions link")
		public void the_user_clicks_practice_questions_link() {
			PF_ArrayPage_obj.Array_PracticeQuestn();	    
		}			
		@When("The user clicks the Search the array link")
		public void the_user_clicks_the_search_the_array_link() {
			PF_ArrayPage_obj.Search_Array();		    
		}		
		@Then("The user should be redirected to question page contains an tryEditor with Run and Submit buttons")
		public void the_user_should_be_redirected_to_question_page_contains_an_try_editor_with_run_and_submit_buttons() {
			String title= PF_ArrayPage_obj.getPageTitle();
		    assertEquals(title,"Assessment");		    
		}
		@Given("The user is on Question page of Search the array after logged in")
		public void the_user_is_on_question_page_of_search_the_array_after_logged_in() {
			String title= PF_ArrayPage_obj.getPageTitle();
		    assertEquals(title, "Assessment");
		    System.out.println("*Reached the Assessmt ie Question Page!!");		    
		}
		@When("The user enter valid python code in tryEditor from sheet {string} and {int} for the question")
		public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and_for_the_question(String sheetName, Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
			ExcelReader reader = new ExcelReader();
			String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
			List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
			String code= tryhereData.get(RowNum).get("Code");
			System.out.println("*code from Excel is -->"+code);
			PF_ArrayPage_obj.Array_validPythonCode(code);
		}
		@And("The user clicks on Submit button")
		public void the_user_clicks_on_submit_button() throws InterruptedException {
			PF_ArrayPage_obj.setSubmit();
		}
		@Then("The user should be presented with successful submission message")
		public void the_user_should_be_presented_with_successful_submission_message() {
			String msg=PF_ArrayPage_obj.getSubmitResult();
			System.out.println("*Printed msg after submit Button->"+msg);
		}	
		@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int} for the question")
		public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and_for_the_question(String sheetName, Integer RowNum) throws InvalidFormatException, IOException, InterruptedException {
			ExcelReader reader = new ExcelReader();
			String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
			List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
			String code= tryhereData.get(RowNum).get("Code");
			PF_ArrayPage_obj.Array_InvalidPythonCode(code);
		}		
		@Given("The user is on the Practice Question page after logged in")
		public void the_user_is_on_the_Practice_Question_page_after_logged_in() {
			DriverFactory.getDriver().navigate().back();
			String title= PF_ArrayPage_obj.getPageTitle();
		    assertEquals(title,"Practice Questions");
		    System.out.println("*Page reached->"+title+" & Page expected is Practice Questions");			
		}		
		@When("The user clicks the Max Consecutive Ones link")
		public void the_user_clicks_the_max_consecutive_ones_link() {
			PF_ArrayPage_obj.array_maxConsctvOnes();
		}		
		@Given("The user is on Question page of Max Consecutive Ones after logged in")
		public void the_user_is_on_question_page_of_max_consecutive_ones_after_logged_in() {
			String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Question page title should reach->"+title);
		    assertEquals(title, "Assessment");
		}		
		@When("The user clicks the Find Numbers with Even Number of Digits link")
		public void the_user_clicks_the_find_numbers_with_even_number_of_digits_link() {
			PF_ArrayPage_obj.array_EvenDigits();
		}		
		@Given("The user is on Question page of Find Numbers with Even Number of Digits after logged in")
		public void the_user_is_on_question_page_of_find_numbers_with_even_number_of_digits_after_logged_in() {
			String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Question page title should reach->"+title);		    
		    assertEquals(title,"Assessment");
		}	
		@When("The user clicks the Squares of a Sorted Array link")
		public void the_user_clicks_the_squares_of_a_sorted_array_link() {
			PF_ArrayPage_obj.array_squareSorted();
		}		
		@Given("The user is on Question page of Squares of a Sorted Array after logged in")
		public void the_user_is_on_question_page_of_squares_of_a_sorted_array_after_logged_in() {
			String title= PF_ArrayPage_obj.getPageTitle();
		    System.out.println("*Question page title should reach->"+title);
		    String expected="Assessment";
		    assertEquals(title, expected);
		}

}
