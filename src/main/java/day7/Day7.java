package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

public class Day7 {
  public static Directory getDirectoryStructure(String[] dirsAsString) {
    return null;
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day7Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
  }

}
