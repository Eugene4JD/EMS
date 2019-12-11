package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class AddTeacherController
{
  @FXML private TextField nameTextField;
  @FXML private TextField initialsTextField;
  @FXML private TextField subjectTextField;
  @FXML private Label errorLabel;

  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public AddTeacherController()
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
    this.initialsTextField.setText("");
    this.subjectTextField.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addTeacherButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      String name = this.nameTextField.getText();
      String initials = this.initialsTextField.getText();
      String subject = this.subjectTextField.getText();
      model.addTeacher(name, initials, subject);
      System.out.println("addTeacherPressed");
      viewHandler.openView("settingsPage");
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
