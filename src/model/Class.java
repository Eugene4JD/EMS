package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing a Class of students
 * @author  Group 5
 * @version v1.1
 */

public class Class implements Serializable
{
  private StudentList students;
  private TeacherList teachers;
  private String className;

  /**
   * Three argument-argument constructor.
   * Initialising Class object with name, Teachers list and Student list. If teacher list is empty or Student list is empty ,or
   * name of the class is an empty string  : this constructor will throw Illegal argument exception
   * @param className
   *         String which will be used as a Class name
   * @param teachers
   *         Teacher list will represent all teachers which are in the class.
   * @param students
   *         Student list will represent all students which are in the class.
   */
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
    if (!(students.areAllStudentsInTheSameSemester()))
      throw new IllegalArgumentException("All students should be from the same semester");
  }

  /**
   * Adding a student using the student list method addStudent
   * @param student
   *     student which will be added to the student list of the class
   */
  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  /**
   * Returning number of students of a class of students
   * @return
   *       returning the size of the student list
   */
  public int getNumberOfStudents()
  {
    return students.getNumberOfStudents();
  }

  /**
   * Returning number of teachers of a class of students
   * @return
   *      returning the size of the teacher list
   */
  public int getNumberOfTeachers()
  {
    return teachers.getNumberOfTeachers();
  }

  /**
   *
   * @return
   *    returning the class name of a class of students
   */
  public String getClassName()
  {
    return className;
  }

  /**
   *
   * @return
   *    returning the String of an object Class overwriting toString method
   */
  public String toString()
  {
    return className;
  }

  /**
   * returns the students of a class
   * @return
   *    student list of a class
   */
  public StudentList getStudents()
  {
    return students;
  }

  /**
   * returns the teachers of a class
   * @return
   *     teachers list of a class
   */
  public TeacherList getTeachers()
  {
    return teachers;
  }

  /**
   *
   * @param object
   *    accept the object
   * @return
   *    true if the object is the same as the object which is calling this method
   */
  public boolean equals(Object object)
  {
    if (!(object instanceof Class))
      return false;
    Class other = (Class) object;
    return other.getClassName().equals(this.className) && other.teachers
        .equals(this.teachers) && other.students.equals(this.students);

  }

  /**
   *
   * @return
   *   this class name
   */
  public String getName()
  {
    return className;
  }
}
