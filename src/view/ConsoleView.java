package view;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import model.*;
import model.Class;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ConsoleView
{
  private EMSModel model;

  public ConsoleView(EMSModel model)
  {
    this.model = model;
  }

  public void start()
  {
    Scanner input = new Scanner(System.in);
    model.setAllUpToDate();
    boolean running = true;
    while (running)
    {
      System.out.println("101) Add Student"); //done       //ADD
      System.out.println("102) Add Teacher"); //done       //ADD
      System.out.println("103) Add Room"); //done          //ADD
      System.out.println("104) Add Class");
      System.out.println("105) Add exam");
      System.out.println("201) Remove Student"); //done    //REMOVE
      System.out.println("202) Remove Teacher"); //done    //REMOVE
      System.out.println("203) Remove Room"); //done       //REMOVE
      System.out.println("204) Remove exam");
      System.out.println("205) Remove all rooms");
      System.out.println("210) Remove all");
      System.out.println("301) Write to binary"); //done   //WRITE
      System.out.println("302) Write to XML");
      System.out.println("401) Read from binary"); //done  //READ
      System.out.println("501) Show all exams");
      System.out.println("502) Show all classes");
      System.out.println("601) Show all students");
      System.out.println("701) Show all teachers");
      System.out.println("801) Show all rooms");
      System.out.println("1010) addExam");
      System.out.println("0) QUIT");

      System.out.print("\nEnter choice: ");
      int choice = input.nextInt();
      switch (choice)
      {
        case 101:
          System.out.println("Enter the Student Name:");
          input.nextLine();
          String name = input.nextLine();
          System.out.println("Enter the valid id:");
          int Id = input.nextInt();
          System.out.println("Enter the valid semester:");
          int semester = input.nextInt();
          Student newStudent = new Student(name, Id ,semester);
          model.addStudent(name, Id, semester);
          break;
        case 102:
          System.out.println("teacherName?");
          input.nextLine();
          String name2 = input.nextLine();
          System.out.println("initials?");
          String initials = input.nextLine();
          System.out.println("subject?");
          String subject = input.nextLine();
          Teacher newTeacher = new Teacher (name2, initials, subject);
          model.addTeacher(name2, initials, subject);
          int l = 0;
          while( l == 0 )
          {
            System.out.println(model.showAllClasses());
            System.out.println("Enter the name of the class, to add Teacher to:");
            String className = input.nextLine();
            if (model.getClassByClassName(className) != null)
            {
              model.getClassByClassName(className).addTeacher(newTeacher);
              l = 1;
            }
          }
          break;
        case 103:
          System.out.println("roomName?");
          input.nextLine();
          String roomName = input.nextLine();
          System.out.println("connectorsAvailable?");
          String typesOfConnectorsAvailable = input.nextLine();
          System.out.println("maxNumberOfStudents?");
          int maxNumberOfStudents = input.nextInt();
          System.out.println("numberOfChairs?");
          int numberOfChairs = input.nextInt();
          System.out.println("numberOfTables?");
          int numberOfTables = input.nextInt();
          System.out.println("canBeMerged? (0 or 1)");
          int buffer = input.nextInt();
          String canBeMerged;
          if (buffer == 0)
            canBeMerged = "false";
          else
            canBeMerged = "true";
          model.addRoom(roomName, typesOfConnectorsAvailable,
              maxNumberOfStudents, numberOfChairs, numberOfTables, canBeMerged);
          break;
        case 104:
          System.out.println("Class Name:");
          input.nextLine();
          String className = input.nextLine();
          //model.addClass(className);
          break;
        case 105:
          System.out.println("Enter the date year:");
          input.nextLine();
          System.out.println("Day:");
          int startDay = input.nextInt();
          System.out.println("Month:");
          int startMonth = input.nextInt();
          System.out.println("Year:");
          int startYear = input.nextInt();
          Date startDate = new Date(startDay,startMonth , startYear);
          System.out.println("Enter the start time:");
          System.out.println("Hour:");
          int startHour = input.nextInt();
          System.out.println("Minute:");
          int startMinute = input.nextInt();
          System.out.println("Second:");
          int startSecond = input.nextInt();
          Time startTime = new Time(startHour,startMinute,startSecond);
          System.out.println("Enter the end time:");
          System.out.println("Hour:");
          int endHour = input.nextInt();
          System.out.println("Minute:");
          int endMinute = input.nextInt();
          System.out.println("Second:");
          int endSecond = input.nextInt();
          Time endTime = new Time(endHour,endMinute,endSecond);
          input.nextLine();
          System.out.println("enter Exam Name: ");
          String examName = input.nextLine();
         // model.addExam(new Exam(examName,startDate,startTime,endTime));
          break;

        case 201:
          System.out.println("id?");
          int id4 = input.nextInt();
          model.removeStudent(id4);
          break;
        case 202:
          System.out.println("initials?");
          String initials5 = input.nextLine();
          model.removeTeacher(initials5);
          break;
        case 203:
          System.out.println("roomName?");
          String roomName6 = input.nextLine();
          model.removeRoom(roomName6);
          break;
        case 209:
          model.removeAllExams();
          break;
        case 210:
          model.removeAll();
          break;
        case 401:
          System.out.println("binNameR?");
          String binNameR = input.nextLine();
          File file401 = new File(binNameR);
          model.readFromBinary(file401);
          System.out.println("............Done");
          break;
        case 501:
          System.out.println(model.showSchedule());
          break;
        case 502:
          System.out.println(model.showAllClasses());
          break;
        case 601:
          System.out.println(model.showStudents());
          break;
        case 701:
          System.out.println(model.showTeachers());
          break;
        case 801:
          System.out.println(model.showRooms());
          break;
        case 1010:
          System.out.println("Enter the date year:");
          input.nextLine();
          System.out.println("Day:");
          int startDayTest = input.nextInt();
          System.out.println("Month:");
          int startMonthTest = input.nextInt();
          System.out.println("Year:");
          int startYearTest = input.nextInt();
          Date startDateTest = new Date(startDayTest,startMonthTest , startYearTest);
          System.out.println("Enter the start time:");
          System.out.println("Hour:");
          int startHourTest = input.nextInt();
          System.out.println("Minute:");
          int startMinuteTest = input.nextInt();
          System.out.println("Second:");
          int startSecondTest = input.nextInt();
          Time startTimeTest = new Time(startHourTest,startMinuteTest,startSecondTest);
          System.out.println("Enter the end time:");
          System.out.println("Hour:");
          int endHourTest = input.nextInt();
          System.out.println("Minute:");
          int endMinuteTest = input.nextInt();
          System.out.println("Second:");
          int endSecondTest = input.nextInt();
          Time endTimeTest = new Time(endHourTest,endMinuteTest,endSecondTest);
          input.nextLine();
          System.out.println("enter Exam Name: ");
          String examNameTest = input.nextLine();
          ClassList testClasses = new ClassList();
          int p = 0;
          while( p == 0 )
          {
            System.out.println(model.showAllClasses());
            System.out.println("Enter the name of the class, to add for exam");
            String testClassName = input.nextLine();
            if (model.getClassByClassName(testClassName) != null)
            {
              testClasses.addClass(model.getClassByClassName(testClassName));
              p = 1;
            }
          }
          RoomList testRooms = new RoomList();
          p = 0;
          while (p == 0)
          {
            System.out.println(model.showRooms());
            System.out.println("Enter the name of the Room, to add for exam ");
            String testRoomName = input.nextLine();
            if (model.getRoomByRoomName(testRoomName) != null)
            {
              testRooms.addRoom(model.getRoomByRoomName(testRoomName));
              p = 1;
            }
          }
          TeacherList testTeachers = new TeacherList();
          p = 0;
          while(p == 0)
          {
            System.out.println(model.showTeachers());
            System.out.println("Enter the name of the Teacher, to add for exam");
            String testTeacherName = input.nextLine();
            if (model.getTeacherByTeacherName(testTeacherName) != null)
            {
              testTeachers.addTeacher(model.getTeacherByTeacherName(testTeacherName));
              p=1;
            }
          }
          model.addExam(new Exam(examNameTest, startDateTest, startTimeTest,endTimeTest, testClasses, testTeachers, testRooms));
          break;
        case 1:
          System.out.println(model.getFreeStudentsFromTheClass().toString());
          System.out.println(model.getFreeTeachersFromTheClass().toString());
          break;

        case 0:
          running = false;
          break;
        default:
          System.out.println("The wrong input, please re enter the value!");
      }
    }

  }
}
