package view;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Class;
import model.EMSModel;
import model.Room;
import model.Student;
import model.Teacher;

import java.util.Optional;

public class SettingsViewController
{
  @FXML private Label errorLabel;
  @FXML private TableView<StudentViewModel> studentListTable;
  @FXML private TableColumn<StudentViewModel, String> studentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentSemesterColumn;
  @FXML private TableView<TeacherViewModel> teacherListTable;
  @FXML private TableColumn<TeacherViewModel, String> teacherNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> teacherInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> teacherSubjectColumn;
  @FXML private TableView<RoomViewModel> roomListTable;
  @FXML private TableColumn<RoomViewModel, String> roomNameColumn;
  @FXML private TableColumn<RoomViewModel, String> roomConnectorsColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomMaxStudentsColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomTablesColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomChairsColumn;
  @FXML private TableColumn<RoomViewModel, Boolean> roomCanBeMergedTableColumn;
  @FXML private TableView<ClassViewModel> classListTable;
  @FXML private TableColumn<ClassViewModel, String> classNameColumn;
  @FXML private TableColumn<ClassViewModel, Number> classNumberOfStudentsColumn;

  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  private StudentListViewModel viewModel1;
  private TeacherListViewModel viewModel2;
  private RoomListViewModel viewModel3;
  private ClassListViewModel viewModel4;

  public SettingsViewController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewModel1 = new StudentListViewModel(model);
    this.viewModel2 = new TeacherListViewModel(model);
    this.viewModel3 = new RoomListViewModel(model);
    this.viewModel4 = new ClassListViewModel(model);

    studentNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    studentIdColumn
        .setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    studentSemesterColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSemesterProperty());

    teacherNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    teacherInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    teacherSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    roomNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    roomConnectorsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getConnectorsProperty());
    roomMaxStudentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getMaxStudentsProperty());
    roomTablesColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTablesProperty());
    roomChairsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getChairsProperty());
    roomCanBeMergedTableColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCanBeMergedProperty());

    classNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    classNumberOfStudentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNumberOfStudentsProperty());
    reset();
  }

  public void reset()
  {
    errorLabel.setText("");
    studentListTable.setItems(viewModel1.update());
    teacherListTable.setItems(viewModel2.update());
    roomListTable.setItems(viewModel3.update());
    classListTable.setItems(viewModel4.update());
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("firstPage");
  }

  @FXML private void addStudentButtonPressed()
  {
    viewHandler.openView("addStudentPage");
  }

  @FXML private void removeStudentButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      StudentViewModel selectedItem = studentListTable.getSelectionModel()
          .getSelectedItem();

      boolean remove = confirmation1();
      if (remove)
      {
        Student student = new Student(selectedItem.getNameProperty().get(),
            selectedItem.getIdProperty().get(),
            selectedItem.getSemesterProperty().get());
        model.removeStudentByObject(student);
        viewModel1.remove(student);
        studentListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML private void resetStudentButtonPressed()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("This will remove all students from the system!");
    Optional<ButtonType> result = alert.showAndWait();
    boolean buffer = ((result.isPresent()) && (result.get() == ButtonType.OK));
    if (buffer)
    {
      model.removeAllStudents();
      reset();
      System.out.println("All students have been removed");
    }
  }

  private boolean confirmation1()
  {
    int index = studentListTable.getSelectionModel().getSelectedIndex();
    StudentViewModel selectedItem = studentListTable.getItems().get(index);
    if (index < 0 || index >= studentListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing student {" + selectedItem.getNameProperty().get() + ": "
            + selectedItem.getIdProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void addTeacherButtonPressed()
  {
    viewHandler.openView("addTeacherPage");
  }

  @FXML private void removeTeacherButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      TeacherViewModel selectedItem = teacherListTable.getSelectionModel()
          .getSelectedItem();

      boolean remove = confirmation2();
      if (remove)
      {
        Teacher teacher = new Teacher(selectedItem.getNameProperty().get(),
            selectedItem.getInitialsProperty().get(),
            selectedItem.getSubjectProperty().get());
        model.removeTeacherByObject(teacher);
        viewModel2.remove(teacher);
        teacherListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML private void resetTeacherButtonPressed()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("This will remove all teachers from the system!");
    Optional<ButtonType> result = alert.showAndWait();
    boolean buffer = ((result.isPresent()) && (result.get() == ButtonType.OK));
    if (buffer)
    {
      model.removeAllTeachers();
      reset();
      System.out.println("All teachers have been removed");
    }
  }

  private boolean confirmation2()
  {
    int index = teacherListTable.getSelectionModel().getSelectedIndex();
    TeacherViewModel selectedItem = teacherListTable.getItems().get(index);
    if (index < 0 || index >= teacherListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing teacher {" + selectedItem.getNameProperty().get() + ": "
            + selectedItem.getInitialsProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void addRoomButtonPressed()
  {
    viewHandler.openView("addRoomPage");
  }

  @FXML private void removeRoomButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      RoomViewModel selectedItem = roomListTable.getSelectionModel()
          .getSelectedItem();

      String buffer = "";
      if (selectedItem.getCanBeMergedProperty().get())
      {
        buffer = "true";
      }
      else
      {
        buffer = "false";
      }

      boolean remove = confirmation3();
      if (remove)
      {
        Room room = new Room(selectedItem.getNameProperty().get(),
            selectedItem.getConnectorsProperty().get(),
            selectedItem.getMaxStudentsProperty().get(),
            selectedItem.getChairsProperty().get(),
            selectedItem.getTablesProperty().get(), buffer);
        model.removeRoomByObject(room);
        viewModel3.remove(room);
        teacherListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML private void resetRoomButtonPressed()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("This will remove all rooms from the system!");
    Optional<ButtonType> result = alert.showAndWait();
    boolean buffer = ((result.isPresent()) && (result.get() == ButtonType.OK));
    if (buffer)
    {
      model.removeAllRooms();
      reset();
      System.out.println("All rooms have been removed");
    }
  }

  @FXML private void resetEverythingButtonPressed()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("This will remove EVERYTHING from the system!");
    Optional<ButtonType> result = alert.showAndWait();
    boolean buffer = ((result.isPresent()) && (result.get() == ButtonType.OK));
    if (buffer)
    {
      model.removeAll();
      reset();
      System.out.println("The program has been reset");
    }
  }

  private boolean confirmation3()
  {
    int index = roomListTable.getSelectionModel().getSelectedIndex();
    RoomViewModel selectedItem = roomListTable.getItems().get(index);
    if (index < 0 || index >= roomListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing teacher {" + selectedItem.getNameProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void addClassButtonPressed()
  {
    viewHandler.openView("addClassPage");
  }

  @FXML private void removeClassButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      ClassViewModel selectedItem = classListTable.getSelectionModel()
          .getSelectedItem();

      boolean remove = confirmation4();
      if (remove)
      {
        Class class_ = model
            .getClassByClassName(selectedItem.getNameProperty().get());
        model.removeClassByName(selectedItem.getNameProperty().get());
        viewModel4.remove(class_);
        classListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML private void resetClassButtonPressed()
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("This will remove all classes from the system!");
    Optional<ButtonType> result = alert.showAndWait();
    boolean buffer = ((result.isPresent()) && (result.get() == ButtonType.OK));
    if (buffer)
    {
      model.removeAllClasses();
      reset();
      System.out.println("All classes have been removed");
    }
  }

  private boolean confirmation4()
  {
    int index = classListTable.getSelectionModel().getSelectedIndex();
    ClassViewModel selectedItem = classListTable.getItems().get(index);
    if (index < 0 || index >= classListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing class {" + selectedItem.getNameProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void viewClassButtonPressed()
  {
    try
    {
      setSelectedItem();
      viewHandler.openView("classDetailsPage");
    }
    catch (Exception e)
    {
      errorLabel.setText("Select a class first");
    }
  }

  private void setSelectedItem()
  {
    int index = classListTable.getSelectionModel().getSelectedIndex();
    ClassViewModel selectedItem = classListTable.getItems().get(index);
    String nameOfClass = selectedItem.getNameProperty().get();
    Class theClass = model.getClassByClassName(nameOfClass);
    model.setTempClass(theClass);
  }
  @FXML private void changeSCButtonPressed()
  {
    viewHandler.openView("changeSecretCodePage");
  }
  @FXML private void userGuideButtonPressed()
  {
    getHostServices().showDocument("http://www.yahoo.com");
  }

  private HostServices getHostServices()
  {
    return null;
  }
}

