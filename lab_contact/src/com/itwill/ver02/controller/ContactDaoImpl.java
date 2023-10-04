package com.itwill.ver02.controller;

import com.itwill.ver02.model.Contact;

//MVC 아키텍쳐에서 Controller 역할 담당 클래스 - data access object (DAO)

public class ContactDaoImpl implements ContactDao {

	//singleton....

	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {}

	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}//singleton....

	public static final int MAX_LENGTH = 1; //연락처 배열 최대 길이...

	private Contact[] contacts = new Contact[MAX_LENGTH];

	private int count = 0;

	public int getCount() {
		return count;
	}

	public boolean isMemoryAvail() { //빈 배열 확인... 
		return count < MAX_LENGTH;
	}

	@Override
	public Contact[] read() {
	    //NULL이 아닌 배열 원소들만 복사하자...
		Contact[] contactArray = new Contact[count];
		for(int i = 0; i < count; i++) {
			contactArray[i] = contacts[i];
		}
		return contactArray;
	}//Over_ride Contact[] read()

	@Override
	public int create(Contact contact) {
		int result = 0; // 연락처 저장 실패...
		if(count < MAX_LENGTH) { //실제 저장된 배열의 길이(count)를 최대 저장소와 비교한다.
			contacts[count] = contact;
			count++;
			result = 1;
		}
		return result;
	}//Over_ride create()

	@Override
	public Contact read(int index) {
		if(index >= 0 && index < count) {
			return contacts[index];
		} else {
			return null;
		}
	}//Over_ride read(int index)

	@Override
	public int update(int index,String name, String phone, String email) {
		int result = 0;
		if(index >= 0 && index < count) {
			contacts[index].setName(name);
			contacts[index].setPhone(phone);
			contacts[index].setEmail(email);
			result = 1;
		} 
		return result;
	}//Over_ride update()

}//end class ContactDaoImpl implements ContactDao
