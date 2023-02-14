package day2;

public class ScoresPartTwo implements GameScore {
  private final char opponentChoice;
  private final char myChoice;

  public ScoresPartTwo(String choices) {
    this.opponentChoice = choices.charAt(0);
    this.myChoice = choices.charAt(2);
  }

  @Override
  public int scoreForOwnChoice() {
    if(myChoice == 'X' && opponentChoice == 'B' || myChoice == 'Y' && opponentChoice == 'A'
        || myChoice == 'Z' && opponentChoice == 'C') {
      return 1;
    }
    if(myChoice == 'X' && opponentChoice == 'C' || myChoice == 'Y' && opponentChoice == 'B'
        || myChoice == 'Z' && opponentChoice == 'A') {
      return 2;
    }
    return 3;
  }

  @Override
  public int scoreForResult() {
    switch (myChoice) {
      case 'X' -> {
        return 0;
      }
      case 'Y' -> {
        return 3;
      }
      case 'Z' -> {
        return 6;
      }
      default -> {
        throw new IllegalStateException("myChoice can only be X, Y or Z, but is " + this.myChoice);
      }
    }
  }
}
