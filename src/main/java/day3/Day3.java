package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {

  private static String[] createArrayFirstPart(String content) {
    int length = content.length();
    String[] cont = new String[2];
    cont[0] = content.substring(0, length / 2);
    cont[1] = content.substring(length / 2, length);
    return cont;
  }

  public static int sumPriorities(String[] rucksackContents, boolean first) {
    ArrayList<StringContainer> container = new ArrayList<>();
    if(first) {
      for (String contents : rucksackContents) {
        container.add(new StringContainer(createArrayFirstPart(contents)));
      }
    } else {
      for(int i = 0; i < rucksackContents.length; i += 3) {
        container.add(new StringContainer(Arrays.copyOfRange(rucksackContents, i, i + 3)));
      }
    }
    return container.stream()
        .mapToInt(StringContainer::getPriorityScore)
        .reduce(0, Integer::sum);
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day3Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(sumPriorities(content, true));
    System.out.println(sumPriorities(content, false));
  }
}
