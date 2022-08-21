package cp.BitManipulationBasics;

public class bitManipulationBasics {
    public static void main(String[] args) {
        // not operator
        int a = 0;
        a = ~a;
        System.out.println(a);

        // binary left shift
            // basically **2n
        int b = 1;
        b <<= 3;
        System.out.println(b);

        // binary right shift
            // basically /= 2**n
        int c = 8;
        c >>= 3;
        System.out.println(c);


    }
}
