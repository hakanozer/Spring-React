package appPack;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainSet {
    public static void main(String[] args) {

        // SET -> benzersiz değerlerin yada object'lerin bir yığın altında toplanmasını istediğimiz durumlarda kullanılır.
        // içerisindeki methodlar ArrayList methodları ile hemen hemen aynıdır.
        // ekleme yaparken sıralama algoritması HashCode büyüklüğüne göre yapılıyor.
        Set<String> sets = new HashSet<>();

        // item add
        sets.add("Adana Kebap");
        sets.add("Hatay Künefe");
        sets.add("Ayran");
        sets.add("Ayran");
        sets.add("Piyaz Salata");
        sets.add("Çay");
        sets.add("Çay");

        Object[] arr = sets.toArray();
        System.out.println( arr[0] );
        System.out.println( sets );
        sets.forEach( item -> {
            System.out.println( item );
        });
        System.out.println("==========================");

        // Sıralama algoritması bizim eklemediğim gibi olmalı ve benzersiz değerlerden oluşmalı
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Adana Kebap");
        linkedSet.add("Hatay Künefe");
        linkedSet.add("Ayran");
        linkedSet.add("Ayran");
        linkedSet.add("Piyaz Salata");
        linkedSet.add("Çay");
        linkedSet.add("Çay");

        String[] arrSet = linkedSet.toArray(new String[0]);
        System.out.println( arrSet[1] );
        System.out.println( linkedSet );
    }
}
