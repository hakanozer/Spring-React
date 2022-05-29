package appPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SampleArrayList {
    public static void main(String[] args) {

        List<Person> ls = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        while( true ) {
            System.out.println("Kişi Adı");
            String name = scanner.nextLine();
            System.out.println("Kişi Soyadı");
            String surname = scanner.nextLine();
            System.out.println("Kişi Yaşı");
            int age = scannerInt.nextInt();
            System.out.println("Kişi TC");
            int tc = scannerInt.nextInt();
            Person person = new Person(name, surname, age, tc);
            ls.add(person);

            System.out.println("Bitir için \"X\" devam için herhangi bir tuşa basınız!");
            String answer = scanner.nextLine();
            if ( answer.equalsIgnoreCase("x") ) {
                break;
            }
        }

        System.out.println(ls);

    }
}
