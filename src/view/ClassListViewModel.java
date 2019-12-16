package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Class;
import model.ClassList;
import model.EMSModel;

public class ClassListViewModel
{
  private ObservableList<ClassViewModel> list;
  private EMSModel model;

  public ClassListViewModel(EMSModel model)
  {
    this.model = model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<ClassViewModel> getList()
  {
    return list;
  }

  public ObservableList<ClassViewModel> update()
  {
    ClassList classes = new ClassList();
    for (int i = 0; i < model.classListSize(); i++)
    {
      classes.addClass(model.getClass(i));
    }
    list.clear();
    for (int i = 0; i < classes.size(); i++)
    {
      list.add(new ClassViewModel(classes.getClassByIndex(i)));
    }
    return list;
  }

  public void remove(Class class_)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(class_.getClassName())
          && list.get(i).getNumberOfStudentsProperty().get() == (class_
          .getNumberOfStudents()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Class class_)
  {
    list.add(new ClassViewModel(class_));
  }
}
