package stepdefinition_DSAlgo;

//import org.testng.Assert;
import org.junit.Assert;

import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_Graph;

public class Graph_step {
	
	private PF_Graph PF_Graph_obj= new PF_Graph(DriverFactory.getDriver());

	
	@When("The user select Graph item from the drop down menu")
	public void the_user_select_graph_item_from_the_drop_down_menu() {
		PF_Graph_obj.startGraph();
	    
	}

	@Given("The user is on the Graph page after logged in")
	public void the_user_is_on_the_graph_page_after_logged_in() {
		 DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/graph/");
	    
	}

	@When("The user clicks on the {string} link for Graph")
	public void the_user_clicks_on_the_link_for_graph(String string) {
		if(string.equalsIgnoreCase("Graph")) {
			PF_Graph_obj.Graph_Link();
	    }else if(string.equalsIgnoreCase("Graph Representations")) {
	    	PF_Graph_obj.Graph_Representn(); 	
	    }
	    
	}

	@Given("The user is on the {string} after logged in for Graph")
	public void the_user_is_on_the_after_logged_in_for_graph(String string) {
		String title=PF_Graph_obj.getPageTitle();
		Assert.assertEquals(title,string);
	    
	}

	@When("The user clicks Try Here button in Graph page")
	public void the_user_clicks_try_here_button_in_graph_page() {
		PF_Graph_obj.tryhere();
	    
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test for Graph")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test_for_graph() {
		String title=PF_Graph_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	    
	}

	@Given("The user is in the Graph page having an tryEditor with a Run button to test")
	public void the_user_is_in_the_graph_page_having_an_try_editor_with_a_run_button_to_test() {
	    
		String title=PF_Graph_obj.getPageTitle();
		Assert.assertEquals(title,"Assessment");
	}

	@When("The user clicks on Run button after Entering valid python code in Graph tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_graph_try_editor() {
	    
		PF_Graph_obj.runfunction();
	}

	@Then("The user should be presented with Run output for Graph")
	public void the_user_should_be_presented_with_run_output_for_graph() {
		String msg=PF_Graph_obj.runMessage();
	    System.out.println("Graph Run Result->"+msg);
	}

	@When("The user clicks on Run button after Entering invalid python code in Graph tryEditor")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_graph_try_editor() {
		PF_Graph_obj.runfunction();
	    
	}

	@Then("The user should get the error message for Graph")
	public void the_user_should_get_the_error_message_for_graph() throws InterruptedException {
		String alertmsg=PF_Graph_obj.alertmsgforInvalid();
		System.out.println("Graph invalid Result->"+alertmsg);
	    
	}


}
