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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailsFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblId;
    private JTextField textId;
    private JTextField textTitle;
    private JLabel lblTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JTextField textAuthor;
    private JTextField textCreated;
    private JTextField textModified;
    private JLabel lblAuthor;
    private JLabel lblCreateTime;
    private JLabel lblModifiedTime;
    
    private BlogDao dao;
    private Component parent;
    private Integer id;
    private BlogMain app;
    
    /**
     * Launch the application.
     */
    public static void showBlogDetailsFrame(Component parent, Integer id, BlogMain app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogDetailsFrame frame = new BlogDetailsFrame(parent, id, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //생성자 분리.
    public BlogDetailsFrame(Component parent, Integer id, BlogMain app) {
        //TODO:
        this.dao = BlogDao.getInstance();
        this.parent = parent;
        this.id = id;
        this.app = app;
        //UI 컴포넌트들 초기화.
        initialize();
        
        //UI 컴포넌트의 값들을 초기화.
        initBlogDetails();
    }
    
    
    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("포스트 상세보기");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = 100;
        int y = 100;
        
        if(parent != null) {
            x = parent.getX()+parent.getWidth();
            y = parent.getY();
        }
        
        setBounds(x, y, 581, 794);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblId = new JLabel("번호");
        lblId.setHorizontalAlignment(SwingConstants.CENTER);
        lblId.setFont(new Font("D2Coding", Font.PLAIN, 16));
        lblId.setBounds(12, 10, 102, 68);
        contentPane.add(lblId);
        
        textId = new JTextField();
        textId.setEditable(false);
        textId.setFont(new Font("D2Coding", Font.PLAIN, 25));
        textId.setBounds(126, 10, 427, 68);
        contentPane.add(textId);
        textId.setColumns(10);
        
        lblTitle = new JLabel("제목");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 16));
        lblTitle.setBounds(12, 88, 102, 68);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 25));
        textTitle.setColumns(10);
        textTitle.setBounds(126, 88, 427, 68);
        contentPane.add(textTitle);
        
        lblContent = new JLabel("내용");
        lblContent.setHorizontalAlignment(SwingConstants.CENTER);
        lblContent.setFont(new Font("D2Coding", Font.PLAIN, 16));
        lblContent.setBounds(12, 166, 102, 68);
        contentPane.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(126, 166, 427, 246);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(textContent);
        
        lblAuthor = new JLabel("작성자");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 16));
        lblAuthor.setBounds(12, 422, 102, 68);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 25));
        textAuthor.setEditable(false);
        textAuthor.setColumns(10);
        textAuthor.setBounds(126, 422, 427, 68);
        contentPane.add(textAuthor);
        
        lblCreateTime = new JLabel("작성시간");
        lblCreateTime.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateTime.setFont(new Font("D2Coding", Font.PLAIN, 16));
        lblCreateTime.setBounds(12, 500, 102, 68);
        contentPane.add(lblCreateTime);
        
        textCreated = new JTextField();
        textCreated.setFont(new Font("D2Coding", Font.PLAIN, 25));
        textCreated.setEditable(false);
        textCreated.setColumns(10);
        textCreated.setBounds(126, 500, 427, 68);
        contentPane.add(textCreated);
        
        lblModifiedTime = new JLabel("수정시간");
        lblModifiedTime.setHorizontalAlignment(SwingConstants.CENTER);
        lblModifiedTime.setFont(new Font("D2Coding", Font.PLAIN, 16));
        lblModifiedTime.setBounds(12, 578, 102, 68);
        contentPane.add(lblModifiedTime);
        
        textModified = new JTextField();
        textModified.setFont(new Font("D2Coding", Font.PLAIN, 25));
        textModified.setEditable(false);
        textModified.setColumns(10);
        textModified.setBounds(126, 578, 427, 68);
        contentPane.add(textModified);
        
        JButton btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBlogPost();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnUpdate.setBounds(126, 656, 137, 59);
        contentPane.add(btnUpdate);
        
        JButton btnClose = new JButton("닫기");
        btnClose.addActionListener((e) -> dispose());
        btnClose.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnClose.setBounds(305, 656, 137, 59);
        contentPane.add(btnClose);
    }//end initialize()
    
    private void updateBlogPost() {
        Integer id = Integer.parseInt(textId.getText());
        String title = textTitle.getText();
        String content = textContent.getText();
        if(title.equals("") || content.equals("")) {
            //메서드가 있는 클래스는 BlogDetailFrame 이기 때문에 자기 자신 this.
            JOptionPane.showMessageDialog(this,"제목과 내용은 반드시 입력하세요.");
            return;
        }
        Blog blog = new Blog(id, title, content, null, null, null);
        int result = dao.update(blog);
        if(result == 1) {
            dispose();
            app.notifyBlogUpdated();
        }
    }//updateBlogPost

    private void initBlogDetails() {
       // DAO (컨트롤러) 메서드를 이용해서 DB에서 검색하고 , 그 결과를 보여준다.
        Blog blog = dao.read(id);
        if(blog != null) {
            textId.setText(blog.getId().toString());
            textTitle.setText(blog.getTitle());
            textContent.setText(blog.getContent());
            textAuthor.setText(blog.getAuthor());
            textCreated.setText(blog.getCreatedTime().toString());
            textModified.setText(blog.getModifiedTime().toString());
        }
    }//initBlogDetails

}//end class
