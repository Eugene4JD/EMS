package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassList implements Serializable
{
  private ArrayList<Class> classes;

  public ClassList()
  {
    classes = new ArrayList<>();
  }

  public boolean doesClassExist(Class classItem)
  {
    for (int i = 0 ; i<classes.size();i++)
    {
      if (classItem.equals(classes.get(i)))
        return false;
    }
    return true;
  }

  public void addClass(Class classItem)
  {
    if (doesClassExist(classItem))
       classes.add(classItem);
  }


  public int getIndexOfClassByClassName(String className)
  {
    for (int i = 0 ; i<classes.size(); i++)
    {
      if (classes.get(i).getClassName().equals(className))
      {
        return i;
      }
    }
    return -1;
  }

  public void removeClassByIndex(int index)
  {
     classes.remove(index);
  }


  public void removeClassByClassName(String className)
  {
    classes.remove(getIndexOfClassByClassName(className));
  }


  public Class getClassByIndex(int index)
  {
    return classes.get(index);
  }


  public Class getClassByClassName(String className)
  {
    if (getIndexOfClassByClassName(className) == -1)
      return null;
    else
      return classes.get(getIndexOfClassByClassName(className));
  }


  public int getTotalNumberOfStudents()
  {
    int k = 0;
    for (int i =0; i< classes.size();i++)
    {
     k += classes.get(i).getNumberOfStudents();
    }
    return k;
  }

  public int getTotalNumberOfTeachers()
  {
    int k = 0;
    for (int i =0; i< classes.size();i++)
    {
      k += classes.get(i).getNumberOfTeachers();
    }
    return k;
  }

  public void removeAll()
  {
    while (classes.size() != 0)
    {
      classes.remove(0);
    }
  }

  public int getNumberOfClasses()
  {
    return classes.size();
  }

  public String showAllClasses()
  {
    String str = "";
    for (int i =0; i< classes.size(); i++)
    {
      str+= classes.get(i).toString()+"\n";
    }
    return str;
  }
  public int size()
  {
    return classes.size();
  }
  public boolean hasAtLeastOneSameClass(ClassList other)
  {
    for (int i = 0; i<other.getNumberOfClasses(); i++)
      for (int j = 0; j < this.classes.size(); j++)
         if (other.getClassByIndex(i).equals(classes.get(j)))
           return true;
   return false;
  }
  public ClassList copy()
  {
    ClassList copyCLassList = new ClassList();
    for (int i =0; i<classes.size();i++)
      copyCLassList.addClass(classes.get(i));
    return copyCLassList;
  }
  public String toString()
  {
    String result = "";
    for (int i=0; i<size();i++)
    {
      result += classes.get(i).getName()+"\n";
    }
    return result;
  }

}
