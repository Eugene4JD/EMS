package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A class representing the Date object
 * @author  Group 5
 * @version v1.1
 */
public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  /**
   * A 3 argument constructor , setting the date to the arguments
   * @param day
   *   int day
   * @param month
   *   int month
   * @param year
   *   int year
   */
  public Date(int day, int month, int year)
  {
    this.set(day, month, year);
  }

  /**
   * sets this date to current date
   */
  public Date()
  {
    LocalDate today = LocalDate.now();
    this.set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
  }

  /**
   * converts month Name into integer representation of it
   * @param monthName
   *   String month Name
   * @return
   *   int month number
   */
  public static int convertToMonthNumber(String monthName)
  {
    switch (monthName)
    {
      case "January":
        return 1;
      case "February":
        return 2;
      case "March":
        return 3;
      case "April":
        return 4;
      case "May":
        return 5;
      case "June":
        return 6;
      case "July":
        return 7;
      case "August":
        return 8;
      case "September":
        return 9;
      case "October":
        return 10;
      case "November":
        return 11;
      case "December":
        return 12;
      default:
        return Integer.MIN_VALUE;
    }
  }

  /**
   * another 3 argument constructor which is setting Date , but instead of int monthName using String
   * representation of it .
   * @param day
   *  int day
   * @param monthName
   *   String monthName
   * @param year
   *   int year
   */
  public Date(int day, String monthName, int year)
  {
    set(day, Date.convertToMonthNumber(monthName), year);
  }

  /**
   * set method to this object , sets all three instance variables using all 3 arguments
   * if year is less than 0 , or if month less than 1 or more than 12, or day less than 1 or more than number of days in this
   * month throws Illegal argument exception
   * @param day
   * int day
   * @param month
   * int month
   * @param year
   * int year
   */
  public void set(int day, int month, int year)
  {
    if (year < 0)
      throw new IllegalArgumentException("Wrong year");
    else
      this.year = year;
    if (month < 1)
      throw new IllegalArgumentException("Wrong month");
    else if (month > 12)
      throw  new IllegalArgumentException("Wrong month");
    else
      this.month = month;
    if (day < 1)
      throw new IllegalArgumentException("Wrong day");
    else if (day > this.numberOfDaysInMonth())
      throw new IllegalArgumentException("Wrong day");
    else
      this.day = day;
  }

  /**
   *
   * @return
   * true if year of this date is leep
   * and false if it is not
   */
  public boolean isLeapYear()
  {
    return (year % 4 == 0 && year % 100 != 0);
  }

  /**
   *
   * @return
   * returns amount of days in this object month
   */
  public int numberOfDaysInMonth()
  {
    if (month == 2 && this.isLeapYear())
      return 29;
    else if (month == 2)
      return 28;
    else if (month == 4 || month == 9 || month == 6 || month == 11)
      return 30;
    else
      return 31;
  }

  /**
   * @return
   * this date object day number
   */
  public int getDay()
  {
    return day;
  }

  /**
   *
   * @return
   *   this Date object month number
   */
  public int getMonth()
  {
    return month;
  }

  /**
   *
   * @return
   *   this Date object year number
   */
  public int getYear()
  {
    return year;
  }

  /**
   *
   * @param date2
   *   another Date
   * @return
   *   true if the this date is before given date as an argument
   */
  public boolean isBefore(Date date2)
  {
    if (this.getYear() != date2.getYear())
      return this.getYear() < date2.getYear();
    else if (this.getMonth() != date2.getMonth())
      return this.getMonth() < date2.getMonth();
    else
      return this.getDay() <= date2.getDay();
  }

  /**
   * @return
   *  returns String representation of the date in the right format
   */
  public String toString()
  {
    String Str = "";
    if (this.day < 10)
      Str += "0" + day + "/";
    else
      Str += day + "/";
    if (this.month < 10)
      Str += "0" + month + "/";
    else
      Str += month + "/";
    if (year < 10)
      Str += "000" + year;
    else if (year < 100)
      Str = "00" + year;
    else if (year < 1000)
      Str = "0" + year;
    else
      Str += year;
    return Str;
  }

  /**
   * equals method
   * @param obj
   *   given object
   * @return
   *   returns true if the object given is equals to this object
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
      return false;
    Date other = (Date) obj;
    return this.year == other.year && this.month == other.month
        && this.day == other.day;
  }
}

