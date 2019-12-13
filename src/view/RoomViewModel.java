package view;

import javafx.beans.property.*;
import model.Room;

public class RoomViewModel
{
  private StringProperty nameProperty;
  private StringProperty connectorsProperty;
  private IntegerProperty maxStudentsProperty;
  private IntegerProperty tablesProperty;
  private IntegerProperty chairsProperty;
  private BooleanProperty canBeMergedProperty;

  public RoomViewModel(Room room)
  {
    nameProperty = new SimpleStringProperty(room.getRoomName());
    connectorsProperty = new SimpleStringProperty(room.getTypesOfConnectorsAvailable());
    maxStudentsProperty = new SimpleIntegerProperty(room.getMaxNumberOfStudents());
    tablesProperty = new SimpleIntegerProperty(room.getNumberOfTables());
    chairsProperty = new SimpleIntegerProperty(room.getNumberOfChairs());
    canBeMergedProperty = new SimpleBooleanProperty(room.isCanBeMerged());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }
  public StringProperty getConnectorsProperty()
  {
    return connectorsProperty;
  }
  public IntegerProperty getMaxStudentsProperty()
  {
    return maxStudentsProperty;
  }
  public IntegerProperty getTablesProperty()
  {
    return tablesProperty;
  }
  public IntegerProperty getChairsProperty()
  {
    return chairsProperty;
  }
  public BooleanProperty getCanBeMergedProperty()
  {
    return canBeMergedProperty;
  }
}
