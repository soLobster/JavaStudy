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

public class Pt_Table extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void showPt_Table() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pt_Table frame = new Pt_Table();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pt_Table() {
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 757, 663);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("나눔고딕", Font.BOLD, 18));
        comboBox.setBounds(107, 22, 156, 38);
        contentPane.add(comboBox);
        
        textField = new JTextField();
        textField.setFont(new Font("나눔고딕", Font.BOLD, 18));
        textField.setColumns(10);
        textField.setBounds(265, 21, 325, 39);
        contentPane.add(textField);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnSearch.setBounds(602, 21, 120, 39);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 89, 733, 402);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JButton btnPt = new JButton("전체 PT 목록");
        btnPt.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnPt.setBounds(64, 503, 162, 58);
        contentPane.add(btnPt);
        
        JButton btnPt_1 = new JButton("PT 상세정보");
        btnPt_1.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnPt_1.setBounds(238, 504, 209, 58);
        contentPane.add(btnPt_1);
        
        JButton btnPt_2 = new JButton("PT 삭제");
        btnPt_2.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnPt_2.setBounds(459, 503, 162, 58);
        contentPane.add(btnPt_2);
        
        JButton btnBackPage = new JButton("뒤로가기");
        btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 18));
        btnBackPage.setBounds(6, 21, 96, 40);
        contentPane.add(btnBackPage);
    }

}
