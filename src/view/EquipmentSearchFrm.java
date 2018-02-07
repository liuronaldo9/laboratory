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
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import dao.EquipmentDAO;

import util.Dbutil;

import model.Equipment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 设备信息查询窗口
 * @author LeLe
 *
 */
public class EquipmentSearchFrm extends JInternalFrame {
	private JTable equipmentTable;
	private JTextField s_equipmentTypeNameTxt;
	
	private Dbutil dbutil = new Dbutil();
	private EquipmentDAO equipmentDAO = new EquipmentDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentSearchFrm frame = new EquipmentSearchFrm();
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
	public EquipmentSearchFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BBE\u5907\u67E5\u627E\u7A97\u53E3");
		setBounds(100, 100, 605, 447);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		s_equipmentTypeNameTxt = new JTextField();
		s_equipmentTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(EquipmentSearchFrm.class.getResource("/images/search.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		equipmentTable = new JTable();
		equipmentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BBE\u5907\u7C7B\u578B\u540D\u79F0", "\u8BBE\u5907\u540D\u79F0", "\u89C4\u683C", "\u5355\u4EF7", "\u8D2D\u4E70\u65E5\u671F", "\u751F\u4EA7\u5382\u5546", "\u6570\u91CF", "\u8D2D\u4E70\u4EBA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(equipmentTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Equipment());
	}
	
	/**
	 * 设备查询事件
	 * @param evt
	 */
	private void equipmentSearchActionPerformed(ActionEvent evt) {
		String s_equipmentTypeName = this.s_equipmentTypeNameTxt.getText();
		Equipment equipment = new Equipment();
		equipment.setEquipmentTypeName(s_equipmentTypeName);
		this.fillTable(equipment);
	}

	/**
	 * 初始化表单
	 */
	private void fillTable(Equipment equipment){
		DefaultTableModel dtm = (DefaultTableModel) equipmentTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = equipmentDAO.list(con, equipment);
			while (rs.next()) {
				Vector vector  = new Vector();
				vector.add(rs.getString("id"));
				vector.add(rs.getString("equipmentTypeName"));
				vector.add(rs.getString("equipmentName"));
				vector.add(rs.getString("standard"));
				vector.add(rs.getString("price"));
				vector.add(rs.getString("buyData"));
				vector.add(rs.getString("production"));
				vector.add(rs.getString("amount"));
				vector.add(rs.getString("buyPerson"));
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
