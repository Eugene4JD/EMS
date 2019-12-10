package model;

import java.io.Serializable;

public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

  public Time(int hour, int minute, int second)
  {
    if ((hour <0 && hour > 24) ||(minute<0 && minute>59) || (second<0 && second>59))
      throw new IllegalArgumentException("Wrong Time");
    set(hour, minute, second);
  }

  public void set(int hour, int minute, int second)
  {
    if (hour > 23)
      throw new IllegalArgumentException("Wrong Time");
    else if (hour < 0)
      throw new IllegalArgumentException("Wrong Time");
    else
      this.hour = hour;
    if (minute > 59)
      throw new IllegalArgumentException("Wrong Time");
    else if (minute < 0)
      throw new IllegalArgumentException("Wrong Time");
    else
      this.minute = minute;
    if (second > 59)
      throw new IllegalArgumentException("Wrong Time");
    else if (second < 0)
      throw new IllegalArgumentException("Wrong Time");
    else
      this.second = second;
  }

  public Time(int TotalSeconds)
  {
    setBySeconds(TotalSeconds);
  }

  public void setBySeconds(int TotalSeconds)
  {
    this.hour = TotalSeconds / 3600;
    this.minute = (TotalSeconds % 3600) / 60;
    this.second = (TotalSeconds % 3600) % 60;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getSecond()
  {
    return second;
  }

  public int getTimeInSeconds()
  {
    return hour * 3600 + minute * 60 + second;
  }

  public String toString()
  {
    String lne = "";
    if (hour < 10)
      lne += "0" + hour + ":";
    else
      lne += hour + ":";
    if (minute < 10)
      lne += "0" + minute + ":";
    else
      lne += minute + ":";
    if (second < 10)
      lne += "0" + second;
    else
      lne += second;

    return lne;
  }

  public String getSimpleTime()
  {
    String lne = "";
    if (hour < 10)
      lne += "0" + hour + ":";
    else
      lne += hour + ":";
    if (minute < 10)
      lne += "0" + minute;
    else
      lne += minute;
    return lne;
  }

  public boolean isBefore(Time clock2)
  {
    return this.getTimeInSeconds() < clock2.getTimeInSeconds();
  }

  public Time timeTo(Time clock2)
  {
    int seconds;
    seconds = Math.abs(clock2.getTimeInSeconds() - this.getTimeInSeconds());
    Time clock3 = new Time(seconds);
    return clock3;
  }

  public Time copy()
  {
    Time newClock = new Time(hour, minute, second);
    return newClock;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
      return false;
    Time other = (Time) obj;
    return other.getTimeInSeconds() == this.getTimeInSeconds();
  }
}