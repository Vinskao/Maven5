package dao;

import domain.CustomerBean;

public class CustomerDAOJdbc {
	private static final String URL = "";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	
	private static final String SELECT = "select * from customer where custid = ?";
	public CustomerBean select(String custid) {
		CustomerBean result = null;

		return result;
	}

	private static final String UPDATE =
			"update customer set password=?, email=?, birth=? where custid=?";
	public boolean update(byte[] password, String email, java.util.Date birth, String custid) {
		
		 return false;
	}
}
