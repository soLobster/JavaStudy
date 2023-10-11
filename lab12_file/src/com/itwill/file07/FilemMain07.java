package com.itwill.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class FilemMain07{

    public static void main(String[] args) {
        // 파일 읽기 쓰기를 하기 위한 파일 이름.
        String file = "data/student_list.dat";

        //Student를 원소로하는 ArrayList를 생성, 1_000_000개의 Student 객체를 저장.
        ArrayList<Student> students = new ArrayList<Student>();

        for(int i = 0; i<1000; i++) {
            Score scores = new Score();
            
            for(int j = 0; j<100; j++) {
                Random random = new Random();
                scores = new Score(random.nextInt(100), random.nextInt(100), random.nextInt(100));
            }
            
            students.add(new Student(i, "student_"+i, scores));
        }

        //파일에 ArrayList를 write
        try (
                FileOutputStream out = new FileOutputStream(file);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
                ){

            oout.writeObject(students);

            System.out.println("작성 성공....!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //파일에서 ArrayList를 read

        try(
                FileInputStream in = new FileInputStream(file);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
                ) {

            ArrayList<Student> stList = (ArrayList<Student>) oin.readObject();

            System.out.println("size "+students.size());
            for(Student s : stList) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//end main.

}//end class.
