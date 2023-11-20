package chap02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ReverseArrayEx {
    static int num;
    static int[] x = new int[num];
    static int[] y = new int[0];
    
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int[] a) {

        for (int i = 0; i < a.length / 2; i++) {

            //System.out.println("a[" + i + "] 와/과" + " a[" + (a.length - i - 1) + "] 을/를 교환합니다.");
            swap(a, i, a.length - i - 1);

            //System.out.println(Arrays.toString(x));
        }
        //System.out.println("역순 정렬을 마쳤습니다.");
    }
    
   static int sumOf(int[] a) {
       int result = 0;
       for(int i = 0; i < a.length; i++) {
           result += a[i];
       }
       return result;
   }

   static void copy(int[] a, int[] b) {
       for(int i = 0; i < a.length; i++) {
           b[i] = a[i];
       }
       System.out.println(Arrays.toString(b));
   }
   
   static void rcopy(int[] a, int[] b) {
       for(int i = 0; i< a.length; i++) {
           b[i] = a[a.length-i-1];
       }
       System.out.println("배열 b"+Arrays.toString(b));
   }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        num = sc.nextInt();

        x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }
        System.out.println("배열 a"+Arrays.toString(x));
        
        rcopy(x, y);
        //System.out.println("배열 x의 모든 요소의 합 >> "+sumOf(x));
    }

}
