package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Room;
import model.RoomList;
import model.Teacher;
import model.TeacherList;

import java.util.ArrayList;

public class RoomListViewArrayList
{
  private ObservableList<RoomViewModel> list;
  private RoomList rooms;

  public RoomListViewArrayList(RoomList rooms)
  {
    this.rooms = rooms;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<RoomViewModel> getList()
  {
    return list;
  }

  public ObservableList<RoomViewModel> update()
  {
    ArrayList<Room> roomList = new ArrayList<>();
    for (int i = 0; i < rooms.size(); i++)
    {
      roomList.add(this.rooms.getRoomByIndex(i));
    }
    list.clear();
    for (int i = 0; i < roomList.size(); i++)
    {
      list.add(new RoomViewModel(roomList.get(i)));
    }
    return list;
  }

  public void remove(Room room)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(room.getRoomName()) && list
          .get(i).getConnectorsProperty().get().equals(room.getTypesOfConnectorsAvailable())
          && list.get(i).getMaxStudentsProperty().get() == room.getMaxNumberOfStudents()
          && list.get(i).getChairsProperty().get() == room.getNumberOfChairs()
          && list.get(i).getTablesProperty().get() == room.getNumberOfTables())

      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Room room)
  {
    list.add(new RoomViewModel(room));
  }
}
