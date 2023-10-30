package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itwill.gym.model.Membership;
import com.itwill.gym.controller.MembershipDao;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyMembershipPage extends JFrame {

    
    public static final String[] COLUMN_NAMES = {"상품 코드","카테고리","금액"};
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JLabel lblBuyMembership;
    private JTable tableMembership;
    private JButton btnBuy;
    private JButton btnBackPage;
    private DefaultTableModel tableModel;
    private MembershipDao dao = MembershipDao.getInstance();
    /**
     * Launch the application.
     */
    public static void showBuyMembershipPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuyMembershipPage frame = new BuyMembershipPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BuyMembershipPage() {
        initialize();
        initTable();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 504, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblBuyMembership = new JLabel("회원권 구매");
        lblBuyMembership.setFont(new Font("D2Coding", Font.BOLD, 30));
        lblBuyMembership.setHorizontalAlignment(SwingConstants.LEFT);
        lblBuyMembership.setBounds(12, 10, 464, 83);
        contentPane.add(lblBuyMembership);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 103, 464, 306);
        contentPane.add(scrollPane);
        
        tableMembership = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        tableMembership.setModel(tableModel);
        tableMembership.getColumnModel().getColumn(0).setPreferredWidth(250);
        tableMembership.getColumnModel().getColumn(1).setPreferredWidth(30);
        tableMembership.setFont(new Font("D2Coding", Font.PLAIN, 15));
        tableMembership.setRowHeight(30);
        scrollPane.setViewportView(tableMembership);
        
        btnBuy = new JButton("구매하기");
        btnBuy.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 구매 확인 창.
                //confirmedBuyMembership();
            }
            
        });
        btnBuy.setFont(new Font("D2Coding", Font.BOLD, 18));
        btnBuy.setBounds(63, 451, 130, 61);
        contentPane.add(btnBuy);
        
        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("D2Coding", Font.BOLD, 18));
        btnBackPage.setBounds(283, 451, 130, 61);
        contentPane.add(btnBackPage);
    }//initialize().
    
    
   // ************* -> 여기가 문제다     
//    private void confirmedBuyMembership() {
//        //회원권 구매 메서드를 정의한다.
//        int row = tableMembership.getSelectedRow();
//        if(row == -1) {
//            JOptionPane.showMessageDialog(BuyMembershipPage.this, "구매하려는 회원권을 선택하세요...!");
//            return;
//        }
//        
//        int confirm = JOptionPane.showConfirmDialog(BuyMembershipPage.this, 
//                "정말 구매 할까요?",
//                "구매 확인",
//                JOptionPane.YES_NO_OPTION);
//        if(confirm == JOptionPane.YES_OPTION) {
//            Integer memCode = (Integer) tableModel.getValueAt(row, 0);
//            Membership result = dao.read(memCode);
//            System.out.println(result);
//            // TODO 1. MembershipDao.selectMembershipCode 
//            // TODO 2. 구매한 회원권을 GymMember 테이블에는 MembershipCode를 insert
//            // int result = dao.
//        }
//        
//    }//confirmedBuyMembership()

    private void initTable() {
        List<Membership> membershipList = dao.read();
        resetTableModel(membershipList);
    }//inittable().

    private void resetTableModel(List<Membership> membershipList) {
        // 테이블 모델 리셋.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        for(Membership m : membershipList) {
            Object[] row = {
                    m.getMembershipcode(),
                    m.getMembershipcategory(),
                    m.getMembershipprice()
            };
            tableModel.addRow(row);
        }
        tableMembership.setModel(tableModel);
    }//end resetTableModel.
    
}//end class
