package chap01;

import java.util.Scanner;

public class Median {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run) {
            System.out.println("3개의 정수 중 중앙값을 구합니다 >> ");
            System.out.print("a = ");
            int a = scanner.nextInt();
            System.out.print("b = ");
            int b = scanner.nextInt();
            System.out.print("c = ");
            int c = scanner.nextInt();

            System.out.println("중앙값 >> "+median3(a, b, c));


        }
    }//end of main...

    static int median3(int a, int b, int c) {

        int median = 0;

        if(a > c) { // a max
            if(b > c) {
                median = b;
            } else if(c > b) {
                median = c;
            } 
        } else if (b > c) { // b max
            if(c > a) {
                median = c;
            } else if (a > c) {
                median = a;
            }
        } else if (c > a) { // c max 
            if(a > b) {
                median = a;
            } else if (b > a) {
                median = b;
            }
        }

        return median;
    }//end median3 method..

}
