package model;

import java.io.Serializable;

public class Room implements Serializable
{
  private String roomName;
  private String typesOfConnectorsAvailable;
  private int maxNumberOfStudents;
  private int numberOfChairs;
  private int numberOfTables;
  private boolean canBeMerged;

  public Room(String roomName, String typesOfConnectorsAvailable,
      int maxNumberOfStudents, int numberOfChairs, int numberOfTables,
      boolean canBeMerged)
  {
    this.roomName = roomName;
    this.typesOfConnectorsAvailable = typesOfConnectorsAvailable;
    this.maxNumberOfStudents = maxNumberOfStudents;
    this.numberOfChairs = numberOfChairs;
    this.numberOfTables = numberOfTables;
    this.canBeMerged = canBeMerged;
  }

  public String getRoomName()
  {
    return roomName;
  }

  public String getTypesOfConnectorsAvailable()
  {
    return typesOfConnectorsAvailable;
  }

  public int getMaxNumberOfStudents()
  {
    return maxNumberOfStudents;
  }

  public int getNumberOfChairs()
  {
    return numberOfChairs;
  }

  public int getNumberOfTables()
  {
    return numberOfTables;
  }

  public boolean isCanBeMerged()
  {
    return canBeMerged;
  }

  public void setRoomName(String roomName)
  {
    this.roomName = roomName;
  }

  public void setTypesOfConnectorsAvailable(String typesOfConnectorsAvailable)
  {
    this.typesOfConnectorsAvailable = typesOfConnectorsAvailable;
  }

  public void setMaxNumberOfStudents(int maxNumberOfStudents)
  {
    this.maxNumberOfStudents = maxNumberOfStudents;
  }

  public void setNumberOfChairs(int numberOfChairs)
  {
    this.numberOfChairs = numberOfChairs;
  }

  public void setNumberOfTables(int numberOfTables)
  {
    this.numberOfTables = numberOfTables;
  }

  public void setCanBeMerged(boolean canBeMerged)
  {
    this.canBeMerged = canBeMerged;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Room))
      return false;
    Room other = (Room) obj;
    return (other.roomName.equals(this.roomName)
        && other.typesOfConnectorsAvailable
        .equals(this.typesOfConnectorsAvailable)
        && other.maxNumberOfStudents == this.maxNumberOfStudents
        && other.numberOfTables == this.numberOfTables
        && other.numberOfChairs == this.numberOfChairs
        && other.canBeMerged == this.canBeMerged);
  }

  public String toString()
  {
    return roomName;
  }
}
