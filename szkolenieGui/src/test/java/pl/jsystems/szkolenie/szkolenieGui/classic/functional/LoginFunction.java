package pl.jsystems.szkolenie.szkolenieGui.classic.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.LoginPage;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.MainWordpressPage;
import pl.jsystems.szkolenie.szkolenieGui.config.GuiConfig;

import static java.lang.Thread.sleep;

public class LoginFunction {
    private WebDriver driver;

    public LoginFunction(WebDriver driver) {
        this.driver = driver;
    }

    public void login(){
        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);
        mainWordpressPage.waitForVisibilityOfElement(mainWordpressPage.loginButton, 15);
        mainWordpressPage.loginButton.click();

        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(By.id("usernameOrEmail")).click();
        WebElement login = loginPage.loginInput;
        login.sendKeys(GuiConfig.LOGIN);
        String getUserName = login.getAttribute("value");
        System.out.println(getUserName);

        loginPage.logginButton.click();

//        loginPage.waitForVisibilityOfElement(By.id(loginPage.password), 15);
        loginPage.waitForVisibilityOfElement(loginPage.loginInput, 15);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(GuiConfig.PASSWORD);
        loginPage.passwordButton.click();
    }
}
