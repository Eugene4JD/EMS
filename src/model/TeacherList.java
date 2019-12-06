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
    for (int i = 0 ; i< teachers.size(); i++)
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
  public int getIndexOfTeacherById(int id)
  {
    for (int i = 0 ; i<teachers.size();i++)
    {
      if (teachers.get(i).getId() == id)
        return i;
    }
    return -1;
  }
  public void removeTeacherByIndex (int index)
  {
    teachers.remove(index);
  }
  public void removeTeacherById (int id)
  {
    if (getIndexOfTeacherById(id) != -1)
    {
      teachers.remove(getIndexOfTeacherById(id));
    }
  }
  public Teacher getTeacherById(int id)
  {
    return teachers.get(getIndexOfTeacherById(id));
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
  public boolean equals(Object object)
  {
    if (!(object instanceof TeacherList))
      return false;
    TeacherList other = (TeacherList) object;
    if (other.getNumberOfTeachers() != this.getNumberOfTeachers())
      return false;
    for (int i = 0; i<this.getNumberOfTeachers(); i++)
    {
      if (!(this.getTeacherByIndex(i)).equals(other.getTeacherById(i)))
        return false;
    }
    return true;
  }
}
