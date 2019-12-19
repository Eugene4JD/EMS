package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing the list of exams
 * @version v1.1
 * @author Group 5
 *
 */
public class ExamList implements Serializable
{

  private ArrayList<Exam> exams;

  /**
   * zero-argument, initialising the exams array list
   */
  public ExamList()
  {
    exams = new ArrayList<>();
  }

  /**
   * method which checks if exam is legit to be created , if exam which trying to add to the
   * exam list is the same with any other which are already in the list wil throw the Illegal argument exception
   * if the  argument exam period is on conflict with any exam in the list and:
   *   - this exams have at least one same teacher
   *   - this exams have the same rooms or at least one same room
   *   - this exams have the at least one same class
   *   will throw illegal argument exception
   *
   * @param exam
   *   given as argument other exam
   * @return
   */
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

  /**
   * adding exam to the list which is given as argument
   * @param exam
   *   exam object
   */
  public void addExam(Exam exam)
  {
    if (isExamLegitToBeCreated(exam))
      exams.add(exam);
  }

  /**
   * removing and exam from the list by given period
   * @param period
   *   given period object
   */
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

  /**
   * remove exam by exam
   * @param exam
   *   given exam as an argument
   */
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

  /**
   * removes exam with the given index
   * @param index
   *  int index
   */
  public void removeExamByIndex(int index)
  {
    exams.remove(index);
  }

  /**
   * get exam by given index in the list
   * @param index
   *    int index
   * @return
   *   exam object
   */
  public Exam getExam(int index)
  {
    return exams.get(index);
  }

  /**
   * get Date and Time Period object in the list by index of the exam in the list
   * @param i
   *    i index
   * @return
   *  Date and Time period object
   */
  public DateAndTimePeriod getPeriodOfTheExamByIndex(int i)
  {
    return exams.get(i).getPeriodOfExam();
  }

  /**
   * get Number of Exams in the list
   * @return
   *   list size
   */
  public int getNumberOfExams()
  {
    return exams.size();
  }

  /**
   *
   * @return
   *  String representation of the examList
   */
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

  /**
   * get the exam by the exam name
   * @param name
   *  String exam name
   * @return
   *   Exam object or null if there isn't such an object
   */
  public Exam getExamByName(String name)
  {
    for (int i=0; i<exams.size();i++)
    {
      if (exams.get(i).getExamName().equals(name))
        return exams.get(i);
    }
    return null;
  }

  /**
   * get the index of the Exam by name
   * @param name
   *   String name
   * @return
   *   index of the exam
   *
   */
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
