package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day7 {
  private static final int TOTAL_DISK_SPACE = 70000000;
  private static final int NEEDED_DISK_SPACE = 30000000;

  public static Directory getDirectoryStructure(String[] dirsAsString) {
    DirectoryCreator creator = new DirectoryCreator();
    for(String console : dirsAsString) {
      String[] c = console.split(" ");
      if(console.charAt(0) == '$') {
        creator.executeCommand(c);
      } else {
        creator.addNode(c);
      }
    }
    return creator.getRoot();
  }

  public static int countSmallDirs(String[] dirsAsString) {
    Directory root = getDirectoryStructure(dirsAsString);
    List<Directory> dirs = root.getDirs();
    return dirs.stream()
        .mapToInt(Directory::getSize)
        .filter(x -> x < 100000)
        .sum();
  }

  public static int getSpaceToBeFreed(Directory root) {
    int takenSpace = root.getSize();
    return NEEDED_DISK_SPACE - (TOTAL_DISK_SPACE - takenSpace);
  }

  public static int sizeOfSmallestToDelete(String[] dirsAsString) {
    Directory root = getDirectoryStructure(dirsAsString);
    int minSize = getSpaceToBeFreed(root);
    List<Directory> dirs = root.getDirs();
    return dirs.stream()
        .mapToInt(Directory::getSize)
        .filter(x -> x >= minSize)
        .min()
        .orElseThrow();
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day7Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(countSmallDirs(content));
    System.out.println(sizeOfSmallestToDelete(content));
  }

}
