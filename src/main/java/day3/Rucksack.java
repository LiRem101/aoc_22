package day3;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Rucksack {
  private final Set<Character> firstCompartment;
  private final Set<Character> secondCompartment;

  public Rucksack(String content) {
    int length = content.length();
    String first = content.substring(0, length / 2);
    String second = content.substring(length / 2, length);
    this.firstCompartment = first.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());
    this.secondCompartment = second.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());
  }

  private char findIntersection() {
    Set<Character> intersect = new HashSet<>(firstCompartment);
    intersect.retainAll(secondCompartment);
    return (char) intersect.toArray()[0];
  }

  public int getPriorityScore() {
    char intersect = findIntersection();
    if(Character.isUpperCase(intersect)) {
      return (int) intersect - (int) 'A' + 27;
    } else {
      return (int) intersect - (int) 'a' + 1;
    }
  }

}
