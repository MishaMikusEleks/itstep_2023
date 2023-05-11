package itstep.task_24.po;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

import static itstep.task_24.bo.CalcBO.makePattern;
import static itstep.task_24.bo.CalcBO.screen;

public class CalcPO {
    public boolean isOpened() throws FindFailed {
        //verify calc is opened
        Pattern calcWindow =makePattern("calc_window").similar(0.95);
        return screen.wait(calcWindow,3L).isValid();
    }

    public CalcPO clickButton(String number) throws FindFailed {
        Pattern digitButton =makePattern(number+"_button").similar(0.95);
         screen.find(digitButton).click();
        return this;
    }

    public boolean input123Visible() throws FindFailed {
        Pattern input_value =makePattern("123_input_value").similar(0.95);
        return screen.wait(input_value,3L).isValid();
    }

    public boolean emptyInputIsVisible() throws FindFailed {
        Pattern input =makePattern("empty_input").similar(0.95);
        return screen.wait(input,3L).isValid();
    }
}
