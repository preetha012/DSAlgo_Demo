package hooks_DSAlgo;


//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import java.util.Properties;
//import java.io.ByteArrayInputStream;
//import org.testng.annotations.BeforeSuite;
//import org.openqa.selenium.TakesScreenshot;
//import io.cucumber.java.Scenario;
//import io.qameta.allure.Allure;
//import utilities_DS_Algo.ConfigReader;
//import org.openqa.selenium.OutputType;
import io.cucumber.java.BeforeAll;
import driverFactory_DSAlgo.DriverFactory;
import io.cucumber.java.AfterAll;

	public class Hooks {
	
		//private static WebDriver driver;

		@BeforeAll(order=0)
		public static void initialize_driver() {
			//driver= DriverFactory.getDriver();
			DriverFactory.getDriver();	
		}	
		
		@AfterAll
		public static void CloseBrowser() {
			DriverFactory.tearDown();
		}

	}