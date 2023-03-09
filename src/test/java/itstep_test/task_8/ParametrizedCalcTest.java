package itstep_test.task_8;

import itstep.task_2.Calc;
import itstep.task_3.CalcException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedCalcTest {

    //Task 4. Create a test with parameters loaded from testng.xml.

    private Calc calc=new Calc();

    @Parameters({ "a","b","expected" })
    @Test
    public void addTest(int a, int b, int expected){

       int actualResult= calc.add(a,b);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

}
