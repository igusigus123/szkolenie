package pl.jsystems.szkolenie.szkolenieGui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainUserPage extends BasePage{
    public MainUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "empty-content__title")
    public WebElement welcomeText;

    @FindBy(css = "span[class=masterbar__item-content] .gravatar")
    public WebElement avatar;



}
