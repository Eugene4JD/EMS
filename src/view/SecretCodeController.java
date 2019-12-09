package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class SecretCodeController
{
  @FXML private PasswordField secretCodeField;
  @FXML private Label errorLabel;
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;

  public SecretCodeController()
  {
    // init
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
    secretCodeField.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void onEnter(ActionEvent event)
  {
    if (event.getSource() == secretCodeField)
    {
      enterButtonPressed();
    }
  }

  public void enterButtonPressed()
  {
    try
    {
      model.validateSecretCode(secretCodeField.getText());
      System.out.println("Success");
      errorLabel.setText("");
      viewHandler.openView("firstPage");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
      secretCodeField.setText("");
    }
  }

  public void cancelButtonPressed()
  {
    viewHandler.closeView();
  }
}
