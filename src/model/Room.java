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
      String canBeMerged)
  {
    if (roomName == "")
      throw new IllegalArgumentException("the wrong Room name");
    else
      this.roomName = roomName;
    if (typesOfConnectorsAvailable == "")
      throw new IllegalArgumentException("the wrong type connectors");
    else
      this.typesOfConnectorsAvailable = typesOfConnectorsAvailable;
    if (maxNumberOfStudents < 1)
      throw new IllegalArgumentException("the wrong number of Students");
    else
      this.maxNumberOfStudents = maxNumberOfStudents;
    if (numberOfChairs < 1)
      throw new IllegalArgumentException("the wrong number of chairs");
    else
      this.numberOfChairs = numberOfChairs;
    if (numberOfTables < 1)
      throw new IllegalArgumentException("the wrong number of tables");
    else
      this.numberOfTables = numberOfTables;
    if (canBeMerged == "true")
      this.canBeMerged = true;
    else if (canBeMerged == "false")
      this.canBeMerged = false;
    else
      throw new IllegalArgumentException("Wrong state of merge");
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
