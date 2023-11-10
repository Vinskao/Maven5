package dao;

import java.sql.*;
import java.util.List;
import db.ConnConst;
import domain.ProductBean;

public class ProductDAOJdbc {

	Connection conn = null;
	public ProductDAOJdbc(){
		try{
			Class.forName(ConnConst.JDBC_DRIVER);
			conn = DriverManager.getConnection(ConnConst.DB_URL, ConnConst.USER, ConnConst.PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
	private static final String SELECT_BY_PK = "select * from product where id = ?";
	public ProductBean SELECT_BY_PK(Integer id) {
		ProductBean result = null;
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_PK);
			preparedStatement.setString(1, String.valueOf(id));
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){ //next() 是 Scanner 類別中的一個方法，通常用於讀取輸入中的下一個單詞（以空白為分隔符）。這主要用於控制台輸入
				result = new ProductBean();
				//String col1 =
				result.setId(Integer.valueOf(resultSet.getString("id")));
				result.setMake(resultSet.getDate("make"));
				result.setName(resultSet.getString("name"));
				result.setPrice(resultSet.getDouble("price"));
				result.setExpire(resultSet.getInt("expire"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {}
		return result;
	}
	
	private static final String SELECT_ALL = "select * from product";
//	public List<ProductBean> SELECT_ALL() {
//		List<ProductBean> result = null;
//		try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_PK);
//			 preparedStatement.setString(1, String.valueOf(id));
//
//		){
//
//		} catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return result;
//	}
	
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
