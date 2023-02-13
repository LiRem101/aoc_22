package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elf {
  private final List<Integer> calories;

  public Elf(List<Integer> calories) {
    this.calories = new ArrayList<>();
    this.calories.addAll(calories);
  }

  public int getTotalCalories() {
    return this.calories.stream()
        .reduce(0, Integer::sum);
  }

}
