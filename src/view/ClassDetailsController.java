package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.EMSModel;

public class ClassDetailsController
{
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  @FXML private TableView<TeacherViewModel> teacherListTable;
  @FXML private TableColumn<TeacherViewModel, String> teacherNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> teacherInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> teacherSubjectColumn;
  @FXML private TableView<StudentViewModel> studentListTable;
  @FXML private TableColumn<StudentViewModel, String> studentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentSemesterColumn;
  private TeacherListViewModel_details viewModel1;
  private StudentListViewModel_details viewModel2;

  public ClassDetailsController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.viewModel1 = new TeacherListViewModel_details(model);
    this.viewModel2 = new StudentListViewModel_details(model);

    teacherNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    teacherInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    teacherSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    studentNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    studentIdColumn
        .setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    studentSemesterColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSemesterProperty());

    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    teacherListTable.setItems(viewModel1.update());
    studentListTable.setItems(viewModel2.update());
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("settingsPage");
  }
}
