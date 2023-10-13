package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain02 {

    
    public List<Object> filter(List<Object> list, MyFilter filter) {
        List<Object> result = new ArrayList<Object>();
        for(Object x : list) {
            if(filter.test(x)) {
                result.add(x);
            }//if
        }//for
        return result;
    }//filter method
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
