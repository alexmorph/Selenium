import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

    private WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    private By signButton = By.xpath("//a[text()='Sign in']");
    private By signUpButton = By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[2]");
    private By userNameField = By.xpath("//*[@id=\"user[login]\"]");
    private By emailField = By.xpath("//*[@id=\"user[email]\"]");
    private By passwordField = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpForButton = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button");

    public LoginPage clickSignIn(){
        driver.findElement(signButton).click();
        return new LoginPage(driver);
    }

    public SignUp clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUp(driver);
    }

    public SignUp clickSignUpFor(){
        driver.findElement(signUpForButton).click();
        return new SignUp(driver);
    }

    public Page typeUserName (String userName){
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public Page typeEmail (String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public Page typeUserPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUp register (String userName, String email, String password){
    this.typeUserName(userName);
    this.typeEmail(email);
    this.typeUserPassword(password);
    this.clickSignUpFor();
    return new SignUp(driver);
    }



}
