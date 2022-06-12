package appPack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // Product Save
    public int save( int cid, String title, String detail, int price ) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "insert into product values( null, ?, ?, ?, ? )";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, cid);
            pre.setString(2, title);
            pre.setString(3, detail);
            pre.setInt(4, price);
            status = pre.executeUpdate();
        }catch (Exception ex) {
            System.err.println("save Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }


    public List<Product> allProduct() {
        List<Product> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "SELECT p.pid, p.cid, p.title, p.detail, p.price, c.title as catTitle FROM product as p INNER JOIN category as c ON p.cid = c.cid";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
               int pid = rs.getInt("pid");
               int cid = rs.getInt("cid");
               String title = rs.getString("title");
               String detail = rs.getString("detail");
               int price = rs.getInt("price");
               String catTitle = rs.getString("catTitle");
               Product p = new Product(pid, cid, title, detail, price, catTitle);
               ls.add(p);
            }
        }catch (Exception ex) {
            System.err.println("allProduct Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }



}
