package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class AddStudentController
{
  @FXML private TextField nameTextField;
  @FXML private TextField idTextField;
  @FXML private TextField semesterTextField;
  @FXML private Label errorLabel;

  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public AddStudentController()
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
    this.errorLabel.setText("");
    this.nameTextField.setText("");
    this.idTextField.setText("");
    this.semesterTextField.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addStudentButtonPressed()
  {
    System.out.println("addPressed");
    viewHandler.openView("settingsPage");
  }

  @FXML private void cancelButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }
}
