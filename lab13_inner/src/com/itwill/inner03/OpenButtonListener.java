package com.itwill.inner03;

import com.itwill.inner03.Button.onClickListener;

public class OpenButtonListener implements onClickListener {
    @Override
    public void onClick() {
        System.out.println("파일 열기 실행");
    }
}
