package useinterface;

public class CustomerImpl implements ICustomer, IProfile {

    @Override
    public String customerName(int customerid) {
        if ( customerid == 10 )
            return "Zehra Bilki";
        else
            return "Ayşe Bilirler";
    }

    @Override
    public boolean customerLoginStatus(int customerid) {
        if ( customerid == 10 )
            return true;
        else
            return false;
    }

    @Override
    public String customerRememberPassword(int customerid) {
        if ( customerid == 10 )
            return "12345";
        else
            return "54321";
    }

    public boolean customerLogout(int customerid) {
        return true;
    }

}
