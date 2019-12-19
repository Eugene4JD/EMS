package model;

import java.io.Serializable;

/**
 *A class representing the Date and time Period object
 * @author Group 5
 * @version v1.1
 */
public class DateAndTimePeriod implements Serializable
{
  private Date dateOfTheExam;
  private Time startTime;
  private Time endTime;

  /**
   * a 3 arguments constructor
   * @param dateOfTheExam
   *     Date object representing the date
   * @param startTime
   *     Time object representing the start time
   * @param endTime
   *     Time object representing the end time
   */
  public DateAndTimePeriod(Date dateOfTheExam, Time startTime, Time endTime)
  {
    this.dateOfTheExam = dateOfTheExam;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * method checks if this period is on conflict with given , it contains cases : if one period is inside another
   * and reverse and if the are crossing
   * @param other
   *  another Date and Time Period object
   * @return
   *  true if periods are on conflict
   *  and false if they are not
   */
  public boolean onConflict(DateAndTimePeriod other)
  {
    if (other.dateOfTheExam.equals(this.dateOfTheExam))
    {
      if ((this.startTime.isBefore(other.startTime) && other.endTime
          .isBefore(this.endTime)) || (
          other.startTime.isBefore(this.startTime) && (this.endTime
              .isBefore(other.endTime))
      || ((this.startTime.isBefore(other.startTime)) && (other.startTime.isBefore(this.endTime)) &&(this.endTime.isBefore(other.endTime)))
      || ((other.startTime.isBefore(this.startTime)) && (this.startTime.isBefore(other.endTime)) && (other.endTime.isBefore(this.endTime)))))
        return true;
      else if (this.startTime.equals(other.startTime) || other.endTime
          .equals(this.endTime))
        return true;
      else
        return false;
    }
    return false;
  }

  /**
   * @return
   * returns the date object of the Date object
   */
  public Date getDateOfTheExam()
  {
    return dateOfTheExam;
  }

  /**
   *
   * @return
   * returns the start time object of the Date object
   */
  public Time getStartTime()
  {
    return startTime;
  }

  /**
   * @return
   * returns the end time object of the Date object
   *
   */
  public Time getEndTime()
  {
    return endTime;
  }

  /**
   * @param other
   *  other Date and time period object
   * @return
   *   if the this period is before the given period as an argument returns true
   *   and if not false
   */
  public boolean isBefore(DateAndTimePeriod other)
  {
    if (this.getDateOfTheExam().isBefore(other.getDateOfTheExam()))
      return true;
    else if (other.getDateOfTheExam().equals(this.getDateOfTheExam()))
    {
      if (this.getEndTime().isBefore(other.startTime))
        return true;
    }
    return false;
  }

  /**
   * @return
   * returns the String representation of Period
   */
  public String toString()
  {
    String str ="";
    str+=dateOfTheExam.toString()+"\n"+ startTime.toString()+" - " + endTime.toString();
    return str;
  }
}