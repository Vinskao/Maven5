package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.ConnConst;
import domain.CustomerBean;

public class CustomerDAOJdbc {
    Connection conn = null;
    public CustomerDAOJdbc(){
        try {
            Class.forName(ConnConst.JDBC_DRIVER);
            conn = DriverManager.getConnection(ConnConst.DB_URL, ConnConst.USER, ConnConst.PASSWORD );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String SELECT = "select * from customer where custid = ?";
    public CustomerBean select(String custid) {
        CustomerBean result = null;
        ResultSet rset = null;
        try(
            PreparedStatement stmt = conn.prepareStatement(SELECT)

        )
        {
            stmt.setString(1, custid);
            rset = stmt.executeQuery();
            if(rset.next()) {
                result = new CustomerBean();
                result.setCustid(rset.getString("custid"));
                result.setPassword(rset.getBytes("password"));
                result.setEmail(rset.getString("email"));
                result.setBirth(rset.getDate("birth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rset!=null) {
                try {
                    rset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private static final String UPDATE =
            "update customer set password=?, email=?, birth=? where custid=?";
    public boolean update(byte[] password, String email, java.util.Date birth, String custid) {
        try(
            PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setBytes(1, password);
            stmt.setString(2, email);
            if(birth!=null) {
                System.out.println(1);
                long time = birth.getTime();
                stmt.setDate(3, new java.sql.Date(time));
            } else {
                stmt.setDate(3, null);
            }
            stmt.setString(4, custid);

            int i = stmt.executeUpdate();
            if(i==1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
