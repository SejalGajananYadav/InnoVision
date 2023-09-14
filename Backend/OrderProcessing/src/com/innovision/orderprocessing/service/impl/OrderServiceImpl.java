package com.innovision.orderprocessing.service.impl;

import java.util.List;
import java.util.Map;

import com.innovision.orderprocessing.dao.OrderDao;
import com.innovision.orderprocessing.dao.impl.OrderDaoImpl;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDateException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;
import com.innovision.orderprocessing.model.Product;
import com.innovision.orderprocessing.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
	
	public OrderServiceImpl() throws ConnectionNotEstablishedException
	{
		orderDao = new OrderDaoImpl();
	}
	
	@Override
	public void saveUpdateOrder(Order order) throws InvalidOrderDetailException  {
		orderDao.update( order);
	}
	
	@Override
	public void saveOrder(Order order) throws InvalidOrderDetailException
	{
	   orderDao.insertOrder(order);
	}
	
	@Override
	public void addProduct(Product product, int quantity)
	{
		orderDao.addProduct(product, quantity);
	}
	
	@Override
	public boolean approveOrder(Order order) throws InvalidOrderDateException {
	   
		return orderDao.approveOrder(order);
	}

	
	@Override
	public void saveProductIntoOrder(Order order, Map<Product, Integer> map)
			throws ProductUnavailableException {
		orderDao.insertProductIntoOrder(order, map);

	}
	
	@Override
	public List<Order> showAllPendingOrder(Customer customer) throws NoPendingOrderException
	{
		return orderDao.getAllPendingOrder(customer);
	}
	
	public Map<Product, Integer> getSelectedProducts()
	{
		return orderDao.getProductList();
	}
}
