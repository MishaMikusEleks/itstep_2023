package itstep.task_13;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;


public class SuiteListener implements ISuiteListener, IExecutionListener {

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

    @Override
    public void onExecutionStart(){
        // System.out.println(suite.getName()+" finished");
        LOGGER.info("start");

    }

}
