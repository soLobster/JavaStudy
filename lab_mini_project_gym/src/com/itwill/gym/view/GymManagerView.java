package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
    private JButton btnCancel;
    private GymMemberDao dao = GymMemberDao.getInstance();
    
    
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
        setBounds(100, 100, 513, 434);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblManagerInfo = new JLabel("관리자 메뉴");
        lblManagerInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagerInfo.setFont(new Font("D2Coding", Font.BOLD, 23));
        lblManagerInfo.setBounds(0, 10, 503, 78);
        contentPane.add(lblManagerInfo);
        
        btnNewMemberJoin = new JButton("회원가입");
        btnNewMemberJoin.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 가입 frame으로 넘어간다.
                GymNewMemberJoin.showGymNewMemberJoin();
            }
        });
        btnNewMemberJoin.setFont(new Font("D2Coding", Font.BOLD, 26));
        btnNewMemberJoin.setBounds(102, 98, 299, 96);
        contentPane.add(btnNewMemberJoin);
        
        btnMemUpOrShow = new JButton("회원 정보 조회 및 수정");
        btnMemUpOrShow.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 조회 및 수정 frame으로 넘어간다.
                GymMemUpdateOrShowAll.memUpdateOrShowAll();
            }
        });
        btnMemUpOrShow.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMemUpOrShow.setBounds(102, 204, 299, 96);
        contentPane.add(btnMemUpOrShow);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e)->dispose());
        btnCancel.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnCancel.setBounds(186, 330, 123, 39);
        contentPane.add(btnCancel);   
    }//end initialize() 

//    private void resetTableModel(List<GymMember> list) {
//        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
//    }
//    
//    private void initTable() {
//        List<GymMember> gymMember = dao.read();
//        resetTabl
//    }
//    
//    public void notifyGymMemberCreated() {
//        initTa
//    }
    
}//end class
