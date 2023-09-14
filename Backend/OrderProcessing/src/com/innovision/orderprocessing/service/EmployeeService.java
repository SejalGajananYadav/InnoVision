package com.innovision.orderprocessing.service;

import java.util.List;

import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.QuoteAlreadyExistException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Employee;
import com.innovision.orderprocessing.model.Order;

public interface EmployeeService {

	public Employee employeelogin(int customerId, String password) throws  UserNotFoundException;
	public List<Order> showAllPendingOrder() throws NoPendingOrderException ;
	public void createQuote(Order order,Employee employee) throws InvalidOrderDetailException, QuoteAlreadyExistException;
}
