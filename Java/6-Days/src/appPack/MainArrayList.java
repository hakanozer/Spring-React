package appPack;

import java.util.*;

public class MainArrayList {
    public static void main(String[] args) {

        // Collections
        // Diziler gibi davranış sergiler
        // Class oldukları için nesne üretilerek içerisindeki özellikler kullanılabilir.
        // Bütün Collection türleri Generic Type denilen bir yapı ile çalışır.

        // Generic Type
        UseGeneric<String> generic = new UseGeneric<>();
        String ali = generic.sum( "Ali", "Hasan");
        System.out.println(ali);

        // ArrayList
        ArrayList ls1 = new ArrayList(); // Default object

        ArrayList<String> ls2 = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        // ls2 ?
        // ls ? -> List!
        // List ailesi daha fazla Collections ailesine miras verdiğinden
        // dolayı List türünde üretilmesi daha fazla yerde kullanım olanağı tanır.

        // Eleman ekleme
        ls.add("İstanbul");
        ls.add("Zonguldak");
        ls.add("Bursa");
        ls.add("Samsun");
        ls.add("Ankara");
        ls.add("Trabzon");
        ls.add("Kocaeli");
        // 0. indexin yerine "Gaziantep" Ekle
        // diğer elemanların indexleri değişmiş.
        ls.add(0, "Gaziantep");

        // Eleman değeri alma
        // index -> 0
        String item = ls.get(0);
        System.out.println(item);

        // toplam içerisindeki eleman sayısı
        System.out.println( ls.size() );

        // tüm elemanları silme
        // ls.clear();

        // tek bir elemanı silme
        boolean deleteStatus =  ls.remove("samsun");
        System.out.println( deleteStatus );
        String deleteItem = ls.remove(4);
        System.out.println( deleteItem );

        // tüm elemanları ayrı ayrı yazdırma
        // for
        System.out.println("===========================");
        for (int i = 0; i < ls.size(); i++) {
            String itm = ls.get(i);
            System.out.println( itm );
        }
        System.out.println("===========================");
        for ( String itm : ls ) {
            System.out.println( itm );
        }

        // java 8 - lambda for loop
        System.out.println("===========================");
        ls.forEach( itm -> {
            System.out.println( itm );
        } );

        System.out.println("===========================");
        // Aranan değer var mı ?
        boolean isSamsun = ls.contains("Samsun");
        System.out.println( isSamsun );

        // bir Objectin bu listedeki index değerini bulur.
        int ind = ls.indexOf("Ankaras");
        System.out.println( "Ankaras : " + ind );

        // index değerine sahip datanın değişmesi için kullanılır.
        ls.set(0, "Antalya");

        // ArrrayList to Array
        String[] arr = ls.toArray( new String[0] );
        //Object[] objArr = ls.toArray();
        System.out.println( arr[5] );

        System.out.println(ls);
        // sıralama
        // küçükten - büyüğe doğru sıralama
        // sözlük karakter dizilimine göre bir sıralama yapar
        Collections.sort(ls); // küçükten - büyüğe
        Collections.reverse(ls); // Tam ters
        System.out.println(ls);

        if ( ls instanceof List) {
            System.out.println("ls Collection Türündedir.");
        }

        // iterable
        System.out.println("===========================");
        Iterator<String> iterator = ls.iterator();
        while( iterator.hasNext() ) { // index kontrolü yapar
            String itm = iterator.next();
            System.out.println( itm );
        }
        System.out.println("===========================");
        while( iterator.hasNext() ) { // index kontrolü yapar
            String itm = iterator.next();
            System.out.println( itm );
        }

    }
}
