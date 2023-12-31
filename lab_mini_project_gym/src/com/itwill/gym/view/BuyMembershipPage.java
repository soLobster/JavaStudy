package com.itwill.gym.view;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.itwill.gym.model.GymMember;
import com.itwill.gym.model.Membership;
import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.controller.MembershipDao;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class BuyMembershipPage extends JFrame {


    public static final String[] COLUMN_NAMES = {"코드","멤버쉽 카테고리","금액"};

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JLabel lblBuyMembership;
    private JTable tableMembership;
    private JButton btnBuy;
    private JButton btnBackPage;
    private DefaultTableModel tableModel;
    private MembershipDao dao = MembershipDao.getInstance();
    private GymMemberDao memDao = GymMemberDao.getInstance();
    private LocalDateTime buyMembership_Date = LocalDateTime.now();

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
        resizeColumnWidth(tableMembership);
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 504, 536);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblBuyMembership = new JLabel("  회원권 구매");
        lblBuyMembership.setFont(new Font("나눔고딕", Font.BOLD, 35));
        lblBuyMembership.setHorizontalAlignment(SwingConstants.LEFT);
        lblBuyMembership.setBounds(0, 0, 488, 93);
        contentPane.add(lblBuyMembership);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 92, 464, 293);
        contentPane.add(scrollPane);

        tableMembership = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }};
            tableModel = new DefaultTableModel(null, COLUMN_NAMES);
            tableMembership.setModel(tableModel);
            tableMembership.setFont(new Font("나눔고딕", Font.BOLD, 17));
            tableMembership.setRowHeight(40);
            scrollPane.setViewportView(tableMembership);

            btnBuy = new JButton("구매하기");
            btnBuy.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO 구매 확인 창.
                    confirmedBuyMembership();
                }

            });
            btnBuy.setFont(new Font("나눔고딕", Font.BOLD, 22));
            btnBuy.setBounds(12, 395, 157, 85);
            contentPane.add(btnBuy);

            btnBackPage = new JButton("뒤로가기");
            btnBackPage.addActionListener((e) -> dispose());
            btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 22));
            btnBackPage.setBounds(319, 395, 157, 85);
            contentPane.add(btnBackPage);
    }//initialize().



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
                    //테스트 코드.
                    //System.out.println("회원 정보: " + member.toString());

                    //GymMember에 Membership_code를 set한다.
                    //membership_code insert...
                    member.setMembership_code(membership_code);

                    // GymMemberDao.update 메서드를 사용하여 회원 정보 업데이트
                    memberDao.updateMembership_Code(member);
                    
                    LocalDateTime buyMembershipDate = LocalDateTime.now();
                    
                    memberDao.updateBuyMembershipDate(member.getId(), buyMembershipDate);
                    
                    
                    LocalDateTime buyMembership = member.getBuyMembershipDate();
                    
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
//                    String FormattedNowDate = buyMemberShip_date.format(formatter);
                    
                    LocalDateTime expireDate = buyMembership.plusDays(memDao.getMembershipNumOfDays(membership_code));
//                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-DD");
//                    String formattedExpireDate = expireDate.format(formatter2);
                    
                    UpdateMembershipExpireDate(member.getId(), expireDate);

                } else {
                    // member 객체가 null인 경우 처리
                    System.err.println("해당 회원 정보를 찾을 수 없습니다.");
                }
            } else {
                // membership_code가 null인 경우 처리
                System.err.println("membership_code가 null입니다.");
            }
            JOptionPane.showMessageDialog(BuyMembershipPage.this, "회원권 구매 성공...!");
        } else {
            JOptionPane.showMessageDialog(BuyMembershipPage.this, "회원권 구매 취소...!");
        }
    }//end ConfirmedBuyMembership().


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

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }//컬럼 테이블 조절 함수

    private void UpdateMembershipExpireDate(int id, LocalDateTime expireDate) {
        memDao.updateGymMemberSetExpireDate(id, expireDate);
    }
    
}//end class
