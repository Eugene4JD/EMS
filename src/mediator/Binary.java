package mediator;

import model.*;
import model.Class;

import java.io.*;

public class Binary implements PersistenceBinary
{
  @Override public Object update(File file)
  {
    if (file.length() != 0)
    {
      ObjectInputStream in = null;
      switch (file.getName())
      {
        case ("Classes.bin"):
          ClassList classes = new ClassList();
          try
          {
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            int count = in.readInt();
            for (int i = 0; i < count; i++)
            {
              classes.addClass((Class) in.readObject());
            }
          }
          catch (IOException | ClassNotFoundException e)
          {
            e.printStackTrace();
          }
          finally
          {
            try
            {
              if (in != null)
              {
                in.close();
              }
              return classes;
            }
            catch (IOException exception)
            {
              // Output unexpected IOExceptions.
              exception.printStackTrace();
            }
          }
          break;
        case ("Exams.bin"):
          ExamList exams = new ExamList();
          try
          {
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            int count = in.readInt();
            for (int i = 0; i < count; i++)
            {
              exams.addExam((Exam) in.readObject());
            }
          }
          catch (IOException | ClassNotFoundException e)
          {
            e.printStackTrace();
          }
          finally
          {
            try
            {
              if (in != null)
              {
                in.close();
              }
              return exams;
            }
            catch (IOException exception)
            {
              // Output unexpected IOExceptions.
              exception.printStackTrace();
            }
          }
          break;
        case ("Rooms.bin"):
          RoomList rooms = new RoomList();
          try
          {

            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            int count = in.readInt();
            for (int i = 0; i < count; i++)
            {
              rooms.addRoom((Room) in.readObject());
            }
          }
          catch (IOException | ClassNotFoundException e)
          {
            e.printStackTrace();
          }
          finally
          {
            try
            {
              if (in != null)
              {
                in.close();
              }
              return rooms;
            }
            catch (IOException exception)
            {
              // Output unexpected IOExceptions.
              exception.printStackTrace();
            }
          }
          break;
        case ("Students.bin"):
          StudentList students = new StudentList();
          try
          {
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            int count = in.readInt();
            for (int i = 0; i < count; i++)
            {
              students.addStudent((Student) in.readObject());
            }
          }
          catch (IOException | ClassNotFoundException e)
          {
            e.printStackTrace();
          }
          finally
          {
            try
            {
              if (in != null)
              {
                in.close();
              }
              return students;
            }
            catch (IOException exception)
            {
              // Output unexpected IOExceptions.
              exception.printStackTrace();
            }
          }
          break;
        case ("Teachers.bin"):
          TeacherList teachers = new TeacherList();
          try
          {
            FileInputStream fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);

            int count = in.readInt();
            for (int i = 0; i < count; i++)
            {
              teachers.addTeacher((Teacher) in.readObject());
            }
          }
          catch (IOException | ClassNotFoundException e)
          {
            e.printStackTrace();
          }
          finally
          {
            try
            {
              if (in != null)
              {
                in.close();
              }
              return teachers;
            }
            catch (IOException exception)
            {
              // Output unexpected IOExceptions.
              exception.printStackTrace();
            }
          }
          break;
        default:
          System.out.println("Such file is not existing");
      }
    }
    return null;
  }

  @Override public void save(File file, Object object)
  {
    ObjectOutputStream out = null;
    switch (file.getName())
    {
      case ("Classes.bin"):
        try
        {
          ClassList classes = (ClassList) object;
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(classes.getNumberOfClasses());
          for (int i = 0; i < classes.getNumberOfClasses(); i++)
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
          try
          {
            out.close();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        break;
      case ("Exams.bin"):
        try
        {
          ExamList exams = (ExamList) object;
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(exams.getNumberOfExams());
          for (int i = 0; i < exams.getNumberOfExams(); i++)
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
          try
          {
            out.close();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        break;
      case ("Rooms.bin"):
        try
        {
          RoomList rooms = (RoomList) object;
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(rooms.numberOfRooms());
          for (int i = 0; i < rooms.numberOfRooms(); i++)
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
          try
          {
            out.close();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        break;
      case ("Students.bin"):
        try
        {
          StudentList students = (StudentList) object;
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(students.getNumberOfStudents());
          for (int i = 0; i < students.getNumberOfStudents(); i++)
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
          try
          {
            out.close();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }

        break;
      case ("Teachers.bin"):
        try
        {
          TeacherList teachers = (TeacherList) object;
          FileOutputStream fos = new FileOutputStream(file);
          out = new ObjectOutputStream(fos);

          out.writeInt(teachers.getNumberOfTeachers());
          for (int i = 0; i < teachers.getNumberOfTeachers(); i++)
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
          try
          {
            out.close();
          }
          catch (IOException e)
          {
            e.printStackTrace();
          }
        }
        break;
      default: System.out.println("Such File is No existing");
    }
  }

  @Override public Object delete(File file, Object object)
  {
    switch (file.getName())
    {
      case ("Classes.bin"):
        ClassList classes = (ClassList) object;
        int maxC = classes.getNumberOfClasses();
        for (int i =0; i < maxC ;i++)
        {
          classes.removeClassByIndex(0);
        }
        file.delete();
        File fileC = new File("Classes.bin");
        try
        {
          fileC.createNewFile();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        return classes;
      case("Exams.bin"):
        ExamList exams = (ExamList) object;
        int maxE = exams.getNumberOfExams();
        for (int i =0; i < maxE ;i++)
        {
          exams.removeExamByIndex(0);
        }
        file.delete();
        File fileE = new File("Exams.bin");
        try
        {
          fileE.createNewFile();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        return exams;
      case ("Rooms.bin"):
        RoomList rooms = (RoomList) object;
        int maxR = rooms.numberOfRooms();
        for (int i =0; i < maxR ;i++)
        {
          rooms.removeRoom(0);
        }
        file.delete();
        File fileR = new File("Rooms.bin");
        try
        {
          fileR.createNewFile();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }

        return rooms;
      case("Students.bin"):
        StudentList students = (StudentList) object;
        int maxS = students.getNumberOfStudents();
        for (int i =0; i < maxS ;i++)
        {
          students.removeStudentByIndex(0);
        }
        file.delete();
        File fileS = new File("Students.bin");
        try
        {
          fileS.createNewFile();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        return students;
      case ("Teachers.bin"):
        TeacherList teachers = (TeacherList) object;
        int max = teachers.getNumberOfTeachers();
        for (int i =0; i < max ;i++)
        {
          teachers.removeTeacherByIndex(0);
        }
        file.delete();
        File fileT = new File("Teachers.bin");
        try
        {
          fileT.createNewFile();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        return teachers;
      default: System.out.println("no such file");
    }
  return null;
  }
}
