package day2;

import static day2.Day2.totalScores;

import junit.framework.TestCase;

public class Day2Test extends TestCase {

  public void testGameScoresOne()
  {
    String gamesComplete = """
        A Y
        B X
        C Z""";
    String[] games = gamesComplete.split("\n");
    int result = totalScores(games, true);
    assertEquals(15, result);
  }

  public void testGameScoresTwo()
  {
    String gamesComplete = """
        A Y
        B X
        C Z""";
    String[] games = gamesComplete.split("\n");
    int result = totalScores(games, false);
    assertEquals(12, result);
  }

}
