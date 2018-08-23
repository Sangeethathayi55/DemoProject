package generic;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(FWListener.class) 
public class BaseTest implements IAutoConst {

	public WebDriver driver;
	public String strURL;
	public long lngITO;
	public Logger log = Logger.getLogger(this.getClass());

	@BeforeSuite
	public void initFrameWork() {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);

	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void openApp(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			log.info("opening Chrome Browser");
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
			log.info("Opening Firefox Browser");
		}

		driver = new ChromeDriver();
		log.info("opening Chome Browser");
		strURL = AutoUtility.getPropertyValue(CONFIG_PATH, "URL");
		driver.get(strURL);
		log.info("Enter the url:" + strURL);
		String sITO = AutoUtility.getPropertyValue(CONFIG_PATH, "ITO");
		log.info("Set ImplicitWait" + sITO);
		lngITO = Integer.parseInt(sITO);
		log.info("Set ImplicitWait:" + lngITO);
		lngITO = Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(lngITO, TimeUnit.SECONDS);
		

	}

	@AfterMethod
	public void closeAPP() {
		driver.close();
		log.info("close the Browser");

	}
}
