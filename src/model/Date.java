package model;

import java.time.LocalDate;

public class Date
{
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year)
  {
    this.set(day, month, year);
  }

  public Date()
  {
    LocalDate today = LocalDate.now();
    this.set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
  }

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

  public Date(int day, String monthName, int year)
  {
    set(day, Date.convertToMonthNumber(monthName), year);
  }

  public void set(int day, int month, int year)
  {
    if (year < 0)
      this.year = -year;
    else
      this.year = year;
    if (month < 1)
      this.month = 1;
    else if (month > 12)
      this.month = 12;
    else
      this.month = month;
    if (day < 1)
      this.day = 1;
    else if (day > this.numberOfDaysInMonth())
      this.day = this.numberOfDaysInMonth();
    else
      this.day = day;
  }

  public boolean isLeapYear()
  {
    return (year % 4 == 0 && year % 100 != 0);
  }

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

  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
    }

    return "no such meaning";
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public int daysBetween(Date other)
  {
    int counter = 0;
    Date startDate;
    Date endDate;
    if (other.isBefore(this))
    {
      startDate = other.copy();
      endDate = this.copy();
    }
    else
    {
      startDate = this.copy();
      endDate = other.copy();
    }
    while (!(startDate.equals(endDate)))
    {
      counter++;
      startDate.stepForwardOneDay();
    }
    return counter;
  }

  public void stepForwardOneDay()
  {
    if (month == 12)
    {
      if (day == 31)
      {
        this.day = 1;
        this.month = 1;
        this.year += 1;
      }
      else
      {
        this.day += 1;
      }
    }
    else
    {
      if ((day == 31) || (day == 30 && this.numberOfDaysInMonth() == 30) || (
          day == 29 && this.numberOfDaysInMonth() == 29) || (day == 28
          && this.numberOfDaysInMonth() == 28))
      {
        this.day = 1;
        this.month += 1;
      }
      else
      {
        this.day += 1;
      }
    }
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public boolean isBefore(Date date2)
  {
    if (this.getYear() != date2.getYear())
      return this.getYear() < date2.getYear();
    else if (this.getMonth() != date2.getMonth())
      return this.getMonth() < date2.getMonth();
    else
      return this.getDay() < date2.getDay();
  }

  public int yearsBetween(Date date2)
  {
    return Math.abs(this.getYear() - date2.getYear());
  }

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

  public Date copy()
  {
    Date newDate = new Date(day, month, year);
    return newDate;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
      return false;
    Date other = (Date) obj;
    return this.year == other.year && this.month == other.month
        && this.day == other.day;
  }
}

