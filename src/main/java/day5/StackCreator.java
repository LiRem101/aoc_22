package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackCreator {
  private final Stack<Character>[] stacks;

  private void fillStack(String[] stackStrings, int length, int numberOfStacks) {
    for(int i = 0; i < numberOfStacks; i++) {
      this.stacks[i] = new Stack<>();
      for(int j = length - 2; j >= 0; j--) {
        char content = stackStrings[j].charAt(1 + i * 4);
        if(content != ' ') {
          this.stacks[i].push(content);
        }
      }
    }
  }

  public StackCreator(String[] stackStrings) {
    int length = stackStrings.length;
    String[] stackNumbers = stackStrings[length-1].split(" ");
    int numberOfStacks = Integer.parseInt(stackNumbers[stackNumbers.length-1]);
    this.stacks = new Stack[numberOfStacks];
    fillStack(stackStrings, length, numberOfStacks);
  }

  public Stack<Character>[] getStacks() {
    return this.stacks;
  }

}
