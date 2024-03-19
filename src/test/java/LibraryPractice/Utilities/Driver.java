package LibraryPractice.Utilities;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver() {

    }

    //We make WebDriver private, because we want to close access from outside the class.
    //We are making it static, because we will use it in a static mehtod.
    private static WebDriver driver;// default value=null

    //Create a re=usable utility method which will return the same driver instance once we call it.
    //If an instance doesn't exist, it will create first, and than it will always return same instance.
    public static WebDriver getDriver() {
        if (driver == null) {





            String browserType= ConfigurationReader.getProperty("browser");
            browserType=browserType.trim().toLowerCase();

            //Depending on the browserType returned from the configuration.properties
            //Switch statement will determine the "case" and open the matching browser.
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--remote-allow-origins=");
                    driver=new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }

        }
        return driver;






    }

    public static void closeDriver(){
        if(driver!=null){


            driver.quit();
            driver = null;
        }
    }
}


