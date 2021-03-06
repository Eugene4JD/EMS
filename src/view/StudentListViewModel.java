package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EMSModel;
import model.Student;
import model.StudentList;

import java.util.ArrayList;

public class StudentListViewModel
{
  private ObservableList<StudentViewModel> list;
  private EMSModel model;

  public StudentListViewModel(EMSModel model)
  {
    this.model = model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<StudentViewModel> getList()
  {
    return list;
  }

  public ObservableList<StudentViewModel> update()
  {
    StudentList students = new StudentList();
    for (int i = 0; i < model.studentListSize(); i++)
    {
      students.addStudent(model.getStudent(i));
    }
    list.clear();
    for (int i = 0; i < students.size(); i++)
    {
      list.add(new StudentViewModel(students.getStudentByIndex(i)));
    }
    return list;
  }

  public void remove(Student student)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(student.getName())
          && list.get(i).getIdProperty().get() == (student.getId())
          && list.get(i).getSemesterProperty().get() == (student.getSemester()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Student student)
  {
    list.add(new StudentViewModel(student));
  }
}
