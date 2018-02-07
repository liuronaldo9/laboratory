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

import dao.ScrapDAO;

import util.Dbutil;

import model.Scrap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScrapSearchInterFrm extends JInternalFrame {
	private JTextField s_equipmentTypeNameTxt;
	private JTable scrapTable;
	
	private Dbutil dbutil = new Dbutil();
	private ScrapDAO scrapDAO = new ScrapDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrapSearchInterFrm frame = new ScrapSearchInterFrm();
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
	public ScrapSearchInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u62A5\u5E9F\u8BBE\u5907\u67E5\u8BE2");
		setBounds(100, 100, 597, 421);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		s_equipmentTypeNameTxt = new JTextField();
		s_equipmentTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrapSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(ScrapSearchInterFrm.class.getResource("/images/search.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		scrapTable = new JTable();
		scrapTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BBE\u5907\u7C7B\u578B\u540D\u79F0", "\u8BBE\u5907\u540D\u79F0", "\u62A5\u5E9F\u65E5\u671F", "\u8D23\u4EFB\u4EBA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(scrapTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Scrap());

	}
	
	/**
	 * 报废设备查询事件
	 * @param evt
	 */
	private void scrapSearchActionPerformed(ActionEvent evt) {
		String s_equipmentTypeName = s_equipmentTypeNameTxt.getText();
		Scrap scrap = new Scrap();
		scrap.setEquipmentTypeName(s_equipmentTypeName);
		this.fillTable(scrap);
	}

	/**
	 * 初始化表格
	 */
	private void fillTable(Scrap scrap){
		DefaultTableModel dtm = (DefaultTableModel) scrapTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbutil.getCon();
			ResultSet rs = scrapDAO.list(con, scrap);
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString("id"));
				vector.add(rs.getString("equipmentTypeName"));
				vector.add(rs.getString("equipmentName"));
				vector.add(rs.getString("scrapData"));
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
