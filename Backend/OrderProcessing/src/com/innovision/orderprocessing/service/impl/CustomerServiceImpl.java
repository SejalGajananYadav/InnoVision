package com.innovision.orderprocessing.service.impl;


import com.innovision.orderprocessing.dao.CustomerDao;
import com.innovision.orderprocessing.dao.impl.CustomerDaoImpl;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.UnathorizedUserException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;
import com.innovision.orderprocessing.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;
	
	public CustomerServiceImpl() throws ConnectionNotEstablishedException
	{
		customerDao = new CustomerDaoImpl();
	}
	
	@Override
	public Customer customerlogin(String Name, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return customerDao.login(Name, password);
	}
	
	@Override
	public Customer customerlogin(int customerId, String password) throws  UserNotFoundException {
		// TODO Auto-generated method stub
		return customerDao.login(customerId, password);
	}
	
	@Override
	public Order customerPlaceOrder() throws UnathorizedUserException, InvalidOrderDetailException, ConnectionNotEstablishedException {
		// TODO Auto-generated method stub
		return customerDao.placeOrder();
	}
	
	
	
}
