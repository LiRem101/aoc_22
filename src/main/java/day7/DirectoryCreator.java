package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DirectoryCreator {
  private final Stack<Directory> path = new Stack<>();
  private final Directory root = new Directory("/");

  public DirectoryCreator() {
    this.path.push(this.root);
  }

  public void executeCommand(String[] cmd) {
    if(cmd[1].equals("cd")) {
      if(cmd[2].equals("/")) {
        while(!this.path.empty()) {
          this.path.pop();
        }
        this.path.push(this.root);
      } else if(cmd[2].equals("..")) {
        if(!this.path.empty()) {
          this.path.pop();
        }
      } else {
        String dirName = cmd[2];
        Directory dummy = new Directory(dirName);
        List<Directory> dirs = this.path.peek().getDirs();
        int posOfDir = dirs.indexOf(dummy);
        this.path.push(dirs.get(posOfDir));
      }
    }
  }

  public void addNode(String[] node) {
    Node newNode;
    if(node[0].equals("dir")) {
      newNode = new Directory(node[1]);
    } else {
      int size = Integer.parseInt(node[0]);
      newNode = new File(size, node[1]);
    }
    this.path.peek().addNode(newNode);
  }

  public Directory getRoot() {
    return this.root;
  }

}
