package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class AddClassController
{
  @FXML private TextField nameTextField;
  @FXML private Label teachersLabel;
  @FXML private Label studentsLabel;
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public AddClassController()
  {
    //init
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
    this.studentsLabel.setText("");
    this.teachersLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }
}
