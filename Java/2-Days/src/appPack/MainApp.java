package appPack;

public class MainApp {
    public static void main(String[] args) {

        // Dizi - Array
        String name = "Ali";
        // Tanımlama
        String[] arr = { "İstanbul", "İzmir", "Bursa", "Samsun", "Urfa" };

        String[] arrx = new String[5];
        arrx[0] = "İstanbul";
        arrx[1] = "İzmir";
        arrx[2] = "Bursa";
        arrx[3] = "Samsun";
        arrx[4] = "Urfa";

        // index -> dizideeki n. elemanla ilgili işlem yapmak için kullanılır.
        // index'ler 0 dan başlar.
        // arr[0] -> "İstanbul"
        System.out.println( arr[0] );
        //System.out.println( arr[5] );


        // dizi eleman sayısı (length)
        int count = arr.length;
        System.out.println( "Count : " +count );

        // son elemanı alma
        String endItem = arr[ count - 1 ];
        System.out.println( endItem );
    }
}
