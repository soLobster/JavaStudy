package com.itwill.map03;


import java.util.Arrays;
import java.util.HashMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting)
        // 문자열 sentence에 등장하는 단어를 key로 하고 
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과: {땅=2, 바다=1, 사람=1, 하늘=2}
      //단어-빈도수를 저장하기 위한 Map을 선언, 생성.
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        String sentence = "하늘 바다 땅 하늘 땅 사람 하늘 sky sky";
        //sentence 문자열을 공백으로 구분해서 단어들로만 이루어진 배열을 만듦.
        String[] splitSentence = sentence.split(" ");
 
        System.out.println("splitSentence : "+Arrays.toString(splitSentence));
        System.out.println("====================");
        // splitSentence : [하늘, 바다, 땅, 하늘, 땅, 사람, 하늘, sky, sky]
        // splitSentence:    0     1    2    3    4    5    6     7     8

        //배열의 원소들을 하나씩 반복하면서
        for(int i=0; i<splitSentence.length; i++) {
            System.out.println("splitSentence : "+ splitSentence[i]);
            System.out.println("for문의 i = "+i);
          //단어가 Map에 key로 존재하면
            if(wordCount.get(splitSentence[i]) != null) {
                
               //key에 해당하는 value(기존 등장 횟수) + 1 값을 Map에 저장.
                System.out.println("단어가 Map에 Key로 존재하고 있어요 value에 1을 더합니다.");
                wordCount.put(splitSentence[i], wordCount.get(splitSentence[i])+1);
                System.out.println("현재 : "+wordCount);
                System.out.println("------------");
            } else { //단어가 Map에 key로 존재하지 않으면,
                
                 //"단어=1"을 map에 저장.
                System.out.println("단어가 Map에 Key로 존재하지 않아요.");
                System.out.println("단어를 Map에 Key로 저장하고 value에 1을 추가합니다.");
                wordCount.put(splitSentence[i],1);
                System.out.println("현재 : "+wordCount);
                System.out.println("-------------");
            }
        }
        
        System.out.println("최종: "+wordCount);
       
    }
}
























//        
