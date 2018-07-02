import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageTest {

    private WebDriver driver;
    private Page page;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get("https://github.com/");

        page = new Page(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = page.clickSignIn();
        String title = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", title);
    }

    @Test
    public void registerFailTest(){
        SignUp signUpPage = page.register("testUser", "testPass", "testEmail");
    String error = signUpPage.getMainErrorText();
      Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUp signUpPage = page.register("", "mail", "pass");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUp signUpPage = page.register("qeqwe", "qweq", "pass");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
