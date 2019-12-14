package model;

import java.io.Serializable;

public class Teacher implements Serializable
{
  private String name;
  private String initials;
  private String subject;
  private boolean isBusy; //maybe

  public Teacher(String name, String initials, String subject)
  {
    if (name.equals(""))
      throw new IllegalArgumentException("wrong name");
    else
      this.name = name;
    if (initials.equals(""))
      throw new IllegalArgumentException("Wrong initials");
    else
      this.initials = initials;
    if (subject.equals(""))
      throw  new IllegalArgumentException("Wrong subject");
    else
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

  public boolean getIsBusy()
  {
    return isBusy;
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

  public void setBusy(boolean isBusy)
  {
    this.isBusy = isBusy;
  }

  public String toString()
  {
    return getName() + " Subject: " + getSubject() + " Initials: "
        + getInitials() + " isBusy: " + getIsBusy();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
      return false;
    Teacher other = (Teacher) obj;
    return (other.getInitials().equals(this.initials) && other.getName()
        .equals(this.getName()) && other.getSubject().equals(this.getSubject())
        && other.isBusy == this.isBusy);
  }
}
