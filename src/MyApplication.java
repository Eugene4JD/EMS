import javafx.application.Application;
import javafx.stage.Stage;
import model.EMSModel;
import model.EMSModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    EMSModel model = new EMSModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}