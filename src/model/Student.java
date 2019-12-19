package model;

/**
 * A class representing a student
 *
 * @author Group 5
 * @version v1.1
 */
import java.io.Serializable;

public class Student implements Serializable
{
  private String name;
  private int id;
  private int semester;

  /**
   * A 3-argument constructor which initializes the instance variables of name, id, semester.
   * it throws a mistake if the name is an empty string/ the id is <0/ the semester is an int out of [1-7]
   * @param name name of the student
   * @param id id of the student
   * @param semester number of the semester
   */
  public Student(String name, int id, int semester)
  {
    if (name.equals(""))
      throw new IllegalArgumentException("wrong name");
    else
      this.name = name;
    if (id < 0)
      throw new IllegalArgumentException("Wrong Id");
    else
      this.id = id;
    if (semester < 1 || semester > 7)
      throw new IllegalArgumentException("Wrong semester");
    else
      this.semester = semester;
  }

  /**
   *
   * @return the id of the student
   */
  public int getId()
  {
    return id;
  }

  /**
   *
   * @return the semester of the student
   */
  public int getSemester()
  {
    return semester;
  }

  /**
   *
   * @return the name of a student
   */
  public String getName()
  {
    return name;
  }

  /**
   *
   * @param id the id of the student
   */
  public void setId(int id)
  {
    this.id = id;
  }

  /**
   *
   * @param name the name of the student
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   *
   * @param semester the semester of the student
   */
  public void setSemester(int semester)
  {
    this.semester = semester;
  }

  /**
   * Returns the string in the format: Name "ID": id "Semester": semester
   * @return the string
   */
  public String toString()
  {
    return getName() + " ID: " + getId() + " semester: " + getSemester();
  }

  /**
   * checks if the students are similar
   * @param obj student object
   * @return true if objects are similar
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Student))
      return false;
    Student other = (Student) obj;
    return (other.getSemester() == this.getSemester() && other.getId() == this
        .getId() && other.getName().equals(this.getName()));
  }
}
