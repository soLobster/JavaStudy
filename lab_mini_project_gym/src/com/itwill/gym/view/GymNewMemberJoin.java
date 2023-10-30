package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.awt.event.ActionEvent;



public class GymNewMemberJoin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblMemberJoin;
    private JLabel lblMemName;
    private JLabel lblMemGender;
    private JLabel lblMemPhoneNum;
    private JLabel lblMemBirthDate;
    private JTextField textMemName;
    private JTextField textPhoneNum;
    private JTextField textGender;
    private JButton btnConfirm;
    private JDateChooser memBirthDateChooser;
    private JScrollPane scrollPane;
    private JTextArea textMemAddress;

    private GymMemberDao dao = GymMemberDao.getInstance();
    
    /**
     * Launch the application.
     */
    public static void showGymNewMemberJoin() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymNewMemberJoin frame = new GymNewMemberJoin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymNewMemberJoin() {
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 451, 485);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblMemberJoin = new JLabel("회원가입");
        lblMemberJoin.setFont(new Font("D2Coding", Font.BOLD, 29));
        lblMemberJoin.setBounds(12, 10, 411, 53);
        contentPane.add(lblMemberJoin);
        
        lblMemName = new JLabel("이름");
        lblMemName.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblMemName.setBounds(12, 68, 101, 53);
        contentPane.add(lblMemName);
        
        lblMemPhoneNum = new JLabel("연락처");
        lblMemPhoneNum.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblMemPhoneNum.setBounds(12, 131, 101, 53);
        contentPane.add(lblMemPhoneNum);
        
        lblMemGender = new JLabel("성별");
        lblMemGender.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblMemGender.setBounds(12, 194, 101, 53);
        contentPane.add(lblMemGender);
        
        lblMemBirthDate = new JLabel("생년월일");
        lblMemBirthDate.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblMemBirthDate.setBounds(12, 257, 101, 53);
        contentPane.add(lblMemBirthDate);
        
        JLabel lblMemAddress = new JLabel("주소");
        lblMemAddress.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblMemAddress.setBounds(12, 320, 101, 53);
        contentPane.add(lblMemAddress);
        
        textMemName = new JTextField();
        textMemName.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMemName.setBounds(125, 73, 283, 40);
        contentPane.add(textMemName);
        textMemName.setColumns(10);
        
        textPhoneNum = new JTextField();
        textPhoneNum.setText("'-'는 빼고 입력해주세요.");
        textPhoneNum.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textPhoneNum.setColumns(10);
        textPhoneNum.setBounds(125, 131, 283, 40);
        textPhoneNum.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // 포커스를 얻었을 때, 힌트 텍스트 지우기
                if (textPhoneNum.getText().equals("'-'는 빼고 입력해주세요.")) {
                    textPhoneNum.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // 포커스를 잃었을 때, 힌트 텍스트 다시 설정
                if (textPhoneNum.getText().isEmpty()) {
                    textPhoneNum.setText("'-'는 빼고 입력해주세요.");
                }
            }
        });
        contentPane.add(textPhoneNum);
        
        textGender = new JTextField();
        textGender.setText("'남' 또는 '여' 로 입력해주세요.");
        textGender.setFont(new Font("D2Coding", Font.PLAIN, 17));
        textGender.setColumns(10);
        textGender.setBounds(125, 194, 283, 40);
        textGender.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                if (textGender.getText().equals("'남' 또는 '여' 로 입력해주세요.")) {
                    textGender.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (textGender.getText().isEmpty()) {
                    textGender.setText("'남' 또는 '여' 로 입력해주세요.");
                }
            }
        });
        contentPane.add(textGender);
        
        //java.util.Date....
        memBirthDateChooser = new JDateChooser();
        memBirthDateChooser.getCalendarButton().setFont(new Font("D2Coding", Font.PLAIN, 16));
        memBirthDateChooser.setBounds(125, 257, 283, 40);
        contentPane.add(memBirthDateChooser);
        
        btnConfirm = new JButton("가입");
        btnConfirm.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 가입.
                createNewMemberJoin();
                
            }
        });
        btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnConfirm.setBounds(75, 388, 101, 38);
        contentPane.add(btnConfirm);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener((e)->dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnCancel.setBounds(255, 388, 101, 38);
        contentPane.add(btnCancel);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(125, 320, 283, 41);
        contentPane.add(scrollPane);
        
        textMemAddress = new JTextArea();
        textMemAddress.setFont(new Font("D2Coding", Font.BOLD, 18));
        scrollPane.setViewportView(textMemAddress);
    }

    private void createNewMemberJoin() {
        // 이름, 폰번호, 성별, 생년월일, 주소에 입력된 내용을 읽고 DB에 Insert 한다.
        // GymMember 객체를 생성해서, DAO 메서드를 사용해서 DB에 삽입.
        String name = textMemName.getText();
        String phone = textPhoneNum.getText();
        String gender = textGender.getText();
        
        //Java.util.date -> java.sql.date 변환. (강제 형변환은 오류)..
        java.util.Date utilDate = memBirthDateChooser.getDate();
        Date birthday = (utilDate != null) ? new java.sql.Date(utilDate.getTime()) : null;
        
        String address = textMemAddress.getText();
        
        if(name.equals("") || phone.equals("") || gender.equals("") || birthday==null || address.equals("")) {
            JOptionPane.showMessageDialog(GymNewMemberJoin.this, "이름, 연락처, 성별, 생년월일, 주소는 반드시 입력되어야 합니다.");
            return;
        }
        GymMember gymMember = new GymMember(null, name, phone, gender, birthday, address, null, null, null, null, null);
        int result = dao.create(gymMember);
        
        if(result == 1) {
            JOptionPane.showMessageDialog(GymNewMemberJoin.this, "회원 가입 성공...!!");
            dispose();
        }
        
    }//end createNewMemberJoin()
    
}//end class
