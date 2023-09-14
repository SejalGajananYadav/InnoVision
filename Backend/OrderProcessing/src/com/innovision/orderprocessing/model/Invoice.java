package com.innovision.orderprocessing.model;

import java.util.Date;
import java.util.Objects;

public class Invoice {
	private int invoiceId;
	private Date invoiceDate;
	private int orderId;
	private int customerId;
	private String typeOfGst;
	private double totalGstAmount;
	private double totalInvoiceValue;
	private String status;
	
	
	
	public Invoice() {
		super();
	}

	public Invoice(int invoiceId, Date invoiceDate, int orderId, int customerId, String typeOfGst,
			double totalGstAmount, double totalInvoiceValue, String status) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.orderId = orderId;
		this.customerId = customerId;
		this.typeOfGst = typeOfGst;
		this.totalGstAmount = totalGstAmount;
		this.totalInvoiceValue = totalInvoiceValue;
		this.status = status;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTypeOfGst() {
		return typeOfGst;
	}

	public void setTypeOfGst(String typeOfGst) {
		this.typeOfGst = typeOfGst;
	}

	public double getTotalGstAmount() {
		return totalGstAmount;
	}

	public void setTotalGstAmount(double totalGstAmount) {
		this.totalGstAmount = totalGstAmount;
	}

	public double getTotalInvoiceValue() {
		return totalInvoiceValue;
	}

	public void setTotalInvoiceValue(double totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, invoiceDate, invoiceId, orderId, status, totalGstAmount, totalInvoiceValue,
				typeOfGst);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return customerId == other.customerId && Objects.equals(invoiceDate, other.invoiceDate)
				&& invoiceId == other.invoiceId && orderId == other.orderId && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalGstAmount) == Double.doubleToLongBits(other.totalGstAmount)
				&& Double.doubleToLongBits(totalInvoiceValue) == Double.doubleToLongBits(other.totalInvoiceValue)
				&& Objects.equals(typeOfGst, other.typeOfGst);
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", orderId=" + orderId
				+ ", customerId=" + customerId + ", typeOfGst=" + typeOfGst + ", totalGstAmount=" + totalGstAmount
				+ ", totalInvoiceValue=" + totalInvoiceValue + ", status=" + status + "]";
	}
	
	
	
}
