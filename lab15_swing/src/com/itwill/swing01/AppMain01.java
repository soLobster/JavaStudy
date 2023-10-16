package com.itwill.swing01;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;  

public class AppMain01 {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain01 window = new AppMain01();
                    window.frame.setVisible(true); //JFrame을 화면에 보여준다.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }//end main

    /**
     * Create the application.
     */
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame(); //JFrame 객체 생성, 필드 초기화.
        frame.setBounds(100, 100, 800, 540); //JFrame의 시작 좌표(x,y) 와 크기(가로, 세로).
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
        
        textField = new JTextField("Type....");
        textField.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 24));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("New button");
        frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
    }

}
