package stepdefinition_DSAlgo;

//import org.testng.Assert;
//import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_Queue;

public class Queue_step {

	private PF_Queue PF_Queue_obj= new PF_Queue(DriverFactory.getDriver());
	
	@When("The user select Queue item from the drop down menu")
	public void the_user_select_queue_item_from_the_drop_down_menu() {
	    
		PF_Queue_obj.startQueue();
	}

	@Given("The user is on the Queue page after logged in")
	public void the_user_is_on_the_queue_page_after_logged_in() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/queue/");
	    
	}

	@When("The user clicks on the {string} link for Queue")
	public void the_user_clicks_on_the_link_for_queue(String string) {
		if(string.equalsIgnoreCase("Implementation of Queue in Python")) {
			PF_Queue_obj.Queue_in_python();
	    }else if(string.equalsIgnoreCase("Implementation using array")) {
	    	PF_Queue_obj.Queue_using_array(); 	
	    }else if(string.equalsIgnoreCase("Queue Operations")) {
	    	PF_Queue_obj.Queue_Operatns();
	    }
	    
	}

	@Given("The user is on the {string} after logged in for Queue")
	public void the_user_is_on_the_after_logged_in_for_queue(String string) {
		String title=PF_Queue_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@When("The user clicks Try Here button in Queue page")
	public void the_user_clicks_try_here_button_in_queue_page() {
		PF_Queue_obj.tryhere();
	    
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test for Queue")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test_for_queue() {
		String title=PF_Queue_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@Given("The user is in the Queue page having an tryEditor with a Run button to test")
	public void the_user_is_in_the_queue_page_having_an_try_editor_with_a_run_button_to_test() {
		String title=PF_Queue_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@When("The user clicks on Run button after Entering valid python code in Queue tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_queue_try_editor() {
		PF_Queue_obj.runfunction();
	    
	}

	@Then("The user should be presented with Run output for Queue")
	public void the_user_should_be_presented_with_run_output_for_queue() {

		String validmsg=PF_Queue_obj.runMessage();
		System.out.println("Stack run result valid->"+validmsg);
	    
	}

	@When("The user clicks on Run button after Entering invalid python code in Queue tryEditor")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_queue_try_editor() {
		PF_Queue_obj.runfunction();
	    
	}

	@Then("The user should get the error message for Queue")
	public void the_user_should_get_the_error_message_for_queue() throws InterruptedException {
		String invalidmsg=PF_Queue_obj.alertmsgforInvalid();
		System.out.println("Stack invalid msg->"+invalidmsg);
	    
	}
	
}
