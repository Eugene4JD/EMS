package view;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class AddRoomController
{
  @FXML private TextField nameTextField;
  @FXML private TextField connectorsTextField;
  @FXML private TextField maxStudentsTextField;
  @FXML private TextField chairsTextField;
  @FXML private TextField tablesTextField;
  @FXML private CheckBox canBeMergedCheckBox;
  @FXML private Label errorLabel;
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public AddRoomController()
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

  public void reset()
  {
    this.errorLabel.setText("");
    this.nameTextField.setText("");
    this.connectorsTextField.setText("");
    this.maxStudentsTextField.setText("");
    this.chairsTextField.setText("");
    this.tablesTextField.setText("");
    this.canBeMergedCheckBox.setSelected(false);
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void cancelButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }

  @FXML private void addRoomButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      String name = this.nameTextField.getText();
      String connectors = this.connectorsTextField.getText();
      int maxStudents = Integer.parseInt(this.maxStudentsTextField.getText());
      int chairs = Integer.parseInt(this.chairsTextField.getText());
      int tables = Integer.parseInt(this.tablesTextField.getText());
      String canBeMerged = "false";
      if (this.canBeMergedCheckBox.isSelected())
      {
        canBeMerged = "true";
      }
      model.addRoom(name, connectors, maxStudents, chairs, tables, canBeMerged);
      System.out.println("room added");
      viewHandler.openView("settingsPage");
    }
    catch (NumberFormatException e)
    {
      errorLabel.setText("Illegal " + e.getMessage());
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

}

