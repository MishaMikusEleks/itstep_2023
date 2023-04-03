package itstep.task_12.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static itstep.task_12.WebDriverSupplier.driver;

public class SignUpPage {

    @FindBy(id="signInModalLabel")
    private WebElement signInModalLabel;

    @FindBy(xpath="//*[@id=\"sign-username\"]")
    private WebElement usernameInput;

    @FindBy(xpath="//*[@id=\"sign-password\"]")
    private WebElement passInput;

    @FindBy(xpath="//button[text()=\"Sign up\"]")
    private WebElement signupButton;

    public SignUpPage() {
        PageFactory.initElements(driver,this);
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return signInModalLabel.isDisplayed();
    }

    public SignUpPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);
       usernameInput.sendKeys(login);
        return this;
    }

    public SignUpPage inputPass(String pass) {
        passInput.sendKeys(pass);
        return this;
    }

    public SignUpPage signUp() {
        signupButton.click();
        return this;
    }

    public HomePage checkAndAcceptAlert() throws InterruptedException {
        Thread.sleep(1000);

        //1.3 check message
        Assert.assertEquals(driver.switchTo().alert().getText(),"Sign up successful."
                , "unexpected message");


        //1.4 click "ok" in message
        driver.switchTo().alert().accept();
        return new HomePage();
    }
}
