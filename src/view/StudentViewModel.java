package view;

import javafx.beans.property.*;
import model.Student;

public class StudentViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty idProperty;
  private IntegerProperty semesterProperty;

  public StudentViewModel(Student student)
  {
    nameProperty = new SimpleStringProperty(student.getName());
    idProperty = new SimpleIntegerProperty(student.getId());
    semesterProperty = new SimpleIntegerProperty(student.getSemester());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }
  public IntegerProperty getIdProperty()
  {
    return idProperty;
  }
  public IntegerProperty getSemesterProperty()
  {
    return semesterProperty;
  }
}
