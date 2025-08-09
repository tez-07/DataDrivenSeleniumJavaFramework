package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public Properties prop;
	
	public WebDriver openBrowserandApplicationURL(String browserName) {
		
		prop = new Properties();
		File propfile = new File("src\\test\\resources\\data.properties");
		
		try {
			FileInputStream fl = new FileInputStream(propfile);
			prop.load(fl);
		}catch(Throwable e) {		//Throwable can handle any kind of error
			e.printStackTrace();
		}
		
		
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));		//providing the key(not hard coded)
		
		return driver;
	}
}
