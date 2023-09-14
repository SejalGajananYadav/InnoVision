package com.innovision.orderprocessing.dao;

import java.util.List;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.QuoteAlreadyExistException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Employee;
import com.innovision.orderprocessing.model.Order;

public interface EmployeeDao {
	public Employee login(int customerId, String password) throws UserNotFoundException;

	public List<Order> getAllPendingOrder() throws NoPendingOrderException;

	public void addQuote(Order order, Employee employee) throws InvalidOrderDetailException, QuoteAlreadyExistException;
}
