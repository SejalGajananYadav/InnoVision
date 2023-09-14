package com.innovision.orderprocessing.dao;

import java.util.List;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Product;

public interface ProductDao {

	public List<Product> getAll() throws ProductUnavailableException;

	public void update(Product entity);

}
