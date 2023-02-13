package day1;

import static day1.Day1.mostCalories;
import static day1.Day1.mostCaloriesOfThree;


import junit.framework.TestCase;

public class Day1Test extends TestCase {

  public void testMostCalories()
  {
    String calories = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000""";

    int result = mostCalories(calories);
    assertEquals(24000, result);
  }

  public void testMostCaloriesFirstThree()
  {
    String calories = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000""";

    int result = mostCaloriesOfThree(calories);
    assertEquals(45000, result);
  }

}
