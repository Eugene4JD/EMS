package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Teacher;

public class TeacherViewModel
{
  private StringProperty nameProperty;
  private StringProperty initialsProperty;
  private StringProperty subjectProperty;

  public TeacherViewModel(Teacher teacher)
  {
    nameProperty = new SimpleStringProperty(teacher.getName());
    initialsProperty = new SimpleStringProperty(teacher.getInitials());
    subjectProperty = new SimpleStringProperty(teacher.getSubject());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  public StringProperty getInitialsProperty()
  {
    return initialsProperty;
  }

  public StringProperty getSubjectProperty()
  {
    return subjectProperty;
  }
}
