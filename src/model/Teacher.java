package model;

public class Teacher
{
  private String name;
  private int id;
  private String subject;

  public Teacher(String name, int id, String subject)
  {
    this.name = name;
    this.id = id;
    this.subject = subject;
  }

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String toString()
  {
    return getName()+" Subject: "+getSubject()+" id: " + getId();
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
      return false;
    Teacher other =(Teacher) obj;
    return other.getId() == this.getId()
        && other.getName().equals(this.getName());
  }
}
