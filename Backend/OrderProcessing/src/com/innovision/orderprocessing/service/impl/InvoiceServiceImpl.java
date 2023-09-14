package com.innovision.orderprocessing.service.impl;

import com.innovision.orderprocessing.dao.InvoiceDao;
import com.innovision.orderprocessing.dao.impl.InvoiceDaoImpl;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidInvoiceDetailsException;
import com.innovision.orderprocessing.exception.InvoiceAlreadyExistsException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Invoice;
import com.innovision.orderprocessing.model.Order;

public class InvoiceServiceImpl {

	
   private InvoiceDao invoiceDao;
	
	public InvoiceServiceImpl() throws ConnectionNotEstablishedException
	{
		invoiceDao = new InvoiceDaoImpl();
	}
	
	public void generateInvoice(Order order, Customer customer) throws InvoiceAlreadyExistsException, InvalidInvoiceDetailsException {
		invoiceDao.insertInvoice(order,customer);
	}
	
	public Invoice showInvoice(Order order, Customer customer) throws InvalidInvoiceDetailsException  {
		// TODO Auto-generated method stub
		return invoiceDao.getInvoice(order, customer);
	}
}
