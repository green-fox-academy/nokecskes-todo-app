import com.sun.org.apache.xpath.internal.Arg;

/**
 * Created by Connor on 2017.04.06..
 */
public class ArgumentHandler {

  String[] arguments;

  public ArgumentHandler(String[] arguments) {
    this.arguments = arguments;
  }

  public boolean noArgument() {
    if (arguments.length == 0) {
      return true;
    }
    return false;
  }

  public boolean validLength() {
    if (arguments.length == 1 || arguments.length == 2) {
      return true;
    }
    return false;
  }

  public boolean validArg() {
    if (arguments[0].equals("-l") || arguments[0].equals("-a") || arguments[0].equals("-r")
            || arguments[0].equals("-c")) {
      return true;
    }
    return false;
  }

  public void printUsage() {
    System.out.println("Java Todo application");
    System.out.println("=======================");
    System.out.println();
    System.out.println("Command line arguments:");
    System.out.println("\t-l\tLists all the tasks");
    System.out.println("\t-a\tAdds a new task");
    System.out.println("\t-r\tRemoves an task");
    System.out.println("\t-c\tCompletes an task");
  }
}
