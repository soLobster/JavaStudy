package com.itwill.gym.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.gym.controller.GymMemberDao;
import com.itwill.gym.controller.PtDao;
import com.itwill.gym.model.GymMember;
import com.itwill.gym.model.PT;
import com.itwill.gym.model.PtWithTrainer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyPtPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblPtBuyInfo;
    private JComboBox<String> ptComboBox;
    private String memberPhone;
    private PtDao dao = PtDao.getInstance();
    private JLabel lblPtPrice;
    private JTextField textPtPrice;
    private JLabel lblPtTrainer;
    private JTextField textPtTrainer;
    private JTextField textPtCount;
    private JLabel lblPtCount;
    private JButton btnBuyPt;
    private JButton btnBackPage;
    private List<PT> ptList = dao.read();
    private List<PtWithTrainer> pwt = dao.readJoin();

    /**
     * Launch the application.
     */
    public static void showBuyPtPage(String memberPhone) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuyPtPage frame = new BuyPtPage(memberPhone);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BuyPtPage(String memberPhone) {
        dao = PtDao.getInstance();
        this.memberPhone = memberPhone;
        initialize();
        popUpPtComboBox();
        //        fillTextField();
    }



    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("ITWILL_FITNESS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 353, 583);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblPtBuyInfo = new JLabel("PT권 구매");
        lblPtBuyInfo.setFont(new Font("D2Coding", Font.BOLD, 32));
        lblPtBuyInfo.setBounds(12, 10, 461, 78);
        contentPane.add(lblPtBuyInfo);

        ptComboBox = new JComboBox();
        ptComboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPtCategory = (String) ptComboBox.getSelectedItem();

                for(PtWithTrainer pt : pwt) {
                    if(pt.getPt_category().equals(selectedPtCategory)) {
                        textPtPrice.setText(String.valueOf(pt.getPt_price() + " 원"));
                        textPtCount.setText(String.valueOf(pt.getPt_time() + " 회"));
                        //조인한 테이블을 토대로 트레이너의 이름을 불러오고자 한다.
                        textPtTrainer.setText(pt.getTrainerName());
                        break;
                    }
                }
            }
        });
        ptComboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
        ptComboBox.setBounds(12, 119, 313, 88);
        contentPane.add(ptComboBox);

        lblPtPrice = new JLabel("PT권 금액");
        lblPtPrice.setHorizontalAlignment(SwingConstants.LEFT);
        lblPtPrice.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblPtPrice.setBounds(12, 255, 133, 47);
        contentPane.add(lblPtPrice);

        textPtPrice = new JTextField();
        textPtPrice.setEditable(false);
        textPtPrice.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textPtPrice.setBounds(192, 255, 133, 47);
        contentPane.add(textPtPrice);
        textPtPrice.setColumns(10);

        lblPtTrainer = new JLabel("담당 트레이너");
        lblPtTrainer.setHorizontalAlignment(SwingConstants.LEFT);
        lblPtTrainer.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblPtTrainer.setBounds(12, 312, 133, 47);
        contentPane.add(lblPtTrainer);

        textPtTrainer = new JTextField();
        textPtTrainer.setEditable(false);
        textPtTrainer.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textPtTrainer.setColumns(10);
        textPtTrainer.setBounds(192, 312, 133, 47);
        contentPane.add(textPtTrainer);

        lblPtCount = new JLabel("PT 횟수");
        lblPtCount.setHorizontalAlignment(SwingConstants.LEFT);
        lblPtCount.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblPtCount.setBounds(12, 369, 133, 47);
        contentPane.add(lblPtCount);

        textPtCount = new JTextField();
        textPtCount.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textPtCount.setEditable(false);
        textPtCount.setColumns(10);
        textPtCount.setBounds(192, 369, 133, 47);
        contentPane.add(textPtCount);

        btnBuyPt = new JButton("구매하기");
        btnBuyPt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmedBuyPt();
            }
        });
        btnBuyPt.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnBuyPt.setBounds(12, 478, 133, 47);
        contentPane.add(btnBuyPt);

        btnBackPage = new JButton("뒤로가기");
        btnBackPage.addActionListener((e) -> dispose());
        btnBackPage.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnBackPage.setBounds(192, 478, 133, 47);
        contentPane.add(btnBackPage);
    }//end initialize

    private void confirmedBuyPt() {
        //TODO ComboBox를 통해 선택한 PT 이용권을 구매한다.
        String selectedPtCategory = (String) ptComboBox.getSelectedItem();
        if(selectedPtCategory == null) {
            JOptionPane.showMessageDialog(BuyPtPage.this, "PT이용권을 선택해주세요.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(BuyPtPage.this, 
                "PT 이용권을 정말 구매하시겠습니까?",
                "구매 확인",
                JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            GymMemberDao memberDao = GymMemberDao.getInstance();
            GymMember member = memberDao.read(memberPhone);

            if(member != null) {
                PtDao ptDao = PtDao.getInstance();
                PtWithTrainer pt = null;

                for(PtWithTrainer ptInfo : pwt) {
                    if(ptInfo.getPt_category().equals(selectedPtCategory)) {
                        pt = ptInfo;
                        break;
                    }
                }

                if (pt != null) {
                    // PT 이용권을 사용자에게 할당 (사용자 정보를 업데이트)
                    member.setPt_Code(pt.getPt_code()); // 이용권 코드 설정

                    // 사용자 정보를 데이터베이스에 업데이트 (실제 데이터베이스와 연결해야 함)
                    memberDao.update(member);

                    // 사용자에게 성공 메시지 표시
                    JOptionPane.showMessageDialog(BuyPtPage.this, "PT 이용권 구매 성공!");
                } else {
                    // 선택한 PT 이용권 정보를 찾을 수 없는 경우
                    JOptionPane.showMessageDialog(BuyPtPage.this, "선택한 PT 이용권을 찾을 수 없습니다.");
                }
            } else {
                // 사용자 정보를 찾을 수 없는 경우
                JOptionPane.showMessageDialog(BuyPtPage.this, "해당 회원 정보를 찾을 수 없습니다.");
            }
        }
    }//confirmedBuyPt


    private void popUpPtComboBox() {
        ptList = dao.read();
        ptComboBox.removeAllItems(); // 기존의 아이템을 제거합니다.

        for (PT pt : ptList) {
            ptComboBox.addItem(pt.getPt_category());
        }
    }//end popUpPtComboBox().



}
