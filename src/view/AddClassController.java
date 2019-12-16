package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;
import model.Teacher;
import model.TeacherList;

public class AddClassController
{
  @FXML private TextField nameTextField;
  @FXML private Label teachersLabel;
  @FXML private Label studentsLabel;
  @FXML private TableView<TeacherViewModel> teacherListTable;
  @FXML private TableColumn<TeacherViewModel, String> teacherNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> teacherInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> teacherSubjectColumn;
  @FXML private TableView<TeacherViewModel> currentTeacherListTable;
  @FXML private TableColumn<TeacherViewModel, String> currentTeacherNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> currentTeacherInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> currentTeacherSubjectColumn;
  private Region root;
  private EMSModel model;
  private TeacherList teacherListCopy;
  private TeacherList emptyTeacherList;
  private ViewHandler viewHandler;
  private TeacherListViewArrayList viewModel1;
  private TeacherListViewArrayList viewModel11;

  public AddClassController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.teacherListCopy = model.getTeacherListCopy();
    this.emptyTeacherList = new TeacherList();
    this.viewModel1 = new TeacherListViewArrayList(teacherListCopy);
    this.viewModel11 = new TeacherListViewArrayList(emptyTeacherList);

    teacherNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    teacherInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    teacherSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    currentTeacherNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    currentTeacherInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    currentTeacherSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    reset();
  }

  public void reset()
  {
    this.studentsLabel.setText("");
    this.teachersLabel.setText("");
    teacherListTable.setItems(viewModel1.update());
    currentTeacherListTable.setItems(viewModel11.update());
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }

  @FXML private void addTeacherButtonPressed()
  {
    TeacherViewModel selectedItem = teacherListTable.getSelectionModel()
        .getSelectedItem();

    Teacher teacher = new Teacher(selectedItem.getNameProperty().get(),
        selectedItem.getInitialsProperty().get(),
        selectedItem.getSubjectProperty().get());
    teacherListCopy.removeTeacherByObject(teacher); //actual ArrayList
    emptyTeacherList.addTeacher(teacher);           //actual ArrayList
    viewModel1.remove(teacher);                     //refresh
    viewModel11.add(teacher);                       //refresh
    teacherListTable.getSelectionModel().clearSelection(); //removes the FOCUS



  }
}
