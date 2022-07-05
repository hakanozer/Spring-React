package appPack;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseMainHashMap {
    public static void main(String[] args) {

        // HashMap
        // Key, Val değer çiftlerini kümeler veri yığınları oluşturmak istediğimizde kullanılır.
        Map<String, Object> hm = new HashMap<>();

        // Eleman ekleme
        // Key isimleri benzersiz olmalıdır.
        // Key'ler aynı olduğunda yeni key değeri eski key değerini ezemiş(Değiştirmiş) olur.
        hm.put("name", "Ali");
        hm.put("name", "Erkan");
        hm.put("surname", "Bilirler");
        hm.put("age", 30);
        hm.put("status", true );

        // single item
        Object itm = hm.get("name");
        System.out.println( itm );

        // remove item
        // olmayan bir key kullanılmak istediğinde uygulama hata vermez.
        hm.remove("namex");

        System.out.println("=================================");
        // SET -> interface
        // İçerisinde bulunan değerlerin benzersiz anahtarlar olmasını ister
        Set<String> keys = hm.keySet();
        for( String key : keys ) {
            Object item = hm.get(key);
            System.out.println( key + " : " + item );
        }
        System.out.println("=================================");

        // toplam item sayısı
        int size = hm.size();
        System.out.println( size );

        System.out.println("=================================");
        Collection<Object> cl = hm.values();
        for( Object item : cl ) {
            System.out.println( "Val : " + item );
        }

        System.out.println("=================================");
        System.out.println(hm);
    }
}
