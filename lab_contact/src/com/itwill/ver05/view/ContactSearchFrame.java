package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver04.model.Contact;
import com.itwill.ver04.controller.ContactDaoImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;



public class ContactSearchFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textPhoneNum;
    private JButton btnConfirm;
    private JButton btnCancel;
    private JLabel lblPhoneNum;
    private Component parent;
    /**
     * Launch the application.
     */
    public static void showContactSearchFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactSearchFrame frame = new ContactSearchFrame(parent);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ContactSearchFrame(Component parent) {
        this.parent = parent;
        initialize();
    }


    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("연락처 검색");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = 100;
        int y = 100;

        if(parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }


        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblPhoneNum = new JLabel("번호를 입력하세요");
        lblPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhoneNum.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblPhoneNum.setBounds(32, 36, 368, 51);
        contentPane.add(lblPhoneNum);

        textPhoneNum = new JTextField();
        textPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
        textPhoneNum.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textPhoneNum.setBounds(32, 112, 368, 51);
        contentPane.add(textPhoneNum);
        textPhoneNum.setColumns(10);

        btnConfirm = new JButton("확인");
        btnConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });
        btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 12));
        btnConfirm.setBounds(116, 193, 97, 23);
        contentPane.add(btnConfirm);

        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 15));
        btnCancel.setBounds(220, 193, 97, 23);
        contentPane.add(btnCancel);
    }

    private void searchContact() {
        // TODO Auto-generated method stub
        
    }

    
}