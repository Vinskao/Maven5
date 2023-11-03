package Test;

import dao.CustomerDAOJdbc;
import domain.CustomerBean;

public class CustTest {
    public static void main(String[] args) {
        CustomerDAOJdbc dao = new CustomerDAOJdbc();

        // 呼叫 select 方法，並取得結果
        CustomerBean customer = dao.select("your_custid"); // 用實際的 custid 替換 "your_custid"

        // 檢查結果是否為 null，如果不是，則印出結果
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getCustid());
            System.out.println("Birth Date: " + customer.getBirth());
            System.out.println("Email: " + customer.getEmail());
            // 以此類推，根據 CustomerBean 的屬性印出相關資訊
        } else {
            System.out.println("找不到對應的客戶資料。");
        }
    }
}

