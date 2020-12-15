package pl.jsystems.szkolenie.szkolenieGui.classic.page.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.BasePage;

public class Comment extends BasePage {
    public Comment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

//    a[href="/me/notifications/comments"] .section-nav-tab__text

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement saveSettingsButton;

    @FindBy(css = ".notification-settings-form-stream:nth-child(2) ul li:nth-child(1) input")
    public WebElement likeRingCheckbox;
}
