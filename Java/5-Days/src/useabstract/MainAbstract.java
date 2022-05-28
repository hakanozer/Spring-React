package useabstract;

public class MainAbstract {
    public static void main(String[] args) {

        Person person = new Person(11);
        System.out.println( person.name() + " " + person.total() );

        // Abstract Sınıflar nesne halinde kullanılabilir.
        BankCustomer customer = new BankCustomer() {
            @Override
            int customerNumber() {
                return 10;
            }
        };
        System.out.println( customer.name() + " " + customer.total() );

    }
}
