package itstep_test.task_12;

import itstep.task_12.bo.DemoblazeBO;
import itstep.task_12.WebDriverSupplier;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpLoginTest {

    //General task
    //Implement PageFactory for a few pages.
    //Implement Wrapper for common WebElements (Input, Button, Select).
    //Implement methods for basic web elements with console logging.


    @BeforeTest
    void setup(){
        WebDriverSupplier.setupDriver();
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

        DemoblazeBO demoblazeBO=new DemoblazeBO();

        demoblazeBO
                .checkSignUpRandomUser()
                .checkLoginUser();

    }


    @AfterTest
    void closeBrowser(){
        WebDriverSupplier.closeDriver();
    }
}
