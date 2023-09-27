package com.itwill.ver02.controller;

import com.itwill.ver02.model.Contact;

//MVC 아키텍처에서 Controller 역할 담당하는 인터페이스.
//DAO Data Access Object.. 콘트롤러를 부르는 다른 이름...

public interface ContactDao {

   /**
    * 전체 연락처 목록 검색.
    * 모든 연락처가 저장된 배열을 불어온다...
    * 
    * @return Contact 배열(Contact[]).
    */
    
   Contact[] read();
    
   /**
    * 새로운 연락처를 저장하는 기능.
    * 
    * @param Contact 배열에 저장할 Contact 타입 객체.
    * @return 배열에 연락처를 저장했으면 1을 리턴하고 실패했을때는 0 리턴.
    */
   
   int create(Contact contact);
   
   /**
    * 연락처 인덱스 검색하기...
    * 
    * 인덱스를 사용한 연락처 정보 검색 기능..
    * @param index 배열에서 연락처 정보를 검색할 기능(int).
    * @return 아규먼트 index가 배열의 인덱스 범위 안에 있으면 Contact 타입 객체를 리턴.
    * index가 배열 범위 밖에 있거나, 해당 인덱스 배열 원소가 null이면 null을 리턴.
    */
   
   Contact read(int index); //over_loading.
   
   /**
    * 연락처 수정하기...
    * 기존의 연락처를 수정(update)하는 기능.
    * 배열의 특정 인덱스의 연락처 중 이름, 이메일, 번호를 수정하는 메서드.
    * @param index -> (int) 수정할 연락처의 인덱스.
    * @param name -> (String) 수정할 연락처의 이름.
    * @param phone -> (String) 수정할 번호.
    * @param email -> (String) 수정할 이메일.
    * @return 수정에 성공하면 1, 실패시 0 리턴...
    */
   
   int update(int index, String name , String phone, String email);
}
