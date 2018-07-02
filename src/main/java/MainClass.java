import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    private static WebDriver driver;
    public static void main(String[] args) {

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://github.com/");

    Page mainPage = new Page(driver);
    mainPage.register("asdasdda", "adadasd", "asddds");



    }
}
