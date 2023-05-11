package itstep.task_24.po;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.testng.Assert;

import static itstep.task_24.bo.CalcBO.makePattern;
import static itstep.task_24.bo.CalcBO.screen;

public class MacPO {
    public MacPO clickLaunchpadIcon() throws FindFailed {
        Pattern launchpadIcon =makePattern("launchpad_icon");
        screen.find(launchpadIcon).click();
        return this;
    }

    public MacPO clickSearchInput() throws FindFailed {
        Pattern searchInput =makePattern("search_input");
        screen.wait(searchInput,3000L).click();
        return this;
    }

    public void clickCalcIcon() throws FindFailed {
        Pattern calcIcon =makePattern("calc_icon")
               // .similar(0.7)
                ;
        Match calcIconMatch= screen.wait(calcIcon,3L);
        Assert.assertTrue(calcIconMatch.isValid());
        calcIconMatch.click();
    }
}
