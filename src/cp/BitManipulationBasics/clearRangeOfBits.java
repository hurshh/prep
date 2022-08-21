package cp.BitManipulationBasics;

public class clearRangeOfBits {
    public static void main(String[] args) {
        System.out.println(ClearRangeOfBits(31,1,3));
    }

    static int ClearRangeOfBits(int a, int start,int end){
        int diff = end-start;
        int mask = -(1 << diff+1);
        mask = ~mask;
        mask <<= start;
        mask = ~mask;
        return a&mask;
    }
}
