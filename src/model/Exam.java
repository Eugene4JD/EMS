package model;

import java.io.Serializable;

public class Exam implements Serializable
{
  private String examName;
  private ClassList examClasses;
  private TeacherList examTeachers;
  private DateAndTimePeriod periodOfExam;
  private RoomList examRooms;
  private String description;

/*  public Exam(String examName, Date dateOfTheExam, Time startTime, Time endTime)
  {
    if (examName .equals(""))
      throw new IllegalArgumentException("wrong Exam name");
    this.examName = examName;
    examClasses = new ClassList();
    periodOfExam = new DateAndTimePeriod(dateOfTheExam, startTime, endTime);
    examRooms = new RoomList();
    examTeachers = new TeacherList();
  }

 */
  public Exam(String examName, Date dateOfTheExam, Time startTime, Time endTime, ClassList classes, TeacherList teachers, RoomList rooms)
  {
    if (examName.equals(""))
      throw new IllegalArgumentException("wrong Exam name");
    this.examName = examName;
    examClasses = classes;
    periodOfExam = new DateAndTimePeriod(dateOfTheExam, startTime, endTime);
    examRooms = rooms;
    examTeachers = teachers;
  }
  public String getExamName()
  {
    return examName;
  }
  public String getDescription()
  {
    return description;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }
  public void addClasses(ClassList examClasses)
  {
    this.examClasses = examClasses;
  }
  public void setExamTeachers(TeacherList other)
  {
    this.examTeachers = other;
  }
  public void addTeacher(Teacher other)
  {
    this.examTeachers.addTeacher(other);
  }

  public void addClass(Class classItem)
  {
    examClasses.addClass(classItem);
  }

  public void removeClassByClassName(String className)
  {
    examClasses.removeClassByClassName(className);
  }

  public void removeClassByIndex(int index)
  {
    examClasses.removeClassByIndex(index);
  }

  public void removeAllClasses()
  {
    examClasses.removeAll();
  }

  public void addRooms(RoomList roomList)
  {
    examRooms = roomList;
  }

  public void addRoom(Room room)
  {
    examRooms.addRoom(room);
  }

  public void removeRoomByRoomName(String roomName)
  {
    examRooms.removeRoomByRoomName(roomName);
  }
  public RoomList getExamRooms()
  {
    return examRooms;
  }
  public TeacherList getExamTeachers()
  {
    return examTeachers;
  }
  public ClassList getExamClasses()
  {
    return examClasses;
  }
  public void removeRoomByIndex(int index)
  {
    examRooms.removeRoom(index);
  }

  public void removeAllRooms()
  {
    examRooms.removeAll();
  }

  public DateAndTimePeriod getPeriodOfExam()
  {
    return periodOfExam;
  }
  public ClassList getClasses()
  {
    return examClasses;
  }
  public TeacherList getTeachers()
  {
    return examTeachers;
  }
  public RoomList getRooms()
  {
    return examRooms;
  }


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

  public boolean equals(Object object)
  {
    if (!(object instanceof Exam))
      return false;
    Exam other = (Exam) object;
    return other.examClasses.equals(this.examClasses) && other.examRooms
        .equals(this.examRooms) && other.periodOfExam.equals(this.periodOfExam);
  }

  public DateAndTimePeriod getPeriodOExam()
  {
    return this.periodOfExam;
  }

  public String showScheduleElement()
  {
    String str = "";
    str += this.examName + " " + this.examRooms + " " + this.periodOfExam
        .toString();
    return str;
  }

}
