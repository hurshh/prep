package leetcode;

public class _1061_LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("parker", "morris", "parser"));
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU(26);

        for(int i=0;i<s1.length();i++){
            int var1 = s1.charAt(i)-96;
            int var2 = s2.charAt(i)-96;

            dsu.merge(Math.max(dsu.find(var1), dsu.find(var2)), Math.min(dsu.find(var1), dsu.find(var2)));
        }

        StringBuilder res= new StringBuilder();

        for(int i=0;i<baseStr.length();i++){
            char temp = (char) ((char) 96+ dsu.find(baseStr.charAt(i) - 96));
            res.append(temp);
        }

        return res.toString();
    }
}
