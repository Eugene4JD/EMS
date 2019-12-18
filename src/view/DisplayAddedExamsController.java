package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.EMSModel;
import model.Exam;

import java.util.Optional;

public class DisplayAddedExamsController
{
  @FXML private Label errorLabel;
  @FXML private TableView<ExamViewModel> examListTable;
  @FXML private TableColumn<ExamViewModel, String> examNameColumn;
  @FXML private TableColumn<ExamViewModel, String> periodOfTheExamColumn;
  @FXML private TableColumn<ExamViewModel, String> classNameColumn;

  private Region root;
  private EMSModel model;
  private ViewHandler viewHandler;
  private ExamListViewModel examViewModel;

  public DisplayAddedExamsController()
  {
    //init
  }

  public void init(ViewHandler viewHandler, EMSModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
    examViewModel = new ExamListViewModel(model);

    examNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    periodOfTheExamColumn.setCellValueFactory(
        cellData -> cellData.getValue().getPeriodProperty());
    classNameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getClassProperty());

    reset();
  }

  public void reset()
  {
    errorLabel.setText("");
    examListTable.setItems(examViewModel.update());
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void removeExamButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      ExamViewModel selectedItem = examListTable.getSelectionModel()
          .getSelectedItem();

      boolean remove = confirmation1();
      if (remove)
      {
        Exam exam = model.getExamByName(selectedItem.getNameProperty().get())
            .copy();
        model.removeFromExamsByExam(exam);
        examViewModel.remove(exam);
        examListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  private boolean confirmation1()
  {
    int index = examListTable.getSelectionModel().getSelectedIndex();
    ExamViewModel selectedItem = examListTable.getItems().get(index);
    if (index < 0 || index >= examListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing Exam {" + selectedItem.getNameProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void viewDetailsButtonPressed()
  {

    try
    {
      setSelectedItem();
      viewHandler.openView("examDetailsPage");
    }
    catch (Exception e)
    {
      errorLabel.setText("Select an exam");
    }
    
  }

  private void setSelectedItem()
  {
    int index = examListTable.getSelectionModel().getSelectedIndex();
    ExamViewModel selectedItem = examListTable.getItems().get(index);
    String nameOfAnExam = selectedItem.getNameProperty().get();
    Exam exam = model.getExamByName(nameOfAnExam);
    model.setTempExam(exam);
  }

  @FXML private void editExamButtonPressed()
  {
    try
    {
      setSelectedItem();
      viewHandler.openView("editExamPage");
    }
    catch (Exception e)
    {
      errorLabel.setText("Select an exam");
    }
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("firstPage");
  }
}
