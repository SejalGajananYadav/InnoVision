package com.innovision.orderprocessing.dao;

import com.innovision.orderprocessing.exception.InvalidInvoiceDetailsException;
import com.innovision.orderprocessing.exception.InvoiceAlreadyExistsException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Invoice;
import com.innovision.orderprocessing.model.Order;

public interface InvoiceDao {
	public void insertInvoice(Order order, Customer customer)
			throws InvoiceAlreadyExistsException, InvalidInvoiceDetailsException;

	public Invoice getInvoice(Order order, Customer customer) throws InvalidInvoiceDetailsException;
}
