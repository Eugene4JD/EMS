package mediator;

import java.io.File;

public interface PersistenceBinary
{
   void save(File file, Object object);
   Object update(File file);
   Object delete(File file, Object object);
}
