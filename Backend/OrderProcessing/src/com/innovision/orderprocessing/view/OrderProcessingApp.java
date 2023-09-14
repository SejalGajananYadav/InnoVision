package com.innovision.orderprocessing.view;

import java.util.List;
import java.util.Scanner;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.InvalidInvoiceDetailsException;
import com.innovision.orderprocessing.exception.InvalidOrderDateException;
import com.innovision.orderprocessing.exception.InvalidOrderDetailException;
import com.innovision.orderprocessing.exception.InvoiceAlreadyExistsException;
import com.innovision.orderprocessing.exception.NoPendingOrderException;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.exception.QuoteAlreadyExistException;
import com.innovision.orderprocessing.exception.UnathorizedUserException;
import com.innovision.orderprocessing.exception.UserNotFoundException;
import com.innovision.orderprocessing.model.Customer;
import com.innovision.orderprocessing.model.Employee;
import com.innovision.orderprocessing.model.Order;
import com.innovision.orderprocessing.model.Product;
import com.innovision.orderprocessing.service.impl.CustomerServiceImpl;
import com.innovision.orderprocessing.service.impl.EmployeeServiceImpl;
import com.innovision.orderprocessing.service.impl.InvoiceServiceImpl;
import com.innovision.orderprocessing.service.impl.OrderServiceImpl;
import com.innovision.orderprocessing.service.impl.ProductServiceImpl;

public class OrderProcessingApp {

	static void employeeFunctionality(int employeeId, String password)
			throws UserNotFoundException, InvalidOrderDetailException, NoPendingOrderException,
			ConnectionNotEstablishedException, QuoteAlreadyExistException {
		Scanner sc = new Scanner(System.in);
		EmployeeServiceImpl employeeservice = new EmployeeServiceImpl();
		// You can use any value which is present in the databse
		Employee employee = employeeservice.employeelogin(employeeId, password);
		List<Order> allPendingOrderList = employeeservice.showAllPendingOrder();
		for (Order o : allPendingOrderList) {
			System.out.println(o);
			System.out.println("Do you want to create quote for this order?:");
			String response = sc.next();
			if (response.equalsIgnoreCase("YES")) {
				employeeservice.createQuote(o, employee);
				System.out.println("New Quote has been successfully added");
			} else {
				System.out.println("Do you want to continue\nEnter yes or no:");
				String response2 = sc.next();
				if (response2.equalsIgnoreCase("YES")) {
					continue;
				} else {
					System.out.println("Thanks for exploring website");
					System.exit(0);
				}
			}
		}
		System.out.println("There are no more pending orders");
		System.out.println("Thanks for exploring website");
		System.exit(0);
		sc.close();
	}

	static void customerFunctionality()
			throws UserNotFoundException, ConnectionNotEstablishedException, InvalidOrderDateException,
			InvoiceAlreadyExistsException, InvalidInvoiceDetailsException, NoPendingOrderException,
			UnathorizedUserException, InvalidOrderDetailException, ProductUnavailableException {
		Scanner sc = new Scanner(System.in);
		CustomerServiceImpl customerservice = new CustomerServiceImpl();
		// You can either use cutsomer name or Id because this method is overloaded.
		Customer customer = customerservice.customerlogin("Michael Johnson", "@Mic8765");
		ProductServiceImpl productservice = new ProductServiceImpl();
		OrderServiceImpl orderservice = new OrderServiceImpl();
		InvoiceServiceImpl invoiceservice = new InvoiceServiceImpl();
		System.out.println("Do you want to place the order or Review the pending orders?\n"
				+ "Select the following option \n1.Review Pending Orders\n2.Place new order");
		int choice1 = sc.nextInt();
		switch (choice1) {
		case 1:
			List<Order> customerPendingOrderList = orderservice.showAllPendingOrder(customer);
			for (Order o : customerPendingOrderList) {
				System.out.println(o);
				System.out.println("Do you want to approve that Order:");
				String response = sc.next();
				if (response.equalsIgnoreCase("YES")) {
					orderservice.approveOrder(o);
					invoiceservice.generateInvoice(o, customer);
					System.out.println("You have approved the order");
					System.out.println("Thanks for exploring the website");
					System.exit(0);
				} else {
					System.out.println("Do you want to continue\nEnter yes or no:");
					String response2 = sc.next();
					if (response2.equalsIgnoreCase("YES")) {
						continue;
					} else {
						System.out.println("Thanks for exploring website");
						System.exit(0);
					}
				}
			}
			System.out.println("There are no more pending orders");
			System.out.println("Thanks for exploring website");
			System.exit(0);
			break;
		case 2:
			Order order = customerservice.customerPlaceOrder();
			List<Product> productList = productservice.getAll();
			for (Product p : productList) {
				System.out.println(p);
				System.out.println("Do you want to approve that product?\nEnter yes or no:");
				String response1 = sc.next();
				if (response1.equalsIgnoreCase("YES")) {
					System.out.println("Enter the quantity:");
					int quantity = sc.nextInt();
					orderservice.addProduct(p, quantity);
				}
				System.out.println("Do you want to continue\nEnter yes or no:");
				String response2 = sc.next();
				if (response2.equalsIgnoreCase("YES")) {
					continue;
				} else
					break;

			}
			orderservice.saveUpdateOrder(order);
			orderservice.saveProductIntoOrder(order, orderservice.getSelectedProducts());
			System.out.println("Do you want to approve that Order:");
			String response = sc.next();
			if (response.equalsIgnoreCase("YES")) {
				orderservice.approveOrder(order);
				invoiceservice.generateInvoice(order, customer);
				System.out.println("You have approved the order");
				System.out.println("Thanks for exploring the website");
			} else {
				System.out.println("Thanks for exploring the website");
				System.exit(0);
			}
			break;
		default:
			System.out.println("Invalid Option");
			System.exit(0);
		}
		sc.close();
	}

	public static void main(String[] args) throws UserNotFoundException, InvalidOrderDetailException,
			NoPendingOrderException, ConnectionNotEstablishedException, InvalidOrderDateException,
			InvoiceAlreadyExistsException, InvalidInvoiceDetailsException, UnathorizedUserException,
			ProductUnavailableException, QuoteAlreadyExistException {

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Are you Employee or Customer?\nSelect from following option\n1.Employee login\n2.Customer login");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			employeeFunctionality(1, "password123");
			break;
		case 2:
			customerFunctionality();
			break;

		default:
			System.out.println("Invalid login option");
			System.exit(0);
		}

		scanner.close();

	}

}
