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

}
