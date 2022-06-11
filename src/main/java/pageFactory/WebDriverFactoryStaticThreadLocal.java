package pageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactoryStaticThreadLocal {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static  void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void closeBrowser()
    {
        driver.get().close();
        driver.remove();
    }
}
