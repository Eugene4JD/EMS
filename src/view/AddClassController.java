package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

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
  @FXML private TableView<StudentViewModel> studentsListTable;
  @FXML private TableColumn<StudentViewModel, String> studentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentSemesterColumn;
  @FXML private TableView<StudentViewModel> currentStudentListTable;
  @FXML private TableColumn<StudentViewModel, String> currentStudentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> currentStudentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> currentStudentSemesterColumn;
  private Region root;
  private EMSModel model;
  private TeacherList freeTeachers;
  private TeacherList selectedTeachers;
  private StudentList freeStudents;
  private StudentList selectedStudents;

  private ViewHandler viewHandler;
  private TeacherListViewArrayList viewModel1;
  private TeacherListViewArrayList viewModel11;
  private StudentListViewArrayList viewModel2;
  private StudentListViewArrayList viewModel22;

  public AddClassController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.freeTeachers = model.getTeacherListCopy();
    this.selectedTeachers = new TeacherList();
    this.freeStudents = model.getStudentListCopy();
    this.selectedStudents = new StudentList();
    this.viewModel1 = new TeacherListViewArrayList(freeTeachers);
    this.viewModel11 = new TeacherListViewArrayList(selectedTeachers);
    this.viewModel2 = new StudentListViewArrayList(freeStudents);
    this.viewModel22 = new StudentListViewArrayList(selectedStudents);

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

    currentTeacherNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    currentTeacherInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    currentTeacherSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    currentStudentNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    currentStudentIdColumn
        .setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    currentStudentSemesterColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSemesterProperty());

    reset();
  }

  public void reset()
  {
    this.studentsLabel.setText("");
    this.teachersLabel.setText("");
    this.nameTextField.setText("");
    this.freeTeachers = model.getTeacherListCopy();
    this.selectedTeachers = new TeacherList();
    this.freeStudents = model.getStudentListCopy();
    this.selectedStudents = new StudentList();
    teacherListTable.setItems(viewModel1.update());
    currentTeacherListTable.setItems(viewModel11.update());
    studentsListTable.setItems(viewModel2.update());
    currentStudentListTable.setItems(viewModel22.update());
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
    freeTeachers.removeTeacherByObject(teacher); //actual ArrayList
    selectedTeachers.addTeacher(teacher);           //actual ArrayList
    viewModel1.remove(teacher);                     //refresh
    viewModel11.add(teacher);                       //refresh
    teacherListTable.getSelectionModel().clearSelection(); //removes the FOCUS

  }

  @FXML private void addStudentButtonPressed()
  {
    StudentViewModel selectedItem = studentsListTable.getSelectionModel()
        .getSelectedItem();
    Student student = new Student(selectedItem.getNameProperty().get(),
        selectedItem.getIdProperty().get(),
        selectedItem.getSemesterProperty().get());
    freeStudents.removeStudentByObject(student);
    selectedStudents.addStudent(student);
    viewModel2.remove(student);
    viewModel22.add(student);
    studentsListTable.getSelectionModel().clearSelection();

  }

  @FXML private void addClassButtonPressed()
  {
    try
    {
      model.addClass(nameTextField.getText(), selectedTeachers,
          selectedStudents);
      reset();
      viewHandler.openView("settingsPage");
    }
    catch (IllegalArgumentException e)
    {
      teachersLabel.setText(e.getMessage());
    }

  }

  
}
