package model;

import java.io.*;

import mediator.Binary;
import mediator.PersistenceBinary;
import mediator.PersistenceXML;
import mediator.XML;

public class EMSModelManager implements EMSModel,Serializable
{
  private PersistenceXML xmlModel;
  private PersistenceBinary BinaryModel;
  private StudentList students;
  private TeacherList teachers;
  private ClassList classes;
  private ExamList exams;
  private RoomList rooms;
  private boolean loggedIn;

  public EMSModelManager()
  {
    loggedIn = false;
    students = new StudentList();
    teachers = new TeacherList();
    classes = new ClassList();
    exams = new ExamList();
    rooms = new RoomList();
    BinaryModel = new Binary();
    xmlModel = new XML();
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
      int numberOfChairs, int numberOfTables, String canBeMerged)
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
    writeToBinary(new File("Students.bin"));
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
        BinaryModel.save(file,classes);
        break;
      case ("Exams.bin"):
        BinaryModel.save(file,exams);
        break;
      case ("Rooms.bin"):
        BinaryModel.save(file,rooms);
        break;
      case ("Students.bin"):
        BinaryModel.save(file,students);
        break;
      case ("Teachers.bin"):
        BinaryModel.save(file,teachers);
    }
  }
  @Override public void readFromBinary(File file)
  {
    switch (file.getName())
    {
      case ("Classes.bin"):
        this.classes = (ClassList) BinaryModel.update(file);
        break;
      case ("Exams.bin"):
        this.exams = (ExamList) BinaryModel.update(file);
        break;
      case ("Rooms.bin"):
        this.rooms = (RoomList) BinaryModel.update(file);
        break;
      case ("Students.bin"):
        this.students = (StudentList) BinaryModel.update(file);
        break;
      case ("Teachers.bin"):
        this.teachers = (TeacherList) BinaryModel.update(file);
    }

  }

  @Override public Class getClassByClassName(String name)
  {
    return classes.getClassByClassName(name);
  }

  @Override public String showStudents()
  {
    return students.showAllStudents();
  }

  @Override public String showAllClasses()
  {
    return classes.showAllClasses();
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
        this.classes = (ClassList) BinaryModel.delete(file,classes);
        break;
      case ("Exams.bin"):
        this.exams = (ExamList) BinaryModel.delete(file,exams);
        break;
      case ("Rooms.bin"):
        this.rooms = (RoomList) BinaryModel.delete(file,rooms);
        break;
      case ("Students.bin"):
        this.students = (StudentList) BinaryModel.delete(file,students);
        break;
      case ("Teachers.bin"):
        this.teachers = (TeacherList) BinaryModel.delete(file,teachers);
    }
   
  }

  @Override public void writeToXMl(File XMLFile)
  {
    xmlModel.save(XMLFile,exams);
  }
}

