package org.thiki.kanban.web.test.welcome;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.thiki.kanban.web.test.DriverFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by xubt on 23/11/2016.
 */
public class WelcomeSpec {
    private final WebDriver driver;

    public WelcomeSpec() {
        this.driver = DriverFactory.getDriver();
    }

    @Step("加载首页")
    public void loadWelcomePage() {
        driver.get(WelcomePage.getUrl());
    }

    @Step("检查首页标题")
    public void checkPageTitle() {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "思奇精益看板-以乐趣创造乐趣");
    }

    @Step("打开登录窗口")
    public void openLoginModal() {
        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        welcomePage.openLoginModal();
        welcomePage.verifyLoginFormRepresented(driver);
    }
}
