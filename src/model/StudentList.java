package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of students
 *
 * @author Group 5
 * @version v1.1
 */
public class StudentList implements Serializable
{
  private ArrayList<Student> students;

  /**
   * An 0-arg constructor
   * only initializes the list
   */
  public StudentList()
  {
    students = new ArrayList<>();
  }

  /**
   * checks if the student is in the list
   * @param student a student object
   * @return true if the student is in the list
   */
  public boolean isStudentExist(Student student)
  {
    for (int i = 0; i < students.size(); i++)
    {
      if (students.get(i).equals(student))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * add the student to the list
   * @param student a student object
   */
  public void addStudent(Student student)
  {
    if (!(isStudentExist(student)))
      students.add(student);
  }

  /**
   * returns the index of the student based on his id
   * @param id if of the student
   * @return the index of the student in the list
   */
  public int getIndexOfStudentById(int id)
  {
    for (int i = 0; i < students.size(); i++)
    {
      if (students.get(i).getId() == id)
        return i;
    }
    return -1;
  }

  /**
   * removes the student from the list based on his id
   * @param index the index of the student
   */
  public void removeStudentByIndex(int index)
  {
    students.remove(index);
  }

  /**
   *
   * @return the number of students in the list
   */
  public int size()
  {
    return students.size();
  }

  /**
   * removes the student based on his id
   * @param id the id of the student
   */
  public void removeStudentById(int id)
  {
    if (getIndexOfStudentById(id) != -1)
    {
      students.remove(getIndexOfStudentById(id));
    }
  }

  /**
   * removes the student from the list based on the object
   * @param student a student object
   */
  public void removeStudentByObject(Student student)
  {
      students.remove(student);
  }

  /**
   * returns the the student object based on his index in the list
   * @param index the index of the student in the list
   * @return a student object
   */
  public Student getStudentByIndex(int index)
  {
    return students.get(index);
  }

  /**
   * @return returns the number of students in the list
   */
  public int getNumberOfStudents()
  {
    return students.size();
  }

  /**
   *
   * @return returns the arrayList of the students
   */
  public ArrayList<Student> getStudents()
  {
    return students;
  }

  /**
   * checks of 2 student objects are similar
   * @param object a student object
   * @return true if the objects are similar
   */
  public boolean equals(Object object)
  {
    if (!(object instanceof StudentList))
      return false;
    StudentList other = (StudentList) object;
    if (other.getNumberOfStudents() != this.getNumberOfStudents())
      return false;
    for (int i = 0; i < this.getNumberOfStudents(); i++)
    {
      if (!(this.getStudentByIndex(i)).equals(other.getStudentByIndex(i)))
        return false;
    }
    return true;
  }

  /**
   *
   * @return a string with all students
   */
  public String showAllStudents()
  {
    String str = "";
    for (int i = 0; i < students.size(); i++)
    {
      str += students.get(i).toString() + "\n";
    }
    return str;
  }

  /**
   *
   * @return a copy of the student object
   */
  public StudentList copy()
  {
    StudentList other = new StudentList();
    for (int i=0;i<students.size();i++)
      other.addStudent(students.get(i));
    return other;
  }

  /**
   *
   * @return a string of all students
   */
  public String toString()
  {
     String str ="";
     for (int i =0 ; i< students.size(); i++)
     {
       str+=students.get(i).toString()+"\n";
     }
     return str;
  }

  /**
   *
   * @return true if all students in the list are in the same semester
   */
  public boolean areAllStudentsInTheSameSemester()
  {
    int semester = students.get(0).getSemester();
    for (int i =1; i<students.size(); i++)
    {
      if (students.get(i).getSemester() != semester)
        return false;
    }
    return true;
  }
}
