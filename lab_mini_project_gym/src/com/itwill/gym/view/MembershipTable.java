package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MembershipTable extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldSearch;
    private JTable tableMembership;

    /**
     * Launch the application.
     */
    public static void showMembershipTable() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MembershipTable frame = new MembershipTable();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MembershipTable ( ) {
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 755, 603);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("나눔고딕", Font.BOLD, 18));
        comboBox.setBounds(114, 0, 156, 38);
        contentPane.add(comboBox);
        
        textFieldSearch = new JTextField();
        textFieldSearch.setFont(new Font("나눔고딕", Font.BOLD, 18));
        textFieldSearch.setColumns(10);
        textFieldSearch.setBounds(282, 0, 325, 39);
        contentPane.add(textFieldSearch);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnSearch.setBounds(619, 0, 120, 39);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 54, 733, 402);
        contentPane.add(scrollPane);
        
        tableMembership = new JTable();
        tableMembership.setFont(new Font("나눔고딕", Font.BOLD, 23));
        scrollPane.setViewportView(tableMembership);
        
        JButton btnShowAllMem = new JButton("전체멤버쉽목록");
        btnShowAllMem.setFont(new Font("나눔고딕", Font.BOLD, 23));
        btnShowAllMem.setBounds(81, 482, 162, 58);
        contentPane.add(btnShowAllMem);
        
        JButton btnViewMemInfo = new JButton("멤버쉽 상세정보");
        btnViewMemInfo.setFont(new Font("나눔고딕", Font.BOLD, 23));
        btnViewMemInfo.setBounds(255, 483, 209, 58);
        contentPane.add(btnViewMemInfo);
        
        JButton btnDeleteMember = new JButton("멤버쉽 삭제");
        btnDeleteMember.setFont(new Font("나눔고딕", Font.BOLD, 23));
        btnDeleteMember.setBounds(476, 482, 162, 58);
        contentPane.add(btnDeleteMember);
        
        JButton btnBackPage = new JButton("뒤로가기");
        btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 15));
        btnBackPage.setBounds(6, 0, 96, 40);
        contentPane.add(btnBackPage);
    }
}
