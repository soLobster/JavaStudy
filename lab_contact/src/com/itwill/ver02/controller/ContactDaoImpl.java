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
        Contact[] contactArray = new Contact[count];
        for(int i = 0; i < count; i++) {
            contactArray[i] = contacts[i];
        }
        return contactArray;
    }

    @Override
    public int create(Contact contact) {
        int result = 0; // 연락처 저장 실패...
        if(count < MAX_LENGTH) { //실제 저장된 배열의 길이(count)를 최대 저장소와 비교한다.
            contacts[count] = contact;
            count++;
            result = 1;
        }
        return result;
    }

    @Override
    public Contact read(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, String phone, String email) {
        // TODO Auto-generated method stub
        return 0;
    }

    //singleton
    
}
