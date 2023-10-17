package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBox cbAbstract;
    private JCheckBox cbFInal;
    private JCheckBox cbStatic;
    private JComboBox<String> comboBox;
    private JButton btnInfo;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 591, 549);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleRadioButtonClick(e);
            }
        });
        rbPrivate.setSelected(true);
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("D2Coding", Font.BOLD, 24));
        rbPrivate.setBounds(8, 6, 140, 60);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleRadioButtonClick(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("D2Coding", Font.BOLD, 24));
        rbPackage.setBounds(152, 6, 140, 60);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        buttonGroup.add(rbProtected);
        rbProtected.addActionListener((e)-> handleRadioButtonClick(e));
        rbProtected.setFont(new Font("D2Coding", Font.BOLD, 24));
        rbProtected.setBounds(296, 6, 140, 60);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        buttonGroup.add(rbPublic);
        rbPublic.addActionListener(this::handleRadioButtonClick);
        rbPublic.setFont(new Font("D2Coding", Font.BOLD, 24));
        rbPublic.setBounds(440, 6, 140, 60);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCheckBoxClick(e);
            }
        });
        cbAbstract.setFont(new Font("D2Coding", Font.BOLD, 24)); //익명클래스
        cbAbstract.setBounds(8, 68, 140, 60);
        frame.getContentPane().add(cbAbstract);
        
        cbFInal = new JCheckBox("final");
        cbFInal.addActionListener((e)->handleCheckBoxClick(e)); //람다
        cbFInal.setFont(new Font("D2Coding", Font.BOLD, 24));
        cbFInal.setBounds(152, 68, 140, 60);
        frame.getContentPane().add(cbFInal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(this::handleCheckBoxClick); //메서드 참조 람다
        cbStatic.setFont(new Font("D2Coding", Font.BOLD, 24));
        cbStatic.setBounds(296, 68, 140, 60);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>();//<>
        comboBox.setFont(new Font("D2Coding", Font.BOLD, 16));
        //콤보박스에서 사용할 문자열들의 배열:
        final String[] emails = {"naver.com", "gmail.com", "outlook.com"};
        //콤보박스모델 객체 생성.
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(emails);
        //콤보박스에 모델을 설정
        comboBox.setModel(model);
        
        comboBox.setBounds(8, 134, 140, 30);
        frame.getContentPane().add(comboBox);
        
        btnInfo = new JButton("confirm");
        btnInfo.setFont(new Font("D2Coding", Font.BOLD, 15));
        btnInfo.setBounds(412, 138, 100, 25);
        frame.getContentPane().add(btnInfo);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 195, 500, 305);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(textArea);
    }

    private void handleCheckBoxClick(ActionEvent e) {
        textArea.setText(e.getSource().toString());
        // TODO 클릭한 체크박스 문자열과 선택 여부를 JTextArea에 출력.
        
    }

    private void handleRadioButtonClick(ActionEvent e) {
        textArea.setText(e.getSource().toString());
        //TODO. 클릭한 라디오 버튼 문자열과 선택 여부를 JTextArea에 출력하자.
    }
}
