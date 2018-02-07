package model;
/**
 * 申请表实体
 * @author LeLe
 *
 */
public class Apply {

	/**
	 * 标号
	 */
	private int id;
	/**
	 * 设备名称
	 */
	private String equipmentName;
	/**
	 * 申请日期
	 */
	private String applyData;
	/**
	 * 规格
	 */
	private String standard;
	/**
	 * 数量
	 */
	private int amount;
	/**
	 * 申请人
	 */
	private String applicant;
	/**
	 * get/set方法
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getApplyData() {
		return applyData;
	}
	public void setApplyData(String applyData) {
		this.applyData = applyData;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	/**
	 * 构造函数
	 */
	public Apply() {
		super();
	}
	/**
	 * 带参数的构造函数
	 * @param equipmentName
	 * @param applyData
	 * @param standard
	 * @param amount
	 * @param applicant
	 */
	public Apply(String equipmentName, String applyData, String standard,
			int amount, String applicant) {
		super();
		this.equipmentName = equipmentName;
		this.applyData = applyData;
		this.standard = standard;
		this.amount = amount;
		this.applicant = applicant;
	}
	
}
