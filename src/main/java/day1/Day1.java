package day1;

import static java.util.Collections.sort;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

  private static ArrayList<Elf> elvesOutOfCalories(String[] calories) {
    ArrayList<Integer> calosNumeric = new ArrayList<>();
    ArrayList<Elf> elves = new ArrayList<>();
    for(String c : calories) {
      if(!"".equals(c)) {
        calosNumeric.add(Integer.parseInt(c));
      } else {
        elves.add(new Elf(calosNumeric));
        calosNumeric.clear();
      }
    }
    elves.add(new Elf(calosNumeric));
    return elves;
  }

  private static ArrayList<Elf> getSortedElves(String calories) {
    String[] caloArray = calories.split("\n");
    ArrayList<Elf> elves = elvesOutOfCalories(caloArray);
    elves.sort(new ElfTotalCaloriesComparator());
    return elves;
  }

  public static int mostCalories(String calories) {
    ArrayList<Elf> elves = getSortedElves(calories);

    return elves.get(0).getTotalCalories();
  }

  public static int mostCaloriesOfThree(String calories) {
    ArrayList<Elf> elves = getSortedElves(calories);
    return elves.stream()
        .limit(3)
        .mapToInt(Elf::getTotalCalories)
        .reduce(0, Integer::sum);
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day1Input1");
    String content = Files.readString(path);
    System.out.println(mostCalories(content));
    System.out.println(mostCaloriesOfThree(content));
  }
}
