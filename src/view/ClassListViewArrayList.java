package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Class;
import model.ClassList;

import java.util.ArrayList;

public class ClassListViewArrayList
{
  private ObservableList<ClassViewModel> list;
  private ClassList classes;

  public ClassListViewArrayList(ClassList classes)
  {
    this.classes = classes;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<ClassViewModel> getList()
  {
    return list;
  }

  public ObservableList<ClassViewModel> update()
  {
    ArrayList<Class> classList = new ArrayList<>();
    for (int i = 0; i < classes.size(); i++)
    {
      classList.add(classes.getClassByIndex(i));
    }
    list.clear();
    for (int i = 0; i < classList.size(); i++)
    {
      list.add(new ClassViewModel(classList.get(i)));
    }
    return list;
  }

  public void remove(Class class1)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(class1.getClassName()) && list
          .get(i).getNumberOfStudentsProperty().get() == (class1.getNumberOfStudents()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Class class1)
  {
    list.add(new ClassViewModel(class1));
  }
}
