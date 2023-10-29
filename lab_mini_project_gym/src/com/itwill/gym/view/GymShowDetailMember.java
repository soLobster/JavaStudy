package com.itwill.gym.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GymShowDetailMember extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private GymMemberDao dao;
    private Component parent;
    private Integer id;
    private GymMemUpdateOrShowAll app;
    private JLabel lblMemNum;
    private JLabel lblMemName;
    private JTextField textMemNum;
    private JTextField textMemPhone;
    private JTextField textMemName;
    private JTextField textMemGender;
    private JTextField textMemAddress;
    private JLabel lblMemEnroll;
    private JLabel lblMemAddress;
    private JLabel lblMemBirthDay;
    private JLabel lblMemGender;
    private JLabel lblMemPhone;
    private JDateChooser dateMemBirthday;
    private JComboBox comboBox;
    private JLabel lblMemJoinDate;
    private JTextField textJoindate;
    private JTextField textExpireDate;
    private JLabel lblPt;
    private JComboBox comboBoxPt;
    private JLabel lblTrainer;
    private JComboBox comboBoxTrainer;
    private JButton btnUpdate;
    private JButton btnCancel;
    /**
     * Launch the application.
     * @param gymMemUpdateOrShowAll2 
     * @param id 
     * @param gymMemUpdateOrShowAll 
     */
    public static void showDetailMember(Component parent, Integer id, GymMemUpdateOrShowAll app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymShowDetailMember frame = new GymShowDetailMember(parent, id, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymShowDetailMember(Component parent, Integer id, GymMemUpdateOrShowAll app) {
        this.dao = GymMemberDao.getInstance();
        this.parent = parent;
        this.id = id;
        this.app = app;
        initialize();
        
        initMemberDetails();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 737, 647);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblMemNum = new JLabel("회원번호");
        lblMemNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemNum.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemNum.setBounds(12, 10, 108, 59);
        contentPane.add(lblMemNum);
        
        lblMemName = new JLabel("이름");
        lblMemName.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemName.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemName.setBounds(12, 79, 108, 59);
        contentPane.add(lblMemName);
        
        lblMemPhone = new JLabel("연락처");
        lblMemPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemPhone.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemPhone.setBounds(330, 10, 108, 59);
        contentPane.add(lblMemPhone);
        
        lblMemGender = new JLabel("성별");
        lblMemGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemGender.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemGender.setBounds(330, 79, 108, 59);
        contentPane.add(lblMemGender);
        
        lblMemAddress = new JLabel("주소");
        lblMemAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemAddress.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemAddress.setBounds(12, 287, 108, 59);
        contentPane.add(lblMemAddress);
        
        lblMemBirthDay = new JLabel("생년월일");
        lblMemBirthDay.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemBirthDay.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemBirthDay.setBounds(12, 148, 108, 59);
        contentPane.add(lblMemBirthDay);
        
        textMemNum = new JTextField();
        textMemNum.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textMemNum.setEditable(false);
        textMemNum.setBounds(132, 10, 181, 59);
        contentPane.add(textMemNum);
        textMemNum.setColumns(10);
        
        textMemPhone = new JTextField();
        textMemPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textMemPhone.setColumns(10);
        textMemPhone.setBounds(450, 9, 237, 59);
        contentPane.add(textMemPhone);
        
        textMemName = new JTextField();
        textMemName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textMemName.setColumns(10);
        textMemName.setBounds(132, 79, 181, 59);
        contentPane.add(textMemName);
        
        textMemGender = new JTextField();
        textMemGender.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textMemGender.setColumns(10);
        textMemGender.setBounds(450, 78, 237, 59);
        contentPane.add(textMemGender);
        
        dateMemBirthday = new JDateChooser();
        dateMemBirthday.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        dateMemBirthday.setBounds(132, 148, 181, 59);
        contentPane.add(dateMemBirthday);
        
        textMemAddress = new JTextField();
        textMemAddress.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMemAddress.setBounds(132, 286, 555, 59);
        contentPane.add(textMemAddress);
        textMemAddress.setColumns(10);
        
        lblMemEnroll = new JLabel("회원권");
        lblMemEnroll.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemEnroll.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemEnroll.setBounds(12, 356, 108, 59);
        contentPane.add(lblMemEnroll);
        
        comboBox = new JComboBox();
        comboBox.setBounds(132, 355, 555, 59);
        contentPane.add(comboBox);
        
        JLabel lblMemExpireDate = new JLabel("만료 기한");
        lblMemExpireDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemExpireDate.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemExpireDate.setBounds(330, 217, 108, 59);
        contentPane.add(lblMemExpireDate);
        
        lblMemJoinDate = new JLabel("최초 등록일");
        lblMemJoinDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemJoinDate.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblMemJoinDate.setBounds(330, 148, 108, 59);
        contentPane.add(lblMemJoinDate);
        
        textJoindate = new JTextField();
        textJoindate.setEditable(false);
        textJoindate.setFont(new Font("D2Coding", Font.PLAIN, 13));
        textJoindate.setColumns(10);
        textJoindate.setBounds(450, 148, 237, 59);
        contentPane.add(textJoindate);
        
        textExpireDate = new JTextField();
        textExpireDate.setFont(new Font("D2Coding", Font.PLAIN, 13));
        textExpireDate.setEditable(false);
        textExpireDate.setColumns(10);
        textExpireDate.setBounds(450, 216, 237, 59);
        contentPane.add(textExpireDate);
        
        lblPt = new JLabel("PT 여부");
        lblPt.setHorizontalAlignment(SwingConstants.CENTER);
        lblPt.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblPt.setBounds(12, 425, 108, 59);
        contentPane.add(lblPt);
        
        comboBoxPt = new JComboBox();
        comboBoxPt.setModel(new DefaultComboBoxModel(new String[] {"예", "아니오"}));
        comboBoxPt.setFont(new Font("D2Coding", Font.PLAIN, 20));
        comboBoxPt.setBounds(132, 424, 151, 60);
        contentPane.add(comboBoxPt);
        
        lblTrainer = new JLabel("담당 트레이너");
        lblTrainer.setHorizontalAlignment(SwingConstants.CENTER);
        lblTrainer.setFont(new Font("D2Coding", Font.BOLD, 15));
        lblTrainer.setBounds(295, 424, 143, 59);
        contentPane.add(lblTrainer);
        
        comboBoxTrainer = new JComboBox();
        comboBoxTrainer.setModel(new DefaultComboBoxModel(new String[] {"김근육", "이근육", "권근육", "강근육", "오근육", "최근육"}));
        comboBoxTrainer.setFont(new Font("D2Coding", Font.PLAIN, 20));
        comboBoxTrainer.setBounds(450, 424, 237, 60);
        contentPane.add(comboBoxTrainer);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.setFont(new Font("D2Coding", Font.BOLD, 18));
        btnUpdate.setBounds(132, 528, 157, 59);
        contentPane.add(btnUpdate);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.BOLD, 18));
        btnCancel.setBounds(419, 528, 157, 59);
        contentPane.add(btnCancel);
    }//initialize()
    
    private void initMemberDetails() {
        //DAO (컨트롤러) 메서드를 이용해서 DB에서 검색하고 , 그 결과를 보여준다.
        GymMember gymMembers = dao.read(id);
        if(gymMembers != null) {
            textMemNum.setText(gymMembers.getId().toString());
            textMemName.setText(gymMembers.getName());
            textMemPhone.setText(gymMembers.getPhone());
            textMemGender.setText(gymMembers.getGender());
            textMemAddress.setText(gymMembers.getAddress());
            dateMemBirthday.setDate(gymMembers.getBirthday());
            textJoindate.setText(gymMembers.getJoinTime().toString());
            textExpireDate.setText(gymMembers.getModefiedTime().toString());
        }   
    }//initMemberDetails

    
}//class
