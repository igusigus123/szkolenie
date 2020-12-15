package pl.jsystems.szkolenie.szkolenieGui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage{
    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

   @FindBy(css = ".x-nav-item.x-nav-item--wide a[title='Log In']")
   public WebElement loginButton;

    @FindBy(css = "#lpc-picture\\.3 > div")
    public WebElement picture;

    @FindBy(id = "lpc-button")
    public WebElement startYourWebsite;
}
