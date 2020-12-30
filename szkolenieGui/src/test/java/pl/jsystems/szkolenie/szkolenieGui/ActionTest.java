package pl.jsystems.szkolenie.szkolenieGui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.MainWordpressPage;
import pl.jsystems.szkolenie.szkolenieGui.config.GuiConfig;

@Tag("Frontend")
@Tags({@Tag("Frontend"), @Tag("ActionTest")})
public class ActionTest extends ConfigFrontEnd {
    @DisplayName("Simple action")
    @Test
    public void actionTest() {
        driver.navigate().to(GuiConfig.BASE_URL);

        MainWordpressPage mainWordpressPage = new MainWordpressPage(driver);

        Actions action = new Actions(driver);

        action.moveToElement(mainWordpressPage.picture)
                .clickAndHold()
                .moveToElement(mainWordpressPage.startYourWebsite)
                .release();
        action.build().perform();

        action.moveToElement(mainWordpressPage.loginButton)
                .click();
        action.build().perform();
    }

    @DisplayName("Keys short")
    @Test
    public void kaysInteraction() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.CONTROL, "R")).perform();
        action.sendKeys(Keys.chord(Keys.ESCAPE)).perform();
        action.sendKeys(Keys.chord(Keys.ENTER)).perform();

    }
}
