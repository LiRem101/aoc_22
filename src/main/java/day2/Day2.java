package day2;

import day1.Elf;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

  public static int totalScores(String[] gameChoices, boolean partOne) {
    ArrayList<Game> games = new ArrayList<>();
    for(String choices : gameChoices) {
      games.add(new Game(choices, partOne));
    }
    return games.stream()
        .mapToInt(Game::getScore)
        .reduce(0, Integer::sum);
  }

  public static void main(String[] args) throws IOException {
    Path path = Path.of("src/main/resources/day2Input1");
    List<String> contentList = Files.readAllLines(path);
    String[] content = contentList.toArray(new String[0]);
    System.out.println(totalScores(content, true));
    System.out.println(totalScores(content, false));
  }
}
