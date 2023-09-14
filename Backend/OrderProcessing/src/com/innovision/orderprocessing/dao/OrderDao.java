package com.innovision.orderprocessing.dao;

import java.util.List;
import java.util.Map;

import com.innovision.orderprocessing.exception.InvalidOrderDateException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;
import com.innovision.orderprocessing.model.Product;

public interface OrderDao {
	public void insertOrder(Order order) throws InvalidOrderDetailException;

	public void update(Order entity) throws InvalidOrderDetailException;

	public void addProduct(Product product, int quantity);

	public boolean approveOrder(Order order) throws InvalidOrderDateException;

	public double calculateShippingCost(Order order) throws InvalidOrderDetailException;

	public double calculateTotalOrderValue(Order order) throws InvalidOrderDetailException;

	public Map<Product, Integer> getProductList();

	public void insertProductIntoOrder(Order order, Map<Product, Integer> map) throws ProductUnavailableException;

	public List<Order> getAllPendingOrder(Customer customer) throws NoPendingOrderException;
}
