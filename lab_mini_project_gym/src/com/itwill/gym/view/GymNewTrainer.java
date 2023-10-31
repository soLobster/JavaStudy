package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymTrainerDao;
import com.itwill.gym.model.GymTrainer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class GymNewTrainer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    
    private JLabel lblNewTrainer;
    private JLabel lblTrainName;
    private JLabel lblTrainGender;
    private JLabel lblTrainPhoneNum;
    private JTextField textName;
    private JTextField textGender;
    private JTextField textPhoneNum;
    private JTextField textEmail;
    private JLabel lblTrainEmail;
    private JDateChooser dateBirth;
    private JLabel lblTrainBirth;
    private JDateChooser dateHire;
    private JLabel lblTrainHireDate;
    private JLabel lblTrainAddress;
    private JTextField textAddress;
    private JLabel lblTrainSal;
    private JTextField textSalary;
    private JButton btnHire;
    private JButton btnCancel;
    
    private GymTrainerDao dao = GymTrainerDao.getInstance();
    private JLabel lblTrainNum;
    private JTextField textTrainNum;
    /**
     * Launch the application.
     */
    public static void addNewTrainer() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymNewTrainer frame = new GymNewTrainer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymNewTrainer() {
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 549, 748);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNewTrainer = new JLabel("신규 직원");
        lblNewTrainer.setFont(new Font("D2Coding", Font.BOLD, 30));
        lblNewTrainer.setBounds(12, 10, 509, 67);
        contentPane.add(lblNewTrainer);
        
        lblTrainName = new JLabel("이름");
        lblTrainName.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainName.setBounds(12, 148, 90, 60);
        contentPane.add(lblTrainName);
        
        lblTrainPhoneNum = new JLabel("연락처");
        lblTrainPhoneNum.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainPhoneNum.setBounds(12, 218, 90, 60);
        contentPane.add(lblTrainPhoneNum);
        
        lblTrainGender = new JLabel("성별");
        lblTrainGender.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainGender.setBounds(260, 148, 90, 60);
        contentPane.add(lblTrainGender);
        
        lblTrainEmail = new JLabel("이메일");
        lblTrainEmail.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainEmail.setBounds(12, 288, 90, 60);
        contentPane.add(lblTrainEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.BOLD, 16));
        textName.setBounds(102, 150, 135, 58);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textGender = new JTextField();
        textGender.setText("'남' or '여'");
        textGender.setFont(new Font("D2Coding", Font.BOLD, 16));
        textGender.setColumns(10);
        textGender.setBounds(362, 150, 135, 58);
        textGender.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                if(textGender.getText().equals("'남' or '여'")) {
                    textGender.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
               if(textGender.getText().isEmpty()) {
                   textGender.setText("'남' or '여'");
               }
            }
        });
        contentPane.add(textGender);
        
        textPhoneNum = new JTextField();
        textPhoneNum.setFont(new Font("D2Coding", Font.BOLD, 18));
        textPhoneNum.setText("'-'는 빼고 입력해주세요.");
        textPhoneNum.setColumns(10);
        textPhoneNum.setBounds(102, 219, 248, 58);
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
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textEmail.setColumns(10);
        textEmail.setBounds(102, 289, 405, 58);
        contentPane.add(textEmail);
        
        lblTrainBirth = new JLabel("생년월일");
        lblTrainBirth.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainBirth.setBounds(12, 358, 90, 60);
        contentPane.add(lblTrainBirth);
        
        dateBirth = new JDateChooser();
        dateBirth.setBounds(102, 358, 248, 60);
        contentPane.add(dateBirth);
        
        lblTrainHireDate = new JLabel("입사날짜");
        lblTrainHireDate.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainHireDate.setBounds(12, 428, 90, 60);
        contentPane.add(lblTrainHireDate);
        
        dateHire = new JDateChooser();
        dateHire.setBounds(102, 428, 248, 60);
        contentPane.add(dateHire);
        
        lblTrainAddress = new JLabel("주소");
        lblTrainAddress.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainAddress.setBounds(12, 498, 90, 60);
        contentPane.add(lblTrainAddress);
        
        textAddress = new JTextField();
        textAddress.setFont(new Font("D2Coding", Font.PLAIN, 14));
        textAddress.setColumns(10);
        textAddress.setBounds(102, 501, 405, 58);
        contentPane.add(textAddress);
        
        lblTrainSal = new JLabel("급여");
        lblTrainSal.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainSal.setBounds(12, 568, 90, 60);
        contentPane.add(lblTrainSal);
        
        textSalary = new JTextField();
        textSalary.setFont(new Font("D2Coding", Font.BOLD, 18));
        textSalary.setColumns(10);
        textSalary.setBounds(102, 569, 248, 58);
        contentPane.add(textSalary);
        
        btnHire = new JButton("추가");
        btnHire.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 직원 고용
                hireNewTrainer();
                
            }
        });
        btnHire.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnHire.setBounds(102, 638, 135, 61);
        contentPane.add(btnHire);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnCancel.setBounds(301, 638, 135, 61);
        contentPane.add(btnCancel);
        
        lblTrainNum = new JLabel("직원번호");
        lblTrainNum.setFont(new Font("D2Coding", Font.BOLD, 20));
        lblTrainNum.setBounds(12, 78, 90, 60);
        contentPane.add(lblTrainNum);
        
        textTrainNum = new JTextField();
        textTrainNum.setFont(new Font("D2Coding", Font.BOLD, 16));
        textTrainNum.setColumns(10);
        textTrainNum.setBounds(102, 78, 135, 58);
        contentPane.add(textTrainNum);
    }

    private void hireNewTrainer() {
        // 이름, 연락처, 성별, 생년월일, 이메일, 입사날짜, 주소, 급여에 입력된 내용을 읽고 DB에 Insert한다.
        // GymTrainer 객체를 생성해서, DAO 메서드를 사용해서 DB에 삽입.
        int t_id = Integer.parseInt(textTrainNum.getText());
        String t_name = textName.getText();
        String t_phone = textPhoneNum.getText();
        String t_gender = textGender.getText();
        String t_email = textEmail.getText();
        
        java.util.Date utilBirthDate = dateBirth.getDate();
        Date birthday = (utilBirthDate != null) ? new java.sql.Date(utilBirthDate.getTime()) : null;
        
        java.util.Date utilHireDate = dateHire.getDate();
        Date hiredate = (utilHireDate != null) ? new java.sql.Date(utilHireDate.getTime()) : null;
        
        String t_address = textAddress.getText();
        
        int t_salary = Integer.parseInt(textSalary.getText());
        
        if(t_id == 0 || t_name.equals("") || t_phone.equals("") || t_gender.equals("") || birthday==null || hiredate==null || t_address.equals("") || t_salary == 0) {
            JOptionPane.showMessageDialog(GymNewTrainer.this, "모든 정보는 반드시 입력되어야 합니다.");
            return;
        }
        
        GymTrainer gymTrainer = new GymTrainer(t_id, t_name, t_phone, t_gender, t_email, t_salary, birthday, hiredate, t_address);
        int result = dao.create(gymTrainer);
        
        if(result == 1) {
            JOptionPane.showMessageDialog(GymNewTrainer.this, "새 직원 고용 완료....!");
            dispose();
        }
    }//end hireNewTrainer().
    
}//end class.
