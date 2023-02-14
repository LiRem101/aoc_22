package day2;

public class ScoresPartOne implements GameScore {
  private final char opponentChoice;
  private final char myChoice;

  public ScoresPartOne(String choices) {
    this.opponentChoice = choices.charAt(0);
    this.myChoice = choices.charAt(2);
  }

  @Override
  public int scoreForOwnChoice() {
    switch (myChoice) {
      case 'X' -> {
        return 1;
      }
      case 'Y' -> {
        return 2;
      }
      case 'Z' -> {
        return 3;
      }
      default -> {
        throw new IllegalStateException("myChoice can only be X, Y or Z, but is " + this.myChoice);
      }
    }
  }

  @Override
  public int scoreForResult() {
    if(myChoice == 'X' && opponentChoice == 'C' || myChoice == 'Y' && opponentChoice == 'A'
        || myChoice == 'Z' && opponentChoice == 'B') {
      return 6;
    }
    if(myChoice == 'X' && opponentChoice == 'A' || myChoice == 'Y' && opponentChoice == 'B'
        || myChoice == 'Z' && opponentChoice == 'C') {
      return 3;
    }
    return 0;
  }
}
