package inheritance;

public class A extends Base {

    @Override
    public void read() {
        number = 200;
        System.out.println("A Read Call " + number);
    }


    public void aCall() {
        System.out.println("aCall Call");
    }

}
