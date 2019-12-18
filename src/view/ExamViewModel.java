package view;

import javafx.beans.property.*;
import model.Exam;

public class ExamViewModel
{
    private StringProperty nameProperty;
    private StringProperty periodProperty;
    private StringProperty classProperty;

    public ExamViewModel(Exam exam)
  {
    nameProperty = new SimpleStringProperty(exam.getExamName());
    periodProperty = new SimpleStringProperty(exam.getPeriodOfExam().toString());
    classProperty = new SimpleStringProperty(exam.getClasses().toString());
  }

    public StringProperty getNameProperty ()
    {
    return nameProperty;
    }
    public StringProperty getPeriodProperty ()
    {
    return periodProperty;
    }
    public StringProperty getClassProperty ()
    {
    return classProperty;
    }
}

