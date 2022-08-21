package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _737_SentenceSimilarity2 {
    public static void main(String[] args) {
    }

    public static boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;

        StringDSU dsu = new StringDSU();

        for(List<String> similar : similarPairs){
            dsu.merge(similar.get(0), similar.get(1));
        }

        for(int i=0;i< sentence1.length;i++){
            if(dsu.find(sentence1[i]) != dsu.find(sentence2[i])) return false;
        }

        return true;
    }

}

class StringDSU{
    public HashMap<String, String> dsu = new HashMap<>();

    public String find(String str){
        if(!dsu.containsKey(str)) dsu.put(str,str);
        return dsu.get(str) == str ? str : (find(dsu.get(str)));
    }

    public void merge(String a, String b){
        if(!dsu.containsKey(a)) dsu.put(a,a);
        if(!dsu.containsKey(b)) dsu.put(b,b);

        String pa = find(a);
        String pb = find(b);
        dsu.put(pa, pb);
    }
}
