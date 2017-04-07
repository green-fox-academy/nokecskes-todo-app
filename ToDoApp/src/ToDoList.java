import com.sun.org.apache.xpath.internal.Arg;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 2017.04.06..
 */

public class ToDoList {

  String[] arguments;
  Path myListPath;
  List<String> lines;

  public ToDoList(String[] arguments) {
    this.arguments = arguments;
    try {
      myListPath = Paths.get("mylist.txt");
      lines = Files.readAllLines(myListPath);
    } catch (Exception e) {
      System.out.println("error");
    }
  }

  public void writeFile() {
    try {
      Files.write(myListPath, lines);
    } catch (Exception e) {
      System.out.println("error");
    }
  }

  public void handleList() {
    if (arguments[0].equals("-l")) {
      printTasks();
    } else if (arguments[0].equals("-a")) {
      append();
    } else if (arguments[0].equals("-r")) {
      removeTask();
    } else if(arguments[0].equals("-c")) {
      checkTask();
    }
  }

  public void printTasks() {
    if (lines.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      for (int i = 0; i < lines.size(); i++) {
        System.out.println((i + 1) + " - " + lines.get(i));
      }
    }
  }

  public void append() {
    if (arguments.length == 1) {
      System.out.println("Unable to add: no task provided");
    } else {
      arguments[1] = "[ ] " + arguments[1];
      lines.add(arguments[1]);
    }
    writeFile();
  }

  public void removeTask() {
    int toRemove = checkIndex("remove");
    if( toRemove >= 0) {
      lines.remove(toRemove);
      writeFile();
    }
  }

  public void checkTask() {
    int toCheck = checkIndex("check");
    if (toCheck >= 0) {
      String taskToCheck = lines.get(toCheck).substring(3);
      lines.remove(toCheck);
      lines.add(toCheck, "[X]" + taskToCheck);
      writeFile();
    }
  }

  public int checkIndex (String task) {
    int toHandle= 0;

    if (arguments.length == 1) {
      System.out.println("Unable to " + task + ": no index provided");
      return -1;
    }

    try {
      toHandle = Integer.parseInt(arguments[1]) - 1;
    } catch (NumberFormatException e) {
      System.out.println("Unable to " + task + ": index is not a number");
      return -1;
    }

    if (toHandle > lines.size()) {
      System.out.println("Unable to " + task + ": index is out of bound");
      return -1;
    }

    return toHandle;
  }


}

