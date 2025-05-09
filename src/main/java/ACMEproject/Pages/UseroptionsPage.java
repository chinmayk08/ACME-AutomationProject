package ACMEproject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UseroptionsPage {

    WebDriver wd;

    public UseroptionsPage(WebDriver wd){
        this.wd=wd;
        PageFactory.initElements(this.wd, this);
    }

    @FindBy(xpath = "(//button[@class='btn btn-default btn-lg dropdown-toggle'])[1]")
    public static WebElement UserOptionMenu; //user option button

    @FindBy(xpath = "//a[text()='Download Client and Support']")
    public static WebElement DownloadClientandSupportMenu;

    @FindBy(xpath = "//h1[@class='page-header']")
    public static WebElement pageHeader; // login dashboard header



}
