package itstep.task_13;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;


public class SuiteListener implements ISuiteListener {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onStart(ISuite suite){
       // System.out.println(suite.getName()+" started");
        LOGGER.info(suite.getName()+" started");
    }

    @Override
    public void onFinish(ISuite suite){
       // System.out.println(suite.getName()+" finished");
        LOGGER.info(suite.getName()+" finished");

    }

}
