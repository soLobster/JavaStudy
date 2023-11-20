package chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

    public static void main(String[] args) {
        // TODO 키의 최댓값을 구하자. (난수 생성)
        // 키의 값은 다음과 같다
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수: ");
        int num = sc.nextInt();

        int[] height = new int[num];

        System.out.println("킷 값은 아래와 값습니다 : ");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height["+i+"] = "+height[i]);
        }
        System.out.println("최댓값은 "+maxOf(height)+" 입니다.");
    }

    static int maxOf(int[] a) {
        int max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }// end of maxOf
}
