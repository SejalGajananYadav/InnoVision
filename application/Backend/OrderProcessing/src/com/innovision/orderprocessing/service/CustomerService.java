package com.innovision.orderprocessing.service;

import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.UnathorizedUserException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;

public interface CustomerService {

	public Customer customerlogin(String Name, String password) throws UserNotFoundException;

	public Customer customerlogin(int customerId, String password) throws UserNotFoundException;

	public Order customerPlaceOrder()
			throws UnathorizedUserException, InvalidOrderDetailException, ConnectionNotEstablishedException;
}
