package chap01;

import java.util.Scanner;

public class Max3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Max3 m = new Max3();
        
        System.out.println("3개의 정수 중 최댓값을 구합니다...");
        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.print("b = ");
        int b = scanner.nextInt();
        System.out.print("c = ");
        int c = scanner.nextInt();

        System.out.println("max? >> "+m.maxReturn3(a, b, c));
    }
    public int maxReturn3(int a, int b, int c) {
        int max = a;
        
        if(b > max) {
            max = b;
        } else if(c > max) {
            max = c;
        }
        return max;
    }
}
