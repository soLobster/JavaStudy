package com.itwill.array06;

//문자열 1차원 배열.

public class ArrayMain06 {

    public static void main(String[] args) {

        String[] newJeans = {"혜인", "해린", "하니", "다니엘", "민지"};
        String[] bts = {"진", "슈가", "제이홉", "RM", "지민", "뷔", "정국"};

        String[][] idols = {newJeans, bts};

        for(String[] group : idols) {
            for(String member : group) {
                System.out.print(member+"\t");
            }
            System.out.println();

        }
        System.out.println("=============================================");
        for(int i = 0; i<idols.length; i++) {
            for(int j = 0; j<idols[i].length; j++) {
                System.out.print(idols[i][j]+"\t");
            }
            System.out.println();
        } 
    }
}
