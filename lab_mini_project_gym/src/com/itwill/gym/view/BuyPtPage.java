package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class BuyPtPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblPtBuyInfo;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void showBuyPtPage() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuyPtPage frame = new BuyPtPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BuyPtPage() {
        initialize();
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 674, 668);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblPtBuyInfo = new JLabel("PT권 구매");
        lblPtBuyInfo.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblPtBuyInfo.setBounds(12, 10, 634, 78);
        contentPane.add(lblPtBuyInfo);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 104, 634, 323);
        contentPane.add(scrollPane);
    }
}
