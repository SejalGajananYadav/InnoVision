package com.innovision.orderprocessing.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.innovision.orderprocessing.dao.ProductDao;
import com.innovision.orderprocessing.exception.ConnectionNotEstablishedException;
import com.innovision.orderprocessing.exception.ProductUnavailableException;
import com.innovision.orderprocessing.model.Product;

public class ProductDaoImpl implements ProductDao, AutoCloseable {

	private static List<Product> productList = new ArrayList<>();
	private Connection con;

	
	public ProductDaoImpl() throws ConnectionNotEstablishedException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OrderProcessing", "root", "@Abc123");
		} catch (SQLException | ClassNotFoundException e) {
			throw new ConnectionNotEstablishedException();
		}
	}

	/*Fetch the data of all the products available in the system to show it to customer else 
	 * raise exception 
	 * */
	@Override
	public List<Product> getAll() throws  ProductUnavailableException {
		// TODO Auto-generated method stub

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from Products");
			ResultSet rs = pstmt.executeQuery();// Query is getting executed here
			while (rs.next()) {
				PreparedStatement pstmt1 = con.prepareStatement("Update Products set Category=? where ProductId=?");
				int productId = rs.getInt(1);
				String productName = rs.getString(2);
				double productPrice = rs.getDouble(3);
				Product product = new Product(productId, productName, productPrice);
				if (rs.getString(4) == null) {
					pstmt1.setString(1, product.getCategory().getProductCategoryType());
					pstmt1.setInt(2, productId);
					pstmt1.executeUpdate();
				}
				productList.add(product);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductUnavailableException();
		}

		return productList;
	}

	

	@Override
	public void update(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		con.close();
	}

}
