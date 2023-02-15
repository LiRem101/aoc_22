package day4;

public class AssignmentPairs {
  private final int startFirst;
  private final int endFirst;
  private final int startSecond;
  private final int endSecond;

  public AssignmentPairs(int[] sections) {
    this.startFirst = sections[0];
    this.endFirst = sections[1];
    this.startSecond = sections[2];
    this.endSecond = sections[3];
  }

  private boolean fullyContain() {
    return startFirst >= startSecond && endFirst <= endSecond || startFirst <= startSecond && endFirst >= endSecond;
  }

  private boolean overlap() {
    return startFirst <= startSecond && startSecond <= endFirst || startSecond <= startFirst && startFirst <= endSecond;
  }

  public int howManyContain() {
    if(fullyContain()) {
      return 1;
    } else {
      return 0;
    }
  }

  public int howManyOverlap() {
    if(overlap()) {
      return 1;
    } else {
      return 0;
    }
  }

}
