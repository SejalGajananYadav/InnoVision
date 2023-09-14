package com.innovision.orderprocessing.dao;

import java.sql.ResultSet;
import java.util.List;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.InvalidProductDetailException;
import com.innovision.orderprocessing.exception.UnathorizedUserException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;

public interface CustomerDao {
	public Customer login(String userName, String password) throws UserNotFoundException;

	public Customer login(int customerId, String password) throws UserNotFoundException;

	public Order placeOrder()
			throws UnathorizedUserException, InvalidOrderDetailException, ConnectionNotEstablishedException;

	public Customer intializeCustomerObject(ResultSet rs) throws UserNotFoundException;

	public List<Customer> getAll() throws InvalidProductDetailException;

	public void update(Customer entity) throws InvalidOrderDetailException;
}
