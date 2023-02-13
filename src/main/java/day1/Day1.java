package day1;

import static java.util.Collections.sort;


import java.util.ArrayList;
import java.util.Arrays;

public class Day1 {

  public static int mostCalories(String calories) {
    ArrayList<Integer> calosNumeric = new ArrayList<>();
    ArrayList<Elf> elves = new ArrayList<>();
    for(String c : calories.split("\n")) {
      if(!"".equals(c)) {
        calosNumeric.add(Integer.parseInt(c));
      } else {
        elves.add(new Elf(calosNumeric));
        calosNumeric.clear();
      }
    }
    elves.add(new Elf(calosNumeric));
    elves.sort(new ElfTotalCaloriesComparator());

    return elves.get(0).getTotalCalories();
  }

  public static void main(String[] args) {

  }
}
