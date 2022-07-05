package appPack;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainIterator {
    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();
        set.add("Ali");
        set.add("Veli");
        set.add("Hasan");
        set.add("Hasan");
        set.add("Hasan");
        set.add("Zehra");
        set.add("Ayşe");

        // tüketimi yapıldıktan sonra bir kez daha kullanılmasını istemediğimiz yığınlarda Iterator kullanılır.
        Iterator<String> iterator = set.iterator();
        while ( iterator.hasNext() ) {
            String item = iterator.next();
            System.out.println(item);
        }
        System.out.println("======================");
        while ( iterator.hasNext() ) {
            String item = iterator.next();
            System.out.println(item);
        }

    }
}
