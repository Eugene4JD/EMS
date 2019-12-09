package model;

import java.io.*;

import mediator.Binary;
import mediator.Persistence;

public class EMSModelManager implements EMSModel,Serializable
{
  private Persistence preModel;
  private StudentList students;
  private TeacherList teachers;
  private ClassList classes;
  private ExamList exams;
  private RoomList rooms;

  public EMSModelManager()
  {
    loggedIn = false;
    students = new StudentList();
    teachers = new TeacherList();
    classes = new ClassList();
    exams = new ExamList();
    rooms = new RoomList();
    preModel = new Binary();
  }

  @Override public boolean isLoggedIn()
  {
    return loggedIn;
  }

  @Override public void validateSecretCode(String secretCode)
  {
    if (secretCode.equals("qwerty123"))
    {
      loggedIn = true;
    }
    else
    {
      throw new IllegalArgumentException("Wrong secret code!");
    }
  }

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

  @Override public void addStudent(String name, int id, int semester)
  {
    students.addStudent(new Student(name, id, semester));
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

  @Override public void removeStudent(int id)
  {
    students.removeStudentById(id);
  }

  @Override public void removeTeacher(String initials)
  {
    teachers.removeTeacherByInitials(initials);
  }

  @Override public void removeRoom(String roomName)
  {
    rooms.removeRoomByRoomName(roomName);
  }

  @Override public void writeToBinary(File file)
  {
    switch (file.getName())
    {
      case ("Classes.bin"):
        preModel.save(file,classes);
        break;
      case ("Exams.bin"):
        preModel.save(file,exams);
        break;
      case ("Rooms.bin"):
        preModel.save(file,rooms);
        break;
      case ("Students.bin"):
        preModel.save(file,students);
        break;
      case ("Teachers.bin"):
        preModel.save(file,teachers);
    }
  }
  @Override public void readFromBinary(File file)
  {
    switch (file.getName())
    {
      case ("Classes.bin"):
        this.classes = (ClassList) preModel.update(file);
        break;
      case ("Exams.bin"):
        this.exams = (ExamList) preModel.update(file);
        break;
      case ("Rooms.bin"):
        this.rooms = (RoomList) preModel.update(file);
        break;
      case ("Students.bin"):
        this.students = (StudentList) preModel.update(file);
        break;
      case ("Teachers.bin"):
        this.teachers = (TeacherList) preModel.update(file);
    }

  }

  @Override public String showStudents()
  {
    return students.showAllStudents();
  }

  @Override public String showRooms()
  {
    return rooms.showAllRooms();
  }

  @Override public String showTeachers()
  {
    return teachers.showAllTeachers();
  }

  @Override public void clearFile(File file)
  {
    switch (file.getName())
    {
      case ("Classes.bin"):
        this.classes = (ClassList) preModel.delete(file,classes);
        break;
      case ("Exams.bin"):
        this.exams = (ExamList) preModel.delete(file,exams);
        break;
      case ("Rooms.bin"):
        this.rooms = (RoomList) preModel.delete(file,rooms);
        break;
      case ("Students.bin"):
        this.students = (StudentList) preModel.delete(file,students);
        break;
      case ("Teachers.bin"):
        this.teachers = (TeacherList) preModel.delete(file,teachers);
    }
   
  }
}

