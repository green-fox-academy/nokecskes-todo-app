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
