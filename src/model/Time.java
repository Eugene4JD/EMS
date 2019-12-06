package model;

public class Time
{
  private int hour;
  private int minute;
  private int second;

  public Time(int hour, int minute, int second)
  {
    set(hour, minute, second);
  }

  public void set(int hour, int minute, int second)
  {
    if (hour > 23)
      this.hour = 0;
    else if (hour < 0)
      this.hour = 0;
    else
      this.hour = hour;
    if (minute > 59)
      this.minute = 59;
    else if (minute < 0)
      this.minute = 0;
    else
      this.minute = minute;
    if (second > 59)
      this.second = 59;
    else if (second < 0)
      this.second = 0;
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

  public void tic()
  {
    second += 1;
    if (second == 60)
    {
      minute += 1;
      second = 0;
    }
    if (minute == 60)
    {
      hour += 1;
      hour = 0;
    }
    if (hour == 24)
    {
      hour = 0;
    }
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

  public String getSipmpleTime()
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
    Time clock3 = new Time (seconds);
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