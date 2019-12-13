package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.EMSModel;
import model.Student;

import java.util.Optional;

public class SettingsViewController
{
  @FXML private Label errorLabel;
  @FXML private TableView<StudentViewModel> studentListTable;
  @FXML private TableColumn<StudentViewModel, String> studentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentSemesterColumn;
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  private StudentListViewModel viewModel;

  public SettingsViewController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewModel = new StudentListViewModel(model);

    studentNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    studentIdColumn
        .setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    studentSemesterColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSemesterProperty());
    reset();
  }

  public void reset()
  {
    errorLabel.setText("");
    studentListTable.setItems(viewModel.update());
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

      boolean remove = confirmation();
      if (remove)
      {
        Student student = new Student(selectedItem.getNameProperty().get(),
            selectedItem.getIdProperty().get(),
            selectedItem.getSemesterProperty().get());
        model.removeStudentByObject(student);
        viewModel.remove(student);
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

  private boolean confirmation()
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

  @FXML private void resetTeacherButtonPressed()
  {
    model.removeAllTeachers();
    System.out.println("All teachers have been removed");
  }
  @FXML private void addRoomButtonPressed()
  {
    viewHandler.openView("addRoomPage");
  }
  @FXML private void resetRoomButtonPressed()
  {
    model.removeAllRooms();
    System.out.println("All rooms have been removed");
  }
  @FXML private void resetClassButtonPressed()
  {
    model.removeAllClasses();
    System.out.println("All classes have been removed");
  }
  @FXML private void resetEverythingButtonPressed()
  {
    model.removeAll();
    System.out.println("Everything has been removed");
  }
}

