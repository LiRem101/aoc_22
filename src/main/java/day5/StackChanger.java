package day5;

import java.util.Stack;

public class StackChanger {
  private Stack<Character>[] stacks;

  public StackChanger(Stack<Character>[] stacks) {
    this.stacks = stacks;
  }

  public void moveStack(String change) {
    String[] changes = change.split(" ");
    int numberOfSwitches = Integer.parseInt(changes[1]);
    int fromStack = Integer.parseInt(changes[3]);
    int toStack = Integer.parseInt(changes[5]);

    for(int i = 0; i < numberOfSwitches; i++) {
      char a = stacks[fromStack-1].pop();
      stacks[toStack-1].push(a);
    }
  }

  public String topMessage() {
    StringBuilder msg = new StringBuilder();
    for (Stack<Character> stack : this.stacks) {
      msg.append(stack.peek());
    }
    return msg.toString();
  }
}
