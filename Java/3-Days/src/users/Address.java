package users;

public class Address {

    // public -> Üretilen özelliğin tüm uygulama görünmesini sağlar.
    public int num1 = 100;

    // protected (Default) -> kendi paketi içerisindeki sınıflardan görümmeyi sağlar.
    protected int num2 = 500;

    // private -> sadece kendi sınıfı içerisinde görünme.
    private int num3 = 200;

    public Address() {
        System.out.println( num3 );
    }

    public String fncName() {
        return "Mehmet Bilsin";
    }

}
