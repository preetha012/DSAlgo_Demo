package stepdefinition_DSAlgo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import  org.junit.Assert;

import driverFactory_DSAlgo.DriverFactory;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_LinkedList;
import utilities_DSAlgo.ExcelReader;
public class LinkedList_step {
	
	private PF_LinkedList PF_LinkedList_obj= new PF_LinkedList(DriverFactory.getDriver());
	
	@Given("The user is in the Home page after logged in")
	public void the_user_is_in_the_home_page_after_logged_in() {
		String title=PF_LinkedList_obj.getPageTitle();
		Assert.assertEquals(title,"NumpyNinja");
	}

	@When("The user selecting linkedlist item from the drop down menu")
	public void the_user_selecting_linkedlist_item_from_the_drop_down_menu() {
	    
		PF_LinkedList_obj.startLinkList();
	}

	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String string) {
		String title=PF_LinkedList_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@Given("The user is in the Linked List  page after logged in")
	public void the_user_is_in_the_linked_list_page_after_logged_in() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/linked-list/");
	    
	}
	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		if(string.equalsIgnoreCase("Introduction")) {
	    	PF_LinkedList_obj.IntroLinkList();
	    }else if(string.equalsIgnoreCase("Creating Linked LIst")) {
	    	PF_LinkedList_obj.createLinklist(); 	
	    }else if(string.equalsIgnoreCase("Types of Linked List")) {
	    	PF_LinkedList_obj.typesLinklist();
	    }
	}

	@Then("The user should be directed to {string} of Linked List Page")
	public void the_user_should_be_directed_to_of_linked_list_page(String string) {
		String title=PF_LinkedList_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@Given("The user is on the {string} after logged in for LinkedList")
	public void the_user_is_on_the_after_logged_in_for_linked_list(String string) {
		String title=PF_LinkedList_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@When("The user clicks Try Here button in the {string} page")
	public void the_user_clicks_Try_Herebutton_in_the_page(String string) {
		PF_LinkedList_obj.tryhere();
	    
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test for LinkedList")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test_for_linked_list() {
		String title=PF_LinkedList_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@Given("The user is in a try here page having  tryEditor with a Run button to test")
	public void the_user_is_in_a_try_here_page_having_try_editor_with_a_run_button_to_test() {
		String title=PF_LinkedList_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@When("The user Enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
		List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
		String code= tryhereData.get(RowNum).get("Code");
		PF_LinkedList_obj.Linklist_PythonCode(code);	
	    
	}

	@When("user click on Run button")
	public void user_click_on_run_button() {
		PF_LinkedList_obj.runfunction();
	    
	}

	@Then("The user should be presented with the Run output")
	public void the_user_should_be_presented_with_the_run_output() {
		String validmsg=PF_LinkedList_obj.runMessage();
		System.out.println("LinkList run result valid->"+validmsg);
	    
	}

	@When("The user Enter invalid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer RowNum) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		String excelfile_path="C:\\Users\\anoop\\eclipse-workspaceNew\\DS_AlgoProjectNew\\src\\test\\resources\\excelData\\PythonCodeExcel.xlsx";
		List<Map<String,String>> tryhereData= reader.getData(excelfile_path, sheetName);
		String code= tryhereData.get(RowNum).get("Code");
		PF_LinkedList_obj.Linklist_PythonCode(code);
	}

	@Then("The user should be presented with the invalid Run output")
	public void the_user_should_be_presented_with_the_invalid_run_output() throws InterruptedException {
		String invalidmsg=PF_LinkedList_obj.alertmsgforInvalid();
		System.out.println("LinkList invalid msg->"+invalidmsg);
	    
	}
	

}
