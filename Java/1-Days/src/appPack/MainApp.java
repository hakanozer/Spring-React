package appPack;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Hello Java");

        // Değişkenler
        // String
        // Defult - null
        // Karakter katarı

        // Kişi Adı, Nick, TC, Yaş
        String name = "Ali";
        String surname = "Bilmem";
        name = "Kemal";
        System.out.println( name );


        // Tam sayı Türleri
        // Byte -> (127) (-128) aralığında bir değer alır.
        // Defult - 0
        byte age = 90;
        // Kişinin yaşı, kaçıncı sınıfta...

        // short
        // Defult - 0
        short area = 32000;
        // Alışveriş total miktarı, arsa kaç metre olduğu

        // int
        // Defult - 0
        // default tam sayı türü
        int count = 214700000;
        // Türkiye nüfusu, kaç kişi oy kullandı

        // long
        // Defult - 0
        long bigCount = 7500000000l;
        // Dünya nüfusu, Güneşin çapı kaç metre

        // Ondalıklı Sayısal değerler
        // double - // 8 bytes
        // Defult - 0.0
        // javada defult ondalıklı değerdir.
        double d1 = 123456782.51231231231231;
        // max 15 basamaklı ondalıklı değerler saklamak için kullanılır.
        // Borsa hesaplamalarında,

        // float - // 4 bytes
        // Defult - 0.0
        float f1 = 12.5f;
        // Günlük metre ölçümlerinde,
        // max 7 basamaklı ondalıklı değerler saklamak için kullanılır.


        // sayısal olmayan karakter türleri
        // boolean -> true, falsa
        // Defult - false
        boolean status = false;
        // Kullınıcı girişi varmı?, Stok yeterli mi?

        // char
        // Defult - '\u0000' – Boş
        char c = 's';
        // CTRL + s -> Kaydet


    }

}
