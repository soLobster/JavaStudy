package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaMain03 {

    public static void main(String[] args) {
        // Stream 클래스.
        // Stream -> 데이터들이 지나가는 통로.
        Random random = new Random();
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i<10; i++) {
            numbers.add(random.nextInt(10));
        }
        System.out.println(numbers);
        
        //numbers의 원소들 중에서 짝수들만 저장하는 리스트를 만들고 출력.
        ArrayList<Integer> evens = new ArrayList<Integer>();//짝수들을 저장하기 위한 리스트 생성.
        for(Integer x : numbers) { //numbers의 모든 정수들을 순서대로 순회하면서
            if(x % 2 == 0) { //리스트에 선택되 숫자가 짝수이면
                evens.add(x); //evens에 추가.
            }
        }
        System.out.println(evens);
        
        List<Integer> listEvens = numbers.stream().filter((x) -> x % 2 == 0).toList();
        //filter 메서드 통과시켜줄지 말지를 결정한다. predicate = boolean 값을 리턴한다. () 안에는 true or false를 리턴하게 작성.
        System.out.println(listEvens);
        List<Integer> listOdds = numbers.stream().filter((x) -> x%2 == 1).toList();
        System.out.println(listOdds);
        
        //numbers의 정수들을 제곱한 값들을 원소로 갖는 리스트를 만들고 출력.
        ArrayList<Integer> squaresNum = new ArrayList<Integer>(); //제곱들을 저장할 리스트.
        for(Integer x : numbers) { //numbers의 모든 원소들을 순서대로 반복하면서.
            squaresNum.add(x*x); //numbers에서 꺼낸 숫자의 제곱을 리스트에 저장한다.
        }
        System.out.println(squaresNum);
        
        List<Integer> listSquares = numbers.stream().map((x) -> x * x).toList(); //map
        System.out.println(listSquares);
        
        //numbers의 원소들 중에서 홀수들의 제곱을 저장하는 리스트를 만들고 출력. <메서드 연쇄 호출>
        List<Integer> listOddSquare = numbers.stream().filter((x) -> x%2 == 1).map((x) -> x*x).toList();
        System.out.println(listOddSquare);
        
        List<String> languages = Arrays.asList("Java","JavaScript","Python","Kotlin","C");
        System.out.println(languages);
        
        //languages의 문자열들 중에서 5글자 이상인 문자열들을 소문자로 변환한 리스트를 만들고 출력.
        List<String> listLowLang = languages.stream().filter((x) -> x.length() >= 5).map((x) -> x.toLowerCase()).toList();
        System.out.println(listLowLang);
        
        List<String> listLowLang2 = languages.stream().filter((x) -> x.length() >= 5).map(String::toLowerCase).toList();
        System.out.println(listLowLang2);
        
        /*
         * 람다 표현식이 아규먼트를 1개만 갖고,
         * 람다의 리턴값이 그 아규먼트에서 파라미터가 없는 메서드 호출 결과인 경우
         * 메서드 참조 방식으로 람다 표현식을 작성할 수 있다.
         * (x) -> x.toLowerCase() 와 String::toLowerCase 는 같은 람다 표현식이다.
         * (x) -> x.length() 와 String::length 
         */
        
        //람다 표현식이 아규먼트를 1개만 전달 받고
        //람다의 구현부가 메서드 1개 호출이고, 그 메서드 람다의 아규먼트를 전달 받는 경우,
        //메서드 참조 방식을 사용할 수 있다.
        //(x) -> System.out.println(x)
        //System.out::println
        
        languages.forEach((x) -> System.out.println(x));
        languages.forEach(System.out::println);
        
    }

}
