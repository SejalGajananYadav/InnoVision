package com.innovision.orderprocessing.model;

import java.util.Objects;

public class Company {
	private String companyName;
	private String companyAddress;
	private String companyCity;
	private int companyGstNumber;
	
	public Company() {
		super();
	}

	public Company(String companyName, String companyAddress, String companyCity, int companyGstNumber) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyCity = companyCity;
		this.companyGstNumber = companyGstNumber;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyAddress=" + companyAddress + ", companyCity="
				+ companyCity + ", companyGstNumber=" + companyGstNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyAddress, companyCity, companyGstNumber, companyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(companyAddress, other.companyAddress) && Objects.equals(companyCity, other.companyCity)
				&& companyGstNumber == other.companyGstNumber && Objects.equals(companyName, other.companyName);
	}
	
	
	
	
}
