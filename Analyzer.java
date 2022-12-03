//Aidan Brown & Aiden McCormack

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Analyzer {
    private int[] M;
    private List<Integer> items;
  
    //fills in the memoized array M, calls opt
    public int analyze(List<Integer> list) {
      items = list;
      M = new int[list.size()];
      return opt(0);
    }

    /**
     *  Uses reccurence relation to store the max value in M
     *  j is i + 1 for all j less than item size
     *  if j is greater than i, call opt(j) + 1 and assign it to temp
     *  Add the max to the memoized array and return the max
     * */
    private int opt(int i) {

      //if M[i] > 0, return M[i]
      if (M[i] > 0) {
        return M[i];
      }
      else {
        int val = 1;
        int max = 0;

        //loop through items array
        //val = 1 + max opt(j), where i < j ≤ n − 1 and sj > si
        for (int j = i + 1; j < items.size(); j++) {
        
          //call opt recursion
          if (items.get(j) > items.get(i)) {
            int temp = opt(j);

            //derive max value
            if (temp > max) {
              max = temp;
            }
          }
        }
        val += max;
        M[i] = val;
        return val;
      }
    } // opt()

    //traceback unwinds the computation of M[0], shows subsequence
    private List<Integer> traceback(int i) {
      List<Integer> res = new ArrayList<Integer>();
      res.add(items.get(i));

      //let j > i be the the smallest index for which M[i] = 1 + M[j]
      int j = i + 1;
      while (j < items.size()) {
        if (M[i] == 1 + M[j]) {

          //append traceback(j) to res
          res.addAll(traceback(j));
          break;  //not sure if this is right
        }
        j++;
      }
      return res;
    } // traceback()
  }