package mediator;

import java.io.File;

public interface PersistenceXML
{
  void save(File file, Object object);
}
