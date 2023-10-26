package com.itwill.jdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogCreateFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblTitle;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JLabel lblAuthor;
    private JTextField textAuthor;
    private JButton btnSave;
    private JButton btnCancel;

    private BlogDao dao = BlogDao.getInstance();
    private Component parent;
    private BlogMain app;
    /**
     * Launch the application.
     */
    public static void showBlogCreateFrame(Component parent, BlogMain app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogCreateFrame frame = new BlogCreateFrame(parent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자.
    public BlogCreateFrame (Component parent, BlogMain app) {
        
        this.parent = parent;
        this.app = app;
        
        initialize(); // UI 컴포넌트들 초기화.
    }
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("새 포스트 작성");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 100;
        int y = 100;
        if(parent != null) {
            x = parent.getX() + parent.getWidth();
            y = parent.getY();
        }
        setBounds(x,y, 500, 720);
        
        //setBounds(100, 100, 500, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblTitle.setBounds(12, 10, 460, 72);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textTitle.setBounds(12, 92, 460, 100);
        contentPane.add(textTitle);
        textTitle.setColumns(10);
        
        lblContent = new JLabel("내용을 입력하세요");
        lblContent.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblContent.setBounds(12, 202, 460, 72);
        contentPane.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 284, 460, 130);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 16));
        scrollPane.setViewportView(textContent);
        
        lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblAuthor.setBounds(12, 424, 460, 72);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 506, 460, 100);
        contentPane.add(textAuthor);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewBlogPost();
            }
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnSave.setBounds(12, 636, 168, 35);
        contentPane.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener((e) -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnCancel.setBounds(304, 636, 168, 35);
        contentPane.add(btnCancel);
    }//initialize

    private void createNewBlogPost() {
        // 제목, 내용, 작성자에 입력된 내용을 읽고 DB에 Insert한다.
        // Blog 객체(create) 를 생성해서, Dao 메서드를 사용해서 DB에 삽입.
        String title = textTitle.getText();
        String content = textContent.getText();
        String author = textAuthor.getText();
        
        if(title.equals("") || content.equals("") || author.equals("")) {
            JOptionPane.showMessageDialog(BlogCreateFrame.this, 
                    "제목, 내용, 작성자는 반드시 입력되어야 합니다.");
            return; //메서드 종료
        }
        Blog blog = new Blog(null, title, content, author, null, null);
        int result = dao.create(blog);
        // TODO: DB insert 성공하면 Main 프레임에게 알려준다. -> 메인 프레임에서 테이블을 새로고침한다.
        if(result == 1) {
            dispose(); // 현재 창 닫기.
            app.notifyBlogCreated(); // 메인 프레임에게 알려줌.
        }
    }
}//end class
