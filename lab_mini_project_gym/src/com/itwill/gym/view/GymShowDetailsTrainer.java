package com.itwill.gym.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymTrainerDao;
import com.itwill.gym.model.GymTrainer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class GymShowDetailsTrainer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Component parent;
    private Integer t_id;
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


    /**
     * Launch the application.
     */
    public static void showDetailTrainer(Component parent, Integer t_id, GymTrainUpdateOrShow app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymShowDetailsTrainer frame = new GymShowDetailsTrainer(parent, t_id, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymShowDetailsTrainer(Component parent, Integer t_id, GymTrainUpdateOrShow gymTrainUpdateOrShow) {
        this.dao = GymTrainerDao.getInstance();
        this.parent = parent;
        this.t_id = t_id;
        this.app = app;

        initialize();

        initTrainerDetails();
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 724, 601);
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
        lblTAddress.setBounds(6, 302, 129, 64);
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
        textAddress.setBounds(130, 302, 537, 50);
        contentPane.add(textAddress);
    }//end initialize()

    private void initTrainerDetails() {
        //DAO (컨트롤러) 메서드를 이용해서 DB에서 검색하고 , 그 결과를 보여준다.
        GymTrainer gymTrainers = dao.read(t_id);
        if(gymTrainers != null) {
            textTNum.setText(gymTrainers.getT_id().toString());
            textTName.setText(gymTrainers.getT_name());
            textTPhoneNum.setText(gymTrainers.getT_phone());
            textGender.setText(gymTrainers.getT_gender());
            textTSalary.setText(gymTrainers.getSalary().toString());
            dateBirth.setDate(gymTrainers.getBirthday());
            dateHire.setDate(gymTrainers.getHiredate());
            textAddress.setText(gymTrainers.getT_address());
        }

    }//initTrainerDetails

}//end class
