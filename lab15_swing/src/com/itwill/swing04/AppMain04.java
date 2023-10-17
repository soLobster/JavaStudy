package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {
//이미지 파일의 경로를 저장하는 배열.
    private static final String[] IMAGEPATHS = {
            "Images/ds.jpg",
            "Images/kt.jpg",
            "Images/lg.jpg",
            "Images/nc.jpg",
            "Images/ssg.jpg"
    };
    
    private JFrame frame;
    private JButton btnPreviousImage;
    private JButton btnNextImage;
    private int imageIndex = 0;
    private JLabel lblImages;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblImages = new JLabel("");
        //lblImages = new JLabel(new ImageIcon(IMAGES[imageIndex]));
        lblImages.setHorizontalAlignment(SwingConstants.CENTER);
        lblImages.setBounds(64, 30, 640, 640);
        frame.getContentPane().add(lblImages);


        imageIndex = 0;
        
//        ImageIcon imageIcon = new ImageIcon(imagePaths);
//        lblImages.setIcon(imageIcon);


        btnPreviousImage = new JButton("<");
        btnPreviousImage.addActionListener((e) -> showPreviousImage());
        btnPreviousImage.setFont(new Font("D2Coding", Font.BOLD, 15));
        btnPreviousImage.setBounds(242, 659, 120, 64);
        frame.getContentPane().add(btnPreviousImage);

        btnNextImage = new JButton(">");
        btnNextImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        btnNextImage.setFont(new Font("D2Coding", Font.BOLD, 15));
        btnNextImage.setBounds(399, 659, 120, 64);
        frame.getContentPane().add(btnNextImage);
    }

    private void showNextImage() {
        if(imageIndex < IMAGEPATHS.length -1) {
            imageIndex++;
            //displayImage();
        } else {
            imageIndex = 0;
        }
        lblImages.setIcon(new ImageIcon(IMAGEPATHS[imageIndex]));
    }

    private void showPreviousImage() {
        if(imageIndex > 0) {
            imageIndex--;
            //displayImage();
        } else {
            imageIndex = IMAGEPATHS.length - 1;
        }
        lblImages.setIcon(new ImageIcon(IMAGEPATHS[imageIndex]));
    }

//    private void displayImage() {
//        String imagePath = IMAGEPATHS[imageIndex];
//        ImageIcon imageIcon = new ImageIcon(imagePath);
//        lblImages.setIcon(imageIcon);
//        
//    }
    

}
