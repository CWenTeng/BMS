package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.PeopleDao;
import com.java1234.model.People;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

public class BorrowerAdd extends JInternalFrame {
	private JTextField PeopleNameTxt;
	private JTextField PeopleAgeTxt;
	private JLabel label_2;
	private JLabel lblId;
	private JTextField PeopleIDTxt;
	private JLabel label_3;
	private JTextField PeopleBranchTxt;
	private JButton button;
	private JButton button_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	
	private DbUtil dbUtil=new DbUtil();
	private PeopleDao peopleDao=new PeopleDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerAdd frame = new BorrowerAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BorrowerAdd() {
		setClosable(true);
		setTitle("\u6DFB\u52A0\u501F\u9605\u4F1A\u5458");
		setBounds(100, 100, 449, 208);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		
		PeopleNameTxt = new JTextField();
		PeopleNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5E74\u9F84\uFF1A");
		
		PeopleAgeTxt = new JTextField();
		PeopleAgeTxt.setColumns(10);
		
		label_2 = new JLabel("\u6027\u522B\uFF1A");
		
		lblId = new JLabel("ID\uFF1A");
		
		PeopleIDTxt = new JTextField();
		PeopleIDTxt.setColumns(10);
		
		label_3 = new JLabel("\u90E8\u95E8\uFF1A");
		
		PeopleBranchTxt = new JTextField();
		PeopleBranchTxt.setColumns(10);
		
		manJrb = new JRadioButton("\u7537");
		manJrb.setSelected(true);
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BorrowerAdd.class.getResource("/images/reset.png")));
		
		button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowerAddActionPerformde(e);
			}
		});
		button_1.setIcon(new ImageIcon(BorrowerAdd.class.getResource("/images/add.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PeopleIDTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PeopleNameTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PeopleAgeTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(manJrb)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(femaleJrb, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PeopleBranchTxt, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(PeopleIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PeopleAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(label)
						.addComponent(PeopleNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(manJrb)
						.addComponent(PeopleBranchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(femaleJrb)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(38))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	
	/**
	 * 图书添加事件处理
	 * @param e
	 */
	private void BorrowerAddActionPerformde(ActionEvent e) {
		// TODO Auto-generated method stub
		String PeopleID=this.PeopleIDTxt.getText();
		String PeopleName=this.PeopleNameTxt.getText();
		String PeopleAge=this.PeopleAgeTxt.getText();
		String PeopleBranch=this.PeopleBranchTxt.getText();
		if(StringUtil.isEmpty(PeopleID)){
			JOptionPane.showMessageDialog(null, "ID不能为空！");
			return;
		}
		if(StringUtil.isEmpty(PeopleName)){
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(PeopleAge)){
			JOptionPane.showMessageDialog(null, "年龄不能为空！");
			return;
		}
		if(StringUtil.isEmpty(PeopleBranch)){
			JOptionPane.showMessageDialog(null, "部门不能为空！");
			return;
		}
		
		String sex="";
		if(manJrb.isSelected()){
			sex="男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		
		People people=new People(PeopleID ,  PeopleName,  Integer.parseInt(PeopleAge), sex, PeopleBranch);
		
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addpeople=peopleDao.add(con,people);
			if(addpeople==1){
				JOptionPane.showMessageDialog(null, "添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "添加失败！");				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败！");	
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.PeopleIDTxt.setText("");
		this.PeopleNameTxt.setText("");
		this.PeopleAgeTxt.setText("");
		this.PeopleBranchTxt.setText("");
	}
	
}
