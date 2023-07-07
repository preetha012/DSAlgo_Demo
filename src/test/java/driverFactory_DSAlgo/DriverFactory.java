package driverFactory_DSAlgo;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities_DSAlgo.ConfigReader;
import utilities_DSAlgo.Loggerload;

public class DriverFactory {

	private static WebDriver driver=null;
	private static ConfigReader configReader_obj = new ConfigReader();
	
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static void init_driver() {		
	
			Properties prop;
			prop= configReader_obj.init_prop();
			String browserName= prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				System.out.print("reached chrome");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				////tlDriver.set(new ChromeDriver());			
			}
			else if(browserName.equals("firefox")) {
				System.out.print("reached firefox");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				//tlDriver.set(new FirefoxDriver());
			}else {
				Loggerload.warn("******Browser name not Passed*****");
			}	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	public static synchronized WebDriver getDriver() {
		if (driver==null){
			Loggerload.warn("*******Driver is null*****");
			init_driver();
		}
		return driver;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
		
