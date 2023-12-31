package Test;
import dao.CustomerDAOJdbc;
import domain.CustomerBean;
public class CustTest {
    public static void main(String[] args) {
        CustomerDAOJdbc dao = new CustomerDAOJdbc();
        // 呼叫 select 方法，並取得結果
        CustomerBean customerSelect = dao.select("Alex");
        // 檢查結果是否為 null，如果不是，則印出結果
        if (customerSelect != null) {
            System.out.println("Customer ID: " + customerSelect.getCustid());
            System.out.println("Birth Date: " + customerSelect.getBirth());
            System.out.println("Email: " + customerSelect.getEmail());
            // 以此類推，根據 CustomerBean 的屬性印出相關資訊
        } else {
            System.out.println("找不到對應的客戶資料。");
        }
        boolean isUpdated = dao.update(new byte[]{1,2,3}, "23fewf", new java.util.Date(322353425), "Alex"  );
        System.out.println(isUpdated);
    }
}

