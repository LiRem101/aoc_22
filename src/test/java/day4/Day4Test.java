package day4;

import static day4.Day4.countContainments;
import static day4.Day4.countOverlaps;


import junit.framework.TestCase;

public class Day4Test extends TestCase {

  public void testPairContain()
  {
    String contentsComplete = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8""";
    String[] contents = contentsComplete.split("\n");
    int result = countContainments(contents);
    assertEquals(2, result);
  }

  public void testPairOverlap()
  {
    String contentsComplete = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8""";
    String[] contents = contentsComplete.split("\n");
    int result = countOverlaps(contents);
    assertEquals(4, result);
  }

}
