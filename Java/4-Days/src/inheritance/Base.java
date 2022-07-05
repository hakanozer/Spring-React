package inheritance;

public class Base {

    int number = 100;

    public Base() {
        System.out.println("Base Call");
    }

    // override edilmeye uygun methodu tasarla
    public void read() {
        System.out.println("Base read Call");
    }

    public int sum( int a, int b ) {
        return  a + b;
    }

}
