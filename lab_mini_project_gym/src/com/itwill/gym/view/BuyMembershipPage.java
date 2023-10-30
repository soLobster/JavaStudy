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

import com.itwill.gym.model.GymMember;
import com.itwill.gym.model.Membership;
import com.itwill.gym.controller.GymMemberDao;
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

    private String memberPhone;
    /**
     * Launch the application.
     */
    public static void showBuyMembershipPage(String memberPhone) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuyMembershipPage frame = new BuyMembershipPage(memberPhone);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BuyMembershipPage(String memberPhone) {
        dao = MembershipDao.getInstance();
        this.memberPhone = memberPhone;
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
                confirmedBuyMembership();
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
    private void confirmedBuyMembership() {
        // 회원권 구매 메서드를 정의한다.
        int row = tableMembership.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(BuyMembershipPage.this, "구매하려는 회원권을 선택하세요...!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(BuyMembershipPage.this,
                "정말 구매 할까요?",
                "구매 확인",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Integer membership_code = (Integer) tableModel.getValueAt(row, 0);
            if (membership_code != null) {
                // 이 부분에서 GymMemberDao를 사용하여 회원 정보를 조회
                GymMemberDao memberDao = GymMemberDao.getInstance();
                GymMember member = memberDao.read(memberPhone);
                
                if (member != null) {
                    System.out.println("회원 정보: " + member.toString());

                    
                    member.setMembership_code(membership_code);
                    
                    // TODO: GymMemberDao를 사용하여 회원 정보 업데이트
                    memberDao.update(member);
                    
                    //TODO: memberDao.update를 재정의 해야할듯 
                    
                } else {
                    // member 객체가 null인 경우 처리
                    System.err.println("해당 회원 정보를 찾을 수 없습니다.");
                }
            } else {
                // membership_code가 null인 경우 처리
                System.err.println("membership_code가 null입니다.");
            }
        }
        //TODO 객체를 가져오는것 까지 확인 했으니 이제 GymMember 테이블에 membership_code를 insert 해야한다.
        initTable();
    }


    private void initTable() {
        List<Membership> membershipList = dao.read();
        resetTableModel(membershipList);
    }//initTable().

    private void resetTableModel(List<Membership> membershipList) {
        // 테이블 모델 리셋.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        for(Membership m : membershipList) {
            Object[] row = {
                    m.getMembership_code(),
                    m.getMembership_category(),
                    m.getMembership_price()
            };
            tableModel.addRow(row);
        }
        tableMembership.setModel(tableModel);
    }//end resetTableModel.
    
}//end class
