package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Class;

public class ClassViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty numberOfStudentsProperty;

  public ClassViewModel(Class class_)
  {
    nameProperty = new SimpleStringProperty(class_.getClassName());
    numberOfStudentsProperty = new SimpleIntegerProperty(class_.getNumberOfStudents());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }
  public IntegerProperty getNumberOfStudentsProperty()
  {
    return numberOfStudentsProperty;
  }
}
