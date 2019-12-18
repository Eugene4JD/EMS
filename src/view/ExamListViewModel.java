package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EMSModel;
import model.Exam;

import java.util.ArrayList;

public class ExamListViewModel
{
  private ObservableList<ExamViewModel> list;
  private EMSModel model;

  public ExamListViewModel(EMSModel model)
  {
    this.model = model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<ExamViewModel> getList()
  {
    return list;
  }

  public ObservableList<ExamViewModel> update()
  {
    ArrayList<Exam> examList = new ArrayList<>();
    for (int i = 0; i < model.examListSize(); i++)
    {
      examList.add(model.getExamByIndex(i));
    }
    list.clear();
    for (int i = 0; i < examList.size(); i++)
    {
      list.add(new ExamViewModel(examList.get(i)));
    }
    return list;
  }

  public void remove(Exam exam)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(exam.getExamName()) && list
          .get(i).getPeriodProperty().get().equals(exam.getPeriodOfExam().toString())
          && list.get(i).getClassProperty().get()
          .equals(exam.getClasses().toString()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Exam exam)
  {
    list.add(new ExamViewModel(exam));
  }
}
