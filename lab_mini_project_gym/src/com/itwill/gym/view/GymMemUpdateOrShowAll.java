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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.model.GymMember;


import javax.swing.DefaultComboBoxModel;

public class GymMemUpdateOrShowAll extends JFrame {
    
    public static final String[] COLUMN_NAMES = {"회원번호", "이름", "연락처", "성별", "생년월일"};

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textSearchKeyword;
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
        setBounds(100, 100, 773, 529);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "연락처", "성별", "생년월일"}));
        comboBox.setFont(new Font("나눔고딕", Font.BOLD, 20));
        comboBox.setBounds(136, 9, 140, 38);
        contentPane.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        textSearchKeyword.setBounds(288, 9, 325, 39);
        contentPane.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 검색 기능
                searchByKeyword();
            }
        });
        btnSearch.setFont(new Font("나눔고딕", Font.BOLD, 25));
        btnSearch.setBounds(619, 9, 126, 39);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 63, 733, 347);
        contentPane.add(scrollPane);
        
        table = new JTable() { // 익명 클래스
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        table.setFont(new Font("나눔고딕", Font.PLAIN, 18));
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
        btnShowAllMem.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnShowAllMem.setBounds(12, 420, 170, 58);
        contentPane.add(btnShowAllMem);
        
        btnViewMemInfo = new JButton("회원정보 상세정보");
        btnViewMemInfo.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원 정보 상세 보기.
                showGymMemberDetails();
            }
        });
        btnViewMemInfo.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnViewMemInfo.setBounds(183, 420, 390, 58);
        contentPane.add(btnViewMemInfo);
        
        btnDeleteMember = new JButton("회원 삭제");
        btnDeleteMember.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 행의 회원을 삭제한다.
                deleteGymMember(); 
            }
        });
        btnDeleteMember.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnDeleteMember.setBounds(575, 420, 170, 58);
        contentPane.add(btnDeleteMember);
        
        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnBackPage.setBounds(12, 9, 116, 40);
        contentPane.add(btnBackPage);
        
    }//end initialize()
    
    private void searchByKeyword() {
        int type = comboBox.getSelectedIndex();
        String keyword = textSearchKeyword.getText();
        if(keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.");
            textSearchKeyword.requestFocus();
            
            return;
        }
        List<GymMember> result = dao.search(type, keyword);
        resetTableModel(result);
    }

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
        resizeColumnWidth(table);
    }//end resetTableModel.
    
    private void initTable() {
        List<GymMember> gymMembers = dao.read();
        resetTableModel(gymMembers);
    }//initTable()
    
    
    public void notifyMemberUpdated() {
        initTable();
        JOptionPane.showMessageDialog(frame, "회원 정보 업데이트 성공");
    }
    
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
    
}//end class
