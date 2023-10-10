package com.itwill.ver03.controller;

import java.util.ArrayList;
import java.util.List;


import com.itwill.ver02.model.Contact;

public class ContactDaoImpl implements ContactDao {

    private static ContactDaoImpl instance = null;

    private ContactDaoImpl() {}

    public static ContactDaoImpl getInstance() {
        if(instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }

    private List<Contact> contacts = new ArrayList<Contact>(); 
    //List는 인터페이스 객체를 생성할 수 없기에 ArrayList로 선언.
    public boolean isValidIndex(int index) {
        return index >= 0 && index < contacts.size();
    }
    public boolean isContainContacts() {
        return contacts.size() > 0;
    }

    @Override
    public List<Contact> read() {
        return contacts;
    }//List<Contact> read()

    @Override
    public Contact read(int index) {
        if(isValidIndex(index)) {
            return contacts.get(index);
        } else {
            return null;
        }
    }//end Contact read()....

    @Override
    public int create(Contact contact) {
        //새로운 연락처 정보를 리스트에 저장
        int result = 0;
        contacts.add(contact);
        if(contacts.contains(contact)) {
            result = 1;
        } else {
            result = 0;
        }
        // 저장 성공  1 리턴
        return result;
    }//end create(Contact contact)

    @Override
    public int update(int index, Contact contact) {
        int result = 0;

        if(isValidIndex(index)) {
            contacts.set(index, contact);

            /*
             * Contact c =contacts.get(index) -> 업데이트 전의 연락처.
             * c.setName(contact.getName()); -> 이름 업데이트
             * c.setName(contact.getPhone()); -> 번호 업데이트
             * c.setEmail(contact.getEmail()): -> 메일 업데이트.
             */

            result = 1;
        } else {
            result = 0;   
        }
        return result;
    }//end update()....

    @Override
    public int delete(int index) {
        int result = 0;
        if(isValidIndex(index)) {
            contacts.remove(index);
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }//end delete()...

}//end implements ContactDaoImpl