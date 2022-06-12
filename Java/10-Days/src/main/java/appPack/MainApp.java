package appPack;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        ProductService service = new ProductService();
        //int status = service.save(5, "Ayna", "Güzel Ayna", 1000);
        //System.out.println("Save :" + status);
        List<Product> ls = service.allProduct();
        ls.forEach( item -> {
            System.out.println( item );
        });
    }
}
