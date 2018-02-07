package model;
/**
 * 用户实体类
 * @author LeLe
 *
 */
public class User {

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	
	/**
	 * 构造器
	 */
	public User() {
		super();
	}
	
	/**
	 * 带参数的构造函数
	 * @param userName
	 * @param passWord
	 */
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	/**
	 * get/set方法
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
