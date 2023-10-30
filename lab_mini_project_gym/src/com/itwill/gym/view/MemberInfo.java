package com.itwill.gym.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MemberInfo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblMemNum;
    private JLabel lblMemName;
    private JLabel lblMemGender;
    private JLabel lblMemPhone;
    private JLabel lblMemBirh;
    private JLabel lblMemAddress;
    private JLabel lblPtMembership;
    private JLabel lblMembership;
    private JTextField textMemNum;
    private JTextField textMemName;
    private JTextField textGender;
    private JTextField textMemPhone;
    private JTextField textMemBirth;
    private JTextField textAddress;
    private JTextField textMembership;
    private JTextField textPtMembership;
    private JButton btnDetailMembershipInfo;
    private JButton btnBackPage;
    private GymMember gymMember;
    private GymMemberDao dao = GymMemberDao.getInstance();
    private GymMemberMenu app;
    private String phone;
    private Component parent;
    private String memberPhone;
    /**
     * Launch the application.
     */
    public static void showMemberInfo(Component parent,String memberPhone, GymMemberMenu app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberInfo frame = new MemberInfo(parent, memberPhone, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MemberInfo(Component parent, String memberPhone, GymMemberMenu app) {
        this.parent = parent;
        this.memberPhone = memberPhone;
        this.app = app;
        initialize();
        initPersonDetails();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 627);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblMemNum = new JLabel("회원번호");
        lblMemNum.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMemNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemNum.setBounds(12, 10, 129, 54);
        contentPane.add(lblMemNum);
        
        lblMemName = new JLabel("이 름");
        lblMemName.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemName.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMemName.setBounds(12, 74, 129, 54);
        contentPane.add(lblMemName);
        
        lblMemGender = new JLabel("성 별");
        lblMemGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemGender.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMemGender.setBounds(12, 138, 129, 54);
        contentPane.add(lblMemGender);
        
        lblMemPhone = new JLabel("연 락 처");
        lblMemPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemPhone.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMemPhone.setBounds(12, 202, 129, 54);
        contentPane.add(lblMemPhone);
        
        lblMemBirh = new JLabel("생년월일");
        lblMemBirh.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemBirh.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMemBirh.setBounds(12, 266, 129, 54);
        contentPane.add(lblMemBirh);
        
        lblMemAddress = new JLabel("주 소");
        lblMemAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblMemAddress.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMemAddress.setBounds(12, 330, 129, 54);
        contentPane.add(lblMemAddress);
        
        lblMembership = new JLabel("회원권");
        lblMembership.setHorizontalAlignment(SwingConstants.CENTER);
        lblMembership.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblMembership.setBounds(12, 394, 129, 54);
        contentPane.add(lblMembership);
        
        lblPtMembership = new JLabel("PT 여부");
        lblPtMembership.setHorizontalAlignment(SwingConstants.CENTER);
        lblPtMembership.setFont(new Font("D2Coding", Font.PLAIN, 15));
        lblPtMembership.setBounds(12, 458, 129, 54);
        contentPane.add(lblPtMembership);
        
        textMemNum = new JTextField();
        textMemNum.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMemNum.setEditable(false);
        textMemNum.setBounds(153, 10, 160, 54);
        contentPane.add(textMemNum);
        textMemNum.setColumns(10);
        
        textMemName = new JTextField();
        textMemName.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMemName.setEditable(false);
        textMemName.setColumns(10);
        textMemName.setBounds(153, 74, 160, 54);
        contentPane.add(textMemName);
        
        textGender = new JTextField();
        textGender.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textGender.setEditable(false);
        textGender.setColumns(10);
        textGender.setBounds(153, 138, 160, 54);
        contentPane.add(textGender);
        
        textMemPhone = new JTextField();
        textMemPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMemPhone.setEditable(false);
        textMemPhone.setColumns(10);
        textMemPhone.setBounds(153, 202, 160, 54);
        contentPane.add(textMemPhone);
        
        textMemBirth = new JTextField();
        textMemBirth.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMemBirth.setEditable(false);
        textMemBirth.setColumns(10);
        textMemBirth.setBounds(153, 266, 160, 54);
        contentPane.add(textMemBirth);
        
        textAddress = new JTextField();
        textAddress.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textAddress.setEditable(false);
        textAddress.setColumns(10);
        textAddress.setBounds(153, 330, 405, 54);
        contentPane.add(textAddress);
        
        textMembership = new JTextField();
        textMembership.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMembership.setEditable(false);
        textMembership.setColumns(10);
        textMembership.setBounds(153, 394, 405, 54);
        contentPane.add(textMembership);
        
        textPtMembership = new JTextField();
        textPtMembership.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textPtMembership.setEditable(false);
        textPtMembership.setColumns(10);
        textPtMembership.setBounds(153, 458, 405, 54);
        contentPane.add(textPtMembership);
        
        btnDetailMembershipInfo = new JButton("회원권 및 PT 상세보기");
        btnDetailMembershipInfo.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnDetailMembershipInfo.setBounds(40, 539, 232, 39);
        contentPane.add(btnDetailMembershipInfo);
        
        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnBackPage.setBounds(429, 539, 129, 39);
        contentPane.add(btnBackPage);
    }//end initialize
    
    private void initPersonDetails() {
        GymMember gymMember = dao.read(memberPhone);
        if(gymMember !=null) {
            textMemNum.setText(gymMember.getId().toString());
            textMemName.setText(gymMember.getName());
            textMemPhone.setText(gymMember.getPhone());
            textMemBirth.setText(gymMember.getBirthday().toString());
            textAddress.setText(gymMember.getAddress());
            textGender.setText(gymMember.getGender());
            
        }
    }//initPersonDetails
    
}//end class
