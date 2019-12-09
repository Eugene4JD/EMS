package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ExamList implements Serializable
{

  private ArrayList<Exam> exams;

  public ExamList()
  {
    exams = new ArrayList<>();
  }
  public boolean isExamLegitToBeCreated(Exam exam)
  {
    for (int i =0; i<exams.size(); i++)
    {
      if (exams.get(i).equals(exam))
        return false;
      if (exams.get(i).getPeriodOExam().onConflict(exam.getPeriodOExam()))
        return false;
    }
    return true;
  }
  public void addExam(Exam exam)
  {
    if (isExamLegitToBeCreated(exam))
      exams.add(exam);
  }
  public void removeExam(DateAndTimePeriod period)
  {
    for (int i=0; i<exams.size(); i++)
    {
      if (exams.get(i).getPeriodOExam().equals(period))
      {
        exams.remove(i);
        break;
      }
    }
  }
  public Exam getExam(int index)
  {
    return exams.get(index);
  }
  public int getNumberOfExams()
  {
    return exams.size();
  }
  public String toString()
  {
    String str = "";
    for (int i = 0; i < exams.size(); i++)
    {
      str+=exams.get(i).showScheduleElement();
      if (i!=exams.size()-1)
        str+="\n";
    }
    return str;
  }
}
