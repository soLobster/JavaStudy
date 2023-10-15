package chap01;

import java.util.Scanner;

public class Difference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter A >> ");
        int a = Integer.parseInt(sc.nextLine());

        int b = 0;

        while(true) {
            System.out.print("Enter B >> ");
            b = Integer.parseInt(sc.nextLine());

            if(b>a) {
                break;   
            } else {
                System.out.println("a보다 큰 값을 입력 하세요.");
            }
        }
        System.out.print("b-a = "+(b-a));
    }
}
