package appPack;

import java.util.Random;

public class Profile {

    String name = "Erkan Bilsin";
    static int age = 32;
    // final
    // değişken yada nesnenin ilk değerinden sonra değişmemesini istediğimiz durumlarda kullanılır.
    // Örn: DB bağlantı bilgileri, ApiKey,
    final String city = "İstanbul";
    final String localtion;
    // nesneler final olur
    final Random random = new Random();

    public Profile() {
        localtion = "Kadıköy";
        minus(50, 3);
        System.out.println( city + localtion );
        // random = new Random(); -> Hatalı kullanım
    }

    public Profile(int age) {
        localtion = "Beşiktaş";
    }

    int minus( int a, int b ) {
        return a - b;
    }

    // final method
    // final method -> override edilmeye uygun değildir.
    final public void call(){
        System.out.println( "Final Call" );
    }

}
