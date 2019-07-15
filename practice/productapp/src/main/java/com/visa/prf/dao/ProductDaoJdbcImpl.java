package com.visa.prf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.visa.prj.entity.Product;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public int addProduct(Product p) throws PersistenceException {
		int id = 0;
		String SQL = "insert into products(id, name, price, category, count) values (0, ?, ?, ?, ?)";
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			// ID AUTO_INCREMENET
			PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS); 
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getCategory());
			ps.setInt(4, p.getCount());
			ps.executeUpdate(); // INSERT, DELETE, UPDATE
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1); // JDBC is 1 based index
			}
		} catch (SQLException ex) {
			throw new PersistenceException("unable to add product", ex);
		} finally {
			DbUtil.closeConnection(con);
		}
		return id;
	}

	@Override
	public List<Product> getProducts() throws FetchException {
		List<Product> products = new ArrayList<>();
		String SQL = "select * from products";
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL); // gives a cursor
			while(rs.next()) {
				products.add(new Product(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("category"),
						rs.getDouble("price"),
						rs.getInt("count")));
			}
		} catch (SQLException e) {
			throw new FetchException("unable to get products", e);
		} finally {
			DbUtil.closeConnection(con);
		}
		return products;
	}

}
