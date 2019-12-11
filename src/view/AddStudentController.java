package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

import java.io.IOException;

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
    errorLabel.setText("");
    try
    {
      System.out.println("addPressed");
      int id = Integer.parseInt(idTextField.getText());
      String name = nameTextField.getText();
      int semester = Integer.parseInt(semesterTextField.getText());
      model.addStudent(name,id,semester);
      viewHandler.openView("settingsPage");
    }
    catch (NumberFormatException e)
    {
      errorLabel.setText("Illegal "+e.getMessage());
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }
}
