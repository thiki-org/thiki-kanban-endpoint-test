package org.thiki.kanban.web.test;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    private static final String CHROME = "chrome";
    private static final String IE = "ie";
    private static final String DEFAULT = "chrome";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void Setup() {
        String browser = System.getenv("BROWSER");
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(CHROME)) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals(IE)) {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
        driver.quit();
    }
}
