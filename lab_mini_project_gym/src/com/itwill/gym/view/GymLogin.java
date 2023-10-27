package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GymLogin {

    private JFrame frame;
    private JTextField memberNumField;
    private JTextField confirmedMember;
    private JButton btnOne;
    private JButton btnTwo;
    private JButton btnThree;
    private JButton btnFour;
    private JButton btnFive;
    private JButton btnSix;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnNine;
    private JButton btnZero;
    private JButton btnConfirm;
    private JButton btnCancel;
    private JButton btnManager;
    private JButton btnGymEnter;
    private JLabel lblMemNumInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymLogin window = new GymLogin();
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
    public GymLogin() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("ITWILL_FITNESS");
        frame.setBounds(100, 100, 662, 825);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("ITWILL FITNESS에 \r\n오신걸 환영합니다");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("D2Coding", Font.BOLD, 30));
        lblWelcome.setBounds(12, 10, 622, 85);
        frame.getContentPane().add(lblWelcome);

        memberNumField = new JTextField();
        memberNumField.setHorizontalAlignment(SwingConstants.CENTER);
        memberNumField.setFont(new Font("D2Coding", Font.PLAIN, 40));
        memberNumField.setEditable(false);
        memberNumField.setBounds(166, 171, 420, 85);
        frame.getContentPane().add(memberNumField);
        memberNumField.setColumns(10);

        confirmedMember = new JTextField();
        confirmedMember.setFont(new Font("D2Coding", Font.PLAIN, 20));
        confirmedMember.setEditable(false);
        confirmedMember.setBounds(166, 266, 420, 46);
        frame.getContentPane().add(confirmedMember);
        confirmedMember.setColumns(10);

        btnOne = new JButton("1");
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "1";
                memberNumField.setText(currentText);
            }
        });
        btnOne.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnOne.setBounds(166, 322, 132, 99);
        frame.getContentPane().add(btnOne);

        btnTwo = new JButton("2");
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "2";
                memberNumField.setText(currentText);
            }
        });
        btnTwo.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnTwo.setBounds(310, 322, 132, 99);
        frame.getContentPane().add(btnTwo);

        btnThree = new JButton("3");
        btnThree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "3";
                memberNumField.setText(currentText);
            }
        });
        btnThree.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnThree.setBounds(454, 322, 132, 99);
        frame.getContentPane().add(btnThree);

        btnFour = new JButton("4");
        btnFour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "4";
                memberNumField.setText(currentText);
            }
        });
        btnFour.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnFour.setBounds(166, 431, 132, 99);
        frame.getContentPane().add(btnFour);

        btnFive = new JButton("5");
        btnFive.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "5";
                memberNumField.setText(currentText);
            }
        });
        btnFive.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnFive.setBounds(310, 431, 132, 99);
        frame.getContentPane().add(btnFive);

        btnSix = new JButton("6");
        btnSix.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "6";
                memberNumField.setText(currentText);
            }
        });
        btnSix.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnSix.setBounds(454, 431, 132, 99);
        frame.getContentPane().add(btnSix);

        btnSeven = new JButton("7");
        btnSeven.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "7";
                memberNumField.setText(currentText);
            }
        });
        btnSeven.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnSeven.setBounds(166, 540, 132, 99);
        frame.getContentPane().add(btnSeven);

        btnEight = new JButton("8");
        btnEight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "8";
                memberNumField.setText(currentText);
            }
        });
        btnEight.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnEight.setBounds(310, 540, 132, 99);
        frame.getContentPane().add(btnEight);

        btnNine = new JButton("9");
        btnNine.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "9";
                memberNumField.setText(currentText);
            }
        });
        btnNine.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnNine.setBounds(454, 540, 132, 99);
        frame.getContentPane().add(btnNine);

        btnZero = new JButton("0");
        btnZero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = memberNumField.getText();
                currentText += "0";
                memberNumField.setText(currentText);
            }
        });
        btnZero.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnZero.setBounds(310, 649, 132, 99);
        frame.getContentPane().add(btnZero);

        btnConfirm = new JButton("확인");
        btnConfirm.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 확인을 누르면 리스트에 담겨 있는 고객 정보와 비교후 true or false 를 리턴.
                // confirmedMember = new JTextField();에 정보를 넘긴다.
            }
        });
        btnConfirm.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnConfirm.setBounds(166, 649, 132, 99);
        frame.getContentPane().add(btnConfirm);

        btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               memberNumField.setText("");
            }
        });
        btnCancel.setFont(new Font("D2Coding", Font.BOLD, 30));
        btnCancel.setBounds(454, 649, 132, 99);
        frame.getContentPane().add(btnCancel);

        btnManager = new JButton("관리자메뉴");
        btnManager.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원번호 '0000'을 입력하면 관리자 메뉴로 넘어간다.
                // 새로운 프레임을 만들어야함.
                if(memberNumField.getText().equals("0000")) {
                    GymManagerView.showGymManagerView();
                } else {
                    JOptionPane.showMessageDialog(frame, "관리자 번호가 아닙니다.");
                }
                
            }
        });
        btnManager.setFont(new Font("D2Coding", Font.BOLD, 18));
        btnManager.setBounds(22, 271, 132, 99);
        frame.getContentPane().add(btnManager);

        btnGymEnter = new JButton("입장");
        btnGymEnter.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 창으로 넘어간다.
                
            }
        });
        btnGymEnter.setFont(new Font("D2Coding", Font.BOLD, 40));
        btnGymEnter.setBounds(23, 117, 132, 141);
        frame.getContentPane().add(btnGymEnter);
        
        lblMemNumInfo = new JLabel("회원번호는 회원의 전화번호입니다.");
        lblMemNumInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemNumInfo.setFont(new Font("D2Coding", Font.BOLD, 22));
        lblMemNumInfo.setBounds(166, 117, 420, 44);
        frame.getContentPane().add(lblMemNumInfo);
    }

}
