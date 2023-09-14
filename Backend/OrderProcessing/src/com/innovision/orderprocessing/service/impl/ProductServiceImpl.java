package com.innovision.orderprocessing.service.impl;


import java.util.List;
import com.innovision.orderprocessing.dao.ProductDao;
import com.innovision.orderprocessing.dao.impl.ProductDaoImpl;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Product;
import com.innovision.orderprocessing.service.ProductService;

public class ProductServiceImpl implements ProductService{

private ProductDao productDao;
	
	public ProductServiceImpl() throws ConnectionNotEstablishedException
	{
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public List<Product> getAll() throws  ProductUnavailableException {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

	

	@Override
	public void saveUpdate(Product entity) {
		// TODO Auto-generated method stub
       productDao.update(entity);
	}

	
}
