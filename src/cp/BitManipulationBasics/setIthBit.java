package cp.BitManipulationBasics;

public class setIthBit {
    public static void main(String[] args) {
        System.out.println(SetIthBit(2,3 ));
    }

    static int SetIthBit (int a, int i){
        int mask = 1<<i;
        return (a|mask);
    }
}
