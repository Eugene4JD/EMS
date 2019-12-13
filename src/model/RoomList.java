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
    return rooms.get(getIndexOfRoomByRoomName(roomName));
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
}