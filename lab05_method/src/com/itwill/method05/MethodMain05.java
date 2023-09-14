package com.itwill.method05;

import java.util.Scanner;

public class MethodMain05 {
	public static void main(String[] args) {
		// 메서드 작성 연습:
		
		int[] scores = new int[5];
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("배열에 들어갈 숫자를 입력하세요(5개) >> ");
		for(int i = 0; i<scores.length; i++) {
			System.out.print("배열에 저장 수 입력하세요(최대 5개 한 숫자씩 입력) >> ");
			scores[i] = sc.nextInt(); 
					//Integer.parseInt(sc.nextLine());
		}

		//int[] scores = {70, 60, 100, 50, 81};

		int sum = sum(scores);
		System.out.println("총점 = " + sum);
		
		double avg = mean(scores);
		System.out.println("평균 = " + avg);

		int max = max(scores);
		System.out.println("최댓값 = " + max);

		int min = min(scores);
		System.out.println("최솟값 = " + min);

		int index = index(scores);
		System.out.println("인덱스 = " + index);

	} // end main...

	public static int sum(int[] num) {
		int sumArr = 0;
		for(int x : num) {
			sumArr += x;
		} 
		return sumArr;
	} // end sum...
	public static double mean(int[] num) {
		double avgArr = 0;
		int sum = 0;
		for(int x : num) {
			sum += x;
			avgArr = (double) sum/num.length;
		}
		return avgArr;
	} // end mean...
	public static int max(int[] num) {
		int max = num[0];
		for(int x : num) {
			if(max < x ) {
				max = x;
			}
		}
		return max;
	} // end max...
	public static int min(int[] num) {
		int min = num[0];
		for(int x : num) {
			if (min > x) {
				min = x;
			}
		}
		return min;
	} // end min...

	public static int index(int[] num) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		System.out.print("순서를 알고 싶은 번호를 입력하세요 >> ");
		index = sc.nextInt();
		sc.close();
		for(int i=0; i<num.length; i++) {
			if(index == num[i]) {
				return i; 
			} 
		}
		
	return index;
	
	} // end index...
	
}