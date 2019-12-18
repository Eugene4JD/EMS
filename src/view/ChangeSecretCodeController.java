package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class ChangeSecretCodeController
{
  @FXML private PasswordField oldSCPasswordField;
  @FXML private PasswordField newSCPasswordField;
  @FXML private Label errorLabel;

  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public ChangeSecretCodeController()
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
    errorLabel.setText("");
    oldSCPasswordField.setText("");
    newSCPasswordField.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void changeButtonPressed()
  {
    try
    {
      if (model.validateSecretCode(oldSCPasswordField.getText()))
       if (newSCPasswordField == null)
         throw new IllegalArgumentException("Wrong Password");
       model.savePassword(newSCPasswordField.getText());
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
  @FXML private void onEnter(ActionEvent event)
  {
    changeButtonPressed();
  }
}
