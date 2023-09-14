package com.itwill.loop03;

public class LoopMain03 {

    public static void main(String[] args) {
        // Ex1. 구구단 2단을 출력하세요.
        for(int i = 1; i<=9; i++) {
            System.out.printf("2 * %d = %d\n", i, 2*i);
        }
        
        //지역변수 사용 범위. 메서드 안에서 선언하는 변수
        //사용된 블럭까지만 유효. 그 이상 넘어가면 사라진다.
        //선언된 위치에서부터 변수가 포함된 "블록({....})"
        //블록이 끝나면 지역변수는 메모리에서 자동으로 지워짐.
        
        //전역변수.
        
        /* Ex2. 아래와 같이 출력하세요.
        1     2     3     4     5     6     7     8     9     10
        11    12    13    14    15    16    17    18    19    20
        21    22    23    24    25    26    27    28    29    30
        31    32    33    34    35    36    37    38    39    40
        41    42    43    44    45    46    47    48    49    50
        51    52    53    54    55    56    57    58    59    60
        61    62    63    64    65    66    67    68    69    70
        71    72    73    74    75    76    77    78    79    80
        81    82    83    84    85    86    87    88    89    90
        91    92    93    94    95    96    97    98    99    100
        */
        
        System.out.println();
        System.out.println("==============================");
        System.out.println();
        
        for(int i=0; i<=90; i+=10) {
            for(int j=1; j<=10; j++) {
                System.out.print(i+j+"\t");
            }
            System.out.println();
        }
     
        System.out.println("==============================");
        
        for(int n=1; n<=100; n++) {
            System.out.print(n + "\t");
            if(n%10==0) {
                System.out.println();
            }
        }
        
    }
}
