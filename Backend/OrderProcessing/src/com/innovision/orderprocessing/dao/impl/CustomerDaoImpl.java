package com.innovision.orderprocessing.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.innovision.orderprocessing.dao.CustomerDao;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.UnathorizedUserException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Order;

public class CustomerDaoImpl implements CustomerDao, AutoCloseable {

	private Connection con;
	private Customer authenticatedCustomer;

	// internally intializes the connection object
	public CustomerDaoImpl() throws ConnectionNotEstablishedException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OrderProcessing", "root", "@Abc123");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ConnectionNotEstablishedException();
		}
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer entity) {
		// TODO Auto-generated method stub

	}

	// To check the username and password details of the customer , checks weather
	// it is already present in database or not
	// User can provide either customer ID or customer name (hence method
	// overloading is used) ,it should match with the password.
	@Override
	public Customer login(String Name, String password) throws UserNotFoundException {
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Customers where Name = ? and password = ?");
			pstmt.setString(1, Name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();// Query is getting executed here
			if (rs.next()) {
				authenticatedCustomer = intializeCustomerObject(rs);
				return intializeCustomerObject(rs);
			} else
				throw new UserNotFoundException();
		} catch (SQLException ex) {
			throw new UserNotFoundException();
		}
	}

	// login by providing the CustomerId
	@Override
	public Customer login(int customerId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from Customers where CustomerID = ? and password = ?");
			pstmt.setInt(1, customerId);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();// Query is getting executed here
			if (rs.next()) {
				authenticatedCustomer = intializeCustomerObject(rs);
				return intializeCustomerObject(rs);
			} else
				throw new UserNotFoundException("User not found in the system");

		} catch (SQLException ex) {
			throw new UserNotFoundException("User not found in the system");
		}
	}

	// To initialize the customer object by fetching the information from the
	// database
	public Customer intializeCustomerObject(ResultSet rs) throws UserNotFoundException {

		try {
			int id = rs.getInt("CustomerID");
			String name = rs.getString("Name");
			String gstNumber = rs.getString("GSTNumber");
			String address = rs.getString("Address");
			String city = rs.getString("City");
			String email = rs.getString("Email");
			String phone = rs.getString("Phone");
			int pincode = rs.getInt("PinCode");
			Customer customer = new Customer(id, name, gstNumber, address, city, email, phone, pincode);
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException("User not found in the system");
		}

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	// this method provides the facility to authenticated customer to place order
	/*
	 * check weather the authenticatedCustomer variable is initialized or not then
	 * initiates the order object by providing the authenticated customer
	 * details.Then it initializes the OrderDaoImpl object to access insertOrder
	 * method which saves the order object data to database; if authenticated user
	 * is not there then UnathorizedUserException is thrown , if order details are
	 * not proper then InvalidOrderDetailException is thrown, otherwise for
	 * connection problemes ConnectionNotEstablishedException is thrown.
	 */
	@Override
	public Order placeOrder()
			throws UnathorizedUserException, InvalidOrderDetailException, ConnectionNotEstablishedException {
		// TODO Auto-generated method stub

		Order order;
		if (authenticatedCustomer != null) {
			order = new Order(new Date(), authenticatedCustomer.getCustomerId(),
					authenticatedCustomer.getCustomerAddress());
			OrderDaoImpl orderDao = new OrderDaoImpl();
			orderDao.insertOrder(order);
			return order;
		} else
			throw new UnathorizedUserException("User is not authenticated");

	}

}
