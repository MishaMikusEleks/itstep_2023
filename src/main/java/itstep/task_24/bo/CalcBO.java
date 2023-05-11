package itstep.task_24.bo;

import itstep.task_24.po.CalcPO;
import itstep.task_24.po.MacPO;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import java.io.File;

public class CalcBO {

   public static  Screen screen =new Screen();
   MacPO macPO=new MacPO();
    CalcPO calcPO=new CalcPO();
    public CalcBO() {
        screen.setAutoWaitTimeout(1);
    }

    public CalcBO openCalcApp() throws FindFailed {
        macPO.clickLaunchpadIcon().
        clickSearchInput();

        screen.type("calc");

        macPO.clickCalcIcon();

        Assert.assertTrue(calcPO.isOpened());
        return this;
    }

    public static Pattern makePattern(String fileName) {
        return new Pattern(new File("src/test/resources/pattern_calc/"+fileName+".png").getAbsolutePath());
    }

    public CalcBO type123() throws FindFailed {
        calcPO.clickButton("1").clickButton("2").clickButton("3");
        Assert.assertTrue(calcPO.input123Visible());
        return this;
    }

    public CalcBO clickC() throws FindFailed {
        calcPO.clickButton("C");
        return this;
    }

    public void checkEmptyInput() throws FindFailed {
        Assert.assertTrue(calcPO.emptyInputIsVisible());
    }
}
