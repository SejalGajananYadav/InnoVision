package com.innovision.orderprocessing.model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Order {
	private int orderId;
    private Date orderDate;
    private int customerId;
    private String customerAddress;
    private Map<Product, Integer> productList;
    private double totalOrderValue;
    private double shippingCost;
    private String shippingAgency;
    private String status;
	
    public Order() {
	}

	public Order( Date orderDate, int customerId, String customerAddress) {
		//this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.customerAddress = customerAddress;
		this.productList = new HashMap<>();
		this.totalOrderValue = 0.0;
		this.shippingCost = 0.0;
		this.shippingAgency = "";
		this.status = "Pending";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Map<Product, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Map<Product, Integer> productList) {
		this.productList = productList;
	}

	public double getTotalOrderValue() {
		return totalOrderValue;
	}

	public void setTotalOrderValue(double totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getShippingAgency() {
		return shippingAgency;
	}

	public void setShippingAgency(String shippingAgency) {
		this.shippingAgency = shippingAgency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", customerAddress=" + customerAddress + ", productList=" + productList + ", totalOrderValue="
				+ totalOrderValue + ", shippingCost=" + shippingCost + ", shippingAgency=" + shippingAgency
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerId, orderDate, orderId, productList, shippingAgency, shippingCost,
				status, totalOrderValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerAddress, other.customerAddress) && customerId == other.customerId
				&& Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
				&& Objects.equals(productList, other.productList)
				&& Objects.equals(shippingAgency, other.shippingAgency)
				&& Double.doubleToLongBits(shippingCost) == Double.doubleToLongBits(other.shippingCost)
				&& Objects.equals(status, other.status)
				&& Double.doubleToLongBits(totalOrderValue) == Double.doubleToLongBits(other.totalOrderValue);
	}
    
    

}
