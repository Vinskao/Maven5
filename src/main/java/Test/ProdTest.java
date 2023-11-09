package Test;
import dao.ProductDAOJdbc;
import domain.ProductBean;
public class ProdTest {
    public static void main(String[] args) {
        ProductDAOJdbc dao = new ProductDAOJdbc();
        ProductBean product = dao.select(1);
        if (product != null){
            System.out.println("id: " + product.getId());
            System.out.println("name: " + product.getName());
            System.out.println("price: " + product.getPrice());
            System.out.println("make: " + product.getMake());
            System.out.println("expire: " + product.getExpire());

        } else {
            System.out.println("找不到對應的商品資料。");
        }

    }
}
