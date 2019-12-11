package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EMSModel;
import model.Student;

import java.util.ArrayList;

public class StudentListViewModel
{
  private ObservableList<StudentViewModel> list;
  private EMSModel model;

  public StudentListViewModel(EMSModel model)
  {
    this.model=model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<StudentViewModel> getList()
  {
    return list;
  }

  public ObservableList<StudentViewModel> update()
  {
    ArrayList<Student> students = new ArrayList<>();
    for (int i=0; i<model.)
  }
}
