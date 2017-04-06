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



  public void listTasks() {
    try {
      Path myListPath = Paths.get("mylist.txt");
      List<String> lines = Files.readAllLines(myListPath);
      if (lines.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < lines.size(); i++) {
          System.out.println((i + 1) + " - " + lines.get(i));
        }
      }
    } catch (Exception e) {
      System.out.println("error");
    }
  }

  public void append(String[] arguments) {
    try {
      Path myListPath = Paths.get("mylist.txt");
      List<String> lines = Files.readAllLines(myListPath);
      if (arguments[arguments.length - 1].equals("-a")) {
        System.out.println("Unable to add: no task provided");
      } else {
        for (int i = 0; i < (arguments.length - 1); i++) {
          if (arguments[i].equals("-a")) {
            lines.add(arguments[i + 1]);
          }
        }
      }
      Files.write(myListPath, lines);
    } catch (Exception e) {
      System.out.println("error");
    }
  }

  public void removeTask(String[] arguments) {
    try {
      Path myListPath = Paths.get("mylist.txt");
      List<String> lines = Files.readAllLines(myListPath);
      /*if (arguments[arguments.length - 1].equals("-r")) {
        System.out.println("Unable to add: no task provided");
      } else {*/
        for (int i = 0; i < (arguments.length - 1); i++) {
          if (arguments[i].equals("-r")) {
            int toRemove = Integer.parseInt(arguments[i + 1]) - 1;
            lines.remove(toRemove);
          }
        }
      /*}*/


      Files.write(myListPath, lines);


    } catch (Exception e) {
      System.out.println("error");
    }
  }
}