package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.EMSModel;

public class ClassDetailsController
{
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public ClassDetailsController()
  {
    //init
  }
  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root=root;
    reset();
  }
  public Region getRoot()
  {
    return root;
  }
  public void reset()
  {
    //later
  }
  @FXML private void backButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }
}
