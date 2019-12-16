package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Student;
import model.StudentList;
import model.Teacher;
import model.TeacherList;

import java.util.ArrayList;

public class StudentListViewArrayList
{
  private ObservableList<StudentViewModel> list;
  private StudentList students;

  public StudentListViewArrayList(StudentList students)
  {
    this.students = students;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<StudentViewModel> getList()
  {
    return list;
  }

  public ObservableList<StudentViewModel> update()
  {
    StudentList other = new StudentList();
    for (int i = 0; i < students.size(); i++)
    {
      students.addStudent(students.getStudentByIndex(i));
    }
    list.clear();
    for (int i = 0; i < students.getNumberOfStudents(); i++)
    {
      list.add(new StudentViewModel((students.getStudentByIndex(i))));
    }
    return list;
  }

  public void remove(Student student)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(student.getName()) && list
          .get(i).getIdProperty().get() == student.getId()
          && list.get(i).getSemesterProperty().get()
          == student.getSemester())
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Student student)
  {
    list.add(new StudentViewModel(student));
  }
}
