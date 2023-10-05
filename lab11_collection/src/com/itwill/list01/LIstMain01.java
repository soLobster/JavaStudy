package com.itwill.list01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Collection<E>
 * |_________List<E>
 *      |________ArrayList<E>, LinkedList<E>, .....
 *      
 * 리스트(list)의 특징. <연속된 공간을 가진다는게 중요하다...>
 * 1. 값들을 저장하는 순서가 중요. (index를 가지고 있다.)
 * 2. 값들을 저장할때마다 인덱스는 자동으로 증가한다. - 저장 공간이 자동으로 증가.
 * 3. 리스트 중간에 있는 값을 삭제하면 인덱스가 자동으로 재배열됨.
 * 4. 같은 값들을 여러번 저장할 수 있다. - Set<E>과 다른 점.
 * 5. List<E> Elements (원소) 리스트가 저장하는 원소의 데이터 타입을 의미한다.
 *    (주의) 리스트는 클래스 타입의 객체만 저장할 수 있음. 기본 타입 데이터는 저장할 수 없다.
 *    Ex) List<Integer> list = new(); (O)
 *        List<int> list = new(); (X)
 *        
 * ArrayList<E>의 특징
 * 1. 배열을 이용한 리스트.
 * 2. 데이터를 저장(add) 삭제(remove) 속도가 느리다.
 * 3. 데이터 검색(get) 속도는 굉장히 빠르다.
 * 
 * LinkedList<E>의 특징
 * 1. linked list 알고리즘을 이용한 리스트.
 * 2. 데이터 저장, 삭제 속도가 빠르다.
 * 3. 데이터 검색 속도가 느리다.
 */

public class LIstMain01 {

    public static void main(String[] args) {
        // 문자열을 저장하는 ArrayList 생성

        ArrayList<String> languages = new ArrayList<String>();

        System.out.println(languages); //-> toString 메서드가 override 되어 있음.

        System.out.println("size = "+ languages.size()); //-> 리스트의 크기(원소 개수).

        //리스트에 원소 추가.
        languages.add("Java"); //add 메서드를 사용한다.
        languages.add("SQL");
        System.out.println(languages);
        System.out.println("size = "+ languages.size());

        // 리스트의 특정 인덱스에 있는 원소 값을 읽음.
        System.out.println(languages.get(0));

        // for 반복문을 사용해서 리스트의 원소들을 모두 출력.
        for(int i = 0; i<languages.size(); i++) {
            System.out.print(languages.get(i)+"\t");
        }

        System.out.println();

        //향상된 for 구문을 사용한 리스트 원소 출력.
        for(String s : languages) {
            System.out.print(s+"\t");
        }

        System.out.println();

        //리스트의 원소 삭제.
        languages.remove(0); //remove(int index)
        System.out.println(languages);

        languages.remove("SQL"); //대소문자 구분을 한다. remove(Object element)
        System.out.println(languages);

        List<String> list =Arrays.asList("Java","SQL","Java","Html");
        ArrayList<String> alist = new ArrayList<String>(list);
        System.out.println(alist);
        boolean result = alist.remove("Java");
        System.out.println(result);
        System.out.println(alist);












    }

}
