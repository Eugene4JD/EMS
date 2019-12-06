package model;

import java.util.ArrayList;

public class ExamList
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
}
