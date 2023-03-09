package itstep_test.task_8;

import itstep.task_2.Calc;
import itstep.task_3.CalcException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderCalcTest {

    //Task 3. add Data provider for each test

    //1. parameters
    //2. data provider method
    //3. linking

    private Calc calc=new Calc();

    @DataProvider
    private Object[][] addProvider(){
        int n=5; //number of test data sets
        int m=3; //argument number (int a, int b, int expected)

        Object[][] res= new Object[n][m];
        res[0]= new Object[]{1,2,3};
        res[1]= new Object[]{0,0,0};
        res[2]= new Object[]{-1,1,0};
        res[3]= new Object[]{0,-10,-10};
        res[4]= new Object[]{99,2,100};
        return res;
    }

    @DataProvider
    private Object[][] multiProvider(){
        int n=3; //number of test data sets
        int m=3; //argument number (int a, int b, int expected)

        Object[][] res= new Object[n][m];
        res[0]= new Object[]{1,2,2};
        res[1]= new Object[]{0,0,0};
        res[2]= new Object[]{-1,1,-1};

        return res;
    }

    @Test (dataProvider = "addProvider")
    public void addTest(int a, int b, int expected){
       int actualResult= calc.add(a,b);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

    @Test
    public void minusTest(){
        int expected = -1;
        int actualResult= calc.minus(1,2);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

    @Test(dataProvider = "multiProvider")
    public void multiTest(int a, int b, int expected){
        int actualResult= calc.mult(a,b);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }

    @Test
    public void divideTest() throws CalcException {
        int expected = 0;
        int actualResult= calc.divide(1,2);
        Assert.assertEquals(actualResult,expected,"unexpected result");
    }
}
