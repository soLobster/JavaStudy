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
    public static void main(String[] args) {
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

    /**
     * Create the frame.
     */
    public MembershipTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 755, 603);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
        comboBox.setBounds(114, 0, 156, 38);
        contentPane.add(comboBox);
        
        textFieldSearch = new JTextField();
        textFieldSearch.setFont(new Font("D2Coding", Font.PLAIN, 17));
        textFieldSearch.setColumns(10);
        textFieldSearch.setBounds(282, 0, 325, 39);
        contentPane.add(textFieldSearch);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.BOLD, 23));
        btnSearch.setBounds(619, 0, 120, 39);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 54, 733, 402);
        contentPane.add(scrollPane);
        
        tableMembership = new JTable();
        tableMembership.setFont(new Font("Nanum Gothic", Font.PLAIN, 16));
        scrollPane.setViewportView(tableMembership);
        
        JButton btnShowAllMem = new JButton("전체멤버쉽목록");
        btnShowAllMem.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnShowAllMem.setBounds(81, 482, 162, 58);
        contentPane.add(btnShowAllMem);
        
        JButton btnViewMemInfo = new JButton("멤버쉽 상세정보");
        btnViewMemInfo.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnViewMemInfo.setBounds(255, 483, 209, 58);
        contentPane.add(btnViewMemInfo);
        
        JButton btnDeleteMember = new JButton("멤버쉽 삭제");
        btnDeleteMember.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnDeleteMember.setBounds(476, 482, 162, 58);
        contentPane.add(btnDeleteMember);
        
        JButton btnBackPage = new JButton("뒤로가기");
        btnBackPage.setFont(new Font("D2Coding", Font.PLAIN, 13));
        btnBackPage.setBounds(6, 0, 96, 40);
        contentPane.add(btnBackPage);
    }
}
