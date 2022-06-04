package appPack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainLinkedHashMap {
    public static void main(String[] args) {

        // Sıralama algoritmasının önemli olduğu durumlarda kullanılır.
        Map<String, Object> hm = new LinkedHashMap<>();

        hm.put("status", true);
        hm.put("total", 100);
        hm.put("message", "Success Data Result");
        hm.put("result", new ArrayList<>());

        System.out.println( hm );

    }
}
