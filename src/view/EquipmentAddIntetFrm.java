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

import model.Equipment;

import dao.EquipmentDAO;

import util.Dbutil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
/**
 * 设备信息添加窗口
 * @author LeLe
 *
 */
public class EquipmentAddIntetFrm extends JInternalFrame {
	private JTextField equipmentTypeNameTxt;
	private JTextField equipmentNameTxt;
	private JTextField standardTxt;
	private JTextField priceTxt;
	private JTextField buyDataTxt;
	private JTextField productionTxt;
	private JTextField amountTxt;
	private JTextField buyPersonTxt;
	
	private Dbutil dbutil = new Dbutil();
	private EquipmentDAO equipmentDAO = new EquipmentDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipmentAddIntetFrm frame = new EquipmentAddIntetFrm();
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
	public EquipmentAddIntetFrm() {
		setTitle("\u8BBE\u5907\u4FE1\u606F\u6DFB\u52A0");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 568, 416);
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		equipmentTypeNameTxt = new JTextField();
		equipmentTypeNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u8BBE\u5907\u540D\u79F0\uFF1A");
		
		equipmentNameTxt = new JTextField();
		equipmentNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u89C4\u683C\uFF1A");
		
		standardTxt = new JTextField();
		standardTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8D2D\u4E70\u65E5\u671F\uFF1A");
		
		buyDataTxt = new JTextField();
		buyDataTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u751F\u4EA7\u5382\u5546\uFF1A");
		
		productionTxt = new JTextField();
		productionTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6570\u91CF\uFF1A");
		
		amountTxt = new JTextField();
		amountTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8D2D\u4E70\u4EBA\uFF1A");
		
		buyPersonTxt = new JTextField();
		buyPersonTxt.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(EquipmentAddIntetFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentResetActionperformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(EquipmentAddIntetFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(label_1)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(label)
								.addComponent(lblNewLabel)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(buyPersonTxt)
								.addComponent(amountTxt)
								.addComponent(productionTxt)
								.addComponent(buyDataTxt)
								.addComponent(priceTxt)
								.addComponent(standardTxt)
								.addComponent(equipmentNameTxt)
								.addComponent(equipmentTypeNameTxt, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(261, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(equipmentTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(equipmentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(standardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(buyDataTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(productionTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(amountTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(buyPersonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 设备信息添加事件
	 * @param evt
	 */
	private void equipmentAddActionPerformed(ActionEvent evt) {
		String equipmentTypeName = this.equipmentTypeNameTxt.getText();
		String equipmentName = this.equipmentNameTxt.getText();
		String standard = this.standardTxt.getText();
		float price = Float.parseFloat(this.priceTxt.getText());
		String buyData = this.buyDataTxt.getText();
		String production = this.productionTxt.getText();
		int amount = Integer.parseInt(this.amountTxt.getText());
		String buyPerson = this.buyPersonTxt.getText();
		
		if (StringUtil.isEmpty(equipmentTypeName)) {
			JOptionPane.showMessageDialog(null, "设备类型名称不能为空！");
		}
		if (StringUtil.isEmpty(equipmentName)) {
			JOptionPane.showMessageDialog(null, "设备名称不能为空！");
		}
		if (StringUtil.isEmpty(standard)) {
			JOptionPane.showMessageDialog(null, "规格不能为空！");
		}
		if (StringUtil.isEmpty(buyData)) {
			JOptionPane.showMessageDialog(null, "购买日期");
		}
		if (StringUtil.isEmpty(production)) {
			JOptionPane.showMessageDialog(null, "生产厂商不能为空！");
		}
		if (StringUtil.isEmpty(buyPerson)) {
			JOptionPane.showMessageDialog(null, "购买人不能为空！");
		}
		
		Equipment equipment = new Equipment(equipmentTypeName, equipmentName, standard, price, buyData, production, amount, buyPerson);
		Connection con = null;
		try {
			con = dbutil.getCon();
			int n = equipmentDAO.equipmentAdd(con, equipment);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "申请信息提交成功！");
				resetEquipmentValue();
			}else {
				JOptionPane.showMessageDialog(null, "申请信息提交失败！");
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
	 * 设备添加表单重置事件
	 * @param evt
	 */
	private void equipmentResetActionperformed(ActionEvent evt) {
		this.resetEquipmentValue();
	}
	
	/**
	 * 重置表单
	 */
	private void resetEquipmentValue(){
		this.equipmentTypeNameTxt.setText("");
		this.equipmentNameTxt.setText("");
		this.standardTxt.setText("");
		this.priceTxt.setText("");
		this.buyDataTxt.setText("");
		this.productionTxt.setText("");
		this.amountTxt.setText("");
		this.buyPersonTxt.setText("");
	}
}
