package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Day6 {

  public static int firstMarker(String msg, int lengthOfMarker) {
    ArrayBlockingQueue<Character> q = new ArrayBlockingQueue<>(lengthOfMarker);
    for(int i = 0; i < lengthOfMarker; i++) {
      q.add(msg.charAt(i));
    }

    for(int i = 4; i < msg.length(); i++) {
      Set<Character> s = new HashSet<>(q);
      if(s.size() == lengthOfMarker) {
        return i;
      }
      q.poll();
      q.add(msg.charAt(i));
    }
    return -1;
  }


  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day6Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(firstMarker(content[0], 4));
    System.out.println(firstMarker(content[0], 14));
  }
}