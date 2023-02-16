package itstep.task_2;

import itstep.task_3.CalcException;

import java.util.Random;

public class Primitives {

    public static void main(String[] args) throws CalcException {
        int a =0;
        int b=1;

        System.out.println("a+b="+add(a,b));
        System.out.println("a-b="+minus(a,b));
        System.out.println("a*b="+mult(a,b));
        System.out.println("a/b="+divide(a,b));

        System.out.println("a/b="+divide(a,0));
    }

    public static int add(int a, int b){
        return a+b;
    }

    private static int minus(int a, int b){
        return a-b;
    }

    private static int mult(int a, int b){
        return a*b;
    }

    private static int divide(int a, int b) throws CalcException {
        if(0==b){
            throw new CalcException("you can't divide by zero");
        }
        return a/b;
    }

    public static void main1(String[] args) {
        Random random=new Random();
        for(int i=1;i<=17; i++){
            System.out.println(i+" - "+ (random.nextInt(5)+1)
                    +" "+(random.nextInt(5)+1)
                    +" "+(random.nextInt(5)+1));
        }
    }

}
