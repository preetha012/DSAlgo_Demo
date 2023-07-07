package stepdefinition_DSAlgo;


import io.cucumber.java.en.*;
import pageObjects_DSAlgo.PF_HomePage;
import utilities_DSAlgo.Loggerload;

//import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

import driverFactory_DSAlgo.DriverFactory;

//import org.junit.Assert;

public class HomePage_step {

		private PF_HomePage PF_HomePage_obj = new PF_HomePage(DriverFactory.getDriver());
		private static String DS_errormsg;
		
		@Given("The user opens DS Algo portal link")
		public void the_user_opens_ds_algo_portal_link() {
			DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com");
		}
		
		@When("The user clicks the Get Started button")
		public void the_user_clicks_the_GetStarted_button() {	
				PF_HomePage_obj.to_home_getstart();	
				Loggerload.info("******************* Launching Home Page******************");
		}
		
		@Then("The user should be redirected to homepage")
		public void the_user_should_be_redirected_to_homepage() {
			String title=PF_HomePage_obj.getHomePageTitle();
			assertEquals(title, "NumpyNinja");
			
		}
		
		@Given("The user is on Home page")
		public void the_user_is_on_home_page() {
			DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/home");
			String title=PF_HomePage_obj.getHomePageTitle();
			assertEquals(title, "NumpyNinja");
			
		}
		@When("The user clicks the Sign in button")
		public void the_user_clicks_the_Sign_in_button() {
			PF_HomePage_obj.SignFunction();	
		}
		@Then("The user should be redirected to Sign in page")
		public void the_user_should_be_redirected_to_sign_in_page() {
			
			String title=PF_HomePage_obj.getHomePageTitle();
			assertEquals(title, "Login");
			
		}
		@When("The user clicks the Register button")
		public void the_user_clicks_the_Register_button() {
			PF_HomePage_obj.RegisterFunction();	
		}
		@Then("The user should be redirected to Register form")
		public void the_user_should_be_redirected_to_register_form() {
			String title=PF_HomePage_obj.getHomePageTitle();
			assertEquals(title, "Registration");
		
		}	
		@When("The user clicks on Get Started link on homepage {string} without login")
		public void the_user_clicks_on_get_started_link_on_homepage_without_login(String string) throws InterruptedException {
			 DS_errormsg=PF_HomePage_obj.DS_GetstartwithoutLogin(string);
			 System.out.println("GetStart withoutLogin->"+DS_errormsg);
			
		}
		
		@Then("The user get warning message {string}")
		public void the_user_get_warning_message(String string) {
			System.out.println(string);
		}
		

		@When("The user clicks on dropdown {string} without login")
		public void the_user_clicks_on_dropdown_without_login(String dropdownItem) throws InterruptedException {
			 DS_errormsg=PF_HomePage_obj.dropdown_withoutLogin(dropdownItem);
			 System.out.println("Dropdown withoutLogin->"+DS_errormsg);
					
		}

}