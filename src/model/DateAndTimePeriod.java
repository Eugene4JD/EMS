package model;

import java.io.Serializable;

public class DateAndTimePeriod implements Serializable
{
  private Date dateOfTheExam;
  private Time startTime;
  private Time endTime;

  public DateAndTimePeriod(Date dateOfTheExam, Time startTime, Time endTime)
  {
    this.dateOfTheExam = dateOfTheExam;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public boolean onConflict(DateAndTimePeriod other)
  {
    if (other.dateOfTheExam.equals(this.dateOfTheExam))
    {
      if ((this.startTime.isBefore(other.startTime) && other.endTime
          .isBefore(this.startTime)) || (
          other.startTime.isBefore(this.startTime) && (this.endTime
              .isBefore(other.endTime))))
        return true;
      else if (this.startTime.equals(other.startTime) || other.endTime
          .equals(this.endTime))
        return true;
      else
        return false;
    }
    return false;
  }

  public Date getDateOfTheExam()
  {
    return dateOfTheExam;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public void setDateOfTheExam(Date dateOfTheExam)
  {
    this.dateOfTheExam = dateOfTheExam;
  }

  public void setStartTime(Time startTime)
  {
    this.startTime = startTime;
  }

  public void setEndTime(Time endTime)
  {
    this.endTime = endTime;
  }

  public DateAndTimePeriod copy()
  {
    DateAndTimePeriod copyObject = new DateAndTimePeriod(dateOfTheExam,
        startTime, endTime);
    return copyObject;
  }

  public String toString()
  {
    String str ="";
    str+=dateOfTheExam.toString()+"  |  "+ startTime.toString()+" - " + endTime.toString();
    return str;
  }
}