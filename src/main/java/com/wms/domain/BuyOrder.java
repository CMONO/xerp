package com.wms.domain;

import java.util.List;

import lombok.Data;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
//物料采购
@Data
@Table("ERP_BuyOrder")
public class BuyOrder {
	
	@Id
	@Column
	private long id;//发票编号 国家规定
	@Name
	@Column
	private String code;// 项目订单编号
	@Column
	private String deliver;// 交付日期
	@Column
	private String askCode;// 询价单编号
	@Column
	private int balanceState;// 结算状态
	@Column
	private int inState;// 入库状态
	@Column
	private int backState;// 退状态
	@Column
	private String cause;//退回原因
	
	@Many(target=BuyOrderDetail.class,field="buyordercode")
	private List<BuyOrderDetail> BuyOrderDetailSet;// 	
	
	
}
