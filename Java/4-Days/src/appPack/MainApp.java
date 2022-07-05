package appPack;

public class MainApp {

    public static void main(String[] args) {

        // Static
        // Nesne üretimi olmadan bir sınıf içerisindeki özellikleri kullanma yeteneği sunar.
        // Erişim -> ClassName.(static anahtar kelimesi almış özellikle)
        // Nasıl davranır ?
        // Uygulama ayağa kalkmadan önce tüm static özellikler bellekte yer tutarak çalışmaya hazır hale gelir.
        Profile pro = new Profile();
        System.out.println( pro.name );
        Profile.age = 40;
        System.out.println( Profile.age );

       int sm = sumx(10, 20);
       System.out.println( "sm " + sm );

       MainApp mainApp = new MainApp();
       mainApp.minus(40, 34);

       Profile p1 = new Profile();
        System.out.println( p1.localtion );

    }

    public static int sumx( int a, int b ) {
        int sm = a + b;
        Profile pro = new Profile();
        return sm;
    }

    int minus( int a, int b ) {
        return a - b;
    }

}

