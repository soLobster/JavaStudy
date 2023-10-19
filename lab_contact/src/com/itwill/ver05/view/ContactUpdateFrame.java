package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ContactUpdateFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JButton btnCancel;
    private JButton btnUpdate;
    private JLabel lblName;
    private JLabel lblPhone;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JLabel lblEmail;
    
    private Component parent; // 부모 컴포넌트(JFrame)을 저장하기 위한 필드.
    
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();
    private ContactMain05 app;
    
    private int index;
    
    /**
     * Launch the application.
     */
    public static void showContactUpdateFrame(Component parent, int index, ContactMain05 app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // constructor. 생성자.
    public ContactUpdateFrame(Component parent, int index, ContactMain05 app) {
        this.parent = parent; // 필드 초기화.
        this.index = index;
        this.app = app;
        initialize(); // Swing 컴포넌트 생성 & 초기화.
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("연락처 업데이트");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 100;
        int y = 100;
        
        if(parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }
        
        setBounds(x, y, 414, 346);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblName.setBounds(12, 16, 103, 64);
        mainPanel.add(lblName);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblPhone.setBounds(12, 90, 103, 64);
        mainPanel.add(lblPhone);
        
        lblEmail = new JLabel("E-Mail");
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblEmail.setBounds(12, 164, 103, 64);
        mainPanel.add(lblEmail);
        
        textName = new JTextField();
        textName.setHorizontalAlignment(SwingConstants.CENTER);
        textName.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textName.setBounds(127, 24, 248, 50);
        mainPanel.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setHorizontalAlignment(SwingConstants.CENTER);
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textPhone.setColumns(10);
        textPhone.setBounds(127, 98, 248, 50);
        mainPanel.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setHorizontalAlignment(SwingConstants.CENTER);
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textEmail.setColumns(10);
        textEmail.setBounds(127, 172, 248, 50);
        mainPanel.add(textEmail);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 14));
        buttonPanel.add(btnUpdate);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 14));
        buttonPanel.add(btnCancel);
    }

    private void updateContact() {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        Contact contact = new Contact(0, name, phone, email);
        dao.update(index, contact);
        app.notifyContactUpdated();
        dispose();
    }
}//class
