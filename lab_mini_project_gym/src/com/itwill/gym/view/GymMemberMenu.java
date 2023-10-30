package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GymMemberMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblMemberLabel;
    private JButton btnMemInfo;
    private JButton btnMembershipBuy;
    private JButton btnMemPtBuy;
    private JButton btnOutMenu;
    private JButton btnExitGym;
    private JButton btnCheckInGym;
    private JTextField textHelloMember;
    private String memberPhone;
    private String memberName;
    private GymMemberDao dao = GymMemberDao.getInstance();
    /**
     * Launch the application.
     * @param string 
     */
    public static void showMemberMenu(String memberPhone) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymMemberMenu frame = new GymMemberMenu(memberPhone);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymMemberMenu(String memberPhone) {
        this.memberPhone = memberPhone;
        initialize();
        helloMember();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 542, 580);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblMemberLabel = new JLabel("회원 메뉴");
        lblMemberLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
        lblMemberLabel.setBounds(6, 6, 548, 48);
        contentPane.add(lblMemberLabel);
        
        textHelloMember = new JTextField();
        textHelloMember.setHorizontalAlignment(SwingConstants.CENTER);
        textHelloMember.setEditable(false);
        textHelloMember.setFont(new Font("D2Coding", Font.BOLD, 25));
        textHelloMember.setBounds(77, 64, 375, 67);
        contentPane.add(textHelloMember);
        textHelloMember.setColumns(10);
        
        btnMemInfo = new JButton("나의 정보");
        btnMemInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //나의 정보 페이지.
                MemberInfo.showMemberInfo(GymMemberMenu.this, memberPhone,GymMemberMenu.this);
                //TODO
                //GymLogin에서 넘겨받은 회원의 전화번호를 토대로 일치하는 회원의 정보를 띄워야한다.
            }
        });
        btnMemInfo.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnMemInfo.setBounds(77, 162, 375, 67);
        contentPane.add(btnMemInfo);
        
        btnMembershipBuy = new JButton("피트니스 회원권 구매 및 연장");
        btnMembershipBuy.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원권 구매 및 연장 페이지
                BuyMembershipPage.showBuyMembershipPage();
                
            }
        });
        btnMembershipBuy.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnMembershipBuy.setBounds(77, 239, 375, 67);
        contentPane.add(btnMembershipBuy);
        
        btnMemPtBuy = new JButton("PT 이용권 구매");
        btnMemPtBuy.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pt 이용권 구매 페이지
                
            }
        });
        btnMemPtBuy.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnMemPtBuy.setBounds(77, 316, 375, 67);
        contentPane.add(btnMemPtBuy);
        
        btnCheckInGym = new JButton("출석");
        btnCheckInGym.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnCheckInGym.setBounds(77, 423, 117, 83);
        contentPane.add(btnCheckInGym);
        
        btnExitGym = new JButton("퇴실");
        btnExitGym.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnExitGym.setBounds(206, 423, 117, 83);
        contentPane.add(btnExitGym);
        
        btnOutMenu = new JButton("나가기");
        btnOutMenu.addActionListener((e) -> dispose());
        btnOutMenu.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnOutMenu.setBounds(335, 423, 117, 83);
        contentPane.add(btnOutMenu);    
    }//initialize
    
    
    private void helloMember() { 
//        GymMemberDao dao = GymMemberDao.getInstance();
//        GymMember member = dao.read(string);
//        
//        System.out.println(member.getName());
//        
//        memberName = member.getName();
        
        getMemberNameByPhone(memberPhone);
        
        textHelloMember.setText(memberName + " 님 환영합니다.");
        //TODO 
        //GymLogin을 통해 넘겨받은 폰번호를 통해 GymMemerdao의 read()를 불러오고 특정 회원을 찾는다
        //찾은 회원의 이름을 표시 해서 textHelloMember에 "회원의 이름" + " 님 환영합니다"를 setText를 해야한다.
        
    }//end helloMember

    private void getMemberNameByPhone(String memberPhone) {
        //GymMemberDao dao = GymMemberDao.getInstance();
        GymMember member = dao.read(memberPhone);
        
       //System.out.println(member.getName());
        
        memberName = member.getName();
        
    }//end getMemberNameByPhone.
    
    
}//end class
