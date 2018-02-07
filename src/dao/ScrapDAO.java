package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;

import model.Scrap;

/**
 * 报废设备DAO类
 * @author LeLe
 *
 */
public class ScrapDAO {

	/**
	 * 报废设备信息添加
	 * @param con
	 * @param scrap
	 * @return
	 * @throws Exception
	 */
	public int scrapAdd(Connection con, Scrap scrap)throws Exception{
		String sql = "insert into t_scrap values(null,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, scrap.getEquipmentTypeName());
		pstmt.setString(2, scrap.getEquipmentName());
		pstmt.setString(3, scrap.getScrapData());
		pstmt.setString(4, scrap.getDutyPerson());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 
	 * @param con
	 * @param scrap
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Scrap scrap)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_scrap");
		if (StringUtil.isNotEmpty(scrap.getEquipmentTypeName())) {
			sb.append(" and equipmentTypeName like '%" + scrap.getEquipmentTypeName() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
