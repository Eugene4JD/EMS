package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable
{
  private StudentList students;
  private TeacherList teachers;
  private String className;

  public Class(String className, TeacherList teachers, StudentList students)
  {
    if (teachers.getNumberOfTeachers() == 0)
      throw new IllegalArgumentException("You haven't chosen any teacher");
    else
      this.teachers = teachers;
    if (students.getNumberOfStudents() == 0)
      throw new IllegalArgumentException("You haven't chosen any students");
    else
      this.students = students;

    if (className .equals(""))
      throw  new IllegalArgumentException("wrong class name");
    else
      this.className = className;
  }

  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  public int getNumberOfStudents()
  {
    return students.getNumberOfStudents();
  }

  public ArrayList<Student> getAllStudents()
  {
    return students.getStudents();
  }

  public void removeStudentByIndex(int index)
  {
    students.removeStudentByIndex(index);
  }

  public void removeStudentById(int id)
  {
    students.removeStudentById(id);
  }

  public void addTeacher(Teacher teacher)
  {
    teachers.addTeacher(teacher);
  }

  public int getNumberOfTeachers()
  {
    return teachers.getNumberOfTeachers();
  }

  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers.getTeachers();
  }

  public void removeTeacherByIndex(int index)
  {
    teachers.removeTeacherByIndex(index);
  }

  public void removeTeacherById(String initials)
  {
    teachers.removeTeacherByInitials(initials);
  }

  public String getClassName()
  {
    return className;
  }

  public String toString()
  {
    return className;
  }

  public StudentList getStudents()
  {
    return students;
  }
  public TeacherList getTeachers()
  {
    return teachers;
  }

  public boolean equals(Object object)
  {
    if (!(object instanceof Class))
      return false;
    Class other = (Class) object;
    return other.getClassName().equals(this.className) && other.teachers
        .equals(this.teachers) && other.students.equals(this.students);
  }
}
