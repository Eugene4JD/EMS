package model;

import java.io.Serializable;

public class Student implements Serializable
{
  private String name;
  private int id;
  private int semester;

  public Student(String name, int id, int semester)
  {
    this.name = name;
    this.id = id;
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
