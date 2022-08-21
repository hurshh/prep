package cp.BitManipulationBasics;

public class clearLastBits {
    public static void main(String[] args) {
        System.out.println(ClearLastBits(6,2));
    }

    static int ClearLastBits(int a, int i){
        int mask = -(1 << i);
        return a&mask;
    }
}
