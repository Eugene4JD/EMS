package model;

import java.io.File;

public interface EMSModel
{
  void validateSecretCode(String secretCode);
  boolean isLoggedIn();
  void addStudent(String name, int id, int semester);
  void addTeacher(String name, String initials, String subject);
  void addRoom(String roomName, String typesOfConnectorsAvailable,
      int maxNumberOfStudents, int numberOfChairs, int numberOfTables,
      String canBeMerged);
  void removeStudent(int id);
  void removeTeacher(String initials);
  void removeRoom(String roomName);
  void addExam(Exam exam);
  void addClass(String ClassName);
  void removeExam(DateAndTimePeriod period);
  Class getClassByClassName(String name);
  String showSchedule();
  void writeToBinary(File BinaryFile);
  void readFromBinary(File BinaryFile);
  String showAllClasses();
  String showStudents();
  String showTeachers();
  String showRooms();
  void clearFile(File BinaryFile);
  void writeToXMl(File XMLFile);
  void removeAllStudents();
  void removeAllRooms();
  void removeAllTeachers();
  void removeAllClasses();
  void removeAllExams();
  void setAllUpToDate();
  void removeAll();
  boolean checkUpdateState(File file);
}
