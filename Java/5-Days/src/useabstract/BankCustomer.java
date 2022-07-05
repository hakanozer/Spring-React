package useabstract;

public abstract class BankCustomer {

    // abstract -> sınıflar abstract anahtar kelimesi almak zorundadır.
    // bu sınıflar altında gövdeli yada gövdesiz methodlar yazılabilir.
    // gövdesiz methodlarda abstract anahtar kelimesi almak zorundadır.

    abstract int customerNumber();

    public int total() {
        int cid = customerNumber();
        if ( cid == 10 )
            return 100000;
        else
            return 50;
    }

    public String name() {
        int cid = customerNumber();
        if ( cid == 10 )
            return "Zehra Bilsinler";
        else
            return "Kemal Bilirim";
    }

}
