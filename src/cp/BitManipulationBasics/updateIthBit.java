package cp.BitManipulationBasics;

public class updateIthBit {
    public static void main(String[] args) {
        System.out.println(UpdateIthBit(13,2,0));
    }

    static int UpdateIthBit(int a, int i, int val){
        int mask = ~(1<<i);
        a = a&mask;

        if(val>0){
            a = a|(1<<i);
        }

        return a;
    }
}
