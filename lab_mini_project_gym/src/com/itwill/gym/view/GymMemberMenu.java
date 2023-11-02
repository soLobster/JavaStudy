package com.itwill.gym.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
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
        getMemberNameByPhone(memberPhone);
        JOptionPane.showMessageDialog(GymMemberMenu.this,  memberName+ "님 오늘도 득근하세요 ^^");
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
        setBounds(100, 100, 466, 516);
        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblMemberLabel = new JLabel(" 회원 메뉴");
        lblMemberLabel.setOpaque(true);
        lblMemberLabel.setBackground(Color.black);
        lblMemberLabel.setFont(new Font("나눔고딕", Font.BOLD, 33));
        lblMemberLabel.setForeground(Color.white);
        lblMemberLabel.setBounds(0, 0, 450, 75);
        contentPane.add(lblMemberLabel);
        
        textHelloMember = new JTextField();
        textHelloMember.setOpaque(true);
        textHelloMember.setBackground(Color.DARK_GRAY);
        textHelloMember.setHorizontalAlignment(SwingConstants.CENTER);
        textHelloMember.setEditable(false);
        textHelloMember.setFont(new Font("나눔고딕", Font.BOLD, 30));
        textHelloMember.setForeground(Color.orange);
        textHelloMember.setBounds(39, 85, 375, 67);
        textHelloMember.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(textHelloMember);
        textHelloMember.setColumns(10);
        
        btnMemInfo = new JButton("나의 정보");
        btnMemInfo.setOpaque(true);
        btnMemInfo.setBackground(Color.DARK_GRAY);
        btnMemInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //나의 정보 페이지.
                MemberInfo.showMemberInfo(GymMemberMenu.this, memberPhone,GymMemberMenu.this);
                //GymLogin에서 넘겨받은 회원의 전화번호를 토대로 일치하는 회원의 정보를 띄워야한다.
            }
        });
        btnMemInfo.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnMemInfo.setBounds(39, 162, 375, 67);
        btnMemInfo.setForeground(Color.white);
        contentPane.add(btnMemInfo);
        
        btnMembershipBuy = new JButton("피트니스 회원권 구매");
        btnMembershipBuy.setOpaque(true);
        btnMembershipBuy.setBackground(Color.DARK_GRAY);
        btnMembershipBuy.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원권 구매 페이지
                
                //위의 MemberInfo.showMemberInfo(GymMemberMenu.this, memberPhone,GymMemberMenu.this);
                // 같이 밑의 BuyMembershipPage.showBuyMembershipPage); <- 이곳에 회원의 전화번호가 넘어가
                // BuyMembershipPage에 회원의 GYM_MEMBER 테이블로 회원권 구매 정보가 넘어가야한
                BuyMembershipPage.showBuyMembershipPage(memberPhone);     
            }
        });
        btnMembershipBuy.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnMembershipBuy.setForeground(Color.white);
        btnMembershipBuy.setBounds(39, 239, 375, 67);
        contentPane.add(btnMembershipBuy);
        
        btnMemPtBuy = new JButton("PT 이용권 구매");
        btnMemPtBuy.setOpaque(true);
        btnMemPtBuy.setBackground(Color.DARK_GRAY);
        btnMemPtBuy.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pt 이용권 구매 페이지
                BuyPtPage.showBuyPtPage(memberPhone);
            }
        });
        btnMemPtBuy.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnMemPtBuy.setForeground(Color.white);
        btnMemPtBuy.setBounds(39, 316, 375, 67);
        contentPane.add(btnMemPtBuy);
        
        btnOutMenu = new JButton("뒤로가기");
        btnOutMenu.setOpaque(true);
        btnOutMenu.setBackground(Color.darkGray);
        btnOutMenu.addActionListener((e) -> dispose());
        btnOutMenu.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnOutMenu.setForeground(Color.white);
        btnOutMenu.setBounds(171, 414, 117, 41);
        contentPane.add(btnOutMenu);    
    }//initialize
    
    
    private void helloMember() { 
        getMemberNameByPhone(memberPhone);
        textHelloMember.setText(memberName + "님 환영합니다");
        //GymLogin을 통해 넘겨받은 폰번호를 통해 GymMemerdao의 read()를 불러오고 특정 회원을 찾는다
        //찾은 회원의 이름을 표시 해서 textHelloMember에 "회원의 이름" + " 님 환영합니다"를 setText를 해야한다. 
    }//end helloMember

    private void getMemberNameByPhone(String memberPhone) {
        GymMember member = dao.read(memberPhone);
        memberName = member.getName();      
    }//end getMemberNameByPhone.
    
    
}//end class
