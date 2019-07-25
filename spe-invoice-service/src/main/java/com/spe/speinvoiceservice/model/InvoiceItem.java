package com.spe.speinvoiceservice.model;

import java.io.Serializable;

public class InvoiceItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2327275791631923735L;

	private Long id;

	private Long productId;

	private String itemDesc;

	private Double quantity;

	private Double unitRate;

	private Double itemDiscount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(Double unitRate) {
		this.unitRate = unitRate;
	}

	public Double getItemDiscount() {
		return itemDiscount;
	}

	public void setItemDiscount(Double itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

}
