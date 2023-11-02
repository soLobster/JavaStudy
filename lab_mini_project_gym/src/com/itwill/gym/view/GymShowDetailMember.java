package com.itwill.gym.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.controller.PtDao;
import com.itwill.gym.model.GymMember;
import com.itwill.gym.model.PtWithTrainer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GymShowDetailMember extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private GymMemberDao dao;
    private Component parent;
    private Integer id;
    private GymMemUpdateOrShowAll app;
    private JLabel lblMemNum;
    private JLabel lblMemName;
    private JTextField textMemNum;
    private JTextField textMemPhone;
    private JTextField textMemName;
    private JTextField textMemGender;
    private JTextField textMemAddress;
    private JLabel lblMemEnroll;
    private JLabel lblMemAddress;
    private JLabel lblMemBirthDay;
    private JLabel lblMemGender;
    private JLabel lblMemPhone;
    private JDateChooser dateMemBirthday;
    private JLabel lblMemJoinDate;
    private JTextField textJoindate;
    private JTextField textExpireDate;
    private JLabel lblPt;
    private JLabel lblTrainer;
    private JButton btnUpdate;
    private JButton btnBackPage;
    private JTextField textMembership;
    private JLabel lblMemExpireDate;
    private JTextField textPt;
    private JTextField textPtTrainerName;
    private PtDao ptDao = PtDao.getInstance();
    private List<PtWithTrainer> pwt = ptDao.readJoin();
    private LocalDateTime currentDateTime;
    private JTextField textMemBuyDate;
    private JLabel lblMemBuyDate;
    
    public static void showDetailMember(Component parent, Integer id, GymMemUpdateOrShowAll app) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GymShowDetailMember frame = new GymShowDetailMember(parent, id, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GymShowDetailMember(Component parent, Integer id, GymMemUpdateOrShowAll app) {
        this.dao = GymMemberDao.getInstance();
        this.parent = parent;
        this.id = id;
        this.app = app;
        currentDateTime = LocalDateTime.now();
        
        initialize();
        
        initMemberDetails();
    }

    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 713, 694);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblMemNum = new JLabel("회원번호");
        lblMemNum.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemNum.setBounds(12, 10, 108, 59);
        contentPane.add(lblMemNum);

        lblMemName = new JLabel("이름");
        lblMemName.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemName.setBounds(12, 79, 108, 59);
        contentPane.add(lblMemName);

        lblMemPhone = new JLabel("연락처");
        lblMemPhone.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemPhone.setBounds(330, 10, 108, 59);
        contentPane.add(lblMemPhone);

        lblMemGender = new JLabel("성별");
        lblMemGender.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemGender.setBounds(330, 79, 108, 59);
        contentPane.add(lblMemGender);

        lblMemAddress = new JLabel("주소");
        lblMemAddress.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemAddress.setBounds(12, 287, 108, 59);
        contentPane.add(lblMemAddress);

        lblMemBirthDay = new JLabel("생년월일");
        lblMemBirthDay.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemBirthDay.setBounds(12, 148, 108, 59);
        contentPane.add(lblMemBirthDay);

        textMemNum = new JTextField();
        textMemNum.setFont(new Font("나눔고딕", Font.BOLD, 20));
        textMemNum.setEditable(false);
        textMemNum.setBounds(132, 10, 181, 59);
        contentPane.add(textMemNum);
        textMemNum.setColumns(10);

        textMemPhone = new JTextField();
        textMemPhone.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textMemPhone.setColumns(10);
        textMemPhone.setBounds(450, 9, 237, 59);
        contentPane.add(textMemPhone);

        textMemName = new JTextField();
        textMemName.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textMemName.setColumns(10);
        textMemName.setBounds(132, 79, 181, 59);
        contentPane.add(textMemName);

        textMemGender = new JTextField();
        textMemGender.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textMemGender.setColumns(10);
        textMemGender.setBounds(450, 78, 237, 59);
        contentPane.add(textMemGender);

        dateMemBirthday = new JDateChooser();
        dateMemBirthday.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        dateMemBirthday.setBounds(132, 148, 181, 59);
        contentPane.add(dateMemBirthday);

        textMemAddress = new JTextField();
        textMemAddress.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textMemAddress.setBounds(132, 286, 555, 59);
        contentPane.add(textMemAddress);
        textMemAddress.setColumns(10);

        lblMemEnroll = new JLabel("회원권");
        lblMemEnroll.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemEnroll.setBounds(12, 356, 108, 59);
        contentPane.add(lblMemEnroll);

        lblMemExpireDate = new JLabel("회원권 만료일");
        lblMemExpireDate.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemExpireDate.setBounds(330, 217, 108, 59);
        contentPane.add(lblMemExpireDate);

        lblMemJoinDate = new JLabel("회원 가입일");
        lblMemJoinDate.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblMemJoinDate.setBounds(330, 148, 108, 59);
        contentPane.add(lblMemJoinDate);

        textExpireDate = new JTextField(); // textExpireDate 필드 초기화
        textExpireDate.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        textExpireDate.setEditable(false);
        textExpireDate.setColumns(10);
        textExpireDate.setBounds(450, 216, 237, 59);
        contentPane.add(textExpireDate);

        textJoindate = new JTextField();
        textJoindate.setEditable(false);
        textJoindate.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        textExpireDate.setEditable(false);
        textJoindate.setColumns(10);
        textJoindate.setBounds(450, 148, 237, 59);
        contentPane.add(textJoindate);


        lblPt = new JLabel("PT 여부");
        lblPt.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblPt.setBounds(12, 425, 108, 59);
        contentPane.add(lblPt);

        lblTrainer = new JLabel("담당 트레이너");
        lblTrainer.setFont(new Font("나눔고딕", Font.BOLD, 18));
        lblTrainer.setBounds(12, 494, 117, 59);
        contentPane.add(lblTrainer);

        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                updateMember();
            }
        });
        btnUpdate.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnUpdate.setBounds(12, 574, 237, 72);
        contentPane.add(btnUpdate);

        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("나눔고딕", Font.BOLD, 22));
        btnBackPage.setBounds(450, 574, 237, 72);
        contentPane.add(btnBackPage);

        textMembership = new JTextField();
        textMembership.setEditable(false);
        textMembership.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textMembership.setColumns(10);
        textMembership.setBounds(132, 355, 555, 59);
        contentPane.add(textMembership);
        
        textPt = new JTextField();
        textPt.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textPt.setEditable(false);
        textPt.setBounds(132, 425, 555, 59);
        contentPane.add(textPt);
        textPt.setColumns(10);
        
        textPtTrainerName = new JTextField();
        textPtTrainerName.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        textPtTrainerName.setEditable(false);
        textPtTrainerName.setColumns(10);
        textPtTrainerName.setBounds(132, 493, 181, 59);
        contentPane.add(textPtTrainerName);
        
    }

    private void initMemberDetails() {
        //DAO (컨트롤러) 메서드를 이용해서 DB에서 검색하고 , 그 결과를 보여준다.
        GymMember gymMembers = dao.read(id);
        BuyMembershipPage mmp = new BuyMembershipPage(dao.read(id).getPhone());
        if(gymMembers != null) {
            textMemNum.setText(gymMembers.getId().toString());
            textMemName.setText(gymMembers.getName());
            textMemPhone.setText(gymMembers.getPhone());
            textMemGender.setText(gymMembers.getGender());
            textMemAddress.setText(gymMembers.getAddress());
            dateMemBirthday.setDate(gymMembers.getBirthday());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd H:mm");
            String FormattedJoin_Date = gymMembers.getJoinTime().format(formatter);
            textJoindate.setText(FormattedJoin_Date);
            
            
            
           
            /*
             * Expire_date를 어렵게 데이터베이스를 통해 갱신하지 말고 여기 GYMSHOWDETAILMEMBER에서만 표기하면 되니까 
             * JoinDate를 불러온 후 밑의 getMebership_code를 통해 membership_numofdays를 불러오자 
             * 그러고 Joindate에 Membership_numofdays를 더해서 
             * 단순하게 Expire_date를 표기해보자.
             */

            //LocalDateTime joinDate = gymMembers.getJoinTime();

            if(gymMembers.getMembership_code() != 0) {
                
//                int membership_code = gymMembers.getMembership_code();
//                int membership_numofdays = dao.getMembershipNumOfDays(membership_code);
//                LocalDateTime expireDate = currentDateTime.plusDays(membership_numofdays);
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                String FormattedExpireDate = gymMembers.getExpireDate().format(formatter);
//                System.out.println(FormattedExpireDate);
//                String FormattedBuyMembershipDate = gymMembers.get.format(formatter);
//                textMemBuyDate.setText(FormattedBuyMembershipDate);
                String FormattedExpire_Date = gymMembers.getExpireDate().format(formatter);
                textExpireDate.setText(FormattedExpire_Date);

                //updateGymMemberSetExpireDate가 여기에 있는게 맞는건가...???
               
                String membership_category = dao.getMembership_category(gymMembers.getMembership_code());
                System.out.println(gymMembers.getMembership_code());
                textMembership.setText(membership_category);
                
                
            } else if (gymMembers.getMembership_code() == 0){
//                textMemBuyDate.setText("X");
                textExpireDate.setText("X");
                textMembership.setText("X");
            }
            

            if(gymMembers.getPt_Code() != 0) {
                for(PtWithTrainer p : pwt) {
                    if(p.getPt_code() == gymMembers.getPt_Code()) {
                        textPt.setText(p.getPt_category());
                        textPtTrainerName.setText(p.getTrainerName());
                    }
                }
            } else if (gymMembers.getPt_Code() == 0) {
                textPt.setText("X");
                textPtTrainerName.setText("X");
            } 
        }//if(gymMembers != null)   
    }//initMemberDetails
    
    private void updateMember() {
        Integer id = Integer.parseInt(textMemNum.getText());
        String name = textMemName.getText();
        String phone = textMemPhone.getText();
        String address = textMemAddress.getText();
        String gender = textMemGender.getText();
        
        java.util.Date utilDate = dateMemBirthday.getDate();
        Date birthday = (utilDate != null) ? new java.sql.Date(utilDate.getTime()) : null;
        
        if(name.equals("") || phone.equals("") || gender.equals("") || birthday==null || address.equals("")) {
            JOptionPane.showMessageDialog(GymShowDetailMember.this, "이름, 연락처, 성별, 생년월일, 주소는 반드시 입력되어야 합니다.");
            return;
        }
        GymMember gymMember = new GymMember(id, name, phone, gender, birthday, address);
        int result = dao.update(gymMember);
        
        if(result == 1) {
            dispose();
            app.notifyMemberUpdated();
        }
        
    }//end updateMember()
    
//    private void UpdateMembershipBuyDate(int id, LocalDateTime buyDate) {
//        dao.updateGymMemberSetMembershipBuyDate(id, buyDate);
//    }
//    
//    private void UpdateMembershipExpireDate(int id, LocalDateTime expireDate) {
//        dao.updateGymMemberSetExpireDate(id, expireDate);
//    }
}//end claass
