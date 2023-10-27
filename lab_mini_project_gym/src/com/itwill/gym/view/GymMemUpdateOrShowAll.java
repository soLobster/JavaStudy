package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;


import javax.swing.DefaultComboBoxModel;

public class GymMemUpdateOrShowAll extends JFrame {
    
    public static final String[] COLUMN_NAMES = {"회원번호", "이름", "연락처", "성별", "생년월일", "주소"};

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JComboBox comboBox;
    private JButton btnSearch;
    private JTable table;
    private JButton btnShowAllMem;
    private JButton btnUpdateMember;
    private JButton btnViewMemInfo;
    private JButton btnDeleteMember;
    private DefaultTableModel tableModel;
    
    
    private GymMemberDao dao = GymMemberDao.getInstance();
    
    /**
     * Launch the application.
     */
    public static void memUpdateOrShowAll() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymMemUpdateOrShowAll frame = new GymMemUpdateOrShowAll();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymMemUpdateOrShowAll() {
        initialize();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 724, 620);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "연락처", "성별", "생년월일", "주소"}));
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
        comboBox.setBounds(62, 10, 128, 39);
        contentPane.add(comboBox);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 17));
        textField.setBounds(202, 10, 308, 39);
        contentPane.add(textField);
        textField.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.BOLD, 26));
        btnSearch.setBounds(522, 10, 120, 39);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 63, 684, 402);
        contentPane.add(scrollPane);
        
        table = new JTable() { // 익명 클래스
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        table.setFont(new Font("D2Coding", Font.PLAIN, 17));
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        
        btnShowAllMem = new JButton("전체회원목록");
        btnShowAllMem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 전체회원목록을 출력한다.
                initTable();
            }
        });
        btnShowAllMem.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnShowAllMem.setBounds(12, 491, 162, 58);
        contentPane.add(btnShowAllMem);
        
        btnUpdateMember = new JButton("회원정보 수정");
        btnUpdateMember.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnUpdateMember.setBounds(186, 491, 162, 58);
        contentPane.add(btnUpdateMember);
        
        btnViewMemInfo = new JButton("회원정보 상세정보");
        btnViewMemInfo.setFont(new Font("D2Coding", Font.BOLD, 15));
        btnViewMemInfo.setBounds(360, 491, 162, 58);
        contentPane.add(btnViewMemInfo);
        
        btnDeleteMember = new JButton("회원 삭제");
        btnDeleteMember.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnDeleteMember.setBounds(534, 491, 162, 58);
        contentPane.add(btnDeleteMember);
        
    }//end initialize()
    
    private void resetTableModel(List<GymMember> list) {
        tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블모델 리셋(초기화)
        for (GymMember gymMember : list) { // DB에서 검색한 내용으로 테이블의 행들을 만듦.
            Object[] row = {
                    gymMember.getId(),
                    gymMember.getName(),
                    gymMember.getPhone(),
                    gymMember.getGender(),
                    gymMember.getBirthday(),
                    gymMember.getAddress()
                    
            };
            tableModel.addRow(row);
        }
        table.setModel(tableModel); // 테이블에 모델을 다시 세팅.
    }//end resetTableModel.
    
    private void initTable() {
        List<GymMember> gymMembers = dao.read();
        resetTableModel(gymMembers);
    }//initTable()
    
    
    
}//end class
