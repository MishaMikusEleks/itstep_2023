package itstep_test.task_24;

import itstep.task_14.AllureListener;
import itstep.task_17.TrelloBO;
import itstep.task_17.model.CreateBoardRequest;
import itstep.task_17.model.CreateBoardResponse;
import itstep.task_17.model.DeleteRequest;
import itstep.task_17.model.TrelloBoard;
import itstep.task_24.bo.CalcBO;
import org.sikuli.script.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

@Listeners({AllureListener.class})
public class TrelloAPITest {



    @Test
    void calcTest() throws FindFailed {
        CalcBO calcBO= new CalcBO();
        calcBO.openCalcApp()
                .type123()
                .clickC()
                .checkEmptyInput();
    }
}
