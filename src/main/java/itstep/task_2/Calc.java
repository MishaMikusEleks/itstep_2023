package itstep.task_2;

import itstep.task_3.CalcException;

import java.util.Random;

public class Calc {

    public static void main(String[] args) throws CalcException {
        int a =0;
        int b=1;
        Calc calc=new Calc();
        System.out.println("a+b="+calc.add(a,b));
        System.out.println("a-b="+calc.minus(a,b));
        System.out.println("a*b="+calc.mult(a,b));
        System.out.println("a/b="+calc.divide(a,b));

        System.out.println("a/b="+calc.divide(a,0));
    }

    public int add(int a, int b){
        return a+b;
    }

    public  int minus(int a, int b){
        return a-b;
    }

    public  int mult(int a, int b){
        return a*b;
    }

    public int divide(int a, int b) throws CalcException {
        if(0==b){
            throw new CalcException("you can't divide by zero");
        }
        return a/b;
    }

    public  void main1(String[] args) {
        Random random=new Random();
        for(int i=1;i<=17; i++){
            System.out.println(i+" - "+ (random.nextInt(5)+1)
                    +" "+(random.nextInt(5)+1)
                    +" "+(random.nextInt(5)+1));
        }
    }

}
