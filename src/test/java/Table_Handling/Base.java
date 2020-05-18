package Table_Handling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	 public String max;
   public double m=0,r=0;

	Properties config = new Properties();
	Properties loca = new Properties();

	public static WebDriver driver;
	FileInputStream fis;
//C:\Automation Scripts\WebTableHandling\src\test\resources\Properties\Config.properties
	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
			config.load(fis);
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Loca.properties");
			loca.load(fis);
			if (config.get("Browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\geckodriver.exe");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability("marionette", true);
				driver = new FirefoxDriver();
			} else {
				if (config.getProperty("Browser").equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
					driver = new ChromeDriver();
				}//System.out.println("user.dir")
			}
			driver.get(config.getProperty("Url"));
		}
	}
	/*
	 * @AfterSuite public void tearDown() { driver.quit(); }
	 */
}
