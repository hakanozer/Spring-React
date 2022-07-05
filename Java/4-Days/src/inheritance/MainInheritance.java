package inheritance;

public class MainInheritance {

    public static void main(String[] args) {

        A bA = new A();
        B bB = new B();
        C bC = new C();

        call(bA);
        call(bB);
        call(bC);

    }

    public static void call( Base base ) {
        if ( base instanceof A ){
            A castA = (A) base;
            castA.aCall();
        }
        if ( base instanceof B ) {

        }
        base.read();
    }


}
