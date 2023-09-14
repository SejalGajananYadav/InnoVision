package com.innovision.orderprocessing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
	private int customerId;
    private String customerName;
    private String customerGstNumber;
    private String customerAddress;
    private String customerCity;
    private String customerEmail;
    private String customerPhone;
    private int customerPincode;
    private List<Order> customerOrders;
	
    public Customer() {
		super();
	}

    
    
	public Customer(int customerId, String customerName, String customerGstNumber, String customerAddress,
			String customerCity, String customerEmail, String customerPhone, int customerPincode) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGstNumber = customerGstNumber;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerPincode = customerPincode;
		this.customerOrders = new ArrayList<>();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGstNumber() {
		return customerGstNumber;
	}

	public void setCustomerGstNumber(String customerGstNumber) {
		this.customerGstNumber = customerGstNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(int customerPincode) {
		this.customerPincode = customerPincode;
	}

	public List<Order> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<Order> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	public void addOrder(Order order) {
		customerOrders.add(order);
    }

	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerGstNumber="
				+ customerGstNumber + ", customerAddress=" + customerAddress + ", customerCity=" + customerCity
				+ ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + ", customerPincode="
				+ customerPincode + ", customerOrders=" + customerOrders + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAddress, customerCity, customerEmail, customerGstNumber, customerId, customerName,
				customerOrders, customerPhone, customerPincode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerAddress, other.customerAddress)
				&& Objects.equals(customerCity, other.customerCity)
				&& Objects.equals(customerEmail, other.customerEmail)
				&& Objects.equals(customerGstNumber, other.customerGstNumber) && customerId == other.customerId
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerOrders, other.customerOrders)
				&& Objects.equals(customerPhone, other.customerPhone) && customerPincode == other.customerPincode;
	}
    
	    
    
    
}
