package model;
/**
 * 设备维修实体类
 * @author LeLe
 *
 */
public class RepairEquipment {

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 设备类型名称
	 */
	private String equipmentTypeName;
	/**
	 * 设备名称
	 */
	private String equipmentName;
	/**
	 * 维修日期
	 */
	private String repairData;
	/**
	 * 维修厂商
	 */
	private String repairManufacturers;
	/**
	 * 维修费用
	 */
	private float repairCost;
	/**
	 * 负责人
	 */
	private String dutyPerson;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipmentTypeName() {
		return equipmentTypeName;
	}
	public void setEquipmentTypeName(String equipmentTypeName) {
		this.equipmentTypeName = equipmentTypeName;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getRepairData() {
		return repairData;
	}
	public void setRepairData(String repairData) {
		this.repairData = repairData;
	}
	public String getRepairManufacturers() {
		return repairManufacturers;
	}
	public void setRepairManufacturers(String repairManufacturers) {
		this.repairManufacturers = repairManufacturers;
	}
	public float getRepairCost() {
		return repairCost;
	}
	public void setRepairCost(float repairCost) {
		this.repairCost = repairCost;
	}
	public String getDutyPerson() {
		return dutyPerson;
	}
	public void setDutyPerson(String dutyPerson) {
		this.dutyPerson = dutyPerson;
	}
	/**
	 * 构造器
	 */
	public RepairEquipment() {
		super();
	}
	
	/**
	 * 带参数的构造函数
	 * @param equipmentTypeName
	 * @param equipmentName
	 * @param repairData
	 * @param repairManufacturers
	 * @param repairCost
	 * @param dutyPerson
	 */
	public RepairEquipment(String equipmentTypeName, String equipmentName,
			String repairData, String repairManufacturers, float repairCost,
			String dutyPerson) {
		super();
		this.equipmentTypeName = equipmentTypeName;
		this.equipmentName = equipmentName;
		this.repairData = repairData;
		this.repairManufacturers = repairManufacturers;
		this.repairCost = repairCost;
		this.dutyPerson = dutyPerson;
	}
	
}
