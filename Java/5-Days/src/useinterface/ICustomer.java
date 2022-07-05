package useinterface;

public interface ICustomer {

    // yazılımda belli bir mimari yapıyı kurmak için kullanılır.
    // Nesnelerin daha iyi ve ihtiyaca göre yönetilmesini sağlar.
    // Kurallar
        // Gövdesiz methodlar yazılır.
        // Nesne olarak kullanılmaz
        // Interfaceler altında üretilen methodlar override edildiğinde default "public" olurlar.

    String customerName( int customerid );
    boolean customerLoginStatus( int customerid );


}
