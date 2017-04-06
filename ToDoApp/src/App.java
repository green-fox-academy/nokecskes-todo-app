import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Connor on 2017.04.06..
 */
public class App {

  public static void main(String[] args) {

    ArgumentHandler handler = new ArgumentHandler(args);
    ToDoList myToDoList = new ToDoList();

    if (handler.noArgument()) {
      handler.printUsage();
    }else if (handler.notValidArg()) {
      System.out.println("Unsupported argument");
      handler.printUsage();
    }





    if (handler.contains("a")) {
      myToDoList.append(args);
    }

    if (handler.contains("l")) {
      myToDoList.listTasks();
    }

    if (handler.contains("r")) {
      myToDoList.removeTask(args);
    }


  }
}



