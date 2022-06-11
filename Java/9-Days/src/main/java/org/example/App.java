package org.example;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        UserService service = new UserService();
        boolean status = service.userLogin("erkan@mail.com", "54321");
        System.out.println("Login : " + status);

        List<User> ls = service.allUser();
        for ( User item : ls ) {
            System.out.println( item );
        }
    }
}
