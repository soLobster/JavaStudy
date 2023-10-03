package com.itwill.instagram.controller;

import com.itwill.instagram.model.InstaMember;

public interface InstaMemberDao {

	/**
	 * 전체 회원 검색...
	 * 모든 회원이 저장된 배열을 불러온다...
	 * 
	 * @return InstaMember 배열(InstaMember[])
	 */
	
	InstaMember[] read();
	
	/**
	 * 새로운 회원을 저장하는 기능...
	 * 
	 * @param InstaMember 배열에 저장할 InstaMember 타입 객체.
	 * @return 배열에 연락처를 저장했으면 1을 리턴 실패시 0을 리턴...
	 */
	
	int create(InstaMember instaMember);
	
	
}
