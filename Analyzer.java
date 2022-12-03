import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Analyzer {

    List <Integer> items;  //the original list

    public int analyze(List<Integer> list){
        
        //add list values to items
        for(int i : list){
            items.add(i);
        }
    }
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
    private int opt(int i){
        List <Integer> M;
        if (M.get(i) >0){
            return M.get(i);
        }

        else{
            int val = 1;
            for(int j = i + 1; j < items.size(); j++){
                if(items.get(j) > items.get(i)){
                    int max = 0;
                    for(int a = 0; a < items.size(); a++){
                        max = Math.max(max, opt(a));
                        return max;
                    }
                    M.get(i) = val;
                }
            }
        }
    }

    private List<Integer> traceback(int i){
        /*
         * res = {si}
         * let j>i be the smallest index for which M[i] = 1 + M[j]
         * append traceback(j) to res
         * return res
         */

    }
}

