package com.itwill.set01;

import java.util.TreeSet;

/*
 * Collection<E>
 * |____________List<E>
 *              |________ArrayList<E>, LinkedList<E>,...
 *              
 * Collection<E>
 * |______Set<E>
 *         |______HashSet<E>, TreeSet<E>,.....
 *         
 * Set<E> 특징
 * 1. 중복된 값을 저장하지 않습니다. ex) {1,2,3,3,3} = {1,2,3}
 * 2. 저장 순서는 중요하지 않음...인덱스가 없다 ex) {1,2} = {2,1}
 * 
 * HashSet<E> : Hash 알고리즘(검색을 빠르게 할 수 있는 알고리즘)을 사용한 Set<E>
 * TreeSet<E> : Tree 알고리즘(정렬을 빠르게 할 수 있는 알고리즘)을 사용한 Set<E>
 */

public class SetMain01 {

    public static void main(String[] args) {
        
        //TreeSet<E> 정수 저장.
        TreeSet<Integer> set = new TreeSet<Integer>();
        System.out.println(set);
        System.out.println("size = "+set.size());
        
        set.add(11);
        System.out.println(set);
        System.out.println("size = "+set.size());
        
        set.add(2);
        System.out.println(set);
        System.out.println("size = "+set.size());
        
        set.add(15);
        System.out.println(set);
        System.out.println("size = "+set.size());
        
        set.add(11); //같은 값은 무시한다.
        System.out.println(set);
        System.out.println("size = "+set.size());
        
        //Set<E>은 get() 메서드를 제공하지 않는다.
        for(Integer n : set) { //-> for 구문은 사용할 수 없지만, 향상된 for 구문은 사용가능.
            System.out.print(n + "\t");
        }
        System.out.println();
        
        //List<E>는 remove(int index), remove(object element) 메서드를 제공.
        //Set<E>는 remove(object element) 메서드만 제공.
        set.remove(15);//Integer 객체 15가 지워진것이다.
        System.out.println(set);
    }

}
