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
  private AddRoomController addRoomController;
  private AddClassController addClassController;
  private ClassDetailsController classDetailsController;
  private AddExamController addExamController;
  private DisplayAddedExamsController displayAddedExamsController;

  public ViewHandler(EMSModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryScene)
  {
    model.setAllUpToDate();
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
      case "addRoomPage":
        root = loadAddRoomView("AddRoomView.fxml");
        break;
      case "addClassPage":
        root = loadAddClassView("AddClassView.fxml");
        break;
      case "classDetailsPage":
        root = loadClassDetailsView("ClassDetailsView.fxml");
        break;
      case "addExamPage":
        root = loadAddExamView("AddExamView.fxml");
        break;
      case "displayAddedExamsPage":
        root = loadDisplayAddedExamsView("DisplayAddedExamsView.fxml");
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

  private Region loadAddRoomView(String fxmlFile)
  {
    if (addRoomController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addRoomController = loader.getController();
        addRoomController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addRoomController.reset();
    }
    return addRoomController.getRoot();
  }

  private Region loadAddClassView(String fxmlFile)
  {
    if (addClassController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addClassController = loader.getController();
        addClassController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addClassController.reset();
    }
    return addClassController.getRoot();
  }

  private Region loadClassDetailsView(String fxmlFile)
  {
    if (classDetailsController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        classDetailsController = loader.getController();
        classDetailsController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      classDetailsController.reset();
    }
    return classDetailsController.getRoot();
  }

  private Region loadAddExamView(String fxmlFile)
  {
    if (addExamController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addExamController = loader.getController();
        addExamController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addExamController.reset();
    }
    return addExamController.getRoot();
  }

  private Region loadDisplayAddedExamsView(String fxmlFile)
  {
    if (displayAddedExamsController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        displayAddedExamsController = loader.getController();
        displayAddedExamsController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      displayAddedExamsController.reset();
    }
    return displayAddedExamsController.getRoot();
  }
}
