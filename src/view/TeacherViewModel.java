package view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Teacher;

public class TeacherViewModel
{
  private StringProperty nameProperty;
  private StringProperty initialsProperty;
  private StringProperty subjectProperty;
  private BooleanProperty isBusyProperty;

  public TeacherViewModel(Teacher teacher)
  {
    nameProperty = new SimpleStringProperty(teacher.getName());
    initialsProperty = new SimpleStringProperty(teacher.getInitials());
    subjectProperty = new SimpleStringProperty(teacher.getSubject());
    isBusyProperty = new SimpleBooleanProperty(teacher.getIsBusy());
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

  public BooleanProperty getIsBusyProperty()
  {
    return isBusyProperty;
  }
}
