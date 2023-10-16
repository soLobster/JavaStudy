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

    private JFrame frame;
    private JButton btnPreviousImage;
    private JButton btnNextImage;
    private String[] imagePaths;
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
        frame.setBounds(100, 100, 614, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblImages = new JLabel("Image-Viewer");
        lblImages.setHorizontalAlignment(SwingConstants.CENTER);
        lblImages.setBounds(79, 6, 450, 350);
        frame.getContentPane().add(lblImages);

        imagePaths = new String[] {
                "Images/ds.jpg",
                "Images/kt.jpg",
                "Images/lg.jpg",
                "Images/nc.jpg",
                "Images/ssg.jpg"
        };

        imageIndex = 0;
        
//        ImageIcon imageIcon = new ImageIcon(imagePaths);
//        lblImages.setIcon(imageIcon);


        btnPreviousImage = new JButton("<");
        btnPreviousImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });
        btnPreviousImage.setFont(new Font("D2Coding", Font.BOLD, 15));
        btnPreviousImage.setBounds(89, 379, 117, 29);
        frame.getContentPane().add(btnPreviousImage);

        btnNextImage = new JButton(">");
        btnNextImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        btnNextImage.setFont(new Font("D2Coding", Font.BOLD, 15));
        btnNextImage.setBounds(412, 379, 117, 29);
        frame.getContentPane().add(btnNextImage);
    }

    private void showNextImage() {
        if(imageIndex < imagePaths.length -1) {
            imageIndex++;
            displayImage();
        }
    }

    private void showPreviousImage() {
        if(imageIndex > 0) {
            imageIndex--;
            displayImage();
        }
        
    }

    private void displayImage() {
        String imagePath = imagePaths[imageIndex];
        ImageIcon imageIcon = new ImageIcon(imagePath);
        lblImages.setIcon(imageIcon);
        
    }
    

}
