package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ApplyDAO;

import util.Dbutil;

import model.Apply;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 申请的设备查询窗口
 * @author LeLe
 *
 */
public class ApplySearchFrm extends JInternalFrame {
	private JTable applyTable;
	private Dbutil dbutil = new Dbutil();
	private ApplyDAO applyDAO =new ApplyDAO();
	private JTextField s_equipmentNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplySearchFrm frame = new ApplySearchFrm();
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
	public ApplySearchFrm() {
		setTitle("\u7533\u8BF7\u4FE1\u606F\u67E5\u8BE2");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u540D\u79F0\uFF1A");
		
		s_equipmentNameTxt = new JTextField();
		s_equipmentNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applySearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(ApplySearchFrm.class.getResource("/images/search.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_equipmentNameTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_equipmentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
		);
		
		applyTable = new JTable();
		applyTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BBE\u5907\u540D\u79F0", "\u7533\u8BF7\u65E5\u671F", "\u89C4\u683C", "\u6570\u91CF", "\u7533\u8BF7\u4EBA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(applyTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable_1(new Apply());
	}
	
	/**
	 * 申请信息查询事件
	 * @param evt
	 */
	private void applySearchActionPerformed(ActionEvent evt) {
		String s_equipmentName = this.s_equipmentNameTxt.getText();
		Apply apply = new Apply();
		apply.setEquipmentName(s_equipmentName);
		this.fillTable_1(apply);
	}

	/**
	 * 初始化表格
	 * @param apply
	 */
	private void fillTable_1(Apply apply){
		DefaultTableModel dtm = (DefaultTableModel) applyTable.getModel();
		dtm.setRowCount(0);
		Connection con =null;
		try {
			con = dbutil.getCon();
			ResultSet rs = applyDAO.list(con, apply);
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("id"));
				vector.add(rs.getString("equipmentName"));
				vector.add(rs.getString("applyData"));
				vector.add(rs.getString("standard"));
				vector.add(rs.getString("amount"));
				vector.add(rs.getString("applicant"));
				dtm.addRow(vector);
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		finally{
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
