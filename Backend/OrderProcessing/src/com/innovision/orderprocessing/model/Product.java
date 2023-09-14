package com.innovision.orderprocessing.model;

import java.util.Objects;

public class Product {
	private int productId;
    private String productName;
    private double productPrice;
    private ProductCategory category;
	
    public Product() {
		super();
	}

	public Product(int productId, String name, double price) {
		this.productId = productId;
		this.productName = name;
		this.productPrice = price;
		this.category = assignCategory(productPrice);
	}

	
    public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public double getPrice() {
		return productPrice;
	}

	public void setPrice(double price) {
		this.productPrice = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	//To assign the product levels based on the price value of the products	
	private ProductCategory assignCategory(double price) {
		// TODO Auto-generated method stub
		if (price > 0 && price<= 10000) {
            return new ProductCategory("Level1");
        } else if (price > 10000 && price<=40000) {
            return new ProductCategory("Level2");
        } else {
            return new ProductCategory("Level3");
        }
		
		
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + productName + ", price=" + productPrice + ", category=" + category
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, productName, productPrice, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(productPrice) == Double.doubleToLongBits(other.productPrice)
				&& productId == other.productId;
	}
    
    
    
    
}
