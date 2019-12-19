package model;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class representing the list of classes of students
 * @author Group 5
 * @version v1.1
 */

public class ClassList implements Serializable
{
  private ArrayList<Class> classes;

  /**
   * zero-arguments constructor , just initialising the empty array list of Classes
   */
  public ClassList()
  {
    classes = new ArrayList<>();
  }

  /**
   * checks if the class exists in the class list
   * @param classItem
   *    Class object
   * @return
   *    boolean (exists(true) or not exists(false))
   */
  public boolean doesClassExist(Class classItem)
  {
    for (int i = 0 ; i<classes.size();i++)
    {
      if (classItem.equals(classes.get(i)))
        return false;
    }
    return true;
  }

  /**
   * adding a class to the class list
   * @param classItem
   *     Class object
   */
  public void addClass(Class classItem)
  {
    if (doesClassExist(classItem))
       classes.add(classItem);
  }

  /**
   * finds the index of a class in the class list with the particular name
   * @param className
   *      String which represent the name of the class which should be found
   * @return
   *      the index of a  CLass object if a class with such a className is exists in the list
   *       or -1 if not.
   */
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

  /**
   * removes a class from class list by index
   * @param index
   *   int index
   */
  public void removeClassByIndex(int index)
  {
     classes.remove(index);
  }

  /**
   * removes a class by className
   * @param className
   *    string representing the class name
   */
  public void removeClassByClassName(String className)
  {
    classes.remove(getIndexOfClassByClassName(className));
  }

  /**
   * get the class from the class list by index
   * @param index
   *   int index
   * @return
   *   the class object by index in the class list
   */
  public Class getClassByIndex(int index)
  {
    return classes.get(index);
  }

  /**
   * get the class with particular name from class list
   * @param className
   *   String representing the class name
   * @return
   *   returns the class if class with such className exists
   *   or returning null if not
   */
  public Class getClassByClassName(String className)
  {
    if (getIndexOfClassByClassName(className) == -1)
      return null;
    else
      return classes.get(getIndexOfClassByClassName(className));
  }

  /**
   * removes all classes from the class list
   */
  public void removeAll()
  {
    while (classes.size() != 0)
    {
      classes.remove(0);
    }
  }

  /**
   *
   * @return
   *   returning the number of classes in the class list
   */
  public int getNumberOfClasses()
  {
    return classes.size();
  }

  /**
   * returning the String with the classes represented as a list in it
   * @return
   */
  public String showAllClasses()
  {
    String str = "";
    for (int i =0; i< classes.size(); i++)
    {
      str+= classes.get(i).toString()+"\n";
    }
    return str;
  }

  /**
   * returning the size of the class list
   * @return
   */
  public int size()
  {
    return classes.size();
  }

  /**
   *  checks if two list of classes have at least one class in common
   * @param other
   *   another class list
   * @return
   *   returning true if both class list have at least one same class
   *   or false if not
   */
  public boolean hasAtLeastOneSameClass(ClassList other)
  {
    for (int i = 0; i<other.getNumberOfClasses(); i++)
      for (int j = 0; j < this.classes.size(); j++)
         if (other.getClassByIndex(i).equals(classes.get(j)))
           return true;
   return false;
  }

  /**
   *
   * @return
   *   returning the copy of this class list
   */
  public ClassList copy()
  {
    ClassList copyCLassList = new ClassList();
    for (int i =0; i<classes.size();i++)
      copyCLassList.addClass(classes.get(i));
    return copyCLassList;
  }

  /**
   *
   * @return
   *    returning the String representation of the class list
   */
  public String toString()
  {
    String result = "";
    for (int i=0; i<size();i++)
    {
      result += classes.get(i).getName()+"\n";
    }
    return result;
  }

  /**
   * returning the list with all classes represented in the list which is calling the function but
   * which are not represented in another list which is given as argument
   * @param other
   *   other class list
   * @return
   *   class list
   */
  public ClassList returnWithoutObjectsOfAnotherList(ClassList other)
  {
    ClassList result = new ClassList();
    boolean ready = true;
    for (int i =0; i<this.size();i++)
    {
      ready = true;
      for (int j =0; j < other.size(); j++)
      {
        if (this.getClassByIndex(i).equals(other.getClassByIndex(j)))
          ready = false;
      }
      if (ready)
        result.addClass(this.getClassByIndex(i));
    }
    return result;
  }

}
