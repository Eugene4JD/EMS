package view;
import model.EMSModel;

import java.util.Scanner;
public class ConsoleView
{
  private EMSModel model;

  public ConsoleView(EMSModel model){this.model = model;}
  public void start()
  {
    Scanner input = new Scanner(System.in);
    boolean running = true;


    while (running)
    {
      System.out.println("1) Add Student");
      System.out.println("2) Add Teacher");
      System.out.println("3) Add Room");
      System.out.println("4) Add Class");
      System.out.println("5) Add Exam");
      System.out.println("6) Get grade");
      System.out.println("7) Get size");
      System.out.println("8) Show all grades");
      System.out.println("9) read from text File");
      System.out.println("10) write to the text File");
      System.out.println("11) remove from memory all the grades");
      System.out.println("0) QUIT");

      System.out.print("\nEnter choice: ");
      int choice = input.nextInt();
      switch (choice)
      {
        case 1:
          System.out.println("Enter the Student Name:");
          String name = input.nextLine();
          System.out.println("Enter the valid id:");
          int Id = input.nextInt();
          System.out.println("Enter the valid semester:");
          int semester = input.nextInt();
          model.addStudent(name,Id,semester);
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 0:
          running = false;
          break;
        default: System.out.println("The wrong input, please re enter the value!");
      }
    }

  }
}
