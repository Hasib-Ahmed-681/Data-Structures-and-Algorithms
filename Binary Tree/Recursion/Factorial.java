package Recursion;

public class Factorial {
    public static void main(String[] args){
          // calculate 4! = 4x3x2x1
         // 4!=4 x3!
        //n! = n x (n-1)!

        System.out.println(factorial(4));

    }


    public static int factorial(int n){
//        factorial using loop
//        var factorial = 1;
//        for(var i=n;i>1;i--)
//            factorial*= i;
        //Base Condition
        if(n==0)
            return 1;

        return n*factorial(n-1);
        //when a funcion calling itself = recursion
    }
}
