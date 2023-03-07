package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement ilkloginbutonu;



    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTexBox;


    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTexBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement ikinciloginButonu;

    @FindBy(id = "dropdown-basic-button")
    public WebElement kullanıcıProfilİsmi;


}
