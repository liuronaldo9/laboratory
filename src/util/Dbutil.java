package util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 数据库工具类
 * @author LeLe
 *
 */
public class Dbutil {

	//地址
	private String dbUrl = "jdbc:mysql://localhost:3306/db_laboratory";
	//用户名
	private String dbUserName = "root";
	//密码
	private String dbPassWord = "123456";
	//驱动名称
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		//加载驱动类
		Class.forName(jdbcName);
		//得到连接对象
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if (con!=null) {
			con.close();
		}
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		Dbutil dbutil = new Dbutil();
		try {
			dbutil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
