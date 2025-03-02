package ACMEproject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver wd;

    public LoginPage(WebDriver wd){
        this.wd=wd;
        PageFactory.initElements(this.wd,this);
    }
    @FindBy(xpath = "//input[@id='email']")
    public static WebElement Email;  //Email text box

    @FindBy(xpath = "//input[@id='password']")
    public WebElement Password;  // password text box

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement Loginbtn;  //Login button


    @FindBy(xpath = "//h1[@class='page-header']")
    public static WebElement loginHeader; // login dashboard header

    @FindBy(xpath = "//a[text()='Log Out']")
    public static WebElement LogOut;  //logout button

    @FindBy(xpath = "(//a[@class='btn bg-warning'])[2]")
    public WebElement register; // Register email and pass page button

    @FindBy(xpath = "//input[@id='password-confirm']")
    public WebElement retypePassword; //confirm password text box

    @FindBy(xpath = "//input[@class='form-check-input']")
    public WebElement AgreetermsCheckbox;  //terms and condition accept check box

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement CaptchaCheckbox; //I am not robot captcha check box

    @FindBy(xpath = "//h1[starts-with(text(),'Welcome,')]")
    public static WebElement RegisterHeader; //chack header after register email(header text)

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public static WebElement Registerbtn; // registration save button

    @FindBy(xpath = "//a[text()='Log In']")
    public static WebElement LogIn;  // Login button

    @FindBy(xpath = "(//button[@class='btn btn-default btn-lg dropdown-toggle'])[1]")
    public static WebElement UserOptionMenu; //user option button

    @FindBy(xpath = "//a[text()='Download Client and Support']")
    public static WebElement DownloadClientandSupportMenu;









}
