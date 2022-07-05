package appPack;

public class MainLoop {
    public static void main(String[] args) {

        String[] arr = { "İstanbul", "İzmir", "Bursa", "Samsun", "Urfa" };
        // Loop
        // for, foreach - while - do-while

        // for
        // for(;;) { }
        for ( int i = 0; i<10; i++ ) {
            System.out.println("for loop call");
        }
        //

        for ( int i = 0; i<arr.length; i++ ) {
            String item = arr[i];

            //break;
            //continue; -> ilgili adımı atla, kaldığın yerden devam et.
            if ( i == 1 ) {
                continue;
            }

            if ( i == 3 ) {
                break;
            }

            System.out.println( item );
        }

        // foreach
        System.out.println("===================");
        for( String item : arr ) {
            System.out.println( item );
        }

        // while
        // iterasyon elemanlarını tüketmek için kullanılır.
        System.out.println("===================");
        int number = 5;
        while ( number < 10 ) {
            System.out.println("while call");
            number++;
        }

        // do - while
        // şart sağlanmasa bile en az bir kez çalışan döngü çeşididir.
        System.out.println("===================");
        int count = 3;
        boolean kosul = count < 7;
        do {
            System.out.println("do call : " + count);
            count++;
        }while ( kosul );


    }
}
