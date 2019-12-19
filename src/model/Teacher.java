package model;

import java.io.Serializable;

/**
 * A class representing a teacher
 *
 * @author Group 5
 * @version v1.1
 */
public class Teacher implements Serializable
{
  private String name;
  private String initials;
  private String subject;
  private boolean isBusy; //maybe

  /**
   * A 3-argument constructor. Throws a mistake if one of the introduced strings is an empty string
   * @param name name
   * @param initials initials
   * @param subject subject
   */
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

  /**
   * Returns the name of the teacher
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Returns the initials of the teacher
   * @return the initials
   */
  public String getInitials()
  {
    return initials;
  }

  /**
   * Returns the subject of the teacher
   * @return the subject
   */
  public String getSubject()
  {
    return subject;
  }

  /**
   * Sets the name of the teacher
   * @param name the name of the teacher
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Sets the initials of the teacher
   * @param initials the initials of the teacher
   */
  public void setId(String initials)
  {
    this.initials = initials;
  }

  /**
   * Sets the subject of the teacher
   * @param subject the subject of the teacher
   */
  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  /**
   * returns the name of the teacher
   * @return the name of the teacher
   */
  public String toString()
  {
    return getName();
  }

  /**
   * checks if two teacher objects are similar
   * @param obj a teacher object
   * @return a boolean (true if objects are the same)
   */
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
