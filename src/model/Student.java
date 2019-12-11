package model;

import javafx.scene.control.SeparatorMenuItem;

import java.io.Serializable;

public class Student implements Serializable
{
  private String name;
  private int id;
  private int semester;

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

  public int getId()
  {
    return id;
  }

  public int getSemester()
  {
    return semester;
  }

  public String getName()
  {
    return name;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setSemester(int semester)
  {
    this.semester = semester;
  }

  public String toString()
  {
    return getName() + " ID: " + getId() + " semester: " + getSemester();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Student))
      return false;
    Student other = (Student) obj;
    return (other.getSemester() == this.getSemester() && other.getId() == this
        .getId() && other.getName().equals(this.getName()));
  }
}
