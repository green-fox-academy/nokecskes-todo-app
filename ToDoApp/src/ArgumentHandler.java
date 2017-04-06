import com.sun.org.apache.xpath.internal.Arg;

/**
 * Created by Connor on 2017.04.06..
 */
public class ArgumentHandler {

  String[] arguments;

  public ArgumentHandler(String[] arguments) {
    this.arguments =arguments;
  }

  public boolean noArgument() {
    if (arguments.length == 0) {
      return true;
    }
    return false;
  }

  public boolean notValidArg() {
    if((arguments.length == 1 || arguments.length == 2) && (arguments[0].startsWith("-"))) {
      return false;
    }
    return true;
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

  public boolean contains(String contain) {
    if (!noArgument()) {
      for (String argument : arguments) {
        if (argument.startsWith("-") && argument.contains(contain)){
          return true;
        }
      }
    }
    return false;
  }

}
