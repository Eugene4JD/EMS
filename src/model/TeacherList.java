package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a list of teachers (Supervisors)
 *
 * @author Group 5
 * @version v1.1
 */
public class TeacherList implements Serializable
{
  private ArrayList<Teacher> teachers;

  /**
   * A zero-argument constructor.
   * only initializes the instance variable - teachers
   */
  public TeacherList()
  {
    teachers = new ArrayList<>();
  }

  /**
   * Checks if the list contains the teacher accepted as an argument
   *
   * @param teacher the teacher
   * @return boolean
   */
  public boolean isTeacherExist(Teacher teacher)
  {
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).equals(teacher))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * adds a teacher to the list
   *
   * @param teacher the teacher
   */
  public void addTeacher(Teacher teacher)
  {
    if (!(isTeacherExist(teacher)))
      teachers.add(teacher);
  }

  /**
   * returns the index of the the teacher based on his name
   *
   * @param initials ex: JFK - John Fitzgerald Kennedy
   * @return index
   */
  public int getIndexOfTeacherByInitials(String initials)
  {
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getInitials().equals(initials))
        return i;
    }
    return Integer.MIN_VALUE;
  }

  /**
   * removes a teacher from the list based on his index in this list
   *
   * @param index index of the teacher in the list
   */
  public void removeTeacherByIndex(int index)
  {
    teachers.remove(index);
  }

  /**
   * removes a teacher from the list based on his/her initials
   *
   * @param initials the initials of a teacher
   */
  public void removeTeacherByInitials(String initials)
  {
    if (getIndexOfTeacherByInitials(initials) != Integer.MIN_VALUE)
    {
      teachers.remove(getIndexOfTeacherByInitials(initials));
    }
  }

  /**
   * removes the teacher from the list based on the Teacher object accepted as an argument
   *
   * @param teacher the teacher object
   */
  public void removeTeacherByObject(Teacher teacher)
  {
    teachers.remove(teacher);
  }

  /**
   * return the Teacher object based on the index in the list
   * @param index the index of the teacher in the list
   * @return a Teacher object
   */
  public Teacher getTeacherByIndex(int index)
  {
    return teachers.get(index);
  }

  /**
   * returns the number of teachers
   * @return an integer value of the number of teachers
   */
  public int getNumberOfTeachers()
  {
    return teachers.size();
  }

  /**
   * returns an ArrayList containing all teachers
   * @return  returns an ArrayList containing all teachers
   */
  public ArrayList<Teacher> getTeachers()
  {
    return teachers;
  }

  /**
   * searches the list for a teacher with this name and returns a the object
   * @param name the name of the teacher
   * @return a teacher Object
   */
  public Teacher getTeacherByName(String name)
  {
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getName().equals(name))
        return teachers.get(i);
    }
    return null;
  }

  /**
   *checks if the objects are similar
   * @param object the teacher object
   * @return a true value if the objects are same
   */
  public boolean equals(Object object)
  {
    if (!(object instanceof TeacherList))
      return false;
    TeacherList other = (TeacherList) object;
    if (other.getNumberOfTeachers() != this.getNumberOfTeachers())
      return false;
    for (int i = 0; i < this.getNumberOfTeachers(); i++)
    {
      if (!(this.getTeacherByIndex(i)).equals(other.getTeacherByIndex(i)))
        return false;
    }
    return true;
  }

  /**
   * displays all teachers in a String form
   * @return a String of all teachers
   */
  public String showAllTeachers()
  {
    String str = "";
    for (int i = 0; i < teachers.size(); i++)
    {
      str += teachers.get(i).toString() + "\n";
    }
    return str;
  }

  /**
   * checks if another teacher list contains a teacher from the current list
   * @param teacherList the list of teachers object
   * @return a true if both lists have at least
   */
  public boolean hasAtLeastOneSameTeacher(TeacherList teacherList)
  {
    for (int i = 0; i < teacherList.size(); i++)
      for (int j = 0; j < this.teachers.size(); j++)
        if (teacherList.getTeacherByIndex(i).equals(this.teachers.get(j)))
          return true;
    return false;
  }

  /**
   *
   * @return returns the number of teachers
   */
  public int size()
  {
    return teachers.size();
  }

  /**
   * makes a copy of the list
   * @return returns a copy of the list
   */
  public TeacherList copy()
  {
    TeacherList copyObject = new TeacherList();
    for (int i = 0; i < teachers.size(); i++)
    {
      copyObject.addTeacher(teachers.get(i));
    }
    return copyObject;
  }

  /**
   * displays the list as a String
   * @return the list of teachers as a String
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < teachers.size(); i++)
    {
      str += teachers.get(i).toString() + "\n";
    }
    return str;
  }

  /**
   * returns the teachers which are not in the accepted list
   * @param other A list of teachers
   * @return a list of teachers
   */
  public TeacherList returnWithoutObjectsOfAnotherList(TeacherList other)
  {
    TeacherList result = new TeacherList();
    boolean ready = true;
    for (int i = 0; i < this.size(); i++)
    {
      ready = true;
      for (int j = 0; j < other.size(); j++)
      {
        if (this.getTeacherByIndex(i).equals(other.getTeacherByIndex(j)))
          ready = false;
      }
      if (ready)
        result.addTeacher(this.getTeacherByIndex(i));
    }
    return result;
  }
}
