package service;

import java.util.Arrays;
import dao.CustomerDAOJdbc;
import domain.CustomerBean;
public class CustomerService {
    private CustomerDAOJdbc customerDao = new CustomerDAOJdbc();
    public boolean changePassword(String username, String oldPassword, String newPassword) {
//        System.out.println(123);
        CustomerBean login = this.login(username, oldPassword);
//        System.out.println(456);
        if(login!=null) {
            if(newPassword!=null && newPassword.length()!=0) {
                byte[] pass = newPassword.getBytes();
                return customerDao.update(
                        pass, login.getEmail(), login.getBirth(), username);
            }
        }
        return false;
    }
    public CustomerBean login(String username, String password) {
        CustomerBean select = customerDao.select(username);
        if(select!=null) {
            if(password!=null) {
                byte[] pass = select.getPassword();		//資料庫取出
                byte[] temp = password.getBytes();		//使用者輸入
                if(Arrays.equals(pass, temp)) {
                    return select;
                }
            }
        }
        return null;
    }
}
