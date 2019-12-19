package model;

import java.io.Serializable;

/**
 * A class representing the time when the exam takes place
 *
 * @author Group 5
 * @version 1.1
 */
public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

  /**
   * A three-argument constructor. If an illegal time is introduced, an exception is thrown.
   * The constructor calls the setter to set the values for hour, minute, second.
   *
   * @param hour   the hour
   * @param minute the minute
   * @param second the second (usually set to 0)
   */
  public Time(int hour, int minute, int second)
  {
    if ((hour < 0 && hour > 24) || (minute < 0 && minute > 59) || (second < 0
        && second > 59))
      throw new IllegalArgumentException("Wrong Time");
    set(hour, minute, second);
  }

  /**
   * This is a setter for h, m, s. It is called by the constructor.
   * If an illegal time is introduced, the setter will throw an exception.
   *
   * @param hour   the hour
   * @param minute the minute
   * @param second the second
   */
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

  /**
   *
   * @return returns the hour
   */
  public int getHour()
  {
    return hour;
  }

  /**
   *
   * @return returns the minute
   */
  public int getMinute()
  {
    return minute;
  }

  /**
   * it is used in isBefore() method
   * @return returns the time as a sum of seconds
   *
   */
  public int getTimeInSeconds()
  {
    return hour * 3600 + minute * 60 + second;
  }

  /**
   *
   * @return returns the time as a string in the format: HH:MM:SS
   */
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

  /**
   *
   * @param clock2
   *              the method accepts another time value as an argument
   * @return returns the a true/false if the instance var TIME is before the time taken as an argument in this method
   */
  public boolean isBefore(Time clock2)
  {
    return this.getTimeInSeconds() < clock2.getTimeInSeconds();
  }

  /**
   *
   * @param obj
   *           accepts a Time object
   * @return returns if the time objects are the same
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Time))
      return false;
    Time other = (Time) obj;
    return other.getTimeInSeconds() == this.getTimeInSeconds();
  }
}