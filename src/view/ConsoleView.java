package view;

import model.EMSModel;

import java.io.File;
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
    File Classes_bin = new File("Classes.bin");
    File Exams_bin = new File("Exams.bin");
    File Rooms_bin = new File("Rooms.bin");
    File Students_bin = new File("Students.bin");
    File Teachers_bin = new File("Teachers.bin");

    if (Classes_bin.length() != 0)
    {
      model.readFromBinary(Classes_bin);
    }
    if (Exams_bin.length() != 0)
    {
      model.readFromBinary(Exams_bin);
    }
    if (Rooms_bin.length() != 0)
    {
      model.readFromBinary(Rooms_bin);
    }
    if (Students_bin.length() != 0)
    {
      model.readFromBinary(Students_bin);
    }
    if (Teachers_bin.length() != 0)
    {
      model.readFromBinary(Teachers_bin);
    }
    boolean running = true;
    while (running)
    {
      System.out.println("101) Add Student"); //done       //ADD
      System.out.println("102) Add Teacher"); //done       //ADD
      System.out.println("103) Add Room"); //done          //ADD
      System.out.println("201) Remove Student"); //done    //REMOVE
      System.out.println("202) Remove Teacher"); //done    //REMOVE
      System.out.println("203) Remove Room"); //done       //REMOVE
      System.out.println("301) Write to binary"); //done   //WRITE
      System.out.println("401) Read from binary"); //done  //READ
      System.out.println("501) Show all exams");
      System.out.println("601) Show all students");
      System.out.println("701) Show all teachers");
      System.out.println("801) Show all rooms");
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
          model.addStudent(name, Id, semester);
          break;
        case 102:
          System.out.println("teacherName?");
          String name2 = input.nextLine();
          System.out.println("initials?");
          String initials = input.nextLine();
          System.out.println("subject?");
          String subject = input.nextLine();
          model.addTeacher(name2, initials, subject);
          break;
        case 103:
          System.out.println("roomName?");
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
          boolean canBeMerged;
          if (buffer == 0)
            canBeMerged = false;
          else
            canBeMerged = true;
          model.addRoom(roomName, typesOfConnectorsAvailable,
              maxNumberOfStudents, numberOfChairs, numberOfTables, canBeMerged);
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
        case 301:
          System.out.println("binNameW?");
          String binNameW = input.nextLine();
          File file301 = new File(binNameW);
          model.writeToBinary(file301);
          System.out.println("...........Done");
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
        case 601:
          System.out.println(model.showStudents());
          break;
        case 701:
          System.out.println(model.showTeachers());
          break;
        case 801:
          System.out.println(model.showRooms());
          break;
        case 0:
          model.writeToBinary(Classes_bin);
          model.writeToBinary(Exams_bin);
          model.writeToBinary(Rooms_bin);
          model.writeToBinary(Students_bin);
          model.writeToBinary(Teachers_bin);
          running = false;
          break;
        default:
          System.out.println("The wrong input, please re enter the value!");
      }
    }

  }
}
