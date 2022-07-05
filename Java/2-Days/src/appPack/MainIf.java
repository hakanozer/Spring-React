package appPack;

public class MainIf {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 15;
        boolean status = false;

        // Mantıksal operatörler
        // >,<,>=,<=, !=, ==
        // logic operatörler
        // &&, ||

        // Mantıksal operatörler
        // javada kıyaslama yapabilmek için kullanılır.
        // geriye boolean türler döner
        status = num1 > num2; // false
        status = num1 < num2; // true
        status = num1 >= num2; // false
        status = num1 <= num2; // true
        status = num1 != num2; // true
        status = num1 == num2; // false

        // one line if
        // ?, :
        // ? -> şart sağlandığında yapılacak iş
        // : -> şart sağlanmadığında yapılacak iş
        String data = num1 > num2 ? "Büyük" : "Küçük";
        System.out.println( status );
        System.out.println( data );


        // logic
        // && -> solda bulunan şart ile sağda bulunan şart doğru ise
        status = num1 > num2 && num1 > 1; // false
        status = num1 > num2 || num1 > 1; // true
        status = (num1 > 9 && num2 < num1) || (num1 > num2 && num2 > 15); // true
        System.out.println( "End :" +  status );

        if ( num1 > 10 ) {
            System.out.println("Koşul Sağlandı");
        }else {
            System.out.println("Koşul Sağlanmadı!");
        }

        // else - if
        String name = "Ali";
        String surname = "";
        String email = "";

        if ( name.equals("") ) {
            System.out.println("Name Empty");
        }else if ( surname.equals("") ) {
            System.out.println("Surname Empty");
        }else if ( email.equals("") ) {
            System.out.println("Email Empty");
        }else {
            System.out.println("Form Gönderiliyor...");
        }
        // şartlardan bir tanesini sağladığında bu line çalışır


        // Swich
        String menu = "about";
        switch ( menu ) {
            case "home":
                System.out.println("Menu Home");
                break;
            case "about":
                System.out.println("Menu About");
                break;
            case "contact":
                System.out.println("Menu Contact");
                break;
            default:
                System.out.println("Menu Home");
        }
        // koşullardan bir tanesini bulduğunda bu linedan itibaren çalışır.


    }
}
