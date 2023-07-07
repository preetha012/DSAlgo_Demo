package stepdefinition_DSAlgo;

//import org.testng.Assert;
import org.junit.Assert;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_Tree;

public class Tree_step {
	
	private PF_Tree PF_Tree_obj= new PF_Tree(DriverFactory.getDriver());

	@When("The user select Tree item from the drop down menu")
	public void the_user_select_tree_item_from_the_drop_down_menu() {
	   
		PF_Tree_obj.startTree();
	}

	@Given("The user is on the Tree page after logged in")
	public void the_user_is_on_the_tree_page_after_logged_in() {
	   DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/tree/");
	    
	}

	@When("The user clicks on the {string} link for Tree")
	public void the_user_clicks_on_the_link_for_tree(String string) {
		if(string.equalsIgnoreCase("Overview of Trees")) {
			PF_Tree_obj.Tree_Overview();
	    }else if(string.equalsIgnoreCase("Terminologies")) {
	    	PF_Tree_obj.Tree_Terminology(); 	
	    }else if(string.equalsIgnoreCase("Types of Trees")) {
	    	PF_Tree_obj.Tree_Types();
	    }
	    
	}

	@Given("The user is on the {string} after logged in for Tree")
	public void the_user_is_on_the_after_logged_in_for_tree(String string) {
		String title=PF_Tree_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@When("The user clicks Try Here button in Tree page")
	public void the_user_clicks_try_here_button_in_tree_page() {
		PF_Tree_obj.tryhere();
	    
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test for Tree")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test_for_tree() {
	   
		String title=PF_Tree_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	}

	@Given("The user is in the Tree page having an tryEditor with a Run button to test")
	public void the_user_is_in_the_tree_page_having_an_try_editor_with_a_run_button_to_test() {
	   
		String title=PF_Tree_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	}

	@When("The user clicks on Run button after Entering valid python code in Tree tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_tree_try_editor() {
		PF_Tree_obj.runfunction();
	    
	}

	@Then("The user should be presented with Run output for Tree")
	public void the_user_should_be_presented_with_run_output_for_tree() {
	   
		String msg=PF_Tree_obj.runMessage();
		System.out.println("Tree Run result->"+msg);
	}

	@When("The user clicks on Run button after Entering invalid python code in Tree tryEditor")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_tree_try_editor() {
		PF_Tree_obj.runfunction();
	    
	}

	@Then("The user should get the error message for Tree")
	public void the_user_should_get_the_error_message_for_tree() throws InterruptedException {
		String alertmsg=PF_Tree_obj.alertmsgforInvalid();
		System.out.println("Tree Run invalid result->"+alertmsg);
	    
	}
}
