
package org.cth.other.enumtest;

/**
 * <p>
 * Description: MES类路径枚举对象，k3c的formid和类路径对应，用于手动同步功能
 * </p>
 * 
 * @author cth
 * @date 2019年10月17日 上午9:12:53
 */
public enum MesClassPathEnum {

	/** 物料 */
	BD_MATERIAL("BD_MATERIAL", "com.more.mes.erpservice.k3cerp.service.bill.data.BdMaterialService"),

	/** 供应商 */
	BD_SUPPLIER("BD_SUPPLIER", "com.more.mes.erpservice.k3cerp.service.bill.data.BdSupplierService"),

	/** 客户 */
	BD_CUSTOMER("BD_CUSTOMER", "com.more.mes.erpservice.k3cerp.service.bill.data.BdCustomerService"),

	/** 部门 */
	BD_DEPARTMENT("BD_DEPARTMENT", "com.more.mes.erpservice.k3cerp.service.bill.data.BdDepartmentService"),

	/** 仓库 */
	BD_STOCK("BD_STOCK", "com.more.mes.erpservice.k3cerp.service.bill.data.BdStockService"),

	/** 用户 */
	SEC_USER("SEC_USER", "com.more.mes.erpservice.k3cerp.service.bill.data.SecUserService"),

	/** 计量单位 */
	BD_UNIT("BD_UNIT", "com.more.mes.erpservice.k3cerp.service.bill.data.BdUnitService"),

	/** 物料清单（BOM） */
	ENG_BOM("ENG_BOM", "com.more.mes.erpservice.k3cerp.service.bill.data.EngBomService"),

	/** 采购订单 */
	PUR_PURCHASEORDER("PUR_PURCHASEORDER", "com.more.mes.erpservice.k3cerp.service.bill.document.PurPurchaseorderService"),

	/** 生产订单 */
	PRD_MO("PRD_MO", "com.more.mes.erpservice.k3cerp.service.bill.document.PrdMoService"),
	
	/** 物料盘点作业 */
	STK_STOCKCOUNTINPUT("STK_STOCKCOUNTINPUT", "com.more.mes.erpservice.k3cerp.service.bill.document.StkStockCountInputService"),
	
	/** 收料通知单 */
	PUR_RECEIVEBILL("PUR_RECEIVEBILL", "com.more.mes.erpservice.k3cerp.service.bill.input.PurReceiveBillService"),

	/** 生产汇报单 */
	PRD_MORPT("PRD_MORPT", "com.more.mes.erpservice.k3cerp.service.bill.input.PrdMorptService"),
	
	/** 生产退料申请单 */
	WB_MTRLRETREQ("WB_MTRLRETREQ", "com.more.mes.erpservice.k3cerp.service.bill.input.WbMtrlretreqService"),
	
	/** 退货通知单 */
	SAL_RETURNNOTICE("SAL_RETURNNOTICE", "com.more.mes.erpservice.k3cerp.service.bill.input.SalReturnNoticeService"),

	/** 采购退料申请单 */
	PUR_MRAPP("PUR_MRAPP", "com.more.mes.erpservice.k3cerp.service.bill.output.PurMrappService"),

	/** 生产用料清单 */
	PRD_PPBOM("PRD_PPBOM", "com.more.mes.erpservice.k3cerp.service.bill.output.PrdPpbomService"),

	/** 发货通知单 */
	SAL_DELIVERYNOTICE("SAL_DELIVERYNOTICE", "com.more.mes.erpservice.k3cerp.service.bill.output.SalDeliveryNoticeService"),

	/** 出库申请单 */
	STK_OUTSTOCKAPPLY("STK_OUTSTOCKAPPLY", "com.more.mes.erpservice.k3cerp.service.bill.output.StkOutStockApplyService");

	private String formId;
	private String classPath;

    /**
     * 测试formId集合
     */
    public static String[] dataArr = { STK_OUTSTOCKAPPLY.getFormId(), SAL_DELIVERYNOTICE.getFormId() };

	MesClassPathEnum(String formId, String classPath) {
		this.formId = formId;
		this.classPath = classPath;
	}

    /**
     * 获取类路径
     */
    public static String getClassFullName(String bdType) {
        return MesClassPathEnum.valueOf(bdType.toUpperCase()).getClassPath();
    }

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

}
