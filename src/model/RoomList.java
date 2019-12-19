package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * a class representing a list of classes
 *
 * @author Group 5
 * @version v1.1
 */
public class RoomList implements Serializable
{
  private ArrayList<Room> rooms;

  /**
   * a 0-arg constructor. Initializes the list
   */
  public RoomList()
  {
    rooms = new ArrayList<>();
  }

  /**
   * checks if the room is in the list
   *
   * @param room the room object
   * @return true if the room is in the list
   */
  public boolean isRoomExists(Room room)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomName().equals(room.getRoomName()))
        return true;
    }
    return false;
  }

  /**
   * adds a room to the list
   *
   * @param room a room object
   */
  public void addRoom(Room room)
  {
    if (!(isRoomExists(room)))
      rooms.add(room);
  }

  /**
   * removes a room from the list
   *
   * @param index the index of the room in the list
   */
  public void removeRoom(int index)
  {
    rooms.remove(index);
  }

  /**
   * removes the room from the list based on the room's name
   *
   * @param roomName the name of the room
   */
  public void removeRoomByRoomName(String roomName)
  {
    if (getIndexOfRoomByRoomName(roomName) != -1)
    {
      removeRoom(getIndexOfRoomByRoomName(roomName));
    }
  }

  /**
   * returns the index of the room from the list based on the room's name
   *
   * @param roomName the name of the room
   * @return the index of the room in the list
   */
  public int getIndexOfRoomByRoomName(String roomName)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomName().equals(roomName))
        return i;
    }
    return -1;
  }

  /**
   * @return the number of rooms
   */
  public int numberOfRooms()
  {
    return rooms.size();
  }

  /**
   * returns a room object based on the room's name
   *
   * @param roomName the name of the room
   * @return a room object
   */
  public Room getRoomByRoomName(String roomName)
  {
    if (getIndexOfRoomByRoomName(roomName) != -1)
      return rooms.get(getIndexOfRoomByRoomName(roomName));
    else
      return null;
  }

  /**
   * returns a room object based on the index of the room in the list
   *
   * @param index the index of the room in the list
   * @return a roo object
   */
  public Room getRoomByIndex(int index)
  {
    return rooms.get(index);
  }

  /**
   * removes all rooms from the lsit
   */
  public void removeAll()
  {
    while (rooms.size() != 0)
    {
      rooms.remove(0);
    }
  }

  /**
   * @return a string with all rooms
   */
  public String showAllRooms()
  {
    String str = "";
    for (int i = 0; i < rooms.size(); i++)
    {
      str += rooms.get(i).toString() + "\n";
    }
    return str;
  }

  /**
   * @return the number of rooms in the list
   */

  public int size()
  {
    return rooms.size();
  }

  /**
   * removes a room object from the list
   *
   * @param room a room object
   */
  public void removeRoomByObject(Room room)
  {
    rooms.remove(room);
  }

  /**
   * checks if the rooms are similar
   *
   * @param object a room object
   * @return true if the rooms are similar
   */
  public boolean equals(Object object)
  {
    if (!(object instanceof RoomList))
      return false;
    RoomList other = (RoomList) object;
    if (rooms.size() != other.size())
      return false;
    for (int i = 0; i < size(); i++)
    {
      if (!rooms.get(i).equals(other.getRoomByIndex(i)))
      {
        return false;
      }
    }
    return true;
  }

  /**
   * checks if the list contains at least one same room with the accepted list
   *
   * @param other a roomList object
   * @return true if there is at least one same room
   */
  public boolean hasAtLeastOneSameRoom(RoomList other)
  {
    for (int i = 0; i < size(); i++)
    {
      for (int j = 0; j < other.size(); j++)
      {
        if (rooms.get(i).equals(other.getRoomByIndex(j)))
          return true;
      }
    }
    return false;
  }

  /**
   * @return the string with all rooms
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < rooms.size(); i++)
    {
      str += rooms.get(i).toString() + " ";
    }
    return str;
  }

  /**
   * @return a copy of the roomlist object
   */
  public RoomList copy()
  {
    RoomList copyList = new RoomList();
    for (int i = 0; i < rooms.size(); i++)
    {
      copyList.addRoom(rooms.get(i));
    }
    return copyList;
  }

  /**
   * returns a copy of the list, but without the rooms contained in the accepted argument (roomList)
   *
   * @param other another roomList object
   * @return a roomList object
   */
  public RoomList returnWithoutObjectsOfAnotherList(RoomList other)
  {
    RoomList result = new RoomList();
    boolean ready = true;
    for (int i = 0; i < this.size(); i++)
    {
      ready = true;
      for (int j = 0; j < other.size(); j++)
      {
        if (this.getRoomByIndex(i).equals(other.getRoomByIndex(j)))
          ready = false;
      }
      if (ready)
        result.addRoom(this.getRoomByIndex(i));
    }
    return result;
  }
}