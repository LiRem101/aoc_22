package day2;

import static day2.Day2.totalScores;

import junit.framework.TestCase;

public class Day2Test extends TestCase {

  public void testGameScores()
  {
    String gamesComplete = """
        A Y
        B X
        C Z""";
    String[] games = gamesComplete.split("\n");
    int result = totalScores(games);
    assertEquals(15, result);
  }

}
