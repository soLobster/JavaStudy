package chap01;

import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정사각형을 출력합니다.");
        System.out.print("변의 길이 >> ");
        int num = scanner.nextInt();
        
        for(int i = 0; i<num ; i++) {
            for(int j = 0; j<num ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

}
