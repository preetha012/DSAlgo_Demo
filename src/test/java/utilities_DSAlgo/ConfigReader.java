package utilities_DSAlgo;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigReader {
	private Properties prop;
	
	public Properties init_prop() {
		
		prop= new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:/Users/anoop/eclipse-workspaceNew/DS_AlgoProjectNew/src/test/resources/config/config.properties");
				prop.load(ip);
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return prop;
		}
	


}
