package com.itwill.loop04;


public class LoopMain04 {

    public static void main(String[] args) {
        /* 369게임: 아래와 같이 출력하세요.
        1   2   *   4   5   *   7   8   *   10
        11  12  *   14  15  *   17  18  *   20
        21  22  *   24  25  *   27  28  *   *
        *   *   *   *   *   *   *   *   *   40
        41  42  *   44  45  *   47  48  *   50
        51  52  *   54  55  *   57  58  *   *
        *   *   *   *   *   *   *   *   *   70
        71  72  *   74  75  *   77  78  *   80
        81  82  *   84  85  *   87  88  *   *
        *   *   *   *   *   *   *   *   *   100
        */
        //for(if *출력)
        //else 숫자
        //줄바꿈.
    
    	
        for(int i = 1; i<=100; i++) {
             int tenNum = i/10;
        	 int oneNum = i%10;
        	 
        	 boolean oneNumChk = (oneNum==3)||(oneNum==6)||(oneNum==9);
        	 boolean tenNumChk = (tenNum==3)||(tenNum==6)||(tenNum==9);
        	 
        	if(oneNumChk&&tenNumChk) { //or보다 and가 먼저 와야한다. or가 먼저오면 and가 포함 되어 버린다.
        		System.out.print("XX\t"); //"*"+"\t" = "*\t"
        	}  else if(oneNumChk||tenNumChk) {
        	    System.out.print("X\t");
        	      } 
        	else {
        		System.out.print(i+"\t");
        	}
         
        	if(oneNum==0) {
        		System.out.println();
        	}
        } 
        
    }
}
