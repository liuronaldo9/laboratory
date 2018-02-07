package model;
/**
 * 报废设备实体类
 * @author LeLe
 *
 */
public class Scrap {

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
	 * 报废日期
	 */
	private String scrapData;
	/**
	 * 责任人
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
	public String getScrapData() {
		return scrapData;
	}
	public void setScrapData(String scrapData) {
		this.scrapData = scrapData;
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
	public Scrap() {
		super();
	}
	/**
	 * 带参数的构造函数
	 * @param equipmentTypeName
	 * @param equipmentName
	 * @param scrapData
	 * @param dutyPerson
	 */
	public Scrap(String equipmentTypeName, String equipmentName,
			String scrapData, String dutyPerson) {
		super();
		this.equipmentTypeName = equipmentTypeName;
		this.equipmentName = equipmentName;
		this.scrapData = scrapData;
		this.dutyPerson = dutyPerson;
	}
}
