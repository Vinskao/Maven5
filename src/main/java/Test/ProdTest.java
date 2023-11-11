package Test;
import dao.ProductDAOJdbc;
import domain.ProductBean;
public class ProdTest {
    public static void main(String[] args) {
        ProductDAOJdbc dao = new ProductDAOJdbc();
        ProductBean product = dao.SELECT_BY_PK(1);
        if (product != null){
            System.out.println("id: " + product.getId());
            System.out.println("name: " + product.getName());
            System.out.println("price: " + product.getPrice());
            System.out.println("make: " + product.getMake());
            System.out.println("expire: " + product.getExpire());

        } else {
            System.out.println("找不到對應的商品資料。");
        }
        ProductBean updatedProduct = new ProductBean();
        updatedProduct.setId(1);
        updatedProduct.setName("小高");
        updatedProduct.setPrice(99.99);
        updatedProduct.setMake(new java.util.Date(300000000));
        updatedProduct.setExpire(365);
        if (dao.update(updatedProduct)){
            System.out.println("Updated");
        }
    }
}
