package appPack;

public class MainApp {
    public static void main(String[] args) {

        // istisna
        // try - catch
        // database.open();
        try {
            // hata olma olasılığı olan kod parçalarının yazıldığı bölüm
            System.out.println("This line call - 1");
            int end = 1 / 1;
            String stNumber = "ali";
            int cNumber = Integer.parseInt(stNumber);
            int sum = cNumber + 50;
            System.out.println( sum );
            System.out.println("This line call - 2");
            // database.close(); tavsiye edimeyen kod bölümü
        }catch (Exception ex) {
            // hata olduğunda çalışacak bölüm
            System.err.println("main error : " + ex);

            // throw new
            // uygulamada kendi hatamızı istediğimiz bir kod parçasında fırmatmak için kullanılır.
            // bu ifadeden sonra hiç bir kod bloğu çalışmaz.
            // throw new RuntimeException("Runtime Message");
        }finally {
            // hata olsun yada olmasın çalışacak bölüm
            // database.close(); // tavsiye bölüm
        }
        System.out.println("This line call - 3");

        Settings settings = new Settings();
        try {
            settings.sum("a40", "70");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("This line call - 4");

    }
}
