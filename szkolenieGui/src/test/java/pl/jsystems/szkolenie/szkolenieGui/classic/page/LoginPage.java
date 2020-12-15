package pl.jsystems.szkolenie.szkolenieGui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "usernameOrEmail")
    public WebElement loginInput;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement logginButton;

    public static final String password = "password";

    @FindBy(id = password)
    public WebElement passwordInput;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement passwordButton;
}
