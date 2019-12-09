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
      System.out.println("8) Show all grades");
      System.out.println("9) read from text File");
      System.out.println("10) write to the text File");
      System.out.println("11) remove from memory all the grades");
      System.out.println("0) QUIT");

      System.out.print("\nEnter choice: ");
      int choice = input.nextInt();
      switch (choice)
      {
        case 101:
          System.out.println("Enter the Student Name:");
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
        case 0:
          running = false;
          break;
        default:
          System.out.println("The wrong input, please re enter the value!");
      }
    }

  }
}
