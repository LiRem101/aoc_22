package day3;

import static day3.Day3.sumPriorities;

import junit.framework.TestCase;

public class Day3Test extends TestCase {

  public void testRucksackPriorityScores()
  {
    String rucksackContentsComplete = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw""";
    String[] rucksackContents = rucksackContentsComplete.split("\n");
    int result = sumPriorities(rucksackContents);
    assertEquals(157, result);
  }

}
