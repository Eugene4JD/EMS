package model;

public class DateAndTimePeriod
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
  public DateAndTimePeriod copy()
  {
    DateAndTimePeriod copyObject = new DateAndTimePeriod(dateOfTheExam, startTime, endTime);
    return copyObject;
  }
}