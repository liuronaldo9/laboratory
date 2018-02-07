package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import dao.UserDAO;

import model.User;

import util.Dbutil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JPasswordField;
/**
 * 登录窗口
 * @author LeLe
 *
 */
public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private Dbutil dbutil = new Dbutil();
	private UserDAO userDAO = new UserDAO();
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
					LogOnFrm frame = new LogOnFrm();
					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnFrm() {
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();//
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setResizable(false);
		setTitle("\u5B9E\u9A8C\u5BA4\u8BBE\u5907\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5B9E\u9A8C\u5BA4\u8BBE\u5907\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.BOLD, 19));
		label.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/logo.png")));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/userName.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801");
		label_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.png")));
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(110)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label_2))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordTxt)
										.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(39)
									.addComponent(btnNewButton_1)))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(41))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登录事件处理
	 * @param evt
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String passWord = new String(this.passwordTxt.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user = new User(userName , passWord);
		Connection con = null;
		try {
			con = dbutil.getCon();
			User currentUser = userDAO.login(con, user);
			if (currentUser !=null) {
				dispose();
				new MainFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
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

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resultValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
