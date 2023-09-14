package com.innovision.orderprocessing.service.impl;

import java.util.List;

import com.innovision.orderprocessing.dao.EmployeeDao;
import com.innovision.orderprocessing.dao.impl.EmployeeDaoImpl;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.QuoteAlreadyExistException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Employee;
import com.innovision.orderprocessing.model.Order;
import com.innovision.orderprocessing.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() throws ConnectionNotEstablishedException
	{
		employeeDao = new EmployeeDaoImpl();
	}
	
	@Override
	public Employee employeelogin(int employeeId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return employeeDao.login(employeeId, password);
	}

	@Override
	public List<Order> showAllPendingOrder() throws NoPendingOrderException {
		// TODO Auto-generated method stub
		return employeeDao.getAllPendingOrder();
	}

	@Override
	public void createQuote(Order order, Employee employee) throws InvalidOrderDetailException, QuoteAlreadyExistException {
		// TODO Auto-generated method stub
		employeeDao.addQuote(order, employee);
	}

}
