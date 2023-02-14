package day2;

public class Game {
  private final char opponentChoice;
  private final char myChoice;

  public Game(String choices) {
    this.opponentChoice = choices.charAt(0);
    this.myChoice = choices.charAt(2);
  }

  private int scoreForOwnChoice() {
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

  private int scoreForResult() {
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

  public int getScore() {
    return scoreForOwnChoice() + scoreForResult();
  }
}
