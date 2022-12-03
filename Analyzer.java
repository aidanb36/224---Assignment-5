import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Analyzer {

    List <Integer> items;  //the original list
    List <Integer> M;

    public int analyze(List<Integer> list){
        /*
        * if M[i] > 0{
        *  return M[i]
        * } 
        * else{
        *  val = 1 + max opt(j), where i < j <= n - 1 and sj > si
        *  M[i] = val
        * return val
        * }
        */

        //add list values to items
        for (int i = 0; i < list.size(); i++) {
            items.add(list.get(i));
            M.add(1);
        }
        M.set(M.size() - 1, 1);

        for (int i = list.size() - 1; i > -1; i--) {
            opt(i);
        }

        // System.out.println(M);
        return Collections.max(M);
    }

    private int opt(int i){

        int val = 0;
        if (M.get(i) > 1){
            return M.get(i);
        }

        else{
            for(int j = i + 1; j < items.size(); j++){
                if(i < j & j <= M.size() - 1 & items.get(j) > items.get(i)){
                    val = opt(j) + 1;
                    M.set(i,val);
                    break;
                    // int max = 0;
                    // for(int a = 0; a < items.size(); a++){
                    //     max = Math.max(max, opt(a));
                    //     return max;
                }
                else{
                    val = M.get(i);
                    M.set(i,val);
                }   
            }
            return val;
        }
    }

    private List<Integer> traceback(int i){
        /*
         * res = {si}
         * let j>i be the smallest index for which M[i] = 1 + M[j]
         * append traceback(j) to res
         * return res
         */
        List<Integer> finals = new ArrayList<>();

        for (int j = 0; j < M.size(); j++) {
            finals.add(M.get(j));
        }
        return finals;

    }
}

