package appPack;

public class TypeCast {
    public static void main(String[] args) {

        // String to int
        String stNumber = "30";
        String stBoolean = "true";
        int cNumber = Integer.parseInt(stNumber);
        short sNumber = Short.parseShort(stNumber);
        byte bNumber = Byte.parseByte(stNumber);
        boolean status = Boolean.parseBoolean(stBoolean);
        System.out.println( status );


        // int to String
        int num = 500;
        int num1 = 90;
        float f1 = 10.5f;
        String sNum = ""+(num+num1); // 590
        String sNum1 = String.valueOf(num);
        String fNum = ""+f1;
        System.out.println( sNum );


        // float to int
        float fNumber1 = 40.8f;
        float fNumber2 = 2.9f;
        float sum = fNumber1 + fNumber2;
        int sm = (int) sum;
        System.out.println( "Toplam : " + sm );

    }
}
