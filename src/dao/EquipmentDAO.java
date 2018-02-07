package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.StringUtil;
import model.Apply;
import model.Equipment;

/**
 * 设备的DAO类
 * @author LeLe
 *
 */
public class EquipmentDAO {

	/**
	 * 设备信息添加
	 * @return
	 * @throws Exception 
	 */
	public int equipmentAdd(Connection con, Equipment equipment) throws Exception{
		String sql = "insert into t_equipment values (null,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, equipment.getEquipmentTypeName());
		pstmt.setString(2, equipment.getEquipmentName());
		pstmt.setString(3, equipment.getStandard());
		pstmt.setFloat(4, equipment.getPrice());
		pstmt.setString(5, equipment.getBuyData());
		pstmt.setString(6, equipment.getProduction());
		pstmt.setInt(7, equipment.getAmount());
		pstmt.setString(8, equipment.getBuyPerson());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 设备查询方法集合
	 * @param con
	 * @param equipment
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Equipment equipment)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_equipment");
		if (StringUtil.isNotEmpty(equipment.getEquipmentTypeName())) {
			sb.append(" and equipmentTypeName like '%" + equipment.getEquipmentTypeName() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
