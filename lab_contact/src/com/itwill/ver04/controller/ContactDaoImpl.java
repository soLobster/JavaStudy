package com.itwill.ver04.controller;


import java.util.List;

import com.itwill.ver04.fileutil.FileUtil;
import com.itwill.ver04.model.Contact;

public class ContactDaoImpl implements ContactDao {
    
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {
        // 데이터 폴더 초기화: 폴더가 없으면 생성, 있으면 그대로 사용.
        System.out.println("데이터 폴더를 생성합니다.");
        FileUtil.initDataDir();
        
        // 데이터 초기화: 데이터 파일이 있으면 파일에서 읽어오기, 없으면 빈 리스트 만들기.
        contacts = FileUtil.initData();
        System.out.println("데이터 폴더가 이미 있습니다.");
    }
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }

    private List<Contact> contacts;
    
    public boolean isValidIndex(int index) {
        return index >= 0 && index < contacts.size();
    }
    
    public boolean isContainContacts() {
        return contacts.size() > 0;
    }
    
    @Override
    public List<Contact> read() {
        return contacts;
    }

    @Override
    public Contact read(int index) {
//        if (isValidIndex(index)) {
//            return contacts.get(index);
//        } else {
//            return null;
//        }
        try {
            return contacts.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public int create(Contact contact) {
        contacts.add(contact);
        // TODO: 바뀐 리스트를 파일에 쓰기.
        FileUtil.writeDataToFile(contacts);
        return 1;
    }

    @Override
    public int update(int index, Contact contact) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
//        contacts.set(index, contact);
        Contact c = contacts.get(index); // 업데이트 전의 연락처.
        c.setName(contact.getName()); // 이름 업데이트
        c.setPhone(contact.getPhone()); // 전화번호 업데이트
        c.setEmail(contact.getEmail()); // 이메일 업데이트
        
        // TODO: 바뀐 리스트를 파일에 쓰기.
        FileUtil.writeDataToFile(contacts);
        return 1;
    }

    @Override
    public int delete(int index) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contacts.remove(index);
        
        // TODO: 바뀐 리스트를 파일에 쓰기.
        FileUtil.writeDataToFile(contacts);
        return 1;
    }

}