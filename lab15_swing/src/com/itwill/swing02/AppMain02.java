package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

    private JFrame frame;
    private JTextField textInput;
    private JButton btnInput;
    private JLabel lblMessage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // absolute layout (절대 레이아웃)
        
        lblMessage = new JLabel("메시지를 입력하세요."); //지역변수.
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 24));
        lblMessage.setBounds(12, 10, 410, 60);
        frame.getContentPane().add(lblMessage);
        
        textInput = new JTextField(); //필드 멤버 변수.
        textInput.setFont(new Font("나눔스퀘어라운드 Regular", Font.PLAIN, 24));
        textInput.setBounds(12, 80, 410, 60);
        frame.getContentPane().add(textInput);
        textInput.setColumns(10);
        
        btnInput = new JButton("입력"); //버튼 객체 생성
        // 버튼에 ActionListener 객체를 설정(등록) 
        btnInput.addActionListener(new ActionListener() {
            @Override //함수형 인터페이스.
            public void actionPerformed(ActionEvent e) {     
                handleButtonClick();         
            }
        });
        btnInput.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.BOLD, 24));
        btnInput.setBounds(120, 150, 200, 60);
        frame.getContentPane().add(btnInput);
    }
    
    private void handleButtonClick() {
        System.out.println("버튼이 클릭 되었습니다.");
        // 버튼을 클릭했을 때 수행할 기능 작성.
        // 1. JTextField에 입력된 문자열을 읽음.
        String msg = textInput.getText();
        // 2. 1에서 읽은 문자열을 JLabel에 씀.
        lblMessage.setText(msg);
        // 3. JTextField에 입력된 내용을 지운다.
        textInput.setText("");
    }
}
