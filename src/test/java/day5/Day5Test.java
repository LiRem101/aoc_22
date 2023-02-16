package day5;

import static day5.Day5.findEmptyLine;
import static day5.Day5.stackTopAfterRearrangement;


import java.util.Stack;
import junit.framework.TestCase;

public class Day5Test extends TestCase {

  public void testFindEmptyLine()
  {
    String contentsComplete = """
            [D]   \s
        [N] [C]   \s
        [Z] [M] [P]
         1   2   3\s
                
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
        """;
    String[] contents = contentsComplete.split("\n");
    int result = findEmptyLine(contents);
    assertEquals(4, result);
  }

  public void testCreateStacks()
  {
    String contentsComplete = """
            [D]   \s
        [N] [C]   \s
        [Z] [M] [P]
         1   2   3\s
        """;
    String[] contents = contentsComplete.split("\n");
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    Stack<Character> stack3 = new Stack<>();
    stack1.push('Z');
    stack1.push('N');
    stack2.push('M');
    stack2.push('C');
    stack2.push('D');
    stack3.push('P');
    StackCreator sc = new StackCreator(contents);
    Stack<Character>[] result = sc.getStacks();
    assertEquals(stack1, result[0]);
    assertEquals(stack2, result[1]);
    assertEquals(stack3, result[2]);
  }

  public void testChangeStacks()
  {
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    Stack<Character> stack3 = new Stack<>();
    stack1.push('Z');
    stack1.push('N');
    stack2.push('M');
    stack2.push('C');
    stack2.push('D');
    stack3.push('P');
    Stack<Character>[] stacks = new Stack[] {stack1, stack2, stack3};
    StackChanger changer = new StackChanger(stacks);
    changer.moveStack("move 1 from 2 to 1");
    changer.moveStack("move 3 from 1 to 3");
    changer.moveStack("move 2 from 2 to 1");
    changer.moveStack("move 1 from 1 to 2");

    assertEquals(changer.topMessage(), "CMZ");
  }

  public void testFindTopMessage()
  {
    String contentsComplete = """
            [D]   \s
        [N] [C]   \s
        [Z] [M] [P]
         1   2   3\s
                
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
        """;
    String[] contents = contentsComplete.split("\n");
    String result = stackTopAfterRearrangement(contents);
    assertEquals("CMZ", result);
  }

}
