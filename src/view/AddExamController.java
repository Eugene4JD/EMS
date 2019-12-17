package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.control.*;
import model.EMSModel;

public class AddExamController
{
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  @FXML private Label errorLabel;
  @FXML private TextField nameTextField;
  @FXML private DatePicker dateDatePicker;
  @FXML private TextField startHH;
  @FXML private TextField startMM;
  @FXML private TextField endHH;
  @FXML private TextField endMM;

  public AddExamController()
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

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("firstPage");
  }
}
