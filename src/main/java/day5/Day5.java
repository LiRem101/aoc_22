package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day5 {

  public static int findEmptyLine(String[] stringInput) {
    for(int i = 0; i < stringInput.length; i++) {
      if(stringInput[i].equals("")) {
        return i;
      }
    }
    throw new IllegalArgumentException("Input has no empty line.");
  }

  public static String stackTopAfterRearrangement(String[] stringInput, boolean oneAtATime) {
    int emptyLine = findEmptyLine(stringInput);
    String[] startStackStrings = Arrays.copyOfRange(stringInput, 0, emptyLine);
    String[] stackProcedureStrings = Arrays.copyOfRange(stringInput, emptyLine + 1, stringInput.length);
    StackCreator creator = new StackCreator(startStackStrings);
    Stack<Character>[] startStacks = creator.getStacks();
    StackChanger changer = new StackChanger(startStacks);
    for(String procedure : stackProcedureStrings) {
      if(oneAtATime) {
        changer.moveStackOneATime(procedure);
      } else {
        changer.moveStackSeveralATime(procedure);
      }
    }
    return changer.topMessage();
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day5Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(stackTopAfterRearrangement(content, true));
    System.out.println(stackTopAfterRearrangement(content, false));
  }
}