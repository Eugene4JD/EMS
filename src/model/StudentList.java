package model;

import java.util.ArrayList;

public class StudentList
{
  private ArrayList<Student> students;

  public StudentList()
  {
    students = new ArrayList<>();
  }

  public boolean isStudentExist(Student student)
  {
    for (int i = 0 ; i< students.size(); i++)
    {
      if (students.get(i).equals(student))
      {
        return true;
      }
    }
    return false;
  }
  public void addStudent(Student student)
  {
    if (!(isStudentExist(student)))
      students.add(student);
  }
  public int getIndexOfStudentById(int id)
  {
    for (int i = 0 ; i<students.size();i++)
    {
      if (students.get(i).getId() == id)
        return i;
    }
    return -1;
  }
  public void removeStudentByIndex (int index)
  {
    students.remove(index);
  }
  public void removeStudentById (int id)
  {
    if (getIndexOfStudentById(id) != -1)
    {
      students.remove(getIndexOfStudentById(id));
    }
  }
  public Student getStudentById(int id)
  {
    return students.get(getIndexOfStudentById(id));
  }
  public Student getStudentByIndex(int index)
  {
    return students.get(index);
  }
  public int getNumberOfStudents()
  {
    return  students.size();
  }
  public ArrayList<Student> getStudents()
  {
    return students;
  }
  public boolean equals(Object object)
  {
    if (!(object instanceof StudentList))
      return false;
    StudentList other = (StudentList) object;
    if (other.getNumberOfStudents() != this.getNumberOfStudents())
      return false;
    for (int i = 0; i<this.getNumberOfStudents(); i++)
    {
      if (!(this.getStudentByIndex(i)).equals(other.getStudentByIndex(i)))
        return false;
    }
    return true;
  }
  public String showAllStudents()
  {
    String str = "";
    for (int i = 0; i< students.size(); i++)
    {
      str += students.get(i).toString()+"\n";
    }
    return str;
  }
}
