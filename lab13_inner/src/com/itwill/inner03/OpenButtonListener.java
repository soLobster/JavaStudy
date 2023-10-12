package com.itwill.inner03;

import com.itwill.inner03.Button.onClickListener;

//단지 밖에 클래스를 만들었다.

public class OpenButtonListener implements onClickListener {
    @Override
    public void onClick() {
        System.out.println("파일 열기 실행");
    }
}
