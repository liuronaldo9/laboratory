package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.RepairEquipmentDAO;

import util.Dbutil;

import model.RepairEquipment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 维修设备查询窗口
 * @author LeLe
 *
 */
public class RepairEquipmentSearchInterFrm extends JInternalFrame {
	private JTextField s_equipmentTypeNameTxt;
	private JTable repairTable;
	
	private Dbutil dbutil = new Dbutil();
	private RepairEquipmentDAO repairEquipmentDAO = new RepairEquipmentDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepairEquipmentSearchInterFrm frame = new RepairEquipmentSearchInterFrm();
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
	public RepairEquipmentSearchInterFrm() {
		setTitle("\u8BBE\u5907\u7EF4\u4FEE\u67E5\u627E");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 609, 431);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		s_equipmentTypeNameTxt = new JTextField();
		s_equipmentTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repairSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(RepairEquipmentSearchInterFrm.class.getResource("/images/search.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		repairTable = new JTable();
		repairTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BBE\u5907\u7C7B\u578B\u540D\u79F0", "\u8BBE\u5907\u540D\u79F0", "\u4FEE\u7406\u65E5\u671F", "\u4FEE\u7406\u5382\u5BB6", "\u4FEE\u7406\u8D39", "\u8D23\u4EFB\u4EBA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(repairTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new RepairEquipment());

	}
	
	/**
	 * 修理信息查询事件
	 * @param evt
	 */
	private void repairSearchActionPerformed(ActionEvent evt) {
		String s_equipmentTypeName = s_equipmentTypeNameTxt.getText();
		RepairEquipment repairEquipment = new RepairEquipment();
		repairEquipment.setEquipmentTypeName(s_equipmentTypeName);
		this.fillTable(repairEquipment);
	}

	/**
	 * 初始化表格
	 */
	private void fillTable(RepairEquipment repairEquipment){
		DefaultTableModel dtm = (DefaultTableModel) repairTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = repairEquipmentDAO.list(con, repairEquipment);
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("id"));
				vector.add(rs.getString("equipmentTypeName"));
				vector.add(rs.getString("equipmentName"));
				vector.add(rs.getString("repairData"));
				vector.add(rs.getString("repairManufacturers"));
				vector.add(rs.getString("repairCost"));
				vector.add(rs.getString("dutyPerson"));
				dtm.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
