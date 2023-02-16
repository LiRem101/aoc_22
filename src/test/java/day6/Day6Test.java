package day6;

import static day6.Day6.firstMarker;


import junit.framework.TestCase;

public class Day6Test extends TestCase {

  public void testFindMarkerCharacterFour()
  {
    assertEquals(7, firstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 4));
    assertEquals(5, firstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 4));
    assertEquals(6, firstMarker("nppdvjthqldpwncqszvftbrmjlhg", 4));
    assertEquals(10, firstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4));
    assertEquals(11, firstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4));
  }

  public void testFindMarkerCharacterFourteen()
  {
    assertEquals(19, firstMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14));
    assertEquals(23, firstMarker("bvwbjplbgvbhsrlpgdmjqwftvncz", 14));
    assertEquals(23, firstMarker("nppdvjthqldpwncqszvftbrmjlhg", 14));
    assertEquals(29, firstMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14));
    assertEquals(26, firstMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14));
  }

}
