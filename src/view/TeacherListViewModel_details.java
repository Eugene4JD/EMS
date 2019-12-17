package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EMSModel;
import model.Teacher;

import java.util.ArrayList;

public class TeacherListViewModel_details
{
  private ObservableList<TeacherViewModel> list;
  private EMSModel model;

  public TeacherListViewModel_details(EMSModel model)
  {
    this.model = model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<TeacherViewModel> getList()
  {
    return list;
  }

  public ObservableList<TeacherViewModel> update()
  {
    ArrayList<Teacher> teachers = new ArrayList<>();
    for (int i = 0; i < model.getTempClass().getNumberOfTeachers(); i++)
    {
      teachers.add(model.getTempClass().getTeachers().getTeacherByIndex(i));
    }
    list.clear();
    for (int i = 0; i < teachers.size(); i++)
    {
      list.add(new TeacherViewModel(teachers.get(i)));
    }
    return list;
  }

  public void remove(Teacher teacher)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(teacher.getName()) && list
          .get(i).getInitialsProperty().get().equals(teacher.getInitials())
          && list.get(i).getSubjectProperty().get()
          .equals(teacher.getSubject()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Teacher teacher)
  {
    list.add(new TeacherViewModel(teacher));
  }
}
