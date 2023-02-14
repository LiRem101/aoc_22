package day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StringContainer {
  private final ArrayList<Set<Character>> characters;

  public StringContainer(String[] content) {
    this.characters = new ArrayList<>();
    for(String s : content) {
      this.characters.add(s.chars()
          .mapToObj(c -> (char) c)
          .collect(Collectors.toSet()));
    }
  }

  private char findIntersection() {
    Set<Character> intersect = new HashSet<>(this.characters.get(0));
    for(int i = 1; i < characters.size(); i++) {
      intersect.retainAll(this.characters.get(i));
    }
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
