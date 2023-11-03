package daoExample;

import java.sql.DriverManager;
import java.util.List;

import domain.ProductBean;

public class ProductDAOJdbc {
	private static final String URL = "";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	
	private static final String SELECT_BY_PK = "select * from product where id = ?";
	public ProductBean select(Integer id) {
		ProductBean result = null;
		
		
		
		return result;
	}
	
	private static final String SELECT_ALL = "select * from product";
	public List<ProductBean> select() {
		List<ProductBean> result = null;
		
		return result;
	}
	
	private static final String INSERT =
			"insert into product (id, name, price, make, expire) values (?, ?, ?, ?, ?)";
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		
		return result;
	}
	
	private static final String UPDATE =
			"update product set name=?, price=?, make=?, expire=? where id=?";
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		
		return result;
	}
	
	private static final String DELETE = "delete from product where id = ?";
	public boolean delete(Integer id) {
		
		return false;
	}
}
