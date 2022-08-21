package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _254_FactorCombination {
    public static void main(String[] args) {

    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n<=3) return ans;
        ArrayList<Integer> factors = getfactors(n);
        helper(0,ans,new ArrayList<Integer>(), factors);
        ans.remove(0);
        for(List<Integer> l:ans){
            long temp = 1;
            for(int i: l) temp *= i;
            if(n/temp != 1) l.add((int) (n/temp));
        }

        return ans;
    }

    public void helper(int index, List<List<Integer>> ans, List<Integer> curr, ArrayList<Integer> factors){
        if(index == factors.size()){
            ans.add(curr);
            return;
        }

        helper(index+1,ans,curr,factors);
        curr.add(factors.get(index));
        helper(index+1,ans,curr,factors);
    }

     ArrayList<Integer> getfactors(int n){
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i=2;i< Math.sqrt(n);i++){
            if(n%i == 0){
                factors.add(i);
                if(i*i != n){
                    factors.add(n/i);
                }
            }
        }
        return factors;
    }


}
