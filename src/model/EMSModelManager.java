package model;

public class EMSModelManager implements model.EMSModel
{

  private StudentList students;
  private TeacherList teachers;
  private ClassList classes;
  private ExamList exams;
  private RoomList rooms;

  @Override public void addClass(String ClassName, TeacherList Teachers,
      StudentList Students) //????/////
  {
    Class newClass = new Class(ClassName);
    for (int i = 0; i < Teachers.getNumberOfTeachers(); i++)
    {
      newClass.addTeacher(Teachers.getTeacherByIndex(i));
    }
    for (int i = 0; i < Students.getNumberOfStudents(); i++)
    {
      newClass.addStudent(Students.getStudentById(i));

    }
  }

  @Override public void addExam(Exam exam)
  {
    if (exams.isExamLegitToBeCreated(exam))
      exams.addExam(exam);
  }

  @Override public void addRoom(String roomName,
      String typesOfConnectorsAvailable, int maxNumberOfStudents,
      int numberOfChairs, int numberOfTables, boolean canBeMerged)
  {
    if (!rooms.isRoomExists(
        new Room(roomName, typesOfConnectorsAvailable, maxNumberOfStudents,
            numberOfChairs, numberOfTables, canBeMerged)))
    {
      rooms.addRoom(
          new Room(roomName, typesOfConnectorsAvailable, maxNumberOfStudents,
              numberOfChairs, numberOfTables, canBeMerged));
    }
  }

  @Override public void addStudent(String name, int id, int Semester)
  {
    if (!students.isStudentExist(new Student(name, id, Semester)))
      students.addStudent(new Student(name, id, Semester));
  }

  @Override public void addTeacher(String name, String initials, String subject)
  {
    if (!teachers.isTeacherExist(new Teacher(name, initials, subject)))
      teachers.addTeacher(new Teacher(name, initials, subject));
  }

  @Override public void removeExam(DateAndTimePeriod period)
  {
    exams.removeExam(period);
  }

  @Override public String showSchedule()
  {
    return exams.toString();
  }
}
