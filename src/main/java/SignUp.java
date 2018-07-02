import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {

   private WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class='setup-wrapper']//h1");
    private By userNameField = By.xpath(".//*[@id='user_login']");
    private By emailField = By.xpath(".//*[@id='user_email']");
    private By passwordField = By.xpath(".//*[@id='user_password']");
    private By signUpButton = By.xpath(".//*[@id='signup_button']");
    private By mainError = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/div");
    private By userNameError = By.xpath("//input[@id='user_login']/ancestor::dd/following-sibling::dd");
    private By emailError = By.xpath(".//*[@id='user_email']/ancestor::dd/following-sibling::dd");
    private By passwordError = By.xpath(".//*[@id='user_password']/ancestor::dd/following-sibling::dd");

    public SignUp typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUp typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUp typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUp registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUp(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText(){
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement(userNameError).getText();
    }

    public String getPasswrodErrorText(){
        return driver.findElement(passwordError).getText();
    }

    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }





}
