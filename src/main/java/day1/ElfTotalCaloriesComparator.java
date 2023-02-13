package day1;

import java.util.Comparator;

public class ElfTotalCaloriesComparator implements Comparator<Elf> {

  @Override
  public int compare(Elf e1, Elf e2) {
    return e2.getTotalCalories() - e1.getTotalCalories();
  }
}
