package com.itwill.gym.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.itwill.gym.controller.GymTrainerDao;
import com.itwill.gym.model.GymTrainer;

import javax.swing.DefaultComboBoxModel;

public class GymTrainUpdateOrShow extends JFrame {

    public static final String[] COLUMN_NAMES = {"직원 번호", "이름", "연락처", "성별", "월급여", "생년월일","입사 날짜"};
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textSearchKeyword;
    private JTable table;
    private JButton btnSearch;
    private JComboBox comboBox;
    private JButton btnShowAllTrain;
    private JButton btnDeleteTrain;
    private DefaultTableModel tableModel;
    
    private GymTrainerDao dao = GymTrainerDao.getInstance();
    private JButton btnAddTrainer;
    private JButton btnBackPage;
    private JButton btnShowDetailTrain;
    private JFrame frame;
    /**
     * Launch the application.
     */
    public static void showGymTrainUpdateOrShow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymTrainUpdateOrShow frame = new GymTrainUpdateOrShow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymTrainUpdateOrShow() {
        
        initialize();
        initTable();
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 794, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font("나눔고딕", Font.BOLD, 20));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "연락처", "성별", "주소", "이메일","입사 날짜"}));
        comboBox.setBounds(163, 10, 167, 46);
        contentPane.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        textSearchKeyword.setBounds(335, 10, 242, 46);
        contentPane.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByKeyword();
            }
        });
        btnSearch.setFont(new Font("나눔고딕", Font.BOLD, 24));
        btnSearch.setBounds(587, 8, 176, 46);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 66, 751, 335);
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
        
        btnShowAllTrain = new JButton("전체 직원");
        btnShowAllTrain.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 전체 트레이너 목록 출력.
                initTable();
            }
        });
        btnShowAllTrain.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnShowAllTrain.setBounds(12, 411, 178, 82);
        contentPane.add(btnShowAllTrain);
        
        btnShowDetailTrain = new JButton("직원 상세정보");
        btnShowDetailTrain.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 트레이너 정보 상세보
                showTrainerDetails();
            }
        });
        btnShowDetailTrain.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnShowDetailTrain.setBounds(392, 411, 178, 82);
        contentPane.add(btnShowDetailTrain);
        
        btnDeleteTrain = new JButton("직원 삭제");
        btnDeleteTrain.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 행의 트레이너를 삭제한다.
                deleteGymTrainer();
            }
        });
        btnDeleteTrain.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnDeleteTrain.setBounds(587, 411, 178, 82);
        contentPane.add(btnDeleteTrain);
        
        btnAddTrainer = new JButton("새 직원 고용");
        btnAddTrainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GymNewTrainer.addNewTrainer();
            }
        });
        btnAddTrainer.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnAddTrainer.setBounds(202, 411, 178, 82);
        contentPane.add(btnAddTrainer);
        
        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 20));
        btnBackPage.setBounds(12, 10, 139, 46);
        contentPane.add(btnBackPage);
    }

    private void searchByKeyword() {
        int type = comboBox.getSelectedIndex();
        String keyword = textSearchKeyword.getText();
        if(keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.");
            textSearchKeyword.requestFocus();
            
            return;
        }
        List<GymTrainer> result = dao.search(type, keyword);
        resetTableModel(result);
    }

    private void showTrainerDetails() {
        // 테이블에서 선택된 트레이너 인덱스 
        int row = table.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(GymTrainUpdateOrShow.this, "테이블에서 트레이너를 선택해주세요.");
            return;
        }
        
        Integer t_Id = (Integer) tableModel.getValueAt(row , 0);
        
        GymShowDetailsTrainer.showDetailTrainer(frame, t_Id, GymTrainUpdateOrShow.this);
        
    }

    private void deleteGymTrainer() {
        // 회원 삭제 메서드를 정의한다.
        int row = table.getSelectedRow();
        if(row == -1 ) {
            JOptionPane.showMessageDialog(GymTrainUpdateOrShow.this, "삭제하려는 직원을 테이블에서 선택하세요.");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(GymTrainUpdateOrShow.this, 
                "정말 삭제 할까요?",
                "삭제 확인",
                JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            Integer Id = (Integer) tableModel.getValueAt(row, 0);
            int result = dao.delete(Id);
            if(result == 1) {
                initTable();
                JOptionPane.showMessageDialog(GymTrainUpdateOrShow.this, "직원 삭제 성공....!");
            }
        }
    }//end deleteGymTrainer().

    private void resetTableModel(List<GymTrainer> list) {
        // 테이블 모델 리셋.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        for(GymTrainer gymTrainer : list) {
            Object[] row = {
                    gymTrainer.getT_id(),
                    gymTrainer.getT_name(),
                    gymTrainer.getT_phone(),
                    gymTrainer.getT_gender(),
                    gymTrainer.getT_salary(),
                    gymTrainer.getBirthday(),
                    gymTrainer.getHiredate()
            };
            tableModel.addRow(row);
        }
        table.setModel(tableModel);
        resizeColumnWidth(table);
    }//end resetTableModel.
    
    
    private void initTable() {
        List<GymTrainer> gymTrainers = dao.read();
        resetTableModel(gymTrainers);
    }//initTable().

    public void notifyTrainerUpdated() {
        initTable();
        JOptionPane.showMessageDialog(frame, "직원 정보 업데이트 성공");
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
