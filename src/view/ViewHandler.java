package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.EMSModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryScene;
  private EMSModel model;
  private SecretCodeController secretCodeController;
  private FirstPageController firstPageController;
  private SettingsViewController settingsViewController;
  private AddStudentController addStudentController;
  private AddTeacherController addTeacherController;

  public ViewHandler(EMSModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryScene)
  {
    this.primaryScene = primaryScene;
    openView("secretCode");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "secretCode":
        root = loadSecretCodeView("SecretCodeView.fxml");
        break;
      case "firstPage":
        root = loadFirstPageView("FirstPageView.fxml");
        break;
      case "settingsPage":
        root = loadSettingsView("settingsView.fxml");
        break;
      case "addStudentPage":
        root = loadAddStudentView("AddStudentView.fxml");
        break;
      case "addTeacherPage":
        root = loadAddTeacherView("AddTeacherView.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "EMS";
    primaryScene.setScene(currentScene);
    primaryScene.setWidth(root.getPrefWidth());
    primaryScene.setHeight(root.getPrefHeight());
    primaryScene.getIcons()
        .add(new Image(getClass().getResourceAsStream("logo_icon.png")));
    primaryScene.show();
    if (root.getUserData() != null)
    {
      primaryScene.centerOnScreen();
      primaryScene.setTitle(title);
    }
  }

  public void closeView()
  {
    primaryScene.close();
  }

  private Region loadSecretCodeView(String fxmlFile)
  {
    if (secretCodeController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        secretCodeController = loader.getController();
        secretCodeController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      secretCodeController.reset();
    }
    return secretCodeController.getRoot();
  }

  private Region loadFirstPageView(String fxmlFile)
  {
    if (firstPageController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        firstPageController = loader.getController();
        firstPageController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      firstPageController.reset();
    }
    return firstPageController.getRoot();
  }

  private Region loadSettingsView(String fxmlFile)
  {
    if (settingsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        settingsViewController = loader.getController();
        settingsViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      settingsViewController.reset();
    }
    return settingsViewController.getRoot();
  }

  private Region loadAddStudentView(String fxmlFile)
  {
    if (addStudentController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addStudentController = loader.getController();
        addStudentController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addStudentController.reset();
    }
    return addStudentController.getRoot();
  }

  private Region loadAddTeacherView(String fxmlFile)
  {
    if (addTeacherController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addTeacherController = loader.getController();
        addTeacherController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addTeacherController.reset();
    }
    return addTeacherController.getRoot();
  }
}
