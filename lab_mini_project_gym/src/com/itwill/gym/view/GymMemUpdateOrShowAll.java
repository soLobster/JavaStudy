package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Component;

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
    
    public static final String[] COLUMN_NAMES = {"회원번호", "이름", "연락처", "성별", "생년월일"};

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JComboBox comboBox;
    private JButton btnSearch;
    private JTable table;
    private JButton btnShowAllMem;
    private JButton btnViewMemInfo;
    private JButton btnDeleteMember;
    private DefaultTableModel tableModel;
    private JFrame frame;
    
    private GymMemberDao dao = GymMemberDao.getInstance();
    private JButton btnBackPage;

    
    
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
        initTable();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 773, 620);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "연락처", "성별", "생년월일"}));
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
        comboBox.setBounds(120, 9, 156, 38);
        contentPane.add(comboBox);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 17));
        textField.setBounds(288, 9, 325, 39);
        contentPane.add(textField);
        textField.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 검색 기능
                
            }
        });
        btnSearch.setFont(new Font("D2Coding", Font.BOLD, 23));
        btnSearch.setBounds(625, 9, 120, 39);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 63, 733, 402);
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
        btnShowAllMem.setBounds(87, 491, 162, 58);
        contentPane.add(btnShowAllMem);
        
        btnViewMemInfo = new JButton("회원정보 상세정보");
        btnViewMemInfo.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 상세 보기.
                showGymMemberDetails();
            }
        });
        btnViewMemInfo.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnViewMemInfo.setBounds(261, 492, 209, 58);
        contentPane.add(btnViewMemInfo);
        
        btnDeleteMember = new JButton("회원 삭제");
        btnDeleteMember.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 행의 회원을 삭제한다.
                deleteGymMember(); 
            }
        });
        btnDeleteMember.setFont(new Font("D2Coding", Font.BOLD, 20));
        btnDeleteMember.setBounds(482, 491, 162, 58);
        contentPane.add(btnDeleteMember);
        
        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("D2Coding", Font.PLAIN, 13));
        btnBackPage.setBounds(12, 9, 96, 40);
        contentPane.add(btnBackPage);
        
    }//end initialize()
    
    private void showGymMemberDetails() {
        //테이블에서 선택된 회원 인덱스.
        int row = table.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(GymMemUpdateOrShowAll.this, "테이블에서 회원을 선택해주세요.");
            return;
        }
        
        Integer id = (Integer) tableModel.getValueAt(row, 0);
        
        GymShowDetailMember.showDetailMember(frame, id, GymMemUpdateOrShowAll.this);
    }

    private void deleteGymMember() {
        // 회원 삭제 메서드를 정의한다.
        int row = table.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(GymMemUpdateOrShowAll.this, "삭제하려는 회원을 테이블에서 선택하세요.");
            return; //메서드 종료.
        }
        
        int confirm = JOptionPane.showConfirmDialog(GymMemUpdateOrShowAll.this,
                "정말 삭제 할까요??",
                "삭제 확인",
                 JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            Integer id =(Integer) tableModel.getValueAt(row, 0);
            int result = dao.delete(id);
            if(result == 1) {
                initTable();
                JOptionPane.showMessageDialog(GymMemUpdateOrShowAll.this, "회원 삭제 성공...!");
            }
        }
        
    }//end deleteGymMember()

    private void resetTableModel(List<GymMember> list) {
        tableModel = new DefaultTableModel(null, COLUMN_NAMES); // 테이블모델 리셋(초기화)
        for (GymMember gymMember : list) { // DB에서 검색한 내용으로 테이블의 행들을 만듦.
            Object[] row = {
                    gymMember.getId(),
                    gymMember.getName(),
                    gymMember.getPhone(),
                    gymMember.getGender(),
                    gymMember.getBirthday(),
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
