package itstep.task_2;

public class Primitives {

    public static void main(String[] args) {
        int a =0;
        int b=1;

        System.out.println("a+b="+add(a,b));
        System.out.println("a-b="+minus(a,b));
        System.out.println("a*b="+mult(a,b));
        System.out.println("a/b="+divide(a,b));

    }

    private static int add(int a, int b){
        return a+b;
    }

    private static int minus(int a, int b){
        return a-b;
    }

    private static int mult(int a, int b){
        return a*b;
    }

    private static int divide(int a, int b){
        return a/b;
    }
}
