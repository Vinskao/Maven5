package Test;

import domain.CustomerBean;
import service.CustomerService;
import java.sql.SQLOutput;
public class CustServTest {
    public static void main(String[] args) {
        //test login
        CustomerService customerService = new CustomerService();
        CustomerBean result = customerService.login("Babe","B");
        System.out.println(result);
        //test change password
        if(customerService.changePassword("Ellen", "F", "G")){
            System.out.println("Change successful");
        } else {
            System.out.println("not good");
        }
    }
}
