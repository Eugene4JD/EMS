package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.EMSModel;

public class SettingsViewController
{
  @FXML private Label errorLabel;
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public SettingsViewController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public void reset()
  {
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  public void backButtonPressed() {viewHandler.openView("firstPage");}
}
