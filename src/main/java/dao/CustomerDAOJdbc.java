package dao;

import db.ConnConst;
import domain.CustomerBean;
import java.sql.*;

public class CustomerDAOJdbc {
    Connection conn = null;
    public CustomerDAOJdbc(){
        try {
            Class.forName(ConnConst.JDBC_DRIVER);
            conn = DriverManager.getConnection(ConnConst.DB_URL, ConnConst.USER, ConnConst.PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String SELECT = "select * from customer where custid = ?";
    public CustomerBean select(String custid) {
        CustomerBean result = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT);
            preparedStatement.setString(1,custid);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Executes the given SQL statement, which returns a single ResultSet object.

            if (resultSet.next()){
                result = new CustomerBean();
                result.setCustid(resultSet.getString("custid"));
                result.setBirth(resultSet.getDate("birth"));
                result.setEmail(resultSet.getString("email"));
                //Retrieves the value of the designated column in the current row of this ResultSet object as a String
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    private static final String UPDATE =
            "update customer set password=?, email=?, birth=? where custid=?";
    public boolean update(byte[] password, String email, java.util.Date birth, String custid) {

        return false;
    }
}