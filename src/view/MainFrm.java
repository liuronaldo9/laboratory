package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 主界面窗口
 * @author LeLe
 *
 */
public class MainFrm extends JFrame {

	private JPanel table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u5B9E\u9A8C\u5BA4\u8BBE\u5907\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8BBE\u5907\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu menu_2 = new JMenu("\u8BBE\u5907\u67E5\u8BE2");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/search.png")));
		mnNewMenu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u8BBE\u5907\u6DFB\u52A0\u767B\u8BB0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentAddIntetFrm equipmentAddIntetFrm = new EquipmentAddIntetFrm();
				equipmentAddIntetFrm.setVisible(true);
				table.add(equipmentAddIntetFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu_2.add(menuItem);
		
		JMenuItem menuItem_8 = new JMenuItem("\u8BBE\u5907\u67E5\u8BE2");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentSearchFrm equipmentSearchFrm = new EquipmentSearchFrm();
				equipmentSearchFrm.setVisible(true);
				table.add(equipmentSearchFrm);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu_2.add(menuItem_8);
		
		JMenu menu_1 = new JMenu("\u8BBE\u5907\u7533\u8BF7");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_6 = new JMenuItem("\u8BBE\u5907\u7533\u8BF7\u767B\u8BB0");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplyAddInterFrm applyAddInterFrm = new ApplyAddInterFrm();
				applyAddInterFrm.setVisible(true);
				table.add(applyAddInterFrm);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u8BBE\u5907\u7533\u8BF7\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplySearchFrm applySearchFrm = new ApplySearchFrm();
				applySearchFrm.setVisible(true);
				table.add(applySearchFrm);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu_1.add(menuItem_7);
		
		JMenu menu = new JMenu("\u8BBE\u5907\u7EF4\u4FEE");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		mnNewMenu.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u8BBE\u5907\u7EF4\u4FEE\u8BB0\u5F55\u767B\u8BB0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepairEquipmentAddInterFrm requirEquipmentAddInterFrm = new RepairEquipmentAddInterFrm();
				requirEquipmentAddInterFrm.setVisible(true);
				table.add(requirEquipmentAddInterFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8BBE\u5907\u7EF4\u4FEE\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepairEquipmentSearchInterFrm rESearchInterFrm = new RepairEquipmentSearchInterFrm();
				rESearchInterFrm.setVisible(true);
				table.add(rESearchInterFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(menuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BBE\u5907\u62A5\u5E9F");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/delete.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u8BBE\u5907\u62A5\u5E9F\u8BB0\u5F55\u767B\u8BB0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScrapAddIntetFrm sAddIntetFrm = new ScrapAddIntetFrm();
				sAddIntetFrm.setVisible(true);
				table.add(sAddIntetFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8BBE\u5907\u62A5\u5E9F\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScrapSearchInterFrm scrapSearchInterFrm = new ScrapSearchInterFrm();
				scrapSearchInterFrm.setVisible(true);
				table.add(scrapSearchInterFrm);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		mnNewMenu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if (result == 0) {
					dispose();
					new LogOnFrm().setVisible(true);
				}
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menuBar.add(menuItem_5);
		table = new JPanel();
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setLayout(new BorderLayout(0, 0));
		setContentPane(table);
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
