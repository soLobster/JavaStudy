package com.itwill.gym.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class GymManagerView extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblManagerInfo;
    private JButton btnMemUpOrShow;
    private JButton btnNewMemberJoin;
    private JButton btnBackPage;
    private GymMemberDao dao = GymMemberDao.getInstance();
    private JButton btnTrainerList;
    private JButton btnMembershipList;
    private JButton btnPtList;
    
    
    /**
     * Launch the application.
     */
    public static void showGymManagerView() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymManagerView frame = new GymManagerView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymManagerView() {
        initialize();
    }
    
    
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 427, 741);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.DARK_GRAY);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblManagerInfo = new JLabel("관리자 메뉴");
        lblManagerInfo.setOpaque(true);
        lblManagerInfo.setBackground(Color.black);
        lblManagerInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagerInfo.setFont(new Font("나눔고딕", Font.BOLD, 40));
        lblManagerInfo.setForeground(Color.white);
        lblManagerInfo.setBounds(0, 0, 411, 88);
        contentPane.add(lblManagerInfo);
        
        btnNewMemberJoin = new JButton("신규회원가입");
        btnNewMemberJoin.setOpaque(true);
        btnNewMemberJoin.setBackground(Color.darkGray);
        btnNewMemberJoin.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 가입 frame으로 넘어간다.
                GymNewMemberJoin.showGymNewMemberJoin();
            }
        });
        btnNewMemberJoin.setFont(new Font("나눔고딕", Font.BOLD, 26));
        btnNewMemberJoin.setForeground(Color.white);
        btnNewMemberJoin.setBounds(56, 98, 299, 96);
        contentPane.add(btnNewMemberJoin);
        
        btnMemUpOrShow = new JButton("회원 정보 조회 및 수정");
        btnMemUpOrShow.setOpaque(true);
        btnMemUpOrShow.setBackground(Color.darkGray);
        btnMemUpOrShow.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 조회 및 수정 frame으로 넘어간다.
                GymMemUpdateOrShowAll.memUpdateOrShowAll();
            }
        });
        btnMemUpOrShow.setFont(new Font("나눔고딕", Font.BOLD, 26));
        btnMemUpOrShow.setForeground(Color.white);
        btnMemUpOrShow.setBounds(56, 204, 299, 96);
        contentPane.add(btnMemUpOrShow);
        
        btnBackPage = new JButton("뒤로가기");
        btnBackPage.setOpaque(true);
        btnBackPage.setBackground(Color.darkGray);
        btnBackPage.addActionListener((e)->dispose());
        btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnBackPage.setForeground(Color.WHITE);
        btnBackPage.setBounds(143, 642, 123, 39);
        contentPane.add(btnBackPage);   
        
        btnTrainerList = new JButton("직원 관리");
        btnTrainerList.setOpaque(true);
        btnTrainerList.setBackground(Color.darkGray);
        btnTrainerList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 트레이너 관리 frame 으로 넘어간다.
                GymTrainUpdateOrShow.showGymTrainUpdateOrShow();
            }
        });
        btnTrainerList.setFont(new Font("나눔고딕", Font.BOLD, 26));
        btnTrainerList.setForeground(Color.white);
        btnTrainerList.setBounds(56, 310, 299, 96);
        contentPane.add(btnTrainerList);
        
        btnMembershipList = new JButton("회원권 관리");
        btnMembershipList.setOpaque(true);
        btnMembershipList.setBackground(Color.DARK_GRAY);
        btnMembershipList.setFont(new Font("나눔고딕", Font.BOLD, 26));
        btnMembershipList.setForeground(Color.white);
        btnMembershipList.setBounds(56, 416, 299, 96);
        contentPane.add(btnMembershipList);
        
        btnPtList = new JButton("PT 이용권 관리");
        btnPtList.setOpaque(true);
        btnPtList.setBackground(Color.DARK_GRAY);
        btnPtList.setFont(new Font("나눔고딕", Font.BOLD, 26));
        btnPtList.setForeground(Color.white);
        btnPtList.setBounds(56, 522, 299, 96);
        contentPane.add(btnPtList);
    }//end initialize()
}//end class
