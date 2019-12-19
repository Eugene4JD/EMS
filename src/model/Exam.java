package model;

import java.io.Serializable;

/**
 * A class representing Exam
 * @version v1.1
 * @author Group 5
 *
 */
public class Exam implements Serializable
{
  private String examName;
  private ClassList examClasses;
  private TeacherList examTeachers;
  private DateAndTimePeriod periodOfExam;
  private RoomList examRooms;
  private String description;

  /**
   * A 7 arguments constructor . If the exam name equals to empty String , or classes list is empty , or if start time is after the end time
   * or more than one class selected for the exam, or teacher list is empty , or room list is empty it will throw Illegal argument exception
   * @param examName
   *   String examName
   * @param dateOfTheExam
   *    Date dateOfTheExam
   * @param startTime
   *    Time startTime
   * @param endTime
   *    Time endTime
   * @param classes
   *    ClassList classes
   * @param teachers
   *    TeacherList teachers
   * @param rooms
   *    RoomList rooms
   */
  public Exam(String examName, Date dateOfTheExam, Time startTime, Time endTime, ClassList classes, TeacherList teachers, RoomList rooms)
  {
    if (examName.equals(""))
      throw new IllegalArgumentException("wrong Exam name");
    if (endTime.isBefore(startTime))
      throw new IllegalArgumentException("wrong Time input(End Time should be after Start Time)");
    if (classes.size() == 0)
      throw new IllegalArgumentException("no class has been selected");
    if (classes.size() > 1)
      throw  new IllegalArgumentException("You must select only one class for the exam");
    if (teachers.size() == 0)
      throw new IllegalArgumentException("no teachers has been selected");
    if (rooms.size() == 0)
      throw new IllegalArgumentException("no rooms has been selected");
    this.examName = examName;
    examClasses = classes;
    periodOfExam = new DateAndTimePeriod(dateOfTheExam, startTime, endTime);
    examRooms = rooms;
    examTeachers = teachers;
  }

  /**
   *
   * @return
   *   returns the name of the exam
   */
  public String getExamName()
  {
    return examName;
  }

  /**
   * returns the room list of the exam
   * @return
   */
  public RoomList getExamRooms()
  {
    return examRooms;
  }

  /**
   *
   * @return
   * returns the teacher list of this exam
   */
  public TeacherList getExamTeachers()
  {
    return examTeachers;
  }

  /**
   *
   * @return
   * returns the Classes list of this exam
   */
  public ClassList getExamClasses()
  {
    return examClasses;
  }

  /**
   *
   * @return
   * return the period object  of the exam
   */
  public DateAndTimePeriod getPeriodOfExam()
  {
    return periodOfExam;
  }

  /**
   *
   * @return
   * the class list of this exam
   */
  public ClassList getClasses()
  {
    return examClasses;
  }

  /**
   *
   * @return
   * the teacher list of this exam
   */
  public TeacherList getTeachers()
  {
    return examTeachers;
  }

  /**
   *
   * @return
   * the room list of this exam
   */
  public RoomList getRooms()
  {
    return examRooms;
  }

  /**
   * sets all of the value of given exam like an argument
   * @param exam
   *   given exam object like an argument
   */
  public void setValueSimilarToExam(Exam exam)
  {
    this.periodOfExam = exam.getPeriodOfExam();
    this.examTeachers = exam.getExamTeachers();
    this.examRooms = exam.getExamRooms();
    this.examClasses = exam.getExamClasses();
    this.examName = exam.getExamName();
  }

  /**
   *
   * @return
   * returns String representation of an exam
   */
  public String toString()
  {
    String str = "";
    if (examClasses.getNumberOfClasses() > 0)
      str += examClasses.getClassByIndex(0).getClassName();
    for (int i = 1; i < examClasses.getNumberOfClasses(); i++)
    {
      str += "-" + examClasses.getClassByIndex(i);
    }
    return str;
  }

  /**
   * equals method
   * @param object
   *   given object
   * @return
   *   return true if the this object is the same as given
   *   and false if is is not
   */
  public boolean equals(Object object)
  {
    if (!(object instanceof Exam))
      return false;
    Exam other = (Exam) object;
    return other.examClasses.equals(this.examClasses) && other.examRooms
        .equals(this.examRooms) && other.periodOfExam.equals(this.periodOfExam);
  }

  /**
   *
   * @return
   *  return more advance String representation of the exam
   */
  public String showScheduleElement()
  {
    String str = "";
    str += this.examName + " " + this.examRooms + " " + this.periodOfExam
        .toString();
    return str;
  }
  public Exam copy()
  {
    return new Exam(this.examName,this.periodOfExam.getDateOfTheExam(),this.getPeriodOfExam().getStartTime(),this.getPeriodOfExam().getEndTime(),this.examClasses,this.examTeachers,this.examRooms);
  }

}
