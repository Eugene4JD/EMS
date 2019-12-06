package model;

public interface EMSModel
{
   void addStudent (String name, int id, int Semester);
   void addTeacher (String name, int id, String subject);
   void addRoom (String roomName, boolean isThereProjector, int maxNumberOfStudents);
   void addExam(Exam exam);
   void addClass(String ClassName, TeacherList Teachers, StudentList Students);
   void removeExam(DateAndTimePeriod period);
}
