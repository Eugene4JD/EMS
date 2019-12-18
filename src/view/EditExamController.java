package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import model.Class;

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

  private TeacherListViewArrayList teacherViewModel;
  private TeacherListViewArrayList currentTeacherViewModel;
  private TeacherList freeTeachers;
  private TeacherList chosenTeachers;

  private ClassListViewArrayList classViewModel;
  private ClassListViewArrayList currentClassViewModel;
  private ClassList freeClasses;
  private ClassList chosenClasses;

  private RoomListViewArrayList roomListViewModel;
  private RoomListViewArrayList currentRoomListViewModel;
  private RoomList freeRooms;
  private RoomList chosenRooms;
  public EditExamController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    this.nameTextField.setText(model.getTempExam().getExamName());
    errorLabel.setText("");
    this.startHH.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getStartTime().getHour()));
    this.startMM.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getStartTime().getMinute()));
    this.endHH.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getEndTime().getHour()));
    this.endMM.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getEndTime().getMinute()));
    this.dateDD.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getDateOfTheExam().getDay()));
    this.dateMM.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getDateOfTheExam().getMonth()));
    this.dateYY.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getDateOfTheExam().getYear()));

    this.freeClasses = model.getClassListCopy().returnWithoutObjectsOfAnotherList(model.getTempExam().getExamClasses());
    this.chosenClasses = model.getTempExam().getClasses();
    this.classViewModel = new ClassListViewArrayList(freeClasses);
    this.currentClassViewModel = new ClassListViewArrayList(chosenClasses);

    this.freeRooms = model.getRoomListCopy().returnWithoutObjectsOfAnotherList(model.getTempExam().getExamRooms());
    this.chosenRooms = model.getTempExam().getRooms();
    this.roomListViewModel = new RoomListViewArrayList(freeRooms);
    this.currentRoomListViewModel = new RoomListViewArrayList(chosenRooms);


    this.freeTeachers = model.getTeacherListCopy().returnWithoutObjectsOfAnotherList(model.getTempExam().getExamTeachers());
    this.chosenTeachers = model.getTempExam().getTeachers();
    this.teacherViewModel = new TeacherListViewArrayList(freeTeachers);
    this.currentTeacherViewModel = new TeacherListViewArrayList(chosenTeachers);

    supervisorNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    supervisorInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    supervisorSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    currentSupervisorNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    currentSupervisorInitialsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getInitialsProperty());
    currentSupervisorSubjectColumn.setCellValueFactory(
        cellData -> cellData.getValue().getSubjectProperty());

    classNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    classNumberOfStudentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNumberOfStudentsProperty());

    currentClassNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    currentClassNumberOfStudentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getNumberOfStudentsProperty());

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
    roomCanBeMergedTableColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCanBeMergedProperty());

    currentRoomNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    currentRoomConnectorsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getConnectorsProperty());
    currentRoomMaxStudentsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getMaxStudentsProperty());
    currentRoomChairColumn.setCellValueFactory(
        cellData -> cellData.getValue().getChairsProperty());
    currentRoomTableColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTablesProperty());
    currentRoomCanBeMergedTableColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCanBeMergedProperty());

    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    this.nameTextField.setText(model.getTempExam().getExamName());
    errorLabel.setText("");
    this.startHH.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getStartTime().getHour()));
    this.startMM.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getStartTime().getMinute()));
    this.endHH.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getEndTime().getHour()));
    this.endMM.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getEndTime().getMinute()));
    this.dateDD.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getDateOfTheExam().getDay()));
    this.dateMM.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getDateOfTheExam().getMonth()));
    this.dateYY.setText(Integer.toString(model.getTempExam().getPeriodOfExam().getDateOfTheExam().getYear()));

    this.freeClasses = model.getClassListCopy().returnWithoutObjectsOfAnotherList(model.getTempExam().getExamClasses());
    this.chosenClasses = model.getTempExam().getClasses();
    this.classViewModel = new ClassListViewArrayList(freeClasses);
    this.currentClassViewModel = new ClassListViewArrayList(chosenClasses);
    classListTable.setItems(classViewModel.update());
    currentClassListTable.setItems(currentClassViewModel.update());

    this.freeRooms = model.getRoomListCopy().returnWithoutObjectsOfAnotherList(model.getTempExam().getExamRooms());
    this.chosenRooms = model.getTempExam().getRooms();
    this.roomListViewModel = new RoomListViewArrayList(freeRooms);
    this.currentRoomListViewModel = new RoomListViewArrayList(chosenRooms);
    roomListTable.setItems(roomListViewModel.update());
    currentRoomListTable.setItems(currentRoomListViewModel.update());

    this.freeTeachers = model.getTeacherListCopy().returnWithoutObjectsOfAnotherList(model.getTempExam().getExamTeachers());
    this.chosenTeachers =model.getTempExam().getTeachers();
    this.teacherViewModel = new TeacherListViewArrayList(freeTeachers);
    this.currentTeacherViewModel = new TeacherListViewArrayList(chosenTeachers);
    supervisorListTable.setItems(teacherViewModel.update());
    currentSupervisorListTable.setItems(currentTeacherViewModel.update());
  }

  @FXML private void saveExamButtonPressed()
  {
    try
    {

      String name = nameTextField.getText();
      Date newDate = new Date(Integer.parseInt(dateDD.getText()),
          Integer.parseInt(dateMM.getText()),
          Integer.parseInt(dateYY.getText()));
      Time startTime = new Time(Integer.parseInt(startHH.getText()),
          Integer.parseInt(startMM.getText()), 0);
      Time endTime = new Time(Integer.parseInt(endHH.getText()),
          Integer.parseInt(endMM.getText()), 0);
       Exam newExam = new Exam(name, newDate, startTime, endTime, chosenClasses,
          chosenTeachers, chosenRooms);
      model.removeFromExamsByExam(model.getTempExam());
      model.addExam(newExam);
      
      viewHandler.openView("displayAddedExamsPage");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void addSupervisorButtonPressed()
  {
    try
    {
      TeacherViewModel selectedItem = supervisorListTable.getSelectionModel()
          .getSelectedItem();

      Teacher teacher = new Teacher(selectedItem.getNameProperty().get(),
          selectedItem.getInitialsProperty().get(),
          selectedItem.getSubjectProperty().get());
      freeTeachers.removeTeacherByObject(teacher); //actual ArrayList
      chosenTeachers.addTeacher(teacher);           //actual ArrayList
      teacherViewModel.remove(teacher);                     //refresh
      currentTeacherViewModel.add(teacher);                       //refresh
      supervisorListTable.getSelectionModel()
          .clearSelection(); //removes the FOCUS

    }
    catch (Exception e)
    {
      errorLabel.setText("No teacher selected!");
    }
  }

  @FXML private void addClassButtonPressed()
  {
    try
    {
      ClassViewModel selectedItem = classListTable.getSelectionModel().getSelectedItem();
      model.Class class1 = model.getClassListCopy().getClassByClassName(selectedItem.getNameProperty().get());
      freeClasses.removeClassByClassName(selectedItem.getNameProperty().get());
      chosenClasses.addClass(class1);
      classViewModel.remove(class1);
      currentClassViewModel.add(class1);
      classListTable.getSelectionModel().clearSelection();
    }
    catch (Exception e)
    {
      errorLabel.setText("Class is not selected");
    }

  }

  @FXML private void addRoomButtonPressed()
  {
    try
    {
      RoomViewModel selectedItem = roomListTable.getSelectionModel().getSelectedItem();
      Room room = model.getRoomListCopy()
          .getRoomByRoomName(selectedItem.getNameProperty().get());
      freeRooms.removeRoomByRoomName(selectedItem.getNameProperty().get());
      chosenRooms.addRoom(room);
      roomListViewModel.remove(room);
      currentRoomListViewModel.add(room);
      roomListTable.getSelectionModel().clearSelection();
    }
    catch (Exception e)
    {
      errorLabel.setText("Room is not selected");
    }
  }

  @FXML private void removeSupervisorButtonPressed()
  {
    try
    {
      TeacherViewModel selectedItem = currentSupervisorListTable
          .getSelectionModel().getSelectedItem();
      Teacher teacher = new Teacher(selectedItem.getNameProperty().get(),
          selectedItem.getInitialsProperty().get(),
          selectedItem.getSubjectProperty().get());
      chosenTeachers.removeTeacherByObject(teacher);
      freeTeachers.addTeacher(teacher);
      teacherViewModel.add(teacher);
      currentTeacherViewModel.remove(teacher);
      currentSupervisorListTable.getSelectionModel().clearSelection();
    }
    catch (Exception e)
    {
      errorLabel.setText("No supervisor has been selected");
    }
  }

  @FXML private void removeClassButtonPressed()
  {
    try
    {
      ClassViewModel selectedItem = currentClassListTable.getSelectionModel().getSelectedItem();
      String className = selectedItem.getNameProperty().get();
      Class class_ = model.getClassByClassName(className);
      chosenClasses.removeClassByClassName(className);
      freeClasses.addClass(class_);
      classViewModel.add(class_);
      currentClassViewModel.remove(class_);
      currentClassListTable.getSelectionModel().clearSelection();
    }
    catch (Exception e)
    {
      errorLabel.setText("No class has been selected");
    }
  }

  @FXML private void removeRoomButtonPressed()
  {
    try
    {
      RoomViewModel selectedItem = currentRoomListTable.getSelectionModel().getSelectedItem();
      String roomName = selectedItem.getNameProperty().get();
      Room room = model.getRoomByRoomName(roomName);
      chosenRooms.removeRoomByRoomName(roomName);
      freeRooms.addRoom(room);
      roomListViewModel.add(room);
      currentRoomListViewModel.remove(room);
      currentRoomListTable.getSelectionModel().clearSelection();
    }
    catch (Exception e)
    {
      errorLabel.setText("No room has been selected");
    }
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("firstPage");
  }
}

