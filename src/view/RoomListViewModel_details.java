package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EMSModel;
import model.Room;

import java.util.ArrayList;

public class RoomListViewModel_details
{
  private ObservableList<RoomViewModel> list;
  private EMSModel model;

  public RoomListViewModel_details(EMSModel model)
  {
    this.model = model;
    list = FXCollections.observableArrayList();
  }

  public ObservableList<RoomViewModel> getList()
  {
    return list;
  }

  public ObservableList<RoomViewModel> update()
  {
    ArrayList<Room> rooms = new ArrayList<>();
    for (int i = 0; i < model.getTempExam().getRooms().size(); i++)
    {
      rooms.add(model.getTempExam().getRooms().getRoomByIndex(i));
    }
    list.clear();
    for (int i = 0; i < rooms.size(); i++)
    {
      list.add(new RoomViewModel(rooms.get(i)));
    }
    return list;
  }

  public void remove(Room room)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getNameProperty().get().equals(room.getRoomName())
          && list.get(i).getConnectorsProperty().get().equals(room.getTypesOfConnectorsAvailable())
          && list.get(i).getMaxStudentsProperty().get() == (room.getMaxNumberOfStudents())
          && list.get(i).getTablesProperty().get() == (room.getNumberOfTables())
          && list.get(i).getChairsProperty().get() == (room.getNumberOfChairs())
          && list.get(i).getCanBeMergedProperty().get() == (room.isCanBeMerged()))
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
