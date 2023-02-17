package day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Directory implements Node {
  private final String name;

  public Directory(String name) {
    this.name = name;
  }

  @Override
  public int getSize() {
    throw new UnsupportedOperationException("getSize() of Directory needs to be implemented yet.");
  }

  public ArrayList<Directory> getDirs() {
    throw new UnsupportedOperationException("getSize() of Directory needs to be implemented yet.");
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
