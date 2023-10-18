package com.itwill.ver05.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ContactSearchFrame extends JFrame {

    public static final String[] COLUMN_NAMES = { "이름", "전화번호", "이메일" };

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textInput;
    private JButton btnConfirmPhone;
    private JButton btnCancelPhone;
    private JLabel lblPhoneNum;
    private JTable table;
    private DefaultTableModel model;

    private Component parent;
    private ContactMain05 app;
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void showContactSearchFrame(Component parent, ContactMain05 app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactSearchFrame frame = new ContactSearchFrame(parent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ContactSearchFrame(Component parent, ContactMain05 app) {
        this.parent = parent;
        this.app = app;
        initialize();
    }

    public void initialize() {
        setTitle("연락처 검색");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = 100;
        int y = 100;

        if (parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }

        setBounds(100, 100, 568, 470);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblPhoneNum = new JLabel("이름 or 번호 or 이메일 입력해주세요 ");
        lblPhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhoneNum.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblPhoneNum.setBounds(112, 40, 338, 51);
        contentPane.add(lblPhoneNum);

        textInput = new JTextField();
        textInput.setText("일부만 입력해도 됩니다.");
        textInput.setHorizontalAlignment(SwingConstants.CENTER);
        textInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textInput.setBounds(129, 103, 293, 51);
        contentPane.add(textInput);
        textInput.setColumns(10);

        btnConfirmPhone = new JButton("검색");
        btnConfirmPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertInfoToTable(textInput.getText());
            }
        });
        btnConfirmPhone.setFont(new Font("D2Coding", Font.PLAIN, 12));
        btnConfirmPhone.setBounds(129, 397, 97, 23);
        contentPane.add(btnConfirmPhone);

        btnCancelPhone = new JButton("취소");
        btnCancelPhone.addActionListener((e) -> dispose());
        btnCancelPhone.setFont(new Font("D2Coding", Font.PLAIN, 15));
        btnCancelPhone.setBounds(314, 397, 97, 23);
        contentPane.add(btnCancelPhone);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 184, 502, 201);
        contentPane.add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        table.setFont(new Font("D2Coding", Font.PLAIN, 15));
        table.setRowHeight(20);
        scrollPane.setViewportView(table);
    }

    private void insertInfoToTable(String searchText) {
        List<Contact> searchResults = searchContact(searchText);

        model.setRowCount(0); // Clear table

        for (Contact contact : searchResults) {
            String name = contact.getName();
            String phone = contact.getPhone();
            String email = contact.getEmail();

            Object[] row = {
                    name,
                    phone,
                    email
            };
            
            model.addRow(row);
        }
    }//insertInfoToTable

    public List<Contact> searchContact(String searchText) {
        List<Contact> contacts = dao.read();
        ArrayList<Contact> searchResults = new ArrayList<Contact>();

        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(searchText.toLowerCase())
                    || c.getPhone().toLowerCase().contains(searchText.toLowerCase())
                    || c.getEmail().toLowerCase().contains(searchText.toLowerCase())
                    )
            {
                searchResults.add(c);
            }
        }
        return searchResults;
    }
}
