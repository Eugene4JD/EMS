package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.EMSModel;

public class EditExamController
{
  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  @FXML private Label errorLabel;
  @FXML private TextField nameTextField;
  @FXML private TextField dateDD;
  @FXML private TextField dateMM;
  @FXML private TextField dateYY;
  @FXML private TextField startHH;
  @FXML private TextField startMM;
  @FXML private TextField endHH;
  @FXML private TextField endMM;
  @FXML private TableView<TeacherViewModel> supervisorListTable;
  @FXML private TableColumn<TeacherViewModel, String> supervisorNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> supervisorInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> supervisorSubjectColumn;
  @FXML private TableView<TeacherViewModel> currentSupervisorListTable;
  @FXML private TableColumn<TeacherViewModel, String> currentSupervisorNameColumn;
  @FXML private TableColumn<TeacherViewModel, String> currentSupervisorInitialsColumn;
  @FXML private TableColumn<TeacherViewModel, String> currentSupervisorSubjectColumn;
  @FXML private TableView<RoomViewModel> currentRoomListTable;
  @FXML private TableColumn<RoomViewModel, String> currentRoomNameColumn;
  @FXML private TableColumn<RoomViewModel, String> currentRoomConnectorsColumn;
  @FXML private TableColumn<RoomViewModel, Number> currentRoomMaxStudentsColumn;
  @FXML private TableColumn<RoomViewModel, Number> currentRoomTableColumn;
  @FXML private TableColumn<RoomViewModel, Number> currentRoomChairColumn;
  @FXML private TableColumn<RoomViewModel, Boolean> currentRoomCanBeMergedTableColumn;
  @FXML private TableView<ClassViewModel> currentClassListTable;
  @FXML private TableColumn<ClassViewModel, String> currentClassNameColumn;
  @FXML private TableColumn<ClassViewModel, Number> currentClassNumberOfStudentsColumn;
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
}
