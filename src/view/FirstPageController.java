package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.EMSModel;

public class FirstPageController
{
  @FXML private Label errorLabel;
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public FirstPageController()
  {
    // init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    reset();
  }

  public void reset()
  {
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  public void exitButtonPressed()
  {
    viewHandler.closeView();
  }
  public void settingsButtonPressed() {viewHandler.openView("settingsPage");}
}
