package pl.jsystems.szkolenie.szkolenieGui.classic.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.modules.CommentModule;

public class NotificationUserPage extends BasePage {
    public NotificationUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href='/me/notifications/comments']")
    public WebElement commentsLabel;

    public CommentModule commentModule;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement saveSettingsButton;

    @FindBy(css = ".notification-settings-form-stream:nth-child(2) ul li:nth-child(1) input")
    public WebElement likeRingCheckbox;

    public WebElement getCommentsLabel() {
        if (commentModule == null) {
            commentModule = new CommentModule(driver);
        }
        return commentsLabel;
    }

    public CommentModule getCommentModule() {
        return commentModule;
    }
}
