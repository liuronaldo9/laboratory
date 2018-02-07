package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import dao.RepairEquipmentDAO;

import model.RepairEquipment;

import util.Dbutil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
/**
 * 维修设备信息条添加窗口
 * @author LeLe
 *
 */
public class RepairEquipmentAddInterFrm extends JInternalFrame {
	private JTextField equipmentTypeNameTxt;
	private JTextField equipmentName;
	private JTextField repairData;
	private JTextField repairManfacturers;
	private JTextField repairCost;
	private JTextField dutyPerson;
	
	private Dbutil dbutil = new Dbutil();
	private RepairEquipmentDAO repairEquipmentDAO = new RepairEquipmentDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepairEquipmentAddInterFrm frame = new RepairEquipmentAddInterFrm();
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
	public RepairEquipmentAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BBE\u5907\u7EF4\u4FEE\u767B\u8BB0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u8BBE\u5907\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		equipmentTypeNameTxt = new JTextField();
		equipmentTypeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BBE\u5907\u540D\u79F0\uFF1A");
		
		equipmentName = new JTextField();
		equipmentName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7EF4\u4FEE\u65E5\u671F\uFF1A");
		
		repairData = new JTextField();
		repairData.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7EF4\u4FEE\u5382\u5546\uFF1A");
		
		repairManfacturers = new JTextField();
		repairManfacturers.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7EF4\u4FEE\u8D39\u7528\uFF1A");
		
		repairCost = new JTextField();
		repairCost.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8D1F\u8D23\u4EBA\uFF1A");
		
		dutyPerson = new JTextField();
		dutyPerson.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repairEquipmentAddActionPreformed(e);
			}
		});
		button.setIcon(new ImageIcon(RepairEquipmentAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repairRestValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(RepairEquipmentAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(label_2)
								.addComponent(lblNewLabel)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(label_4))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dutyPerson)
								.addComponent(repairCost)
								.addComponent(repairManfacturers)
								.addComponent(repairData)
								.addComponent(equipmentName)
								.addComponent(equipmentTypeNameTxt, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(30)
							.addComponent(button_1)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(equipmentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(repairData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(repairManfacturers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(repairCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dutyPerson, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 设备维修记录添加事件
	 * @param evt
	 */
	private void repairEquipmentAddActionPreformed(ActionEvent evt) {
		String equipmentTypeName = this.equipmentTypeNameTxt.getText();
		String equipmentName = this.equipmentName.getText();
		String repairData = this.repairData.getText();
		String repairManfacturers = this.repairManfacturers.getText();
		float repairCost = Float.parseFloat(this.repairCost.getText());
		String dutyPerson = this.dutyPerson.getText();
		
		if (StringUtil.isEmpty(equipmentTypeName)) {
			JOptionPane.showMessageDialog(null, "设备类型名称不能为空！");
			return;
		}
		if (StringUtil.isEmpty(equipmentName)) {
			JOptionPane.showMessageDialog(null, "设备名称不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairData)) {
			JOptionPane.showMessageDialog(null, "维修日期不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repairManfacturers)) {
			JOptionPane.showMessageDialog(null, "维修厂商不能为空！");
			return;
		}
		if (StringUtil.isEmpty(dutyPerson)) {
			JOptionPane.showMessageDialog(null, "负责人不能为空！");
			return;
		}
		
		RepairEquipment rEquipment = new RepairEquipment(equipmentTypeName, equipmentName, repairData, repairManfacturers, repairCost, dutyPerson);
		Connection con = null;
		try {
			con = dbutil.getCon();
			int n = repairEquipmentDAO.repairEquipmentAdd(con, rEquipment);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "设备维护信息提交成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "设备维护信息提交失败！");
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

	/**
	 * 维修表单重置事件处理
	 * @param e
	 */
	private void repairRestValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}
	
	/**
	 * 表单重置
	 */
	private void resetValue(){
		this.equipmentTypeNameTxt.setText("");
		this.equipmentName.setText("");
		this.repairData.setText("");
		this.repairManfacturers.setText("");
		this.repairCost.setText("");
		this.dutyPerson.setText("");
	}
}
