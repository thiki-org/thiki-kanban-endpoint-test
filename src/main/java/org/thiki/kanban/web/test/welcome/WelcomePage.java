package org.thiki.kanban.web.test.welcome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.thiki.kanban.web.test.BasePage;
import org.thiki.kanban.web.test.util.PropertiesUtil;

public class WelcomePage extends BasePage {
    @FindBy(id = "login-button")
    public WebElement loginButton;

    public void openLoginModal() {
        loginButton.click();
    }

    public void verifyLoginFormRepresented(WebDriver driver) {
        WebElement loginForm = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("login-form")));
        loginForm.isDisplayed();
    }

    public static String getUrl() {
        return PropertiesUtil.loadPropByName("welcomePage");
    }
}
