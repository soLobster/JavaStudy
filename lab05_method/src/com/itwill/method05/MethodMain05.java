package com.itwill.method05;

import java.net.SocketTimeoutException;
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

	
	/**
     * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합계를 리턴하는 메서드다
     * @param num
     * @return
     */
	
	public static int sum(int[] num) {
		int sumArr = 0;
		for(int x : num) {
			sumArr += x;
		} 
		return sumArr;
	} // end sum...
	
	/**
	 * 평균을 구한다.
	 * @param num array 정수들의 1차원 배열.
	 * @return 원소들의 평균.
	 */
	
	public static double mean(int[] num) {
		double avgArr = 0;
		//int sum = 0;
		for(int x : num) {
			//sum += x;
			avgArr = (double) sum(num)/num.length;
		}
		return avgArr;
	} // end mean...
	/**
	 * 정수들의 배열의 원소들중 최댓값을 찾아서 리턴.
	 * @param num (정수들의 배열).
	 * @return 최댓값.
	 */
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

	/**
	 * 정수들의 1차원 배열 array에서 최댓값의 위치(인덱스)를 찾아서 리턴.
	 * 만약 최댓값이 2개 이상인 경우 첫번째 최댓값의 인덱스를 리턴.
	 * 
	 * @param num 정수들의 배열.
	 * @return 최댓값의 인덱스다.
	 */
	
//	public static int index(int[] num) {
//        int max = num[0]; //최댓값을 저장할 변수.
//        int index = 0;    //배열 원소의 인덱스를 저장할 변수.
//        int maxIndex = 0; //최댓값의 인덱스를 저장할 변수.
//        for(int x : num) {
//            if(x > max) {
//                max = x;
//                maxIndex = index;
//            } index++;
//        }
//        return maxIndex;
//    }
	
	public static int index(int[] num) {
		Scanner sc = new Scanner(System.in);
		int index = 0;
		boolean flag = true;
		int wantKnowNum = 0;
		System.out.print("순서를 알고 싶은 번호를 입력하세요 >> ");
		wantKnowNum = sc.nextInt();
		sc.close();
		
		for(int i=0; i<num.length; i++) {
		    if(wantKnowNum==num[i]) {
		        index = i;
		        flag = false;
		        break;
		    }   
		}
		
		if(flag) {
            System.out.println("찾으시는 번호가 없습니다.");
        }
		return index;
	} // end index...
} 
