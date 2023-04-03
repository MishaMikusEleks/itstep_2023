package itstep.task_12.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static itstep.task_12.WebDriverSupplier.driver;

public class LoginPage {

    //driver.findElement(By.xpath("//*[@id=\"loginusername\"]"))
    @FindBy(xpath="//*[@id='loginusername']")
    private WebElement loginusernameInput;

    //driver.findElement(By.xpath("//*[@id=\"loginpassword\"]"))
    @FindBy(xpath="//*[@id='loginpassword']")
    private WebElement loginpasswordInput;

    //driver.findElement(By.xpath("//button[text()=\"Log in\"]"))
    @FindBy(xpath="//button[text()='Log in']")
    private WebElement loginButton;

    //driver.findElement(By.id("nameofuser"))
    @FindBy(id="nameofuser")
    private WebElement loginLabel;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public LoginPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);
        //2.2 input login
        //loginusername

        loginusernameInput.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        loginpasswordInput.sendKeys(pass);
        return this;
    }

    public LoginPage login() {
        loginButton.click();
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

    public String loginLabel() throws InterruptedException {
        Thread.sleep(3000);
        return loginLabel.getText();
    }
}
