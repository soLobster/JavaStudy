package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class AppMain03 {

    private JFrame frame;
    private JTextField textInputNum1;
    private JTextField textInputNum2;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JTextArea textResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 460, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNumber1 = new JLabel("NUM 1");
        lblNumber1.setOpaque(true);
        lblNumber1.setBackground(new Color(255, 192, 203));
        lblNumber1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber1.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        lblNumber1.setBounds(12, 75, 140, 55);
        frame.getContentPane().add(lblNumber1);
        
        JLabel lblNumber2 = new JLabel("NUM 2");
        lblNumber2.setOpaque(true);
        lblNumber2.setBackground(new Color(255, 192, 203));
        lblNumber2.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 18));
        lblNumber2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber2.setBounds(12, 172, 140, 55);
        frame.getContentPane().add(lblNumber2);
        
        textInputNum1 = new JTextField();
        textInputNum1.setBackground(new Color(255, 218, 185));
        textInputNum1.setHorizontalAlignment(SwingConstants.CENTER);
        textInputNum1.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        textInputNum1.setBounds(164, 75, 268, 55);
        frame.getContentPane().add(textInputNum1);
        textInputNum1.setColumns(10);
        
        textInputNum2 = new JTextField();
        textInputNum2.setBackground(new Color(255, 218, 185));
        textInputNum2.setHorizontalAlignment(SwingConstants.CENTER);
        textInputNum2.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        textInputNum2.setColumns(10);
        textInputNum2.setBounds(164, 172, 268, 55);
        frame.getContentPane().add(textInputNum2);
        
        btnPlus = new JButton("+");
        btnPlus.setOpaque(true);
        btnPlus.setBackground(Color.CYAN);
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleBtnClick(e);
            }
        });
        btnPlus.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 17));
        btnPlus.setBounds(12, 247, 97, 55);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.setOpaque(true);
        btnMinus.setBackground(Color.CYAN);
        btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleBtnClick(e);
            }
        });
        btnMinus.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        btnMinus.setBounds(120, 247, 97, 55);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.setOpaque(true);
        btnMultiply.setBackground(Color.CYAN);
        btnMultiply.addActionListener(this::handleBtnClick);
        btnMultiply.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        btnMultiply.setBounds(226, 247, 97, 55);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.setOpaque(true);
        btnDivide.setBackground(Color.CYAN);
        btnDivide.addActionListener((e) -> handleBtnClick(e));
        btnDivide.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        btnDivide.setBounds(335, 247, 97, 55);
        frame.getContentPane().add(btnDivide);
        
        textResult = new JTextArea();
        textResult.setBackground(new Color(255, 255, 255));
        textResult.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 18));
        textResult.setBounds(56, 342, 343, 179);
        frame.getContentPane().add(textResult);
    }

    protected void handleDivideBtnClick() {
        String num1 = textInputNum1.getText();
        String num2 = textInputNum2.getText();
        
        try {
            int intNum1 = Integer.parseInt(num1);
            int intNum2 = Integer.parseInt(num2);
            
            int result = intNum1 / intNum2;
            
            textResult.setText(Integer.toString(result));
            
            textInputNum1.setText("");
            textInputNum2.setText("");
        } catch (NumberFormatException e) {     
            textResult.setText("숫자를 입력해주세요...!");        
            textInputNum1.setText("");
            textInputNum2.setText("");
        }
    }

    protected void handleMultiplyBtnClick() {
        String num1 = textInputNum1.getText();
        String num2 = textInputNum2.getText();
        
        try {
            int intNum1 = Integer.parseInt(num1);
            int intNum2 = Integer.parseInt(num2);
            
            int result = intNum1 * intNum2;
            
            textResult.setText(Integer.toString(result));
            
            textInputNum1.setText("");
            textInputNum2.setText("");
        } catch (NumberFormatException e) {
            textResult.setText("숫자를 입력해주세요...!");    
            textInputNum1.setText("");
            textInputNum2.setText("");
         
        }
    }

    protected void handleMinusBtnClick() {
        String num1 = textInputNum1.getText();
        String num2 = textInputNum2.getText();
        
        try {
            int intNum1 = Integer.parseInt(num1);
            int intNum2 = Integer.parseInt(num2);
            
            int result = intNum1 - intNum2;
            
            textResult.setText(Integer.toString(result));
            
            textInputNum1.setText("");
            textInputNum2.setText("");
        } catch (NumberFormatException e) {
            textResult.setText("숫자를 입력해주세요...!");    
            textInputNum1.setText("");
            textInputNum2.setText("");
           
        }
    }

    protected void handleBtnClick(ActionEvent event) {
//        System.out.println(e.getSource());
        // -> 아규먼트 ActionEvent 객체에서 이벤트가 발생된 GUI 컴포넌트 정보를 알 수 있음.
        
        // JTextField에 입력된 문자열 -> 숫자 변환 -> 버튼 종류에 따라서 사칙연산 -> JTextArea 출력한다.
        double number1 = 0; // 지역변수는 선언하면서 초기화를 해주는것이 좋다.
        double number2 = 0;
        try {
            
            number1 = Double.parseDouble(textInputNum1.getText());
            number2 = Double.parseDouble(textInputNum2.getText());
            
        } catch (NumberFormatException ex) {
            textResult.setText("number1 또는 number2는 숫자여야 합니다.");
            return; // 메서드 종료
        }
        
        double result = 0; // 사칙연산의 결과를 저장할 변수.
        String op = ""; // 사칙연산 연산자 문자열(+,-,*,/)을 저장할 변수.
        
        Object source = event.getSource(); // 이벤트가 발생한 객체(컴포넌트)
        if(source == btnPlus) { //equals가 아니다 주소값을 비교한것임.
            result = number1 + number2;
            op = "+";
        } else if(source == btnMinus) {
            result = number1 - number2;
            op = "-";
        } else if(source == btnMultiply) {
            result = number1 * number2;
            op = "x";
        } else {
            result = number1 / number2;
            op = "/";
        }
        
        String msg = String.format("%f %s %f = %f" ,
                number1, op, number2, result);
        
        textResult.setText(msg);
        
//        String num1 = textInputNum1.getText();
//        String num2 = textInputNum2.getText();
//        
//        try {
//            int intNum1 = Integer.parseInt(num1);
//            int intNum2 = Integer.parseInt(num2);
//            
//            int result = intNum1 + intNum2;
//            
//            textResult.setText(Integer.toString(result));
//            
//            textInputNum1.setText("");
//            textInputNum2.setText("");
//        } catch (NumberFormatException e1) {
//            
//            textResult.setText("숫자를 입력해주세요...!");    
//            textInputNum1.setText("");
//            textInputNum2.setText("");
//        }
    }
}
