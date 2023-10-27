package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

import com.itwill.gym.controller.GymTrainerDao;
import com.itwill.gym.model.GymTrainer;

import javax.swing.DefaultComboBoxModel;

public class GymTrainUpdateOrShow extends JFrame {

    public static final String[] COLUMN_NAMES = {"트레이너 번호", "이름", "연락처", "성별", "월급여", "생년월일"};
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private JButton btnSearch;
    private JComboBox comboBox;
    private JButton btnShowAllTrain;
    private JButton btnDeleteTrain;
    private DefaultTableModel tableModel;
    
    private GymTrainerDao dao = GymTrainerDao.getInstance();
    private JButton btnAddTrainer;
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
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 809, 563);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font("D2Coding", Font.BOLD, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"트레이너 번호", "이름", "연락처", "성별", "주소", "이메일"}));
        comboBox.setBounds(106, 10, 167, 46);
        contentPane.add(comboBox);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 16));
        textField.setBounds(285, 10, 198, 46);
        contentPane.add(textField);
        textField.setColumns(10);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnSearch.setBounds(495, 10, 122, 46);
        contentPane.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 66, 769, 335);
        contentPane.add(scrollPane);
        
        table = new JTable() { // 익명 클래스
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(tableModel);
        table.setFont(new Font("D2Coding", Font.PLAIN, 15));
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        
        btnShowAllTrain = new JButton("전체 트레이너");
        btnShowAllTrain.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 전체 트레이너 목록 출력.
                initTable();
            }
        });
        btnShowAllTrain.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnShowAllTrain.setBounds(12, 411, 178, 82);
        contentPane.add(btnShowAllTrain);
        
        JButton btnShowDetailTrain = new JButton("트레이너 상세정보");
        btnShowDetailTrain.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnShowDetailTrain.setBounds(402, 411, 178, 82);
        contentPane.add(btnShowDetailTrain);
        
        btnDeleteTrain = new JButton("트레이너 삭제");
        btnDeleteTrain.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnDeleteTrain.setBounds(603, 411, 178, 82);
        contentPane.add(btnDeleteTrain);
        
        btnAddTrainer = new JButton("새 트레이너 추가");
        btnAddTrainer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GymNewTrainer.addNewTrainer();
            }
        });
        btnAddTrainer.setFont(new Font("D2Coding", Font.BOLD, 16));
        btnAddTrainer.setBounds(212, 411, 178, 82);
        contentPane.add(btnAddTrainer);
    }

    private void resetTableModel(List<GymTrainer> list) {
        // 테이블 모델 리셋.
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        for(GymTrainer gymTrainer : list) {
            Object[] row = {
                    gymTrainer.getT_id(),
                    gymTrainer.getT_name(),
                    gymTrainer.getT_phone(),
                    gymTrainer.getT_gender(),
                    gymTrainer.getSalary(),
                    gymTrainer.getBirthday()
            };
            tableModel.addRow(row);
        }
        table.setModel(tableModel);
    }//end resetTableModel.
    
    
    private void initTable() {
        List<GymTrainer> gymTrainers = dao.read();
        resetTableModel(gymTrainers);
        
    }//initTable().

    
}//end class
