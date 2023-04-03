package itstep_test.task_11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import itstep.task_11.bo.DemoblazeBO;
import itstep.task_11.po.HomePage;
import itstep.task_11.po.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

public class EndToEndTest {

    //General task
    //Make up one simple UI end-to-end test case for your test page from Task_10.
    //Automate that scenario using WebDriver
    //Create PageObject for all pages used in scenario

    private WebDriver driver;

    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

    }

    @Test
    void endToEndTest() throws InterruptedException {

        //target https://www.demoblaze.com/
        //1. sign up
        //1.1 verify sign up page open
        //1.2  sign up
        //1.3 check message
        //1.4 click "ok" in message
        //2. login
        //2.2 input login
        //2.1 verify logged in

        DemoblazeBO demoblazeBO=new DemoblazeBO(driver);

        demoblazeBO
                .checkSignUpRandomUser()
                .checkLoginUser();

    }


    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
