package com.itwill.set04;

import java.util.HashSet;

public class SetMain04 {

    public static void main(String[] args) {
        // Score 타입 객체를 저장할 수 있는 HashSet을 선언, 생성.
        HashSet<Score> examScore = new HashSet<>();
        //Score score = new Score();
        //Set에 3개의 Score 객체를 저장.
        examScore.add(new Score(100,50,60));
        examScore.add(new Score(95,50,80));
        examScore.add(new Score(90,50,60));
        examScore.add(new Score(95,50,80));

        
        
        for(Score x : examScore) {
            System.out.println(x);
        }

    }

}
