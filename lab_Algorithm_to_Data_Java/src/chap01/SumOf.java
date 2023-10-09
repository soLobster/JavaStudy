package chap01;

import java.util.Scanner;

public class SumOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a >> ");
        int a = scanner.nextInt();
        System.out.print("Enter b >> ");
        int b = scanner.nextInt();

        System.out.println("Sum of "+a+" ~ "+b+" = "+sumof(a, b));
    }

    static int sumof(int a, int b) {
        int result = 0;
        int max = 0;
        int min = 0;

        if(a>b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        for(int i = min; i <= max; i++) {
            result += i;
        }

        return result;
    }
}
