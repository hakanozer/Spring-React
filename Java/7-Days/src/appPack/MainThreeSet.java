package appPack;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class MainThreeSet {
    public static void main(String[] args) {

        // TreeSet benzersiz ve küçükten büyüğe doğru sıralama yapar
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Ali");
        treeSet.add("Veli");
        treeSet.add("Hasan");
        treeSet.add("Hasan");
        treeSet.add("Hasan");
        treeSet.add("Zehra");
        treeSet.add("Ayşe");
        treeSet.add("Taner");

        System.out.println( treeSet );

    }
}
