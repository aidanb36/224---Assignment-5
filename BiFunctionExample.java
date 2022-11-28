// jdh CS224 Fall 2022

import java.util.function.BiFunction;

public class BiFunctionExample {
  public static void main(String argv[]) {
    BiFunction <String, String, Boolean> streq = (s1, s2)  -> s1 == s2;

    String[] stringList = {"pearl", "heart", "flower"};
    boolean res = test(streq, "heart", stringList);
    System.out.println("result is " + res);
  }

  public static boolean test(BiFunction<String, String, Boolean> comparator, String s1, String[] stringList) {
    boolean returnVal = false;
    for (String s: stringList) {
      boolean rc = comparator.apply(s1, s);
      if (rc) {
        System.out.println("found a match: '" + s1 + "' and '" + s + "'");
        returnVal = true;
      }
    }
    return returnVal;
  }
}
