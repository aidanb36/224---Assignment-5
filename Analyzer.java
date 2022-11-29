import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Analyzer {

    List<Integer> items;  //the original list
    int[] M;      //M

    public int analyze(List<Integer> list){
        
        //add list values to items
        for(int i : list){
            items.add(i);
        }
    }

    private int opt(int i){
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
        if(M[i] > 0){
            return M[i];
        } 

        else{
            int val = 1 + opt(j);
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
