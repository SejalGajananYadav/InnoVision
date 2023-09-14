package com.innovision.orderprocessing.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.innovision.orderprocessing.dao.InvoiceDao;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidInvoiceDetailsException;
import com.innovision.orderprocessing.exception.InvoiceAlreadyExistsException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Invoice;
import com.innovision.orderprocessing.model.Order;

public class InvoiceDaoImpl implements InvoiceDao, AutoCloseable {

	private Connection con;
	private double gstAmount;

	// internally intializes the connection object
	public InvoiceDaoImpl() throws ConnectionNotEstablishedException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OrderProcessing", "root", "@Abc123");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ConnectionNotEstablishedException();
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * this method is used to create the invoice details in the database by using
	 * order object which will represent the approved order details and customer
	 * object is used for authenticated user details which represents who is going
	 * to approve the order
	 */
	@Override
	public void insertInvoice(Order order, Customer customer)
			throws InvoiceAlreadyExistsException, InvalidInvoiceDetailsException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt1 = con
					.prepareStatement("Select * from Invoices where OrderID = ? and CustomerID = ?");
			pstmt1.setInt(1, order.getOrderId());
			pstmt1.setInt(2, customer.getCustomerId());
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				throw new InvoiceAlreadyExistsException();
			} else {
				PreparedStatement pstmt = con.prepareStatement(
						"Insert into Invoices(InvoiceDate,OrderID,CustomerID,TypeOfGST,TotalGSTAmount,TotalInvoiceValue,Status)values(?,?,?,?,?,?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				pstmt.setDate(1, new java.sql.Date(new Date().getTime()));
				pstmt.setInt(2, order.getOrderId());
				pstmt.setDouble(3, customer.getCustomerId());
				pstmt.setString(4, "Inter State");
				pstmt.setDouble(5, order.getTotalOrderValue() * 0.1);
				pstmt.setDouble(6, calculateInvoiceValue(order, customer));
				pstmt.setString(7, "Unpaid");
				pstmt.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new InvoiceAlreadyExistsException();
		}
	}

	/*
	 * This method returns the Invoice object. It fetches all the data of the
	 * invoice for give order and customer then it passes that data to invoice
	 * object and initialize it.
	 */
	public Invoice getInvoice(Order order, Customer customer) throws InvalidInvoiceDetailsException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt1 = con
					.prepareStatement("Select * from Invoices where OrderID = ? and CustomerID = ?");
			pstmt1.setInt(1, order.getOrderId());
			pstmt1.setInt(2, customer.getCustomerId());
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				int invoiceId = rs.getInt(1);
				Date invoiceDate = new Date(rs.getDate(2).getTime());
				int orderId = rs.getInt(3);
				int customerId = rs.getInt(4);
				String typeOfGst = rs.getString(5);
				double totalGstAmount = rs.getDouble(6);
				double invoiceValue = rs.getDouble(7);
				String status = rs.getString(8);

				Invoice invoice = new Invoice(invoiceId, invoiceDate, orderId, customerId, typeOfGst, totalGstAmount,
						invoiceValue, status);
				return invoice;
			} else {
				throw new InvalidInvoiceDetailsException();
			}
		} catch (SQLException e) {
			throw new InvalidInvoiceDetailsException();
		}
	}

	/*
	 * this method calculates the total invoice value based on the order details. It
	 * fetched the totalOrderValue and shipping cost from the database then gst
	 * amount is calculated 10% of the totalordervalue and return the addition of
	 * gstamiunt, totalordervalue and shipping cost as total invoice value
	 */
	public double calculateInvoiceValue(Order order, Customer customer) throws InvalidInvoiceDetailsException {

		try {

			PreparedStatement pstmt1 = con.prepareStatement(
					"Select TotalOrderValue,ShippingCost from Orders where OrderID = ? and CustomerID = ?");
			pstmt1.setInt(1, order.getOrderId());
			pstmt1.setInt(2, customer.getCustomerId());
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				double totalOrderValue = rs.getDouble(1);
				double shippingCost = rs.getDouble(2);
				gstAmount = 0.1 * totalOrderValue;
				return totalOrderValue + shippingCost + gstAmount;
			}
		} catch (SQLException ex) {
			throw new InvalidInvoiceDetailsException();
		}

		return 0.0;
	}

}
