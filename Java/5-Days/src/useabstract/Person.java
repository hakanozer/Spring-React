package useabstract;

public class Person extends BankCustomer {

    final private int customerID;
    public Person(int customerID) {
        this.customerID = customerID;
    }

    @Override
    int customerNumber() {
        return customerID;
    }


}
