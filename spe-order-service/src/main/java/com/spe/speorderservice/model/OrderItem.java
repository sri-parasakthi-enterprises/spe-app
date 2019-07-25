package com.spe.speorderservice.model;

import java.io.Serializable;

public class OrderItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8257661113135843845L;

	private Long itemId;

	private Long productId;

	private String itemDesc;

	private String hsnCode;

	private Double quantity;

	private String paperType; // NILL, QuadCap, DblCap, DblCrown, DblDemy etc

	private Short gsm;

	private Double reamWeight;

	private Short pages;

	private String itemType; // KS, LS, SS, Record-note etc

	private Double unitRate;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long id) {
		this.itemId = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public Short getGsm() {
		return gsm;
	}

	public void setGsm(Short gsm) {
		this.gsm = gsm;
	}

	public Double getReamWeight() {
		return reamWeight;
	}

	public void setReamWeight(Double reamWeight) {
		this.reamWeight = reamWeight;
	}

	public Short getPages() {
		return pages;
	}

	public void setPages(Short pages) {
		this.pages = pages;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Double getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(Double unitRate) {
		this.unitRate = unitRate;
	}

}
