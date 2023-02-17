package day7;

import static day7.Day7.countSmallDirs;
import static day7.Day7.getDirectoryStructure;
import static day7.Day7.getSpaceToBeFreed;
import static day7.Day7.sizeOfSmallestToDelete;


import java.util.List;
import junit.framework.TestCase;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class Day7Test extends TestCase {

  public void testCreateDirectoryStructure()
  {
    String contentsComplete = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
        """;
    String[] contents = contentsComplete.split("\n");
    Directory result = getDirectoryStructure(contents);
    List<Directory> dirs = result.getDirs();
    assertEquals(4, dirs.size());
    assertEquals(48381165, result.getSize());
  }

  public void testCountSmallDirs()
  {
    String contentsComplete = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
        """;
    String[] contents = contentsComplete.split("\n");
    int result = countSmallDirs(contents);
    assertEquals(95437, result);
  }

  public void testHowMuchSpaceNeeded() {
    MockitoAnnotations.openMocks(this);
    Directory mockRoot = Mockito.mock(Directory.class);
    Mockito.when(mockRoot.getSize()).thenReturn(48381165);
    int result = getSpaceToBeFreed(mockRoot);
    assertEquals(8381165, result);
  }

  public void testSmallestDirToDelete()
  {
    String contentsComplete = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
        """;
    String[] contents = contentsComplete.split("\n");
    int result = sizeOfSmallestToDelete(contents);
    assertEquals(24933642, result);
  }

}
