package itstep.task_11.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isOpen() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.id("signInModalLabel")).isDisplayed();
    }

    public SignUpPage inputLogin(String login) throws InterruptedException {
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(login);
        return this;
    }

    public SignUpPage inputPass(String pass) {
        driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(pass);
        return this;
    }

    public SignUpPage signUp() {
        driver.findElement(By.xpath("//button[text()=\"Sign up\"]")).click();
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
}
