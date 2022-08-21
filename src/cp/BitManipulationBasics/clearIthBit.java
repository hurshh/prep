package cp.BitManipulationBasics;

public class clearIthBit {
    public static void main(String[] args) {
        System.out.println(ClearIthBit(5,1));
    }

    static int ClearIthBit(int a, int i){
        int mask = ~(1<<i);
        return (a & mask);
    }
}
