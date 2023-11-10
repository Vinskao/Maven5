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
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    private static final String UPDATE =
            "update customer set password=?, email=?, birth=? where custid=?";

    public boolean update(byte[] password, String email, java.util.Date birth, String custid) {
        int x =0;
        CustomerBean result = null;
        ResultSet rset = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(UPDATE);
        PreparedStatement stmt = conn.prepareStatement(UPDATE);
        )
        {
            stmt.setBytes(1, password);
            stmt.setString(2, email);
            stmt.setDate(3, new java.sql.Date(birth.getTime()));
            stmt.setString(4, custid);
            x = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (rset != null){
                try {
                    rset.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        if (x == 0){
            return false;
        } else {
            return true;
        }
    }
}