package Model;

import java.io.Serializable;

public class Student implements Serializable
{
  private String name;
  private int Id;
  private int Semester;

  public Student(String name, int Id, int Semester)
  {
    this.name = name;
    this.Id = Id;
    this.Semester = Semester;
  }

  public int getId()
  {
    return Id;
  }

  public int getSemester()
  {
    return Semester;
  }

  public String getName()
  {
    return name;
  }

  public void setId(int id)
  {
    Id = id;
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public void setSemester(int semester)
  {
    Semester = semester;
  }

  public String toString()
  {
    return getName()+" id: "+getId()+" semester: "+getSemester();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Student))
      return false;
    Student other =(Student) obj;
    return other.getSemester() == this.getSemester()
        && other.getId() == this.getId()
        && other.getName().equals(this.getName());
  }
}
