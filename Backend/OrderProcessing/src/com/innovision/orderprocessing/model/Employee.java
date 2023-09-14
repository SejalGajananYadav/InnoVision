package com.innovision.orderprocessing.model;

import java.util.Objects;

public class Employee {
	private String userName;
	private int employeeID;
	public Employee() {
		super();
	}

	public Employee(String userName, int employeeID) {
		this.userName = userName;
		this.employeeID= employeeID;
	}

	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeID, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeID == other.employeeID 
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", employeeID=" + employeeID + "]";
	}

	
	
	
	
	
	
}
