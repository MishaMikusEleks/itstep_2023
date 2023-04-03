package itstep.task_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.id("signInModalLabel")).isDisplayed();
    }

    public LoginPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);
        //2.2 input login
        //loginusername

        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String pass) {
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys(pass);
        return this;
    }

    public LoginPage login() {
        driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
        return this;
    }

    public HomePage checkAndAcceptAlert() throws InterruptedException {
        Thread.sleep(1000);

        //1.3 check message
        Assert.assertEquals(driver.switchTo().alert().getText(),"Sign up successful."
                , "unexpected message");


        //1.4 click "ok" in message
        driver.switchTo().alert().accept();
        return new HomePage(driver);
    }

    public String loginLabel() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(By.id("nameofuser")).getText();
    }
}
