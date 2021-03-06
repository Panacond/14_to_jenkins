import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageFactory.BucketPage;
import pageFactory.SearchPage;
import pageFactory.StartPage;
import support.PropertiesReader;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class BaseTest {
    protected static WebDriver driver;
    PropertiesReader properties = new PropertiesReader();

    @BeforeTest
    public void profileSetUp(){chromedriver().setup();}

    @BeforeMethod
    public void testSetUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","--no-gpu");
        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getUrl());
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

    public WebDriver getDriver(){return driver;}

    public StartPage getStartPage(){return new StartPage(getDriver());}

    @Step("Go to next page")
    public SearchPage getSearchPage(){return new SearchPage(getDriver());}

    @Step("Open bucket page")
    public BucketPage getBucketPage(){return new BucketPage(getDriver());}
}
