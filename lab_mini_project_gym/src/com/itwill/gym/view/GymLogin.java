package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
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
        confirmedMember.setText("회원 확인을 먼저 해주세요...!");
        confirmedMember.setHorizontalAlignment(SwingConstants.CENTER);
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
                comfirmedMember();
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
               confirmedMember.setText("회원 확인을 먼저 해주세요...!");
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
                /* 
                 * comfirmedMember() method 를 통해 회원 확인이 되었을 때 입장 버튼을 누르면 회원 정보 메뉴로 넘어간다
                 */
                
                boolean isConfirmed = comfirmedMember();
                
                if(isConfirmed) {
                    String inputMemberPhoneName = memberNumField.getText();
                    GymMemberDao dao = GymMemberDao.getInstance();
                    GymMember gymMembers = dao.read(inputMemberPhoneName);
                    
                    //System.out.println(gymMembers.getPhone());
                    
                    String memberPhone = gymMembers.getPhone();
                    
                    GymMemberMenu.showMemberMenu(memberPhone);
                    //TODO 
                    //회원의 전화번호를 GymMemberMenu.showMemberMenu로 넘겨야한다.
                    //그래야 showMemberMenu에서 회원의 전화번호를 통해 회원의 정보를 db 테이블에서 넘겨받을 수 있다.
                }
                
                if(!isConfirmed) {
                    JOptionPane.showMessageDialog(frame, "회원 확인이 완료되지 않았습니다.");
                }
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
    }//initialize

    private boolean comfirmedMember() {
        // Gym_Member DB에 저장되어 있는 회원의 전화번호와 memberNumField에 입력된 회원 전화번호를 비교해서
        // 일치하면 true를 리턴하고 confirmedMember JTextArea에 '회원 확인 되었습니다' 라고 표시.
        // 불일치하면 false를 리턴하고 confirmedMember JTextTArea에 '일치하지 않는 회원전화번호입니다' 라고 표시.
        
        // String 타입의 객체를 생성 이것은 memberNumField에 입력된 정보를 불러옴 
        String inputMemberPhoneNum = memberNumField.getText();
        // GymMemberDao 객체 싱글톤. 저장된 List에서 read()를 통해 데이터베이스를 불러옴.
        GymMemberDao memberDao = GymMemberDao.getInstance();
        List<GymMember> gymMembers = memberDao.read();
        
        
        // 불린 타입 변수를 선언.
        boolean isMemberConfirmed = false;
         
        for(GymMember member : gymMembers) {
            if(inputMemberPhoneNum.equals(member.getPhone())) {
                isMemberConfirmed = true;
                confirmedMember.setText("회원 확인 되었습니다....!");
                break;
            }
        }
        
        if (!isMemberConfirmed) {
            confirmedMember.setText("일치하지 않는 회원 전화번호입니다");
        }
    
        //회원인지 아닌지 boolean값을 반환한다.
        return isMemberConfirmed;
        
    }//end confirmedMember().

}//end class
