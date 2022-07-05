package appPack;

import java.util.Scanner;

public class UseScanner {
    public static void main(String[] args) {

        // Scanner Sınıfı
        Scanner read = new Scanner(System.in);
        Scanner readSt = new Scanner( System.in );

        System.out.print("Lütfen 1. Sayıyı Giriniz! :");
        int num1 = read.nextInt();

        System.out.print("Lütfen 2. Sayıyı Giriniz! :");
        int num2 = read.nextInt();
        int sum = num1 + num2;

        // kişinin adı
        System.out.print("Lütfen Adınızı Giriniz! :");
        String name = readSt.nextLine();

        // Sn. Erkan Toplam Sonucunuz: 790
        //String line = "Sn. " + name + " Toplam Sonucunuz: " + sum;
        //System.out.println( line );
        System.out.printf("Sn. %s Toplam Sonucunuz: %s", name, sum);


    }
}
