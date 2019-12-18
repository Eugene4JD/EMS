package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.EMSModel;

public class ExamDetailsController
{
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  @FXML private TableView<TeacherViewModel> supervisorListTable;
  @FXML private TableColumn<TeacherViewModel, String> supervisorNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> supervisorInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> supervisorSubjectColumn;
  @FXML private TableView<StudentListViewModel> studentInCLassTable;
  @FXML private TableColumn<StudentViewModel, String> studentNameColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentIdColumn;
  @FXML private TableColumn<StudentViewModel, Number> studentSemesterColumn;
  @FXML private TableView<RoomViewModel> roomsForExamListTable;
  @FXML private TableColumn<RoomViewModel, String> roomNameColumn;
  @FXML private TableColumn<RoomViewModel, String> roomConnectorsColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomMaxStudentsColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomTablesColumn;
  @FXML private TableColumn<RoomViewModel, Number> roomChairsColumn;
  @FXML private TableColumn<RoomViewModel, Boolean> roomCanBeMergedTableColumn;

  private TeacherListViewModel_details supervisorViewModel;
  private StudentListViewModel_details studentsViewModel;
  private RoomListViewModel_details roomListViewModel;

  public ExamDetailsController()
  {
    //init
  }
}
