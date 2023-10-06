package com.itwill.ver03.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
   
    @Override
    public List<Contact> read() {
       return contacts;
    }
    
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
    }

    @Override
    public Contact read(int index) {
        

    }

   

    @Override
    public int update(int index, Contact contact) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(int index) {
        // TODO Auto-generated method stub
        return 0;
    }

}