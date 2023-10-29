package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

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

    /**
     * Launch the application.
     */
    public static void showMemberMenu() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymMemberMenu frame = new GymMemberMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymMemberMenu() {
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 542, 490);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblMemberLabel = new JLabel("회원 메뉴");
        lblMemberLabel.setFont(new Font("D2Coding", Font.BOLD, 30));
        lblMemberLabel.setBounds(6, 6, 548, 48);
        contentPane.add(lblMemberLabel);
        
        btnMemInfo = new JButton("나의 정보");
        btnMemInfo.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnMemInfo.setBounds(77, 89, 375, 67);
        contentPane.add(btnMemInfo);
        
        btnMemPtBuy = new JButton("PT 이용권 구매");
        btnMemPtBuy.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnMemPtBuy.setBounds(77, 248, 375, 67);
        contentPane.add(btnMemPtBuy);
        
        btnMembershipBuy = new JButton("피트니스 회원권 구매 및 연장");
        btnMembershipBuy.setFont(new Font("D2Coding", Font.BOLD, 22));
        btnMembershipBuy.setBounds(77, 169, 375, 67);
        contentPane.add(btnMembershipBuy);
        
        btnCheckInGym = new JButton("출석");
        btnCheckInGym.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnCheckInGym.setBounds(77, 327, 117, 83);
        contentPane.add(btnCheckInGym);
        
        btnExitGym = new JButton("퇴실");
        btnExitGym.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnExitGym.setBounds(206, 327, 117, 83);
        contentPane.add(btnExitGym);
        
        btnOutMenu = new JButton("나가기");
        btnOutMenu.addActionListener((e) -> dispose());
        btnOutMenu.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnOutMenu.setBounds(335, 327, 117, 83);
        contentPane.add(btnOutMenu);
        
    }
}
