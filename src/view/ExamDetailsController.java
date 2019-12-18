package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.EMSModel;

public class ExamDetailsController
{
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  @FXML private Text nameText;
  @FXML private Text periodText;
  @FXML private TableView<TeacherViewModel> supervisorListTable;
  @FXML private TableColumn<TeacherViewModel, String> supervisorNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> supervisorInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> supervisorSubjectColumn;
  @FXML private TableView<StudentViewModel> studentInClassTable;
  @FXML private TableColumn<StudentViewModel, String> studentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentSemesterColumn;
  @FXML private TableView<RoomViewModel> roomsForExamListTable;
  @FXML private TableColumn<RoomViewModel, String> roomNameColumn;
  @FXML private TableColumn<RoomViewModel, String> roomConnectorsColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomMaxStudentsColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomTablesColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomChairsColumn;
  @FXML private TableColumn<RoomViewModel, Boolean> roomCanBeMergedColumn;

  private TeacherListViewModel_detailsForExam supervisorViewModel;
  private StudentListViewModel_detailsForExam studentsViewModel;
  private RoomListViewModel_details roomListViewModel;

  public ExamDetailsController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    this.supervisorViewModel = new TeacherListViewModel_detailsForExam(model);
    this.studentsViewModel = new StudentListViewModel_detailsForExam(model);
    this.roomListViewModel = new RoomListViewModel_details(model);

    supervisorNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    supervisorInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    supervisorSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    studentNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    studentIdColumn
        .setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    studentSemesterColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSemesterProperty());

    roomNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    roomConnectorsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getConnectorsProperty());
    roomMaxStudentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getMaxStudentsProperty());
    roomChairsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getChairsProperty());
    roomTablesColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTablesProperty());
    roomCanBeMergedColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCanBeMergedProperty());

    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    supervisorListTable.setItems(supervisorViewModel.update());
    studentInClassTable.setItems(studentsViewModel.update());
    roomsForExamListTable.setItems(roomListViewModel.update());
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("displayAddedExamsPage");
  }
}
