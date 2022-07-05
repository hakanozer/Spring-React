package oop;


import users.Address;

import java.util.Random;
import java.util.Scanner;

public class Action {

    // sınıfa ait olan nesne yada değişkenler kurucu method çalışmadan önce bellekte oluşurlar.
    String name = "Ali";

    // Kurucu Method
    // Sınıf üretilmeden önce çalışan methodlardır.
    // Biz bir kurucu method yazdığımızda default olarak gelen kurucu method iptal olur.
    // Kural -> Kurucu methodlar sınıf adı ile aynı olmalıdır.
    public Action() {
        System.out.println("Action Call " + name);
    }

    // this -> kullanıldığı methodun sınıfını işaret eder.
    public Action(String name) {
        this.name = name;
    }

    // noParams noReturn
    public void noParams() {
        System.out.println("noReturn call");
    }

    // noReturn
    public void noReturn( int a, int b ) {
        int sm = a + b;
        System.out.println("Sum : " + sm);
    }

    // int return

    /**
     * Çıkarma işlemi yapar.
     * @param a (int)
     * @param b (int)
     * @return eğer değer 40'tan büyük ise 100 sonucu döner.
     */
    public int minus( int a, int b ) {
        int min = a - b;
        if ( min > 40 ) {
            return 100;
        }
        System.out.println("Min : " + min);
        return min;
    }

    // alan hesapla
    public double alan( int num ) {
        double sonuc = 0;
        if ( num < 1 ) {
            System.out.println("Lütfen birden büyük bir değer giriniz!");
        }else {
            sonuc = 3.14 * (num * num);
        }
        return sonuc;
    }


    public Address fncAddress() {
        Address address = new Address();
        return address;
    }


    // sınırsız data alımı
    // spaceParams("Fenerbahçe", "Galatasaray", "Beşiktaş")
    public String spaceParams( String... items ) {
        String st = "";
        for ( String item : items ) {
            st += item + " ";
        }
        return st;
    }


}
