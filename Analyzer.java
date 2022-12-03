import java.util.List;
import java.util.ArrayList;

class Analyzer {
    private int[] M;
    private List<Integer> items;
    
    // Analyze function fills in memoized array 
    public int analyze(List<Integer> list) {
      items = list;
      M = new int[list.size()];
      return opt(0);
    }
  
    // Uses reccurence relation to store the max value in M
    private int opt(int i) {
      if (i == items.size() - 1)
        return 1;
      if (M[i] != 0)
        return M[i];
      int max = 1;
      for (int j = i + 1; j < items.size(); j++) {
        if (items.get(j) > items.get(i)) {
          int temp = 1 + opt(j);
          if (temp > max)
            max = temp;
        }
      }
      M[i] = max;
      return max;
    }
  
    private List<Integer> traceback(int i) {
      List<Integer> result = new ArrayList<Integer>();
      result.add(items.get(i));
      int max = M[i];
      for (int j = i + 1; j < items.size(); j++) {
        if (items.get(j) > items.get(i) && M[j] == max - 1) {
          result.add(items.get(j));
          max--;
        }
      }
      return result;
    }
}