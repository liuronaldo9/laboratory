package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import dao.ApplyDAO;

import model.Apply;

import util.Dbutil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
/**
 * 申请设备窗口
 * @author LeLe
 *
 */
public class ApplyAddInterFrm extends JInternalFrame {
	/**
	 * 设备名称
	 */
	private JTextField equipmentNameTxt;
	/**
	 * 申请日期
	 */
	private JTextField applyDataTxt;
	/**
	 * 规格
	 */
	private JTextField standardTxt;
	/**
	 * 数量
	 */
	private JTextField amountTxt;
	/**
	 * 申请人
	 */
	private JTextField applicantTxt;
	
	private Dbutil dbutil = new Dbutil();
	private ApplyDAO applyDAO = new ApplyDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyAddInterFrm frame = new ApplyAddInterFrm();
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
	public ApplyAddInterFrm() {
		setEnabled(false);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BBE\u5907\u7533\u8BF7");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u8BBE\u5907\u540D\uFF1A");
		
		equipmentNameTxt = new JTextField();
		equipmentNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7533\u8BF7\u65E5\u671F\uFF1A");
		
		applyDataTxt = new JTextField();
		applyDataTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u89C4\u683C\uFF1A");
		
		standardTxt = new JTextField();
		standardTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u91CF\uFF1A");
		
		amountTxt = new JTextField();
		amountTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7533\u8BF7\u4EBA\uFF1A");
		
		applicantTxt = new JTextField();
		applicantTxt.setColumns(10);
		//添加按钮
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applyAddActionPreformed(e);
			}
		});
		button.setIcon(new ImageIcon(ApplyAddInterFrm.class.getResource("/images/add.png")));
		//充值按钮
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(ApplyAddInterFrm.class.getResource("/images/reset.png")));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(equipmentNameTxt, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
							.addComponent(applyDataTxt)
							.addComponent(standardTxt)
							.addComponent(amountTxt)
							.addComponent(applicantTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1)))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(equipmentNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(applyDataTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(standardTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(amountTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(applicantTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
	/**
	 * 申请表添加事件
	 * @param evt
	 */
	private void applyAddActionPreformed(ActionEvent evt) {
		String equipmentName = this.equipmentNameTxt.getText();
		String applyData = this.applyDataTxt.getText();
		String standard = this.standardTxt.getText();
		int amount = Integer.parseInt(this.amountTxt.getText());
		String applicant = this.applicantTxt.getText();
		
		if (StringUtil.isEmpty(equipmentName)) {
			JOptionPane.showMessageDialog(null, "设备名称不能为空！");
			return;
		}
		if (StringUtil.isEmpty(applyData)) {
			JOptionPane.showMessageDialog(null, "申请日期不能为空！");
			return;
		}
		if (StringUtil.isEmpty(standard)) {
			JOptionPane.showMessageDialog(null, "规格不能为空！");
			return;
		}
		if (StringUtil.isEmpty(applicant)) {
			JOptionPane.showMessageDialog(null, "申请人不能为空！");
			return;
		}
		Apply apply = new Apply(equipmentName, applyData, standard, amount, applicant);
		Connection con = null;
		try{
			con = dbutil.getCon();
			int n = applyDAO.applyAdd(con , apply);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "申请信息提交成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "申请信息提交失败！");
			}
		}catch(Exception e){
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
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	/**
	 * 表单重置
	 */
	private void resetValue(){
		this.equipmentNameTxt.setText("");
		this.applyDataTxt.setText("");
		this.standardTxt.setText("");
		this.amountTxt.setText("");
		this.applicantTxt.setText("");
	}
}
