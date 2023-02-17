package day7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Directory implements Node {
  private final String name;
  private final HashSet<Node> nodes = new HashSet<>();

  public Directory(String name) {
    this.name = name;
  }

  public void addNode(Node newNode) {
    nodes.add(newNode);
  }

  @Override
  public int getSize() {
    return nodes.stream()
        .mapToInt(Node::getSize)
        .sum();
  }

  public List<Directory> getDirs() {
    List<Directory> dirs = nodes.stream()
        .filter(x -> x instanceof Directory)
        .map(x -> (Directory) x)
        .flatMap(x -> x.getDirs().stream())
        .collect(Collectors.toList());
    dirs.add(this);
    return dirs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Directory directory = (Directory) o;
    return name.equals(directory.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
