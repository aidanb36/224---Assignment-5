import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Analyzer {

    List <Integer> items = new ArrayList<>();  //the original list
    List <Integer> M = new ArrayList<>();
    List <Integer> lengthOfList = new ArrayList<>();

    public int analyze(List<Integer> list){
        
        //add list values to items
        for(int i = 0; i < list.size(); ++i){
            items.add(list.get(i));
            M.add(0);
        }
        M.set(M.size() - 1, 0);

        for (Integer i : M) {
            opt(i); 
        }

        System.out.println(M);

        return Collections.max(M);
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
        int val = 0;
        if (M.get(i) > 0){

            return M.get(i);
        }
        else{
            
            for(int j = i + 1; j < items.size(); j++){

                if(i < j  & j <= M.size() - 1 & items.get(j) > items.get(i)){
                    val = 1 + opt(j);

                    M.set(i, val);
                    break;
                }
                else{
                    val = M.get(i);

                    M.set(i, val);
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
        List <Integer> unwindList = new ArrayList<>();

        for (Integer integer : M) {
            unwindList.add(M.get(integer));
            
        }

        return unwindList;

    }
}

