package itstep_test.task_13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import itstep.task_12.WebDriverSupplier;
import itstep.task_12.bo.DemoblazeBO;
import itstep.task_13.SuiteListener;
import itstep.task_13.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteListener.class,
        TestListener.class,
        UniversalVideoListener.class})
public class SignUpLoginListenerTest {

    //Implement custom Test and Test Suite Listeners
    //Add logging for all overridden listener methods
    //Add video recorder for onFail action

    @BeforeTest
    void setup(){
        WebDriverSupplier.setupDriver();
    }

    @Video
    @Test
    void endToEndTest() throws InterruptedException {

        DemoblazeBO demoblazeBO=new DemoblazeBO();

        demoblazeBO
                .checkSignUpRandomUser()
                .checkLoginUser();

    }

    @Video
    @Test
    void endToEndFailTest() throws InterruptedException {
        DemoblazeBO demoblazeBO=new DemoblazeBO();

        demoblazeBO
                .checkSignUpRandomUser()
                .checkLoginUser()
                .failTest();

    }

    @AfterTest
    void closeBrowser(){
        WebDriverSupplier.closeDriver();
    }
}
