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
        throw new IllegalArgumentException("This exam already in the system");
      if (exams.get(i).getPeriodOfExam().onConflict(exam.getPeriodOfExam()))
      {
        System.out.println("Period is on conflict");
        if ((exam.getExamRooms().equals(exams.get(i).getExamRooms())))
          throw new IllegalArgumentException("The Wrong Date input(Period is used already for this rooms)");
        if ((exam.getExamRooms().hasAtLeastOneSameRoom(exams.get(i).getExamRooms())))
          throw new IllegalArgumentException("The Wrong Date input(Some Rooms are busy for this period)");
        if ((exam.getExamTeachers().hasAtLeastOneSameTeacher(exams.get(i).getExamTeachers())))
          throw new IllegalArgumentException("The Wrong Date input(Teachers are busy for this period)");
        if ((exam.getExamClasses().hasAtLeastOneSameClass(exams.get(i).getExamClasses())))
           throw new IllegalArgumentException("The Wrong Date Input(Some Classes are busy for this period)");
        if(exam.getClasses().getNumberOfClasses() == 0)
          throw new IllegalArgumentException("You haven't chosen any classes!");
        if (exam.getTeachers().getNumberOfTeachers() == 0)
          throw new IllegalArgumentException("You haven't chosen any supervisors!");
        if (exam.getRooms().numberOfRooms() == 0)
          throw new IllegalArgumentException("You haven't chosen any room!");
      }
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
      if (exams.get(i).getPeriodOfExam().equals(period))
      {
        exams.remove(i);
        break;
      }
    }
  }
  public void removeExamByObject(Exam exam){
    for (int i =0; i<this.exams.size();i++)
    {
      if (exams.get(i).equals(exam))
      {
            exams.remove(i);
            break;
      }
    }
  }
  public void removeExamByIndex(int index)
  {
    exams.remove(index);
  }
  public Exam getExam(int index)
  {
    return exams.get(index);
  }
  public DateAndTimePeriod getPeriodOfTheExamByIndex(int i)
  {
    return exams.get(i).getPeriodOfExam();
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
  public Exam getExamByName(String name)
  {
    for (int i=0; i<exams.size();i++)
    {
      if (exams.get(i).getExamName().equals(name))
        return exams.get(i);
    }
    return null;
  }
  public int getIndexOfExamByName(String name)
  {
    for (int i=0; i<exams.size();i++)
    {
      if (exams.get(i).getExamName().equals(name))
        return i;
    }
    return -1;
  }
}
