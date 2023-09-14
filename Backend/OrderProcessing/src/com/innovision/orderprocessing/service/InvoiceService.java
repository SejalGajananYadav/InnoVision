package com.innovision.orderprocessing.service;

import com.innovision.orderprocessing.exception.InvalidInvoiceDetailsException;
import com.innovision.orderprocessing.exception.InvoiceAlreadyExistsException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Invoice;
import com.innovision.orderprocessing.model.Order;

public interface InvoiceService {

	public void generateInvoice(Order order, Customer customer) throws InvoiceAlreadyExistsException, InvalidInvoiceDetailsException;
	
	public Invoice showInvoice(Order order, Customer customer) throws InvalidInvoiceDetailsException;
}
