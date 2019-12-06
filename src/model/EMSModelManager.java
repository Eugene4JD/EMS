package model;

public class EMSModelManager implements model.EMSModel
{

  private StudentList students;
  private TeacherList teachers;
  private ClassList classes;
  private ExamList exams;
  private RoomList rooms;

  @Override public void addClass(String ClassName, TeacherList Teachers,
      StudentList Students)
  {
    Class newClass = new Class(ClassName);
    for (int i =0; i< Teachers.getNumberOfTeachers(); i++)
    {
      newClass.addTeacher(Teachers.getTeacherById(i));
    }
    for (int i =0; i< Students.getNumberOfStudents();i++)
    {
      newClass.addStudent(Students.getStudentById(i));

      
    }
  }

  @Override public void addExam(Exam exam)
  {
    if (exams.isExamLegitToBeCreated(exam))
       exams.addExam(exam);
  }

  @Override public void addRoom(String roomName, boolean isThereProjector,
      int maxNumberOfStudents)
  {
    if (!rooms.isRoomExisting(new Room(roomName,isThereProjector,maxNumberOfStudents)))
       rooms.addRoom(new Room(roomName,isThereProjector,maxNumberOfStudents));
  }

  @Override public void addStudent(String name, int id, int Semester)
  {
    if (!students.isStudentExist(new Student(name,id,Semester)))
      students.addStudent(new Student(name,id,Semester));
  }

  @Override public void addTeacher(String name, int id, String subject)
  {
    if (!teachers.isTeacherExist(new Teacher(name,id,subject)))
      teachers.addTeacher(new Teacher(name,id,subject));
  }

  @Override public void removeExam(DateAndTimePeriod period)
  {
    exams.removeExam(period);
  }
}
