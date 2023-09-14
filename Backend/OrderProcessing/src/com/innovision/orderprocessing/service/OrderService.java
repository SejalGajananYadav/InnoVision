package com.innovision.orderprocessing.service;

import java.util.List;
import java.util.Map;

import com.innovision.orderprocessing.exception.InvalidOrderDateException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;
import com.innovision.orderprocessing.model.Product;

public interface OrderService {

	public void saveUpdateOrder(Order order) throws InvalidOrderDetailException;

	public void saveOrder(Order order) throws InvalidOrderDetailException;

	public void addProduct(Product product, int quantity);

	public boolean approveOrder(Order order) throws InvalidOrderDateException;

	void saveProductIntoOrder(Order order, Map<Product, Integer> map) throws ProductUnavailableException;
	
	public List<Order> showAllPendingOrder(Customer customer) throws  NoPendingOrderException;
}
