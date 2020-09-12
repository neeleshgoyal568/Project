package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver launchBrowser(String browserName, String baseUrl) {
		if(browserName.equalsIgnoreCase("chrome")) {
			/*System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");*/
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("Chrome Browser Launch", true);
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("Firefox Browser Launch", true);
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.ie.driver", "./exe/geckodriver.exe");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			Reporter.log("IE Browser Launch", true);
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			Reporter.log("Edge Browser Launch", true);
		}
			
		return driver;
	}
}

