package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain02 {

    public static void main(String[] args) {
        // 대용량 파일 복사.
        // data/ratings.dat 파일을 읽고, data/ratings_copy.dat 파일에 복사.
        // 1) read() 한바이트씩. , write(int b) 사용할 때 시간 측정.
        // 2) read(byte[] b) , write(byte[] b, int off, int len) 사용할 때 시간 측정.

        String origin = "data/ratings.dat"; //읽을 원본 파일 경로, 이름.
        String dest = "data/ratings_copy.dat"; //복사할 파일 경로, 이름.

        FileInputStream in = null;  //파일 읽기 통로.
        FileOutputStream out = null; //파일 쓰기 통로.
        try {
            in = new FileInputStream(origin);
            out = new FileOutputStream(dest);

            long startTime = System.currentTimeMillis(); // 파일 복사 시작 시간.
            boolean run = true;
            while(run) {
                int read = in.read(); //1) 파일에서 1바이트 읽음.

                if(read == -1) { //end of file (EOF) 
                    run = false;
                }

                out.write(read); // 1) 파일에 1바이트를 씀.
            }

            long endTime = System.currentTimeMillis(); //파일 복사 종료 시간.
            long elapsed = endTime - startTime; //복사할 때 경과된 시간.
            System.out.println("복사 시간 >> "+elapsed+"ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//end of main

}//end of class
