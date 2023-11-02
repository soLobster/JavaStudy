package com.itwill.gym.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.itwill.gym.controller.GymTrainerDao;
import com.itwill.gym.model.GymTrainer;
import com.itwill.gym.model.GTGMPT;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GymShowDetailsTrainer extends JFrame {

    public static final String[] COLUMN_NAMES = {"회원 이름", "성별", "연락처", "PT 카테고리"};
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Component parent;
    private Integer t_Id;
    private GymTrainUpdateOrShow app;
    private GymTrainerDao dao;
    private JLabel lblTName;
    private JLabel lblTNum;
    private JLabel lblTBirth;
    private JLabel lblTPhoneNum;
    private JLabel lblTGender;
    private JLabel lblTHireDate;
    private JLabel lblTAddress;
    private JLabel lblTSalary;
    private JTextField textTNum;
    private JTextField textTName;
    private JTextField textTPhoneNum;
    private JTextField textGender;
    private JTextField textTSalary;
    private JTextField textAddress;
    private JDateChooser dateBirth;
    private JDateChooser dateHire;
    private JButton btnUpdate;
    private JButton btnCancel;
    private JLabel lblTSession;
    private JScrollPane scrollPane;
    private JTable tablePtSession;
    private DefaultTableModel tableModel;
    private JLabel lblTEmail;
    private JTextField textTEmail;


    /**
     * Launch the application.
     */
    public static void showDetailTrainer(Component parent, Integer t_Id, GymTrainUpdateOrShow app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymShowDetailsTrainer frame = new GymShowDetailsTrainer(parent, t_Id, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymShowDetailsTrainer(Component parent, Integer t_Id, GymTrainUpdateOrShow app) {
        this.dao = GymTrainerDao.getInstance();
        this.parent = parent;
        this.t_Id = t_Id;
        this.app = app;

        initialize();

        initTrainerDetails();
        
        initTable();
        
        resizeColumnWidth(tablePtSession);
        
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 724, 725);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTName = new JLabel("이름");
        lblTName.setHorizontalAlignment(SwingConstants.CENTER);
        lblTName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTName.setBounds(6, 80, 129, 64);
        contentPane.add(lblTName);

        lblTNum = new JLabel("직원번호");
        lblTNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblTNum.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTNum.setBounds(6, 6, 129, 64);
        contentPane.add(lblTNum);

        lblTBirth = new JLabel("생년월일");
        lblTBirth.setHorizontalAlignment(SwingConstants.CENTER);
        lblTBirth.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTBirth.setBounds(6, 156, 129, 64);
        contentPane.add(lblTBirth);

        lblTPhoneNum = new JLabel("연락처");
        lblTPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblTPhoneNum.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTPhoneNum.setBounds(296, 6, 129, 64);
        contentPane.add(lblTPhoneNum);

        lblTGender = new JLabel("성별");
        lblTGender.setHorizontalAlignment(SwingConstants.CENTER);
        lblTGender.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTGender.setBounds(296, 80, 129, 64);
        contentPane.add(lblTGender);

        lblTHireDate = new JLabel("입사 날짜");
        lblTHireDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblTHireDate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTHireDate.setBounds(296, 156, 129, 64);
        contentPane.add(lblTHireDate);

        lblTAddress = new JLabel("주소");
        lblTAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblTAddress.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTAddress.setBounds(6, 318, 129, 64);
        contentPane.add(lblTAddress);

        lblTSalary = new JLabel("급여(월)");
        lblTSalary.setHorizontalAlignment(SwingConstants.CENTER);
        lblTSalary.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTSalary.setBounds(6, 232, 129, 64);
        contentPane.add(lblTSalary);

        textTNum = new JTextField();
        textTNum.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textTNum.setEditable(false);
        textTNum.setBounds(130, 13, 154, 50);
        contentPane.add(textTNum);
        textTNum.setColumns(10);

        textTName = new JTextField();
        textTName.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textTName.setColumns(10);
        textTName.setBounds(130, 80, 154, 50);
        contentPane.add(textTName);

        textTPhoneNum = new JTextField();
        textTPhoneNum.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textTPhoneNum.setColumns(10);
        textTPhoneNum.setBounds(437, 14, 230, 50);
        contentPane.add(textTPhoneNum);

        textGender = new JTextField();
        textGender.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textGender.setColumns(10);
        textGender.setBounds(437, 80, 154, 50);
        contentPane.add(textGender);

        dateBirth = new JDateChooser();
        dateBirth.setBounds(130, 156, 154, 50);
        contentPane.add(dateBirth);

        dateHire = new JDateChooser();
        dateHire.setBounds(437, 156, 154, 50);
        contentPane.add(dateHire);

        textTSalary = new JTextField();
        textTSalary.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textTSalary.setColumns(10);
        textTSalary.setBounds(130, 240, 154, 50);
        contentPane.add(textTSalary);

        textAddress = new JTextField();
        textAddress.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textAddress.setColumns(10);
        textAddress.setBounds(130, 326, 537, 50);
        contentPane.add(textAddress);

        lblTEmail = new JLabel("이메일");
        lblTEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblTEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTEmail.setBounds(296, 232, 129, 64);
        contentPane.add(lblTEmail);
        
        textTEmail = new JTextField();
        textTEmail.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textTEmail.setColumns(10);
        textTEmail.setBounds(437, 240, 230, 50);
        contentPane.add(textTEmail);
        
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                updateTrainer();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnUpdate.setBounds(130, 605, 129, 50);
        contentPane.add(btnUpdate);

        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnCancel.setBounds(437, 605, 129, 50);
        contentPane.add(btnCancel);

        lblTSession = new JLabel("PT 현황");
        lblTSession.setHorizontalAlignment(SwingConstants.CENTER);
        lblTSession.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTSession.setBounds(6, 392, 120, 64);
        contentPane.add(lblTSession);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(130, 392, 537, 203);
        contentPane.add(scrollPane);

        tablePtSession = new JTable() { // 익명 클래스
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        tablePtSession.setModel(tableModel);
        tablePtSession.setFont(new Font("D2Coding", Font.PLAIN, 15));
        tablePtSession.setRowHeight(25);
        scrollPane.setViewportView(tablePtSession);
    }//end initialize()

    private void initTrainerDetails() {
        //DAO (컨트롤러) 메서드를 이용해서 DB에서 검색하고 , 그 결과를 보여준다.
        GymTrainer gymTrainers = dao.read(t_Id);
        if(gymTrainers != null) {
            textTNum.setText(gymTrainers.getT_id().toString());
            textTName.setText(gymTrainers.getT_name());
            textTPhoneNum.setText(gymTrainers.getT_phone());
            textGender.setText(gymTrainers.getT_gender());
            textTSalary.setText(gymTrainers.getT_salary().toString());
            dateBirth.setDate(gymTrainers.getBirthday());
            dateHire.setDate(gymTrainers.getHiredate());
            textAddress.setText(gymTrainers.getT_address());
            textTEmail.setText(gymTrainers.getT_email());
        }
    }//initTrainerDetails
    
    private void updateTrainer() {
        Integer t_id = Integer.parseInt(textTNum.getText());
        String t_name = textTName.getText();
        String t_phone = textTPhoneNum.getText();
        String t_gender = textGender.getText();
        Integer t_salary = Integer.parseInt(textTSalary.getText());
        
        java.util.Date utilDate = dateBirth.getDate();
        Date t_birthday = (utilDate != null) ? new java.sql.Date(utilDate.getTime()) : null;
        
        java.util.Date utilDate2 = dateHire.getDate();
        Date t_hiredate = (utilDate2 != null) ? new java.sql.Date(utilDate2.getTime()) : null;
        
        String t_address = textAddress.getText();
        
        String t_email = textTEmail.getText();
        
        if(t_name.equals("") || t_phone.equals("") || t_gender.equals("") || t_salary == 0 || t_birthday==null || t_hiredate==null || t_address.equals("") || t_email.equals("")) {
            JOptionPane.showMessageDialog(GymShowDetailsTrainer.this, "트레이너 정보가 누락 되어 있으면 안됩니다.");
            return;
        }
        GymTrainer gymTrainer = new GymTrainer(t_id, t_name, t_phone, t_gender, t_email, t_salary, t_birthday, t_hiredate, t_address);
        int result = dao.update(gymTrainer);
        
        if(result == 1) {
            dispose();
            app.notifyTrainerUpdated();
        }
    }//end updateTrainer.
    private void resetTableModel(List<GTGMPT> list) {
        tableModel = new DefaultTableModel(null, COLUMN_NAMES);
        for(GTGMPT gtgmpt : list) {
            Object[] row = {
                    gtgmpt.getName(),
                    gtgmpt.getGender(),
                    gtgmpt.getPhone(),
                    gtgmpt.getPt_category()
            };
            tableModel.addRow(row);
        }
        tablePtSession.setModel(tableModel);
    }//end resetTablemodel
    
    
    private void initTable() {
        List<GTGMPT> gymtrainer = dao.readPt(t_Id);
        resetTableModel(gymtrainer);
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
    }//테이블 컬럼 사이즈 조절 함수
}//end class
