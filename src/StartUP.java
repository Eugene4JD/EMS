import model.*;
import  view.ConsoleView;

import java.io.File;
import java.io.IOException;

public class StartUP
{
  public static void main(String[] args)
  {
    EMSModel model = new EMSModelManager();
    ConsoleView view = new ConsoleView(model);
    view.start();
  }
}
