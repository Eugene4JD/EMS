package model;

import java.time.LocalDate;

public class Date
{
    private int day;
    private int month;
    private int year;

  public Date( int day, int month, int year)
    {
      this.set(day, month, year);
    }

  public Date() {
    LocalDate today = LocalDate.now();
    this.set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
  }

    public static int convertToMonthNumber (String monthName)
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
  public Date( int day, String mounthName,int year)
    {
      set(day, Date.convertToMonthNumber(mounthName), year);
    }
    public void stepForward ( int days)
    {
      for (int i = 0; i < days; i++)
        this.stepForwardOneDay();
    }

    public void set ( int day, int month, int year)
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
      else if (day > this.nuberOfDaysInMonth())
        this.day = this.nuberOfDaysInMonth();
      else
        this.day = day;
    }
    public boolean isLeapYear () {
    return (year % 4 == 0 && year % 100 != 0);
  }
    public int nuberOfDaysInMonth () {
    if (month == 2 && this.isLeapYear())
      return 29;
    else if (month == 2)
      return 28;
    else if (month == 4 || month == 9 || month == 6 || month == 11)
      return 30;
    else
      return 31;
  }
    public String getMonthName () {
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

    public int getDay () {
    return day;
  }

    public int getMonth () {
    return month;
  }

    public int getYear () {
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
      startDate= this.copy();
      endDate = other.copy();
    }
    while(!(startDate.equals(endDate)))
    {
      counter++;
      startDate.stepForwardOneDay();
    }
    return counter;
  }
    public void stepForwardOneDay () {
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
      if ((day == 31) || (day == 30 && this.nuberOfDaysInMonth() == 30) || (
          day == 29 && this.nuberOfDaysInMonth() == 29) || (day == 28
          && this.nuberOfDaysInMonth() == 28))
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
    public void setYear ( int year)
    {
      this.year = year;
    }
    public boolean isBefore (Date date2)
    {
      if (this.getYear() != date2.getYear())
        return this.getYear() < date2.getYear();
      else if (this.getMonth() != date2.getMonth())
        return this.getMonth() < date2.getMonth();
      else
        return this.getDay() < date2.getDay();
    }
    public int yearsBetween (Date date2)
    {
      return Math.abs(this.getYear() - date2.getYear());
    }

    public String toString () {
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
    public String getAstroSign () {
    Date date1 = new Date(20, 3, this.year);
    Date date2 = new Date(20, 4, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Aries";
    date1.set(20, 4, this.year);
    date2.set(21, 5, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Taurus";
    date1.set(21, 5, this.year);
    date2.set(21, 6, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Gemeni";
    date1.set(21, 6, this.year);
    date2.set(23, 7, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Cancer";
    date1.set(23, 7, this.year);
    date2.set(23, 8, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Leo";
    date1.set(23, 8, this.year);
    date2.set(24, 9, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Virgo";
    date1.set(24, 9, this.year);
    date2.set(23, 10, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Libra";
    date1.set(23, 10, this.year);
    date2.set(22, 11, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Scorpio";
    date1.set(22, 11, this.year);
    date2.set(22, 12, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Sagittarius";
    date1.set(22, 12, this.year);
    date2.set(20, 1, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Capricorn";
    date1.set(20, 1, this.year);
    date2.set(19, 2, this.year);
    if (this.isBefore(date2) && date1.isBefore(this))
      return "Aquarius";
    return "Pisces";
  }
    public String getAstroElement () {
    if (this.getAstroSign().equals("Aries") || this.getAstroSign().equals("Leo")
        || this.getAstroSign().equals("Sagittarius"))
      return "Fire";
    else if (this.getAstroSign().equals("Taurus") || this.getAstroSign().equals("Virgo")
        || this.getAstroSign().equals("Capricorn"))
      return "Earth";
    else if (this.getAstroSign().equals("Cancer") || this.getAstroSign().equals("Scorpio")
        || this.getAstroSign().equals("Pisces"))
      return "Water";
    else
      return "Air";
  }
    public Date copy () {
    Date newDate = new Date(day, month, year);
    return newDate;
  }
    public boolean equals (Object obj)
    {
      if (!(obj instanceof Date))
        return false;
      Date other = (Date) obj;
      return this.year == other.year && this.month == other.month
          && this.day == other.day;
    }
  }

