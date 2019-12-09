package model;

import java.util.ArrayList;

public class TeacherList
{
  private ArrayList<Teacher> teachers;

  public TeacherList()
  {
    teachers = new ArrayList<>();
  }

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

  public void addTeacher(Teacher teacher)
  {
    if (!(isTeacherExist(teacher)))
      teachers.add(teacher);
  }

  public int getIndexOfTeacherByInitials(String initials)
  {
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getInitials().equals(initials))
        return i;
    }
    return Integer.MIN_VALUE;
  }

  public void removeTeacherByIndex(int index)
  {
    teachers.remove(index);
  }

  public void removeTeacherByInitials(String initials)
  {
    if (getIndexOfTeacherByInitials(initials) != Integer.MIN_VALUE)
    {
      teachers.remove(getIndexOfTeacherByInitials(initials));
    }
  }

  public Teacher getTeacherByInitials(String initials)
  {
    return teachers.get(getIndexOfTeacherByInitials(initials));
  }

  public Teacher getTeacherByIndex(int index)
  {
    return teachers.get(index);
  }

  public int getNumberOfTeachers()
  {
    return teachers.size();
  }

  public ArrayList<Teacher> getTeachers()
  {
    return teachers;
  }

  public ArrayList<Teacher> getFreeTeachers()
  {
    ArrayList<Teacher> buffer = new ArrayList<>();
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getIsBusy() == false)
      {
        buffer.add(teachers.get(i));
      }
    }
    return buffer;
  }

  public ArrayList<Teacher> getBusyTeachers()
  {
    ArrayList<Teacher> buffer = new ArrayList<>();
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getIsBusy() == true)
      {
        buffer.add(teachers.get(i));
      }
    }
    return buffer;
  }

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
  public String showAllTeachers()
  {
    String str ="";
    for (int i =0; i<teachers.size(); i++)
    {
      str+= teachers.get(i).toString() + "\n";
    }
    return str;
  }
}
