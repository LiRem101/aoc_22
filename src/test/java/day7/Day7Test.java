package day7;

import static day7.Day7.getDirectoryStructure;


import java.util.ArrayList;
import java.util.HashSet;
import junit.framework.TestCase;

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
    ArrayList<Directory> dirs = result.getDirs();
    assertEquals(4, dirs.size());
  }

}
