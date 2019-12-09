package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

  @Override public void writeToBinary(File file)
  {
    ObjectOutputStream out = null;
    switch (file.getName())
    {
      case("Classes.bin"):
        try
        {
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(classes.getNumberOfClasses());
          for (int i = 0; i<classes.getNumberOfClasses(); i++)
          {
            out.writeObject(classes.getClassByIndex(i));
          }
        }
        catch (IOException e)
        {
          System.out.println("Exception: " + file.getName());
        }
        finally
        {
        }
        try
        {
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        break;
      case("Exams.bin"):
        try
        {
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(exams.getNumberOfExams());
          for (int i = 0; i<exams.getNumberOfExams(); i++)
          {
            out.writeObject(exams.getExam(i));
          }
        }
        catch (IOException e)
        {
          System.out.println("Exception: " + file.getName());
        }
        finally
        {
        }
        try
        {
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        break;
      case("Rooms.bin"):
        try
        {
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(rooms.numberOfRooms());
          for (int i = 0; i<rooms.numberOfRooms(); i++)
          {
            out.writeObject(rooms.getRoomByIndex(i));
          }
        }
        catch (IOException e)
        {
          System.out.println("Exception: " + file.getName());
        }
        finally
        {
        }
        try
        {
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        break;
      case ("Students.bin"):
        try
        {
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(students.getNumberOfStudents());
          for (int i = 0; i<students.getNumberOfStudents(); i++)
          {
            out.writeObject(students.getStudentByIndex(i));
          }
        }
        catch (IOException e)
        {
          System.out.println("Exception: " + file.getName());
        }
        finally
        {
        }
        try
        {
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        break;
      case("Teachers.bin"):
        try
        {
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(teachers.getNumberOfTeachers());
          for (int i = 0; i<teachers.getNumberOfTeachers(); i++)
          {
            out.writeObject(teachers.getTeacherByIndex(i));
          }
        }
        catch (IOException e)
        {
          System.out.println("Exception: " + file.getName());
        }
        finally
        {
        }
        try
        {
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        break;
      default: System.out.println("error");
    }
    }

  }

