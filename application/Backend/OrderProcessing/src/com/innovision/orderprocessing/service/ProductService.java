package com.innovision.orderprocessing.service;

import java.util.List;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Product;

public interface ProductService {

	public List<Product> getAll() throws ProductUnavailableException;

	public void saveUpdate(Product entity);
}
