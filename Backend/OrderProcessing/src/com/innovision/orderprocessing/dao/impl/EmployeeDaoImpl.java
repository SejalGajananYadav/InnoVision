package com.innovision.orderprocessing.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.innovision.orderprocessing.dao.EmployeeDao;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.QuoteAlreadyExistException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Employee;
import com.innovision.orderprocessing.model.Order;

public class EmployeeDaoImpl implements EmployeeDao, AutoCloseable {
	private Connection con;
	private List<Order> orderList = new ArrayList<>();

	// internally intializes the connection object
	public EmployeeDaoImpl() throws ConnectionNotEstablishedException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OrderProcessing", "root", "@Abc123");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ConnectionNotEstablishedException();
		}
	}

	// To check the username and password details of the customer , checks weather
	// it is already present in database or not
	// User can provide either customer ID or customer name (hence method
	// overloading is used) ,it should match with the password.

	@Override
	public Employee login(int employeeId, String password) throws UserNotFoundException {
		Employee employee;
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select UserName from Employees where EmployeeID = ? and password = ?");
			pstmt.setInt(1, employeeId);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();// Query is getting executed here
			if (rs.next()) {
				String userName = rs.getString(1);
				employee = new Employee(userName, employeeId);
				return employee;
			} else
				throw new UserNotFoundException("User not found in the system");
		} catch (SQLException ex) {
			throw new UserNotFoundException("User not found in the system");
		}
	}

	/*
	 * this method shows all the orders having the status pending and create the
	 * list of such orders and send it to the employee.
	 */
	@Override
	public List<Order> getAllPendingOrder() throws NoPendingOrderException {
		try {
			PreparedStatement pstmt1 = con.prepareStatement(
					"Select o.OrderID,o.OrderDate,o.CustomerID,o.CustomerShippingAddress,o.TotalOrderValue,o.ShippingCost,o.ShippingAgency,o.Status from Orders o  where  o.Status='Pending'");
			ResultSet rs = pstmt1.executeQuery();
			while (rs.next()) {
				int orderId = rs.getInt(1);
				Date new_orderDate = new Date(rs.getDate(2).getTime());
				int new_customerId = rs.getInt(3);
				String new_shippingAddress = rs.getString(4);
				double new_totalOrderValue = rs.getDouble(5);
				double new_shippingCost = rs.getDouble(6);
				String new_shippingAgency = rs.getString(7);
				String new_status = rs.getString(8);
				Order order = new Order(new_orderDate, new_customerId, new_shippingAddress);
				order.setOrderId(orderId);
				order.setTotalOrderValue(new_totalOrderValue);
				order.setShippingCost(new_shippingCost);
				order.setStatus(new_status);
				order.setShippingAgency(new_shippingAgency);
				orderList.add(order);

			}

			return orderList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NoPendingOrderException();
		}

	}

	/*
	 * This method is used by the employee to create quote and save it to database
	 * it throws the InvalidOrderDetails if the order details are invalid or not
	 * proper or not there in database.employee object is passed so that we can
	 * trace that who has created the quote
	 */
	@Override
	public void addQuote(Order order, Employee employee) throws InvalidOrderDetailException, QuoteAlreadyExistException {
		try {
			PreparedStatement pstmt1 = con
					.prepareStatement("Select * from Quote where OrderID = ? ");
			pstmt1.setInt(1, order.getOrderId());
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				throw new QuoteAlreadyExistException("This quote is already present");
			}else
			{
				PreparedStatement pstmt = con.prepareStatement("Insert into Quote(OrderId,CustomerId,EmployeeId ) values(?,?,?) ");
				pstmt.setInt(1, order.getOrderId());
				pstmt.setInt(2, order.getCustomerId());
				pstmt.setInt(3, employee.getEmployeeID());
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new InvalidOrderDetailException("Invalid order details to create quote");
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

}
