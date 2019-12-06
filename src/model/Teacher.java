package model;

public class Teacher
{
  private String name;
  private String initials;
  private String subject;

  public Teacher(String name, String initials, String subject)
  {
    this.name = name;
    this.initials = initials;
    this.subject = subject;
  }

  public String getName()
  {
    return name;
  }

  public String getInitials()
  {
    return initials;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(String initials)
  {
    this.initials = initials;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public String toString()
  {
    return getName() + " Subject: " + getSubject() + " Initials: "
        + getInitials();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
      return false;
    Teacher other = (Teacher) obj;
    return other.getInitials().equals(this.initials) && other.getName()
        .equals(this.getName()) && other.getSubject().equals(this.getSubject());
  }
}
