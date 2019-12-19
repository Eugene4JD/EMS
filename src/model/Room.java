package model;

import java.io.Serializable;

/**
 * A class representing a room
 *
 * @author Group 5
 * @version v1.1
 */
public class Room implements Serializable
{
  private String roomName;
  private String typesOfConnectorsAvailable;
  private int maxNumberOfStudents;
  private int numberOfChairs;
  private int numberOfTables;
  private boolean canBeMerged;

  /**
   * A 6-arg constructor. Throws a mistake if the strings are empty or integers are less than 1
   * @param roomName
   * @param typesOfConnectorsAvailable
   * @param maxNumberOfStudents
   * @param numberOfChairs
   * @param numberOfTables
   * @param canBeMerged
   */
  public Room(String roomName, String typesOfConnectorsAvailable,
      int maxNumberOfStudents, int numberOfChairs, int numberOfTables,
      String canBeMerged)
  {
    if (roomName .equals(""))
      throw new IllegalArgumentException("the wrong Room name");
    else
      this.roomName = roomName;
    if (typesOfConnectorsAvailable.equals(""))
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
    if (canBeMerged .equals("true"))
      this.canBeMerged = true;
    else if (canBeMerged.equals("false"))
      this.canBeMerged = false;
    else
      throw new IllegalArgumentException("Wrong state of merge");
  }

  /**
   *
   * @return the room name
   */
  public String getRoomName()
  {
    return roomName;
  }

  /**
   *
   * @return the types of connectors available
   */
  public String getTypesOfConnectorsAvailable()
  {
    return typesOfConnectorsAvailable;
  }

  /**
   *
   * @return the max number of students in the room
   */
  public int getMaxNumberOfStudents()
  {
    return maxNumberOfStudents;
  }

  /**
   * the max number of chairs in the room
   * @return
   */
  public int getNumberOfChairs()
  {
    return numberOfChairs;
  }

  /**
   *
   * @return the max number of tables in the room
   */
  public int getNumberOfTables()
  {
    return numberOfTables;
  }

  /**
   *
   * @return true if the room can be merged with another room
   */
  public boolean isCanBeMerged()
  {
    return canBeMerged;
  }

  /**
   * checks if two room objects are similar
   * @param obj a room object
   * @return true it the rooms are similar
   */
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

  /**
   *
   * @return the name of the room
   */
  public String toString()
  {
    return roomName;
  }
}
