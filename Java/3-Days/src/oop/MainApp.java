package oop;

import users.Address;

import java.util.Scanner;

public class MainApp {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int number = 10;
        // (Sınıf) 1- Action -> Olulturulacak nesnenin türüne karşılık gelir.
        // (Nesne) 2- ac -> Üretilen sınıfın yeteneklerinin bulunduğu Object.
        // (new) 3- new -> Sınıf içindeki değişken, nesne vb. özellikleri bellekte hazırlar.
        // (Kurucu Method) 4- Sınıf çalışmadan önce sınıfın içerisine değişken yada nesne göndermeye yarar.
        Action ac = new Action();
        ac.name = "Serkan";
        System.out.println( ac.name );

        Action ac2 = ac;
        Action ac1 = new Action();
        System.out.println( ac2.name );

        // ac -> nesne
        // sınıf altındaki özelliklere (.) operatörü ile gidilir.
        // ac.hashCode(); // hashCode normalde bizim sınıfımızda yoktu.
        // Her sınıf Object sınıfından miras aldığı için Object sınıfı altındaki özellikler bizlere görünür.
        Profile pr = new Profile();

        String stObj = "Erkan";
        Object obj = new Action();
        obj = "Ali";
        obj = 100;
        obj = 50.7;
        String[] arr = {"İstanbul", "İzmir", "Bursa"};
        Object[] arrx = { "Ankara", 50, 21.2, true };
        arrx[0] = 100l;

        // Erişim belirteçleri kullanımı
        // Java'da bir sınıf farklı paket içerisinde ise o sınıfın nesnesi kurulurken
        // import mutlaka gereklidir.
        Address address = new Address();
        System.out.println( address.num1 );

        // Fonksiyonlar
        ac.noParams();
        ac.noReturn(300, 55);
        ac.noReturn(12, 2121);
        ac.noReturn(21, 21);
        ac.noReturn(12, 121);

        int min = ac.minus(100, 39);

        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("Lütfen çap giriniz!");
            int cap = read.nextInt();
            double alan = ac.alan(cap);
            if ( alan > 0 ) {
                System.out.println( "Alan : " + alan );
                break;
            }
        }

        Address ad = ac.fncAddress();
        String data = ac.fncAddress().fncName();
        System.out.println( data );

        // açıklama satırı
        ac.minus(50,40);

        // kurucu method - parametre
        Action ac3 = new Action("Mehmet");
        System.out.println( ac3.name );

        String line = ac3.spaceParams("Fenerbahçe", "Galatasaray", "Beşiktaş", "Bursa Spor");
        System.out.println( line );

    }

    private static double alanHesapla() {

        System.out.println("Alan bilgisi için çapını giriniz");
        int cap = input.nextInt();
        if (cap < 1) {
            System.out.println("Lütfen 1 den ufak rakam yazmayın");
        }
        return Math.PI * cap*cap;

    }

}
