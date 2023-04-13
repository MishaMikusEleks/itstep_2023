package itstep_test.task_14;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import itstep.task_12.WebDriverSupplier;
import itstep.task_12.bo.DemoblazeBO;
import itstep.task_13.SuiteListener;
import itstep.task_13.TestListener;
import itstep.task_14.AllureListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class SignUpLoginAllureTest {

    @BeforeTest
    void setup(){
        WebDriverSupplier.setupDriver();
    }

    @Test
    void endToEndTest() throws InterruptedException {

        DemoblazeBO demoblazeBO=new DemoblazeBO();

        demoblazeBO
                .checkSignUpRandomUser()
                .checkLoginUser();

    }

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
