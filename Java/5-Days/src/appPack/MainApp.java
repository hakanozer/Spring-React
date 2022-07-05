package appPack;

import props.User;

public class MainApp {
    public static void main(String[] args) {


        User u1 = new User();
        u1.setName("Ali");
        u1.setSurname("Bilmem");
        u1.setAge(30);
        u1.setEmail("ali@mail.com");

        User u2 = new User("Erkan", "Bilsin", "erkan@mail.com", 33);

        System.out.println( u1 );
        System.out.println( u2 );
        System.out.println( u1.getEmail() );

    }
}
