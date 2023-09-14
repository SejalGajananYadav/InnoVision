package com.innovision.orderprocessing.model;

import java.util.Objects;

public class ProductCategory {
	private String productCategoryType;
	
	public ProductCategory() {
    
    }
	
    public ProductCategory(String productCategoryType) {
        this.productCategoryType = productCategoryType;
    }

	public String getProductCategoryType() {
		return productCategoryType;
	}

	public void setProductCategoryType(String productCategoryType) {
		this.productCategoryType = productCategoryType;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryType=" + productCategoryType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(productCategoryType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategory other = (ProductCategory) obj;
		return Objects.equals(productCategoryType, other.productCategoryType);
	}
    
	
    
}
