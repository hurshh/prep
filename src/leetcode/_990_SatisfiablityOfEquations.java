package leetcode;

import java.util.Arrays;

public class _990_SatisfiablityOfEquations {
    public static void main(String[] args) {
        System.out.println(equationsPossible(new String[]{"b==a","a==b"}));
    }

    public static boolean equationsPossible(String[] equations) {
        Arrays.sort(equations, (a,b) -> b.charAt(1)-a.charAt(1));
        DSU dsu = new DSU(equations.length);
        boolean valid = true;

        for(String equation : equations){
            if((equation.charAt(0) == equation.charAt(3)) && (equation.charAt(1) == '!')){
                valid = false;
                break;
            }
            if(equation.charAt(1) == '='){
                int var1 = equation.charAt(0) - 96;
                int var2 = equation.charAt(3) - 96;

                dsu.merge(var1,var2);
            }
            else {
                int var1 = equation.charAt(0) - 96;
                int var2 = equation.charAt(3) - 96;

                if(dsu.find(var1) == dsu.find(var2)){
                    valid = false;
                    break;
                }
            }
        }

        return valid;
    }
}
