import model.*;
import  view.ConsoleView;

import java.io.File;

public class StartUP
{
  public static void main(String[] args)
  {
    EMSModel model = new EMSModelManager();
    ConsoleView view = new ConsoleView(model);
    view.start();
  }
}
