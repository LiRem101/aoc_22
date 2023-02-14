package day3;

import static day3.Day3.sumPriorities;

import junit.framework.TestCase;

public class Day3Test extends TestCase {

  public void testRucksackPriorityScoresOne()
  {
    String rucksackContentsComplete = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw""";
    String[] rucksackContents = rucksackContentsComplete.split("\n");
    int result = sumPriorities(rucksackContents, true);
    assertEquals(157, result);
  }

  public void testRucksackPriorityScoresSecond()
  {
    String rucksackContentsComplete = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw""";
    String[] rucksackContents = rucksackContentsComplete.split("\n");
    int result = sumPriorities(rucksackContents, false);
    assertEquals(70, result);
  }

}
