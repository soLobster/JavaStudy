package chap01;

import java.util.Scanner;

public class SumGauss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1~10 까지의 합 (1+10)*5 이를 가우스의 덧셈이라 한다.
        //이를 이용해 1부터 N 까지의 정수 합을 구하는 프로그램을 작성하세요.

        while(true) {
            System.out.print("정수를 입력하세요... >> ");
            int n = scanner.nextInt();

            int sum = 0;

            for(int i = 0; i < n; i++) {
                sum += (i + (n-i) + 1);
            }
            
            System.out.println("1부터 입력한 n 정수 까지의 합 = "+sum/2);
            
        }
        
        

    } //end main

}//end SumGauss
