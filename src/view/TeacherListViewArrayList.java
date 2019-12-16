package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Teacher;
import model.TeacherList;

import java.util.ArrayList;

public class TeacherListViewArrayList
{
  private ObservableList<TeacherViewModel> list;
  private TeacherList teachers;

  public TeacherListViewArrayList(TeacherList teachers)
  {
    this.teachers = teachers;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<TeacherViewModel> getList()
  {
    return list;
  }

  public ObservableList<TeacherViewModel> update()
  {
    ArrayList<Teacher> teachers1 = new ArrayList<>();
    for (int i = 0; i < teachers.size(); i++)
    {
      teachers1.add(teachers.getTeacherByIndex(i));
    }
    list.clear();
    for (int i = 0; i < teachers1.size(); i++)
    {
      list.add(new TeacherViewModel(teachers1.get(i)));
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
