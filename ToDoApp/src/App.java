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

    if (args.length == 0) {
      System.out.println("Java Todo application");
      System.out.println("=======================");
      System.out.println();
      System.out.println("Command line arguments:");
      System.out.println("\t-l\tLists all the tasks");
      System.out.println("\t-a\tAdds a new task");
      System.out.println("\t-r\tRemoves an task");
      System.out.println("\t-c\tCompletes an task");
    }

    if (args.length > 0 && args[0].startsWith("-") && args[0].contains("l")) {
      try {
        Path myListPath = Paths.get("mylist.txt");
        List<String> lines = Files.readAllLines(myListPath);
        for (int i = 0; i < lines.size(); i++) {
          System.out.println((i + 1) + " - " + lines.get(i));
        }
      } catch(Exception e){
      System.out.println("error");
    }


  }



    /*When the application is ran with -l argument
    Then it should print the tasks that are stored in the file
    And it should add numbers before each*/

}
}


