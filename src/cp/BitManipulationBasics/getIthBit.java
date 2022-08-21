package cp.BitManipulationBasics;

public class getIthBit {
    public static void main(String[] args) {
        System.out.println(GetIthBit(5,0));
    }

    static int GetIthBit(int a, int i){
        int mask = 1<<i;
        return (mask & a) >0 ? 1 : 0;
    }
}
