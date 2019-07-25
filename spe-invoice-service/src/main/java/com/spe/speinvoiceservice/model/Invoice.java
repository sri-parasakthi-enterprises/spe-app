package com.spe.speinvoiceservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Document(collection = "invoice")
public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4693240109700407083L;

	@Id
	private Long id;

	private Long partyId;

	private Long orderId;

	private Double discount;

	private List<InvoiceItem> invoiceItems;

	private String shipToAddLine1;

	private String shipToAddLine2;

	private String shipToAddLine3;

	private String shipToCity;

	private String shipToState;

	private String shipToPin;

	private String remarks;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public String getShipToAddLine1() {
		return shipToAddLine1;
	}

	public void setShipToAddLine1(String shipToAddLine1) {
		this.shipToAddLine1 = shipToAddLine1;
	}

	public String getShipToAddLine2() {
		return shipToAddLine2;
	}

	public void setShipToAddLine2(String shipToAddLine2) {
		this.shipToAddLine2 = shipToAddLine2;
	}

	public String getShipToAddLine3() {
		return shipToAddLine3;
	}

	public void setShipToAddLine3(String shipToAddLine3) {
		this.shipToAddLine3 = shipToAddLine3;
	}

	public String getShipToCity() {
		return shipToCity;
	}

	public void setShipToCity(String shipToCity) {
		this.shipToCity = shipToCity;
	}

	public String getShipToState() {
		return shipToState;
	}

	public void setShipToState(String shipToState) {
		this.shipToState = shipToState;
	}

	public String getShipToPin() {
		return shipToPin;
	}

	public void setShipToPin(String shipToPin) {
		this.shipToPin = shipToPin;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
