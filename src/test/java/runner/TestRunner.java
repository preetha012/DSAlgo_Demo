package runner;


//import org.testng.annotations.DataProvider;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//import com.cucumber.listener.Reporter;
//import managers.FileReaderManager;
//import org.junit.AfterClass;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) //Junit execution


@CucumberOptions(
		plugin = {"pretty", "html:target/DSAlgoCucumber.html",
				"json:target/cucumber.json",
				//"junit:target/cucumber-reports/Cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				},
		monochrome=true,  //console output color	
		features = {"src/test/resources/features"}, //location of feature files
		glue= {"stepdefinition_DSAlgo","hooks_DSAlgo"},//location of step definition files
		//tags =  "@reg ")  //tags from feature file
			tags= "@Link")

public class TestRunner 
	//extends AbstractTestNGCucumberTests
	{
			
	/*@AfterClass
	public static void writeExtentReport() {
		// Reporter.loadXMLConfig(new File("config/extent-config.xml"));
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}*/
	
	
	//@Override
    //@DataProvider(parallel = false)
    //public Object[][] scenarios() {
				
		//return super.scenarios();
		
   // }

}
