package cn.ekgc.dkscm.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>订单实体类</b>
 * @author Arthur
 * @version 1.0.0 2019-11-12
 * @since 2019-11-12
 */
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long purchaseId;					// 订单主键
	private String purchaseNo;					// 订单编号
	private String goodsName;					// 物资名称
	private String goodsBand;					// 物资品牌
	private String goodsType;					// 物资型号
	private Double applyQuantity;				// 申请数量
	private String goodsUnit;					// 物资单位
	private Double buget;					    // 预算
	private String applyRemark;					// 申请备注
	private Date supplyTime;					// 申请时间
	private User applicantId;					// 申请人
	private User purchaserId;					// 采购人
	private String purchaseBand;                //采购品牌
	private String purchaseType;                //采购型号
    private Double purchaseQuantity;			//采购数量
    private Double purchaseAmount;				//采购金额
    private String purchaseRemark;				//采购备注
    private Date purchaseTime;					//采购时间
    private User repoReviewerId;				//入库审批人
    private String repoReviewRemark;			//入库审批备注
    private Date repoReviewTime;				//入库审批时间
    private User repoId;						//入库人
    private String repoRemark;					//入库备注
    private Date repoTime;						//入库时间
    private User receiverId;					//领取人
    private String receiverRemark;				//领取备注
    private Date receiveTime;					//领取时间
	private Status status;						// 状态
	private Date createTime;					// 创建时间
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsBand() {
		return goodsBand;
	}
	public void setGoodsBand(String goodsBand) {
		this.goodsBand = goodsBand;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Double getApplyQuantity() {
		return applyQuantity;
	}
	public void setApplyQuantity(Double applyQuantity) {
		this.applyQuantity = applyQuantity;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public Double getBuget() {
		return buget;
	}
	public void setBuget(Double buget) {
		this.buget = buget;
	}
	public String getApplyRemark() {
		return applyRemark;
	}
	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}
	public Date getSupplyTime() {
		return supplyTime;
	}
	public void setSupplyTime(Date supplyTime) {
		this.supplyTime = supplyTime;
	}
	public User getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(User applicantId) {
		this.applicantId = applicantId;
	}
	public User getPurchaserId() {
		return purchaserId;
	}
	public void setPurchaserId(User purchaserId) {
		this.purchaserId = purchaserId;
	}
	public String getPurchaseBand() {
		return purchaseBand;
	}
	public void setPurchaseBand(String purchaseBand) {
		this.purchaseBand = purchaseBand;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public Double getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getPurchaseRemark() {
		return purchaseRemark;
	}
	public void setPurchaseRemark(String purchaseRemark) {
		this.purchaseRemark = purchaseRemark;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public User getRepoReviewerId() {
		return repoReviewerId;
	}
	public void setRepoReviewerId(User repoReviewerId) {
		this.repoReviewerId = repoReviewerId;
	}
	public String getRepoReviewRemark() {
		return repoReviewRemark;
	}
	public void setRepoReviewRemark(String repoReviewRemark) {
		this.repoReviewRemark = repoReviewRemark;
	}
	public Date getRepoReviewTime() {
		return repoReviewTime;
	}
	public void setRepoReviewTime(Date repoReviewTime) {
		this.repoReviewTime = repoReviewTime;
	}
	public User getRepoId() {
		return repoId;
	}
	public void setRepoId(User repoId) {
		this.repoId = repoId;
	}
	public String getRepoRemark() {
		return repoRemark;
	}
	public void setRepoRemark(String repoRemark) {
		this.repoRemark = repoRemark;
	}
	public Date getRepoTime() {
		return repoTime;
	}
	public void setRepoTime(Date repoTime) {
		this.repoTime = repoTime;
	}
	public User getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(User receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverRemark() {
		return receiverRemark;
	}
	public void setReceiverRemark(String receiverRemark) {
		this.receiverRemark = receiverRemark;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
