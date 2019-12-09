package model;

import java.io.File;

public interface EMSModel
{
  void addStudent(String name, int id, int Semester);
  void addTeacher(String name, String initials, String subject);
  void addRoom(String roomName, String typesOfConnectorsAvailable,
      int maxNumberOfStudents, int numberOfChairs, int numberOfTables,
      boolean canBeMerged);
  void addExam(Exam exam);
  void addClass(String ClassName, TeacherList Teachers, StudentList Students);
  void removeExam(DateAndTimePeriod period);
  String showSchedule();
  void writeToBinary(File file);
  void readFromBinary(File file);
}
