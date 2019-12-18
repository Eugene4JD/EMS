package model;

import java.io.*;
import java.util.Scanner;

import mediator.Binary;
import mediator.PersistenceBinary;
import mediator.PersistenceXML;
import mediator.XML;

public class EMSModelManager implements EMSModel, Serializable
{
  private PersistenceXML xmlModel;
  private PersistenceBinary BinaryModel;
  private StudentList students;
  private TeacherList teachers;
  private ClassList classes;
  private ExamList exams;
  private RoomList rooms;
  private Class tempClass;
  private Exam tempExam;
  private boolean loggedIn;
  private String secretCode;

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
    tempClass = null;
    secretCode = "123";
  }

  @Override public boolean isLoggedIn()
  {
    return loggedIn;
  }

  @Override public void validateSecretCode(String secretCode)
  {
    if (secretCode.equals(this.secretCode))
    {
      loggedIn = true;
    }
    else
    {
      throw new IllegalArgumentException("Wrong secret code!");
    }
  }

  @Override public void addClass(String ClassName, TeacherList teachers,
      StudentList Students) //????/////
  {
    Class newClass = new Class(ClassName, teachers, Students);
    classes.addClass(newClass);
    writeToBinary(new File("Classes.bin"));
  }

  @Override public void addExam(Exam exam)
  {
    if (exams.isExamLegitToBeCreated(exam))
      exams.addExam(exam);
    sortedByDateExams();
  }

  @Override public void addRoom(String roomName,
      String typesOfConnectorsAvailable, int maxNumberOfStudents,
      int numberOfChairs, int numberOfTables, String canBeMerged)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.getRoomByIndex(i).getRoomName().equals(roomName))
        throw new IllegalArgumentException(
            "This room is already in the system");
    }
    rooms.addRoom(
        new Room(roomName, typesOfConnectorsAvailable, maxNumberOfStudents,
            numberOfChairs, numberOfTables, canBeMerged));
    writeToBinary(new File("Rooms.bin"));
  }

  @Override public void addStudent(String name, int id, int semester)
  {

    for (int i = 0; i < students.getNumberOfStudents(); i++)
    {
      if (students.getStudentByIndex(i).getId() == id)
      {
        throw new IllegalArgumentException("This Id is already used");
      }
    }
    students.addStudent(new Student(name, id, semester));
    writeToBinary(new File("Students.bin"));
  }

  @Override public void addTeacher(String name, String initials, String subject)
  {
    for (int i = 0; i < teachers.getNumberOfTeachers(); i++)
    {
      if (teachers.getTeacherByIndex(i)
          .equals(new Teacher(name, initials, subject)))
        throw new IllegalArgumentException("Teacher already in the system");
    }
    teachers.addTeacher(new Teacher(name, initials, subject));
    writeToBinary(new File("Teachers.bin"));
  }

  @Override public void removeExam(DateAndTimePeriod period)
  {
    exams.removeExam(period);
    writeToBinary(new File("Exams.bin"));
  }

  @Override public String showSchedule()
  {
    return exams.toString();
  }

  @Override public void removeStudent(int id)
  {
    students.removeStudentById(id);
    writeToBinary(new File("Students.bin"));
  }

  @Override public void removeStudentByObject(Student student)
  {
    students.removeStudentByObject(student);
  }

  @Override public Student getStudent(int index)
  {
    Student buffer = students.getStudentByIndex(index);
    return buffer;
  }

  @Override public Teacher getTeacher(int index)
  {
    Teacher buffer = teachers.getTeacherByIndex(index);
    return buffer;
  }

  @Override public void removeTeacher(String initials)
  {
    teachers.removeTeacherByInitials(initials);
    writeToBinary(new File("Teachers.bin"));
  }

  @Override public void removeTeacherByObject(Teacher teacher)
  {
    teachers.removeTeacherByObject(teacher);
  }

  @Override public void removeRoom(String roomName)
  {
    rooms.removeRoomByRoomName(roomName);
    writeToBinary(new File("Rooms.bin"));
  }

  @Override public void writeToBinary(File file)
  {
    switch (file.getName())
    {
      case ("Classes.bin"):
        BinaryModel.save(file, classes);
        break;
      case ("Exams.bin"):
        BinaryModel.save(file, exams);
        break;
      case ("Rooms.bin"):
        BinaryModel.save(file, rooms);
        break;
      case ("Students.bin"):
        BinaryModel.save(file, students);
        break;
      case ("Teachers.bin"):
        BinaryModel.save(file, teachers);
    }
  }

  @Override public void readFromBinary(File file)
  {
    if (BinaryModel.update(file) != null)
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

  }

  @Override public Teacher getTeacherByTeacherName(String name)
  {
    return teachers.getTeacherByName(name);
  }

  @Override public Room getRoomByRoomName(String name)
  {
    return rooms.getRoomByRoomName(name);
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
        this.classes = (ClassList) BinaryModel.delete(file, classes);
        break;
      case ("Exams.bin"):
        this.exams = (ExamList) BinaryModel.delete(file, exams);
        break;
      case ("Rooms.bin"):
        this.rooms = (RoomList) BinaryModel.delete(file, rooms);
        break;
      case ("Students.bin"):
        this.students = (StudentList) BinaryModel.delete(file, students);
        break;
      case ("Teachers.bin"):
        this.teachers = (TeacherList) BinaryModel.delete(file, teachers);
    }

  }

  @Override public void writeToXMl(File XMLFile)
  {
    xmlModel.save(XMLFile, exams);
  }

  @Override public void removeAllClasses()
  {
    clearFile(new File("Classes.bin"));
  }

  @Override public void removeAllExams()
  {
    clearFile(new File("Exams.bin"));
    writeToXMl(new File("exams.xml"));
  }

  @Override public void removeAllRooms()
  {
    clearFile(new File("Rooms.bin"));
  }

  @Override public void removeAllStudents()
  {
    clearFile(new File("Students.bin"));
  }

  @Override public void removeAllTeachers()
  {
    clearFile(new File("Teachers.bin"));
  }

  @Override public void setAllUpToDate()
  {
    File Classes_bin = new File("Classes.bin");
    File Exams_bin = new File("Exams.bin");
    File Rooms_bin = new File("Rooms.bin");
    File Students_bin = new File("Students.bin");
    File Teachers_bin = new File("Teachers.bin");
    File examsXML = new File("exams.xml");

    if (checkUpdateState(Classes_bin))
    {
      readFromBinary(Classes_bin);
    }
    if (checkUpdateState(Exams_bin))
    {
      readFromBinary(Exams_bin);
    }
    if (checkUpdateState(Rooms_bin))
    {
      readFromBinary(Rooms_bin);
    }
    if (checkUpdateState(Students_bin))
    {
      readFromBinary(Students_bin);
    }
    if (checkUpdateState(Teachers_bin))
    {
      readFromBinary(Teachers_bin);
    }
  }

  @Override public void removeAll()
  {
    removeAllRooms();
    removeAllExams();
    removeAllClasses();
    removeAllStudents();
    removeAllTeachers();
  }

  @Override public boolean checkUpdateState(File file)
  {
    if (file.length() > 0)
      return true;
    else
      return false;
  }

  @Override public int studentListSize()
  {
    return students.size();
  }

  @Override public int teacherListSize()
  {
    return teachers.size();
  }

  @Override public int roomListSize()
  {
    return rooms.size();
  }

  @Override public Room getRoom(int index)
  {
    return rooms.getRoomByIndex(index);
  }

  @Override public void removeRoomByObject(Room room)
  {
    rooms.removeRoomByObject(room);
  }

  @Override public int classListSize()
  {
    return classes.size();
  }

  @Override public Class getClass(int index)
  {
    return classes.getClassByIndex(index);
  }

  @Override public void removeClassByName(String name)
  {
    classes.removeClassByClassName(name);
    writeToBinary(new File("Classes.bin"));
  }

  @Override public TeacherList getTeacherListCopy()
  {
    return teachers.copy();
  }

  @Override public StudentList getStudentListCopy()
  {
    return students.copy();
  }

  @Override public StudentList getFreeStudentsFromTheClass()
  {
    if (classes.size() == 0)
      return getStudentListCopy();
    StudentList freeStudents = new StudentList();
    boolean isFree = true;
    for (int i = 0; i < students.getNumberOfStudents(); i++)
    {
      isFree = true;
      for (int j = 0; j < classes.getNumberOfClasses(); j++)
      {
        if (classes.getClassByIndex(j).getStudents()
            .isStudentExist(students.getStudentByIndex(i)))
          isFree = false;
      }
      if (isFree)
        freeStudents.addStudent(students.getStudentByIndex(i));
    }
    return freeStudents;
  }

  @Override public TeacherList getFreeTeachersFromTheClass()
  {
    if (classes.size() == 0)
      return getTeacherListCopy();
    TeacherList freeTeachers = new TeacherList();
    boolean isFree = true;
    for (int i = 0; i < teachers.getNumberOfTeachers(); i++)
    {
      for (int j = 0; j < classes.getNumberOfClasses(); j++)
      {
        if (classes.getClassByIndex(j).getTeachers()
            .isTeacherExist(teachers.getTeacherByIndex(i)))
          isFree = false;
      }
      if (isFree)
        freeTeachers.addTeacher(teachers.getTeacherByIndex(i));
      isFree = true;
    }
    return freeTeachers;
  }

  @Override public void setTempClass(Class tempClass)
  {
    this.tempClass = tempClass;
  }

  @Override public Class getTempClass()
  {
    return tempClass;
  }
  @Override public void sortedByDateExams()
  {
    Exam buffer;
    for (int i = 0; i<exams.getNumberOfExams(); i++)
    {
      for (int j = i; j < exams.getNumberOfExams() - 1; j++)
        if (exams.getExam(j+1).getPeriodOfExam().isBefore(exams.getExam(j).getPeriodOfExam()))
        {
          buffer = exams.getExam(j).copy();
          exams.getExam(j).setValueSimilarToExam(exams.getExam(j + 1));
          exams.getExam(j + 1).setValueSimilarToExam(buffer);
        }
    }
    writeToBinary(new File("Exams.bin"));
    writeToXMl(new File("exams.xml"));
  }

  @Override public Exam getTempExam()
  {
    return tempExam;
  }

  @Override public ClassList getClassListCopy()
  {
    return classes.copy();
  }

  @Override public RoomList getRoomListCopy()
  {
    return rooms.copy();
  }

  @Override public int examListSize()
  {
    return exams.getNumberOfExams();
  }

  @Override public Exam getExamByIndex(int index)
  {
    return exams.getExam(index);
  }

  @Override public Exam getExamByName(String name)
  {
    return exams.getExamByName(name);
  }

  @Override public void setTempExam(Exam tempExam)
  {
    this.tempExam = tempExam;
  }
  @Override public void changeSC(String oldSC, String newSC)
  {
    if (oldSC.equals(this.secretCode))
    {
      this.secretCode = newSC;
    }
    else
      throw new IllegalArgumentException("Wrong old SC!");
  }
  @Override public void removeFromExamsByExam(Exam exam)
  {
    exams.removeExamByIndex(exams.getIndexOfExamByName(exam.getExamName()));
    writeToBinary(new File("Exams.bin"));
    writeToXMl(new File("exams.xml"));
  }

  @Override public String getPassword()
  {
    try
    {
      Scanner in = new Scanner(new File("Password.txt"));

      while (in.hasNext())
      {
        String line = in.nextLine().trim();
        this.secretCode = line;
        System.out.println(line);
        System.out.println(secretCode);
      }
      in.close();
    }
    catch (IOException e)
    {
      System.out.println("Error");
    }
    return null;
  }

    @Override public void savePassword (String password)
    {
      try
      {
        PrintWriter out = new PrintWriter(new File("Password.txt"));
        out.write(password);
        out.flush();
        out.close();
        System.out.println("End writing data to file");
        out.close();
      }
      catch (IOException e)
      {
        System.out.println("Error");
      }
    }
  }

