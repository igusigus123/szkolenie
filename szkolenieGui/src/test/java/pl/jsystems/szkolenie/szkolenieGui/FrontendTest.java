package pl.jsystems.szkolenie.szkolenieGui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.jsystems.szkolenie.szkolenieGui.classic.functional.LoginFunction;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.*;
import pl.jsystems.szkolenie.szkolenieGui.classic.page.modules.CommentModule;
import pl.jsystems.szkolenie.szkolenieGui.config.GuiConfig;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("frontend")
@DisplayName("Frontend test")
public class FrontendTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpBefore() {

    }

    @BeforeEach
    public void setUpEach() {
        try {
            System.setProperty("webdriver.chrome.driver", Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath());
            System.setProperty("webdriver.gecko.driver", Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath());
            // System.setProperty("webdriver.edge.driver", Paths.get(getClass().getClassLoader().getResource("driver/msedgedriver.exe").toURI()).toFile().getAbsolutePath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @Tag("login")
    @DisplayName("Login test")
    @Test
    public void loginTest() {
        driver.get(GuiConfig.BASE_URL);

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();
        MainUserPage mainUserPage = new MainUserPage(driver);
        String welcomeText = mainUserPage.welcomeText.getText();
        assertThat(welcomeText).isEqualTo("Witaj w Czytniku");
    }


    @DisplayName("Check user")
    @Test
    public void checkUser() {
        driver.get(GuiConfig.BASE_URL);

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();
        MainUserPage mainUserPage = new MainUserPage(driver);
        mainUserPage.avatar.click();

        UserProfilePage userProfilePage = new UserProfilePage(driver);
        String username = userProfilePage.userNamePanel.getText();

        assertThat(username).isEqualTo(GuiConfig.LOGIN);
    }

    @DisplayName("Check save button on user profile page")
    @Test
    public void saveButton() {
        driver.get(GuiConfig.BASE_URL);

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainUserPage mainUserPage = new MainUserPage(driver);
        mainUserPage.avatar.click();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserProfilePage userProfilePage = new UserProfilePage(driver);

        String s = userProfilePage.saveButton.getText();
        System.out.println(s);
        assertTrue(userProfilePage.saveButton.isDisplayed());
        assertFalse(userProfilePage.saveButton.isEnabled());
    }

    @DisplayName("Check selected element")
    @RepeatedTest(10)
    public void selectedElement() {
        driver.get(GuiConfig.BASE_URL);

        LoginFunction loginFunction = new LoginFunction(driver);
        loginFunction.login();
        MainUserPage mainUserPage = new MainUserPage(driver);
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        mainUserPage.avatar.click();
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        mainUserPage.waitForElementToBeClickable(mainUserPage.userAvatar);
        mainUserPage.userAvatar.click();

        UserProfilePage userProfilePage = new UserProfilePage(driver);
//        userProfilePage.notificationLabel.click();
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        int j = 0;
        boolean displayed = false;
        while (!displayed) {
            System.out.println("++++++++++" + j++);
            try {
                userProfilePage.notificationLabel.click();
                displayed = true;
            } catch (Exception e) {
                displayed = false;
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }
                mainUserPage.userAvatar.click();
            }
        }

        NotificationUserPage notificationUserPage = new NotificationUserPage(driver);
        notificationUserPage.getCommentsLabel().click();

        CommentModule commentModule = notificationUserPage.getCommentModule();


//        notificationUserPage.commentsLabel.click();
//        assertFalse(notificationUserPage.saveSettingsButton.isEnabled());
//        notificationUserPage.likeRingCheckbox.click();
//        assertThat(notificationUserPage.saveSettingsButton.isEnabled());
//        notificationUserPage.saveSettingsButton.click();

        int counter = 0;
        boolean selected = false;
        while (!selected & counter < 20) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (commentModule.likeRingCheckbox.isSelected()) {
                selected = true;
            } else {
                commentModule.likeRingCheckbox.click();
            }
            counter++;
        }

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        assertTrue(commentModule.likeRingCheckbox.isSelected());
        commentModule.likeRingCheckbox.click();

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        counter = 0;
        boolean selected2 = true;
        while (selected2 & counter < 20) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!commentModule.likeRingCheckbox.isSelected()) {
                selected2 = false;
            } else {
                commentModule.likeRingCheckbox.click();
            }
            counter++;
        }

        commentModule.saveSettingsButton.click();

        assertFalse(commentModule.likeRingCheckbox.isSelected());

        commentModule.likeRingCheckbox.click();

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        counter = 0;
        boolean selected3 = false;
        while (!selected3 & counter < 20) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (commentModule.likeRingCheckbox.isSelected()) {
                selected3 = true;
            } else {
                commentModule.likeRingCheckbox.click();
            }
            counter++;
        }

        if (commentModule.saveSettingsButton.isEnabled()) {
            commentModule.saveSettingsButton.click();
        }

        assertTrue(commentModule.likeRingCheckbox.isSelected());


    }

    @AfterEach
    public void tearDown() {
//        driver.quit();
    }
}
