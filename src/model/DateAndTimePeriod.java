package model;

public class DateAndTimePeriod
{
  private Date myDate;
  private Time startTime;
  private Time endTime;

  public DateAndTimePeriod(Date myDate, Time startTime, Time endTime)
  {
    this.myDate = myDate;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public boolean onConflict(DateAndTimePeriod other)
  {
    if (other.myDate.equals(this.myDate))
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
}