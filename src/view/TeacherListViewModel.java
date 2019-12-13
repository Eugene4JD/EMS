package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EMSModel;
import model.Teacher;

import java.util.ArrayList;

public class TeacherListViewModel
{
  private ObservableList<TeacherViewModel> list;
  private EMSModel model;

  public TeacherListViewModel(EMSModel model)
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
    for (int i = 0; i < model.teacherListSize(); i++)
    {
      teachers.add(model.getTeacher(i));
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
          && list.get(i).getSubjectProperty().get().equals(teacher.getSubject())
          && list.get(i).getIsBusyProperty().get() == (teacher.getIsBusy()))
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
