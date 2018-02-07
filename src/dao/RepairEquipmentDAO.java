package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.StringUtil;

import model.RepairEquipment;

/**
 * 维修设备的DAO类
 * @author LeLe
 *
 */
public class RepairEquipmentDAO {

	/**
	 * 设备维修信息添加
	 * @return
	 * @throws Exception
	 */
	public int repairEquipmentAdd(Connection con, RepairEquipment repairEquipment)throws Exception{
		String sql = "insert into t_service values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, repairEquipment.getEquipmentTypeName());
		pstmt.setString(2, repairEquipment.getEquipmentName());
		pstmt.setString(3, repairEquipment.getRepairData());
		pstmt.setString(4, repairEquipment.getRepairManufacturers());
		pstmt.setFloat(5, repairEquipment.getRepairCost());
		pstmt.setString(6, repairEquipment.getDutyPerson());
		return pstmt.executeUpdate();
		
	}
	
	public ResultSet list(Connection con, RepairEquipment repairEquipment)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_service");
		if (StringUtil.isNotEmpty(repairEquipment.getEquipmentTypeName())) {
			sb.append(" and equipmentTypeName like '%" + repairEquipment.getEquipmentTypeName() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
