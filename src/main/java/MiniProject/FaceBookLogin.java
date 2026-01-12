package MiniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLogin {           //for runing testing.xml 

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")   // to pass name of the parameter to test method
    public void setup(String browser) {   // parameter passed

    	if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

//        } else if (browser.equalsIgnoreCase("opera")) {
//
//            WebDriverManager.operadriver().setup();
//            driver = new OperaDriver();

        } else if (browser.equalsIgnoreCase("safari")) {

        	  WebDriverManager.safaridriver().setup();
            driver = new SafariDriver(); 

        } else {

            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
    }


    @Test
    public void login() {

    	  WebElement phn = driver.findElement(By.xpath("//*[@title='Search']"));    
          phn.sendKeys("laptop"); 
          WebElement lap = driver.findElement(By.xpath("//*[text()='Search']"));   
          lap.submit();
    }
}
