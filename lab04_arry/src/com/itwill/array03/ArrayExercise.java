package com.itwill.array03;

import java.util.Random;


//반복문. 
// for(모든 원소)
// max=a[0]
// min=a[0]
/*
 *for(모든원소)
 *if(max<원소);
 *max=원소; 
 *배열의 최댓값, 최소값 구하기.
 */
public class ArrayExercise {

    public static void main(String[] args) {
        
    	int[] arr1 = {1,5,3,8,2};
		int max1 = arr1[0];
		int min1 = arr1[0];
			    	
		System.out.println("max--for-if--");
			for(int i=0; i<arr1.length; i++) {
			    if(max1 < arr1[i]) 
			    	{
			    		max1 = arr1[i];
			    	}	
			    }
			System.out.println("max1: "+ max1);	
			    	
		System.out.println("min--for-if--");
			    	
		   	for(int i=0; i<arr1.length; i++) {
			    if(min1 > arr1[i]) 
			    	{
			    		min1 = arr1[i];
			    	}
			    }
		   	System.out.println("min1: "+min1);	

	int[] arr2 = {1,5,3,8,2};
	int max2 = arr2[0];
	int min2 = arr2[0];
				    
	    System.out.println("max--Enhanced-for--");
			
	    	for(int i=0; i<arr2.length; i++) {
	    		for(int x : arr2) {
	    			if(x > max2) 
	    				{
	    					max2 = x;   
	    				}    
	    			}
    			}
	    	System.out.println("max2: "+max2);
					
	    System.out.println("min--Enhanced-for--");
	    	for(int i=0; i<arr2.length; i++){
	    		for(int x : arr2){
	    			if(x < min2)
	    			{
	    				min2 = x;
	    			}
	    		}
	    	}
	    	System.out.println("min2: "+min2);
	    	
	    	
	    	System.out.println("============오쌤 코드=============");
	    //정수 5개를 저장할 수 있는 배열 선언 & 초기화.
	    int[] array = new int[5];
	    //배열에 정수 난수([0,11])
	    //기본타입이 아닌 놈들 참조 타입이다.
	    Random random = new Random();
	    for(int i = 0; i < array.length; i++) {
	        array[i] = random.nextInt(11);
	    }
	    
	    //배열의 내용을 출력:
	    for(int x : array) {
	        System.out.print(x+" ");
	    }
	    System.out.println();
	    
	    //배열 원소들 중 최댓값 찾기:
	    int max = array[0]; // 배열의 첫번째 원소를 최댓값이라고 가정.
	    for(int x : array) { //array의 원소들을 처음부터 끝까지 반복하면서 
	       if(x > max) { // 배열에서 찾은 값이 (x) 최댓값보다 크다면.
	           max = x; // 최댓값을 배열에서 찾은 값으로 변경.
	       }
	    }
	    System.out.println("max = "+max);
	    //배열의 원소들 중 최솟값 찾기.
	    int min = array[0];  // 배열의 첫번째 원소를 최솟값이라고 가정.
        for(int x : array) { 
                min = (x < min) ? x : min; //삼항연산자 사용.
           }                                //배열의 원소들을 처음부터 끝까지 반복하면서 
                                            //더 작은 값으로 min의 값을 변경.      
        System.out.println("min = "+min);
    }
}

