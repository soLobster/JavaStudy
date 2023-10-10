package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itwill.file05.Product;


public class FileMain06 {

    public static void main(String[] args) {
        // 1) com.itwill.file05.Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일에 write:
        // FileOutputStream, BufferedOutputStream, ObjectOutputStream 사용.
        // ArrayList를 파일에 쓰는 시간을 측정하고 출력.
        String file = "data/product1.dat";

        try(
                //리소스 생성.
                FileOutputStream out = new FileOutputStream(file);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
                ) {
            //파일에 쓸 Product ArrayList 객체 생성.
            List<Product> products = new ArrayList<Product>(1_000_000);
            Product p = new Product(0, file, 0);
            long start = System.currentTimeMillis();
            
            for(int i=0; i<products.size(); i++) {
                products.add(i, p);
            }

            //자바 객체를 쓴다..
            oout.writeObject(products);
            long end = System.currentTimeMillis();
            System.out.println("파일 작성 성공");
            System.out.println("Write Time >> "+(end - start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        } 

        // 2) 1)에서 작성된 파일에서 ArrayList를 읽고, 내용 확인:
        // FileInputStream, BufferedInputStream, ObjectInputStream 사용.
        // ArrayList를 파일에서 읽는 시간을 측정하고 출력.

        //파일 읽기....
        FileInputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream oin = null;
        try {
            in = new FileInputStream(file);
            bin = new BufferedInputStream(in);
            oin = new ObjectInputStream(bin);

            long start = System.currentTimeMillis();
            Object prod =  oin.readObject();
            System.out.println(prod);
            long end = System.currentTimeMillis();
            
            System.out.println("Read Time >> "+(end-start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oin.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

    }//end main...

}//end class...