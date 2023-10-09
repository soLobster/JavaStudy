package com.itwill.ver02.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itwill.ver02.model.Instagram;
public class InstagramDao {

    private static InstagramDao instance = null;

    private InstagramDao() {}

    public static InstagramDao getInstance() {
        if(instance==null) {
            instance = new InstagramDao();
        }
        return instance;
    }//싱글톤 

    
    //private List<Instagram> instagrams = new ArrayList<Instagram>();
    HashMap<String, Instagram> instagramMap = new HashMap<>();

    public int create(String id, String password, String email, String phone, String name) {
        //회원 가입...
        int result = 0;
        if(!instagramMap.containsKey(email)) {
            Instagram instaMem = new Instagram(id, password, email, phone, name);
            instagramMap.put(email, instaMem);
            result = 1;
        }   else {
            result = 0;
        }
        return result;
    }//end create().
    
    public Instagram read(String email) {
        if(instagramMap.containsKey(email)) {
            return instagramMap.get(email);
        } else {
            return null;
        }
    }//end read(String email)
    
}

