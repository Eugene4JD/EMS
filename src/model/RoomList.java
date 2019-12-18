package model;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable
{
  private ArrayList<Room> rooms;

  public RoomList()
  {
    rooms = new ArrayList<>();
  }

  public boolean isRoomExists(Room room)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomName().equals(room.getRoomName()))
        return true;
    }
    return false;
  }

  public void addRoom(Room room)
  {
    if (!(isRoomExists(room)))
      rooms.add(room);
  }

  public void removeRoom(int index)
  {
    rooms.remove(index);
  }

  public void removeRoomByRoomName(String roomName)
  {
    if (getIndexOfRoomByRoomName(roomName) != -1)
    {
      removeRoom(getIndexOfRoomByRoomName(roomName));
    }
  }

  public int getIndexOfRoomByRoomName(String roomName)
  {
    for (int i = 0; i < rooms.size(); i++)
    {
      if (rooms.get(i).getRoomName().equals(roomName))
        return i;
    }
    return -1;
  }

  public int numberOfRooms()
  {
    return rooms.size();
  }

  public Room getRoomByRoomName(String roomName)
  {
    if (getIndexOfRoomByRoomName(roomName) != -1)
      return rooms.get(getIndexOfRoomByRoomName(roomName));
    else
      return null;
  }

  public Room getRoomByIndex(int index)
  {
    return rooms.get(index);
  }

  public void removeAll()
  {
    while (rooms.size() != 0)
    {
      rooms.remove(0);
    }
  }
  public String showAllRooms()
  {
    String str ="";
    for (int i =0 ; i<rooms.size(); i++)
    {
      str += rooms.get(i).toString()+"\n";
    }
    return str;
  }
  public int size()
  {
    return rooms.size();
  }
  public void removeRoomByObject(Room room)
  {
    rooms.remove(room);
  }
  public boolean equals(Object object)
  {
    if (!(object instanceof RoomList))
      return false;
    RoomList other = (RoomList) object;
    if (rooms.size() != other.size())
      return false;
    for (int i = 0; i<size(); i++)
    {
      if (!rooms.get(i).equals(other.getRoomByIndex(i)))
      {
        return false;
      }
    }
    return true;
  }
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
  public String toString()
  {
    String str = "";
    for (int i =0; i<rooms.size(); i++)
    {
      str+=rooms.get(i).toString()+" ";
    }
    return str;
  }
  public RoomList copy()
  {
    RoomList copyList = new RoomList();
    for (int i=0; i<rooms.size();i++)
    {
      copyList.addRoom(rooms.get(i));
    }
    return copyList;
  }
  public RoomList returnWithoutObjectsOfAnotherList(RoomList other)
  {
    RoomList result = new RoomList();
    boolean ready = true;
    for (int i =0; i<this.size();i++)
    {
      ready = true;
      for (int j =0; j < other.size(); j++)
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