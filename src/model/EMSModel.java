package model;

import java.io.File;

public interface EMSModel
{
  boolean validateSecretCode(String secretCode);
  boolean isLoggedIn();
  void addStudent(String name, int id, int semester);
  void addTeacher(String name, String initials, String subject);
  Teacher getTeacher(int index);
  void addRoom(String roomName, String typesOfConnectorsAvailable,
      int maxNumberOfStudents, int numberOfChairs, int numberOfTables,
      String canBeMerged);
  void removeStudent(int id);
  void removeStudentByObject(Student student);
  Student getStudent(int index);
  void removeTeacher(String initials);
  void removeTeacherByObject(Teacher teacher);
  void removeRoom(String roomName);
  void removeRoomByObject(Room room);
  Room getRoom(int index);
  void addExam(Exam exam);
  void addClass(String ClassName, TeacherList teachers, StudentList students);
  void removeClassByName(String name);
  void removeExam(DateAndTimePeriod period);
  Class getClassByClassName(String name);
  Room getRoomByRoomName(String name);
  Exam getExamByIndex(int index);
  Exam getExamByName(String name);
  Teacher getTeacherByTeacherName(String name);
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
  int studentListSize();
  int teacherListSize();
  int roomListSize();
  int classListSize();
  int examListSize();
  Class getClass(int index);
  TeacherList getTeacherListCopy();
  StudentList getStudentListCopy();
  RoomList getRoomListCopy();
  ClassList getClassListCopy();
  TeacherList getFreeTeachersFromTheClass();
  StudentList getFreeStudentsFromTheClass();
  void setTempClass(Class tempClass);
  Class getTempClass();
  void setTempExam(Exam tempExam);
  Exam getTempExam();
  void sortedByDateExams();
  void changeSC(String oldSC, String newSC);
  void removeFromExamsByExam(Exam exam);
  void savePassword(String password);
  String getPassword();
}
