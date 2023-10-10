package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 입출력 스트림 
 * 프로그램에서 값을 입력받거나 출력하는 통로.
 * ex) System.in -> 입력 스트림 객체...
 *     System.out -> 출력 스트림 객체...
 *     
 *     프로그램 <== InputStream <== 입력장치(키보드,마우스,터치스크린,파일,....)
 *     프로그램 ==> OutputStream ==> 출력장치(모니터, 프린터, 프로젝터, 파일....)
 * 
 *     프로그램 <== FileInputStream <== 파일
 *     프로그램 ==> FileOutputStream ==> 파일
 *     
 *     
 *     java.io.InputStream : 프로그램이 데이터를 읽어오는 통로.
 *     |______FileInputStream : 프로그램이 파일에서 데이터를 읽어오는 통로.
 *     
 *     1. FileInputStream(FIS) 객체 생성 
 *     2. FIS 객체의 read 관련 메서드를 사용.
 *     3. FIS 객체를 close!
 *     
 *     java.io.OutputStream : 프로그램에서 데이터를 Write하는 통로다.
 *     |_____FileOutputStream : 프로그램에서 파일에 데이터를 쓰는 통로.
 *     
 *     1. FileOutputStream(FOS) 객체 생성.
 *     2. FOS 객체의 write 관련 메서드를 사용.
 *     3. FOS 객체를 close.
 */

public class FileMain01 {

    public static void main(String[] args) {
        String fileName = "data/hello.txt"; //읽을 파일 경로, 이름.
        String copyFile = "data/hello_copy.txt"; //복사할 파일 경로, 이름.

        FileInputStream in = null;
        FileOutputStream out = null;
        try { //runtimeException을 상속받지 않기에 try - catch 문을 써야한다.
            // 1. FIS 객체 생성.
            in = new FileInputStream(fileName);
            //FOS 객체 생성.
            out = new FileOutputStream(copyFile); //기존 파일에 내용이 있다면 전부 삭제 후 복사.

            boolean run = true;

            while(run) {
                // 2. read 메서드 사용.
                int read = in.read();

                if(read == -1){ //end of file (EOF)
                    run =false;    
                }
                //System.out.print((char) read);
                // 2. FOS의 write 메서드 사용.
                out.write(read); 
            }
            System.out.print("파일 복사 성공");
        } catch (Exception e) {
            e.printStackTrace(); //예외이름, 메시지, 발생 위치를 출력.
        } finally {
            try {
                in.close(); //FIS 객체를 닫음.
                out.close();//FOS 객체를 닫음.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // end main
} // end class
