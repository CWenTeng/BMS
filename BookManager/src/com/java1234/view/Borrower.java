package com.java1234.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.dao.BorrowDao;
import com.java1234.dao.PeopleDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.model.Borrow;
import com.java1234.model.People;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

public class Borrower extends JInternalFrame {
	private JTable peopleTable;
	private JTable borrowTable;
	private JTextField PeopleNameTxt;
	private JTextField peopleIdTxt;
	private JTextField PeopleBranchTxt;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTable bookTable;

	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();
	private BookTypeDao bookTypeDao=new BookTypeDao();

	private JComboBox bookTypeNameJrb;
	private PeopleDao peopleDao=new PeopleDao();

	private BorrowDao borrowDao=new BorrowDao();
	Book currentbook = new Book();
	String bookid="",peopleid="",backbookid="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrower frame = new Borrower();
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
	public Borrower() {
		setClosable(true);
		setTitle("\u501F\u9605\u4FE1\u606F");
		setBounds(100, 100, 700, 722);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5DF2\u501F\u56FE\u4E66", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");

		JScrollPane scrollPane_2 = new JScrollPane();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel label_2 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");

		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);

		JLabel label_3 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");

		authorTxt = new JTextField();
		authorTxt.setColumns(10);

		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u578B:");

		JButton button_4 = new JButton("\u67E5\u8BE2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookActionPerFormed(e);
			}
		});
		button_4.setIcon(new ImageIcon(Borrower.class.getResource("/images/search.png")));

		bookTypeNameJrb = new JComboBox();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(10)
								.addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(label_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypeNameJrb, 0, 80, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_4)
								.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(button_4)
										.addComponent(label_2)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3)
										.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4)
										.addComponent(bookTypeNameJrb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addGap(26)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
														.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
														.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 632, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap(30, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE)
														.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 628, GroupLayout.PREFERRED_SIZE))))
								.addGap(30))
		);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(192, Short.MAX_VALUE))
		);

		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u6027\u522B", "\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u578B"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(118);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(48);
		scrollPane_2.setViewportView(bookTable);

		JLabel label = new JLabel("\u59D3\u540D\uFF1A");

		PeopleNameTxt = new JTextField();
		PeopleNameTxt.setColumns(10);

		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peopleActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(Borrower.class.getResource("/images/search.png")));

		JLabel lblId = new JLabel("ID\uFF1A");

		peopleIdTxt = new JTextField();
		peopleIdTxt.setColumns(10);

		JLabel label_1 = new JLabel("\u90E8\u95E8\uFF1A");

		PeopleBranchTxt = new JTextField();
		PeopleBranchTxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(34)
								.addComponent(lblId)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(peopleIdTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(PeopleNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(PeopleBranchTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(button)
								.addGap(25))
		);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblId)
										.addComponent(peopleIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(PeopleNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label)
										.addComponent(label_1)
										.addComponent(PeopleBranchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(button))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JButton button_1 = new JButton("\u5F52\u8FD8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(Borrower.class.getResource("/images/reset.png")));

		JButton button_2 = new JButton("\u4E22\u5931");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loseActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(Borrower.class.getResource("/images/delete.png")));

		JScrollPane scrollPane_1 = new JScrollPane();

		borrowTable = new JTable();
		borrowTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				borrowMousePressed(e);
			}
		});
		borrowTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u6027\u522B", "\u4EF7\u683C", "\u56FE\u4E66\u7C7B\u522B"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		borrowTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		borrowTable.getColumnModel().getColumn(1).setPreferredWidth(122);
		borrowTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane_1.setViewportView(borrowTable);

		JButton button_3 = new JButton("\u6DFB\u52A0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		button_3.setIcon(new ImageIcon(Borrower.class.getResource("/images/add.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(button_3)
												.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
												.addComponent(button_1)
												.addGap(152)
												.addComponent(button_2)))
								.addContainerGap())
		);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap(30, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(button_2)
												.addComponent(button_1))
										.addComponent(button_3))
								.addContainerGap())
		);
		panel.setLayout(gl_panel);

		peopleTable = new JTable();
		peopleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				peopleMousePressed(e);
			}
		});
		peopleTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u7F16\u53F7", "\u59D3\u540D", "\u5E74\u9F84", "\u6027\u522B", "\u90E8\u95E8"
				}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		peopleTable.getColumnModel().getColumn(0).setPreferredWidth(65);
		peopleTable.getColumnModel().getColumn(1).setPreferredWidth(112);
		peopleTable.getColumnModel().getColumn(4).setPreferredWidth(105);
		scrollPane.setViewportView(peopleTable);
		getContentPane().setLayout(groupLayout);

		this.BookTable(new Book());
		this.PeopleTable(new People());
		fillBookType();

	}


	/**
	 * 图书丢失处理
	 * @param e
	 */
	private void loseActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(backbookid)){
			JOptionPane.showMessageDialog(null, "请选择丢失的图书");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定删除该记录吗？");
		if(n==0){
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int loseNum=borrowDao.lose(con, backbookid);
				if(loseNum>0){
					JOptionPane.showMessageDialog(null, "成功删除");
					backbookid="";
				}else if(loseNum==0){
					JOptionPane.showMessageDialog(null, "无删除记录");
				}else if(loseNum==-1){
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				this.BookTable(new Book());
				this.BorrowTable();
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}


	/**
	 * 图书归还事件处理
	 * @param e
	 */
	private void backActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(backbookid)){
			JOptionPane.showMessageDialog(null, "请选择要归还的图书");
			return;
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int backNum=borrowDao.back(con, backbookid);
			if(backNum==1){
				JOptionPane.showMessageDialog(null, "成功归还");
				backbookid="";
				this.BorrowTable();
				this.BookTable(new Book());
			}else{
				JOptionPane.showMessageDialog(null, "归还失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "归还失败");
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
	 * 图书借阅信息添加处理
	 * @param e
	 */
	private void addActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookId=this.bookid;
		String peopleId=this.peopleid;

		if(StringUtil.isEmpty(peopleId)){
			JOptionPane.showMessageDialog(null, "请选择借阅会员");
			return;
		}

		if(StringUtil.isEmpty(bookId)){
			JOptionPane.showMessageDialog(null, "请选择借阅图书");
			return;
		}
		Borrow borrow=new Borrow(peopleId, bookId);

		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addNum=borrowDao.add(con, borrow);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "添加成功");
				bookid="";
				this.BorrowTable();
				this.BookTable(new Book());
				return;
			}else{
				JOptionPane.showMessageDialog(null, "添加失败");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
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
	 * 图书信息点击处理
	 * @param e
	 */
	private void bookMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=this.bookTable.getSelectedRow();
		//String b=(String) bookTable.getValueAt(row, 0);
		this.bookid=(String) bookTable.getValueAt(row, 0);

	}

	/**
	 * 借阅人员点击处理
	 * @param e
	 */
	private void peopleMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=this.peopleTable.getSelectedRow();
		//String p=(String)peopleTable.getValueAt(row,0);
		this.peopleid=(String) peopleTable.getValueAt(row,0);
		backbookid="";
		this.BorrowTable();
	}


	/**
	 * 借阅图书点击处理
	 * @param e
	 */
	private void borrowMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=this.borrowTable.getSelectedRow();
		//String w=(String) borrowTable.getValueAt(row, 0);
		this.backbookid=(String) borrowTable.getValueAt(row, 0);
	}



	/**
	 * 借阅人员查询
	 * @param e
	 */
	private void peopleActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String peopleId=this.peopleIdTxt.getText();
		String peopleName=this.PeopleNameTxt.getText();
		String peopleBranch=this.PeopleBranchTxt.getText();

		People people=new People(peopleId,peopleName,peopleBranch);
		this.PeopleTable(people);
	}

	/**
	 * 图书查询
	 * @param e
	 */
	private void bookActionPerFormed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		BookType bookType=(BookType) this.bookTypeNameJrb.getSelectedItem();
		int bookTypeId=bookType.getId();

		Book book=new Book(bookName,author,bookTypeId);
		this.BookTable(book);
	}


	/**
	 * 借阅信息查询表格
	 */
	private void BorrowTable(){
		DefaultTableModel dtm=(DefaultTableModel) borrowTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=borrowDao.list(con,this.peopleid);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}





	/**
	 * 借阅人员表格初始化
	 * @param people
	 */
	private void PeopleTable(People people){
		DefaultTableModel dtm=(DefaultTableModel) peopleTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=peopleDao.list(con,people);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("peopleName"));
				v.add(rs.getInt("peopleAge"));
				v.add(rs.getString("peopleSex"));
				v.add(rs.getString("peopleBranch"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 初始化图书表格
	 * @param book
	 */
	private void BookTable(Book book){
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); 				//设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con,book);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * 借阅信息
	 */
	private void BorrowTable(String p,Book book){
		DefaultTableModel dtm=(DefaultTableModel) peopleTable.getModel();
		dtm.setRowCount(0); 				//设置成0行
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con,book);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 图书类别下拉菜单
	 */
	private void fillBookType(){
		Connection con=null;
		BookType bookType=null;

		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			bookType=new BookType();
			bookType.setBookTypeName("请选择......");
			bookType.setId(-1);
			this.bookTypeNameJrb.addItem(bookType);
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeNameJrb.addItem(bookType);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
