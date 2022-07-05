package useinterface;

public class MainInterface {
    public static void main(String[] args) {

        CustomerImpl customer = new CustomerImpl();
        String name = customer.customerName(10);
        boolean status = customer.customerLoginStatus(10);
        String password = customer.customerRememberPassword(10);
        System.out.println( name + " " + status + " " + password );

        ICustomer customer1 = new CustomerImpl();
        IProfile customer2 = new CustomerImpl();

    }
}
