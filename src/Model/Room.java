package Model;

import java.io.Serializable;

public class Room implements Serializable
{
  private String roomName;
  private boolean hasProjector;
  private int maxNumberOfStudents;


  public Room(String roomName, boolean isThereProjector, int maxNumberOfStudents)
  {
     this.roomName = roomName;
     this.hasProjector = isThereProjector;
     this.maxNumberOfStudents = maxNumberOfStudents;
  }


  public String getRoomName()
  {
    return roomName;
  }
  public boolean isThereAProjector()
  {
    return hasProjector;
  }
  public int getMaxNumberOfStudents()
  {
    return maxNumberOfStudents;
  }


  public void setRoomName(String roomName)
  {
    this.roomName = roomName;
  }
  public void setHasProjector(Boolean hasProjector)
  {
    this.hasProjector = hasProjector;
  }
  public void setMaxNumberOfStudents(int maxNumberOfStudents)
  {
    this.maxNumberOfStudents = maxNumberOfStudents;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Room))
      return false;
    Room other = (Room) obj;
    return other.roomName.equals(this.roomName)
        && other.hasProjector == this.hasProjector
        && other.maxNumberOfStudents == this.maxNumberOfStudents;
  }

  public String toString()
  {
    return roomName;
  }
}
