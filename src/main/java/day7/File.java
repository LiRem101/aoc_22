package day7;

import java.util.Objects;

public record File(int size, String name) implements Node {
  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    File file = (File) o;
    return name.equals(file.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
