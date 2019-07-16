package com.spe.speinvoiceservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoice")
public class Invoice extends AuditModel {

	private static final long serialVersionUID = -2338421187752448587L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long partyId;

	@NotNull
	private Long orderId;

	@NotNull
	private Double discount;

	@NotBlank
	private String shipToAddLine1;

	@NotBlank
	private String shipToAddLine2;

	@NotBlank
	private String shipToAddLine3;

	@NotBlank
	private String shipToCity;

	@NotBlank
	private String shipToState;

	@NotBlank
	private String shipToPin;

	@NotBlank
	private String remarks;

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

}
