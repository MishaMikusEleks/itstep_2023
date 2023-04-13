package itstep.task_14;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static itstep.task_12.WebDriverSupplier.driver;

public class AllureListener implements ITestListener {

    private final Logger LOGGER = Logger.getLogger(this.getClass());
    //Add Allure to your framework
    //Attach screenshot and DOM to the report


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        LOGGER.info(result.getName()+" onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        LOGGER.info(result.getName()+" onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.error(result.getName()+" onTestFailure");
        makeScreenShoot();
    }

    @Attachment(value="Page screen", type="image/png")
    private byte[] makeScreenShoot(){
        LOGGER.error("makeScreenShoot");
        if(null!=driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}
        return new byte[0];
    }

}
