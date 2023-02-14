package day3;

import day2.Game;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

  public static int sumPriorities(String[] rucksackContents) {
    ArrayList<Rucksack> rucksacks = new ArrayList<>();
    for(String contents : rucksackContents) {
      rucksacks.add(new Rucksack(contents));
    }
    return rucksacks.stream()
        .mapToInt(Rucksack::getPriorityScore)
        .reduce(0, Integer::sum);
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day3Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(sumPriorities(content));
  }
}
