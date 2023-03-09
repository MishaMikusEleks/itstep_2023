package itstep_test.task_8;

import itstep.task_2.Calc;
import itstep.task_3.CalcException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {

    //Task 1: Create 4 simple unit tests for Task_2
    // (modify your code to have 4 different methods in Task_2 solving if need).

    private Calc calc=new Calc();

    @Test
    public void addTest(){
        //testData
        int a=1;
        int b=2;

        // expected test data
        int expected = 3;

       int actualResult= calc.add(a,b);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

    @Test
    public void minusTest(){
        int expected = -1;
        int actualResult= calc.minus(1,2);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

    @Test
    public void multiTest(){
        int expected = 2;
        int actualResult= calc.mult(1,2);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

    @Test
    public void divideTest() throws CalcException {
        int expected = 0;
        int actualResult= calc.divide(1,2);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
}
