package chap01;

import java.util.Scanner;

public class DigitsNo {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int num = 0;
        
        while(true) {
            System.out.print("수를 입력하세요 >> ");
            num = Integer.parseInt(scanner.nextLine());
            if(num <= 0) {
                System.out.println("0보다 큰 수를 입력하세요.");
            } else {
                break;
            }
        }
        int count = 0;
        while(num > 0) {
            num = num / 10;
            count++;
        }
        
        
        System.out.println("그 수는 "+count+" 자리 입니다.");
        
     scanner.close();   
    }
}
