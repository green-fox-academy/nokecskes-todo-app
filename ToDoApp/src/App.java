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

    if (handler.noArgument()) {
      handler.printUsage();
    } else if (!handler.validArg() || !handler.validLength()) {
      System.out.println("Unsupported argument");
      handler.printUsage();
    } else {
      ToDoList myToDoList = new ToDoList(args);
      myToDoList.handleList();
    }
  }
}



