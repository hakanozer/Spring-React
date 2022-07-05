package appPack;

import java.util.Vector;

public class MainVector {
    public static void main(String[] args) {

        // Vector kullanım şekli olarak ArrayList ile benzer özelliklere sahiptir.
        // ArrayList (Not Synchronization) bir işlem  sırasına göre çalışırken
        // Vector işlemleri yaparklen Synchronization Şeklinde çalıştırı.

        Vector<String> vector = new Vector<>();
        vector.add("Ali");
        vector.add("Ahmet");
        vector.add("Serkan");
        vector.add("Veli");
        vector.add("Ali");

        System.out.println( vector );

    }
}
