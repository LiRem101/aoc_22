package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

  private static int[] divideInput(String input) {
    String[] inputAsString = input.split("[,-]");
    return Arrays.stream(inputAsString)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public static int countContainments(String[] stringPairs) {
    List<int[]> contents = Arrays.stream(stringPairs)
        .map(Day4::divideInput)
        .toList();
    ArrayList<AssignmentPairs> pairs = new ArrayList<>();
    for(int[] c : contents) {
      pairs.add(new AssignmentPairs(c));
    }
    return pairs.stream()
        .mapToInt(AssignmentPairs::howManyContain)
        .reduce(0, Integer::sum);
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day4Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(countContainments(content));
  }
}
