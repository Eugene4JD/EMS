package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TeacherList implements Serializable
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

  public void removeTeacherByObject(Teacher teacher)
  {
    teachers.remove(teacher);
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

  public Teacher getTeacherByName(String name)
  {
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getName().equals(name))
        return teachers.get(i);
    }
    return null;
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
    String str = "";
    for (int i = 0; i < teachers.size(); i++)
    {
      str += teachers.get(i).toString() + "\n";
    }
    return str;
  }

  public boolean hasAtLeastOneSameTeacher(TeacherList teacherList)
  {
    for (int i = 0; i < teacherList.size(); i++)
      for (int j = 0; j < this.teachers.size(); j++)
        if (teacherList.getTeacherByIndex(i).equals(this.teachers.get(j)))
          return true;
    return false;
  }

  public int size()
  {
    return teachers.size();
  }

  public TeacherList copy()
  {
    TeacherList copyObject = new TeacherList();
    for (int i = 0; i < teachers.size(); i++)
    {
      copyObject.addTeacher(teachers.get(i));
    }
    return copyObject;
  }
  public String toString()
  {
    String str = "";
    for (int i =0; i<teachers.size(); i++)
    {
      str+=teachers.get(i).toString()+"\n";
    }
    return str;
  }
}
