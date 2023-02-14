package day2;

public class Game {
  private final GameScore score;

  public Game(String choices, boolean firstPart) {
    if(firstPart) {
      this.score = new ScoresPartOne(choices);
    } else {
      this.score = new ScoresPartTwo(choices);
    }
  }

  public int getScore() {
    return this.score.scoreForOwnChoice() + this.score.scoreForResult();
  }
}
