package Model;

public class Exam
{
  private String examName;
  private ClassList examClasses;
  private DateAndTimePeriod periodOExam;
  private RoomList examRooms;

  public Exam(String examName, Date  DateOfTheExam, Time startTime, Time endTime)
  {
    this.examName = examName;
    examClasses = new ClassList();
    periodOExam = new DateAndTimePeriod(DateOfTheExam, startTime, endTime);
    examRooms = new RoomList();
  }

  public void addClasses(ClassList examClasses)
  {
    this.examClasses = examClasses;
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
  public void removeRoomByIndex(int index)
  {
    examRooms.removeRoom(index);
  }
  public void removeAllRooms()
  {
    examRooms.removeAll();
  }

  public String toString()
  {
    String str = "";
    if (examClasses.getNumberOfClasses() > 0)
      str+=examClasses.getClassByIndex(0).getClassName();
    for (int i = 1; i< examClasses.getNumberOfClasses(); i++)
    {
      str+="-"+examClasses.getClassByIndex(i);
    }
    return str;
  }

  public boolean equals(Object object)
  {
    if (!(object instanceof Exam ))
      return false;
    Exam other = (Exam) object;
    return other.examClasses.equals(this.examClasses)
        && other.examRooms.equals(this.examRooms)
        && other.periodOExam.equals(this.periodOExam);
  }

  public DateAndTimePeriod getPeriodOExam()
  {
    return this.periodOExam;
  }


}
